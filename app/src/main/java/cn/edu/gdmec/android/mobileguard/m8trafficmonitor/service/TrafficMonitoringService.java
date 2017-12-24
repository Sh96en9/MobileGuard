package cn.edu.gdmec.android.mobileguard.m8trafficmonitor.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.TrafficStats;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.edu.gdmec.android.mobileguard.m8trafficmonitor.db.dao.TrafficDao;

/**
 * Created by asus on 2017/12/2.
 */

public class TrafficMonitoringService extends Service{
    private long mOldRxBytes;
    private long mOldTxBytes;
    private TrafficDao dao;
    private SharedPreferences mSP;
    private long usedFlow;
    boolean flag  = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        mOldRxBytes = TrafficStats.getMobileRxBytes();
        mOldTxBytes = TrafficStats.getMobileTxBytes();
        dao =  new TrafficDao(this);
        mSP = getSharedPreferences( "config",MODE_PRIVATE);
        mTread.start();
    }
    private Thread mTread = new Thread(){
        public void run(){
            while (flag){
                try {
                    Thread.sleep(2000*60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateTodayGPRS();
            }
        }
        private void updateTodayGPRS(){
            //获取已经使用了的流量
            usedFlow = mSP.getLong("usedFlow",0);
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();//得到日历
            calendar.setTime(date);//把当前时间赋给日历
            if (calendar.DAY_OF_MONTH ==1 & calendar.HOUR_OF_DAY==0 & calendar.MINUTE<1 &calendar.SECOND<30){
                usedFlow=0;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataString = sdf.format(date);
            long mobileGPRS = dao.getMoblieGPRS(dataString);
            long mobileRxBytes = TrafficStats.getMobileRxBytes();
            long mobileTxBytes = TrafficStats.getMobileTxBytes();
            //新产生的流量
            long newGprs = (mobileRxBytes + mobileTxBytes) -mOldRxBytes-mobileTxBytes;
            mOldRxBytes = mobileRxBytes;
            mOldTxBytes = mobileTxBytes;
            if (newGprs<0){
                //网络切换过
                newGprs = mobileRxBytes + mobileTxBytes;
            }
            if (mobileGPRS==-1){
                dao.insertTodayGPRS(newGprs);
            }else {
                if (mobileGPRS<0){
                    mobileGPRS=0;
                }
                dao.UpdateTodayGPRS(mobileGPRS+newGprs);
            }
            usedFlow = usedFlow+newGprs;
            SharedPreferences.Editor edit = mSP.edit();
            edit.putLong("usedflow",usedFlow);
            edit.commit();
        }
    };
    @Override
    public void onDestroy(){
        if (mTread!=null & mTread.isInterrupted()){
            flag = false;
            mTread.interrupt();
            mTread =null;
        }
        super.onDestroy();
    }
}
