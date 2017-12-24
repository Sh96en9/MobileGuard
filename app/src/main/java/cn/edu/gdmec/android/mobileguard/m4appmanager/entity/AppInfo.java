package cn.edu.gdmec.android.mobileguard.m4appmanager.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class AppInfo {
    //应用程序包名
    public String packageName;
    //应用程序图标
    public Drawable icon;
    public String appName;
    public String apkPath;
    //应用程序大小
    public long appSize;
    //是否是手机存储
    public boolean isInRoom;
    //是否是用户应用
    public boolean isUserApp;
    //是否选中，莫仍都为false
    public boolean isSelected=false;
    //拿到app位置字符串
    public String version;
    public String InstallTime;
    public String signature;
    public String permissions;
    public String activityName;
    public  boolean isLock;
    public String getAppLocation(boolean isInRoom){
        if (isInRoom){
            return "手机内存";
        }else {
            return "外部存储";
        }

    }
    /** 应用程序是否加锁 */

}
