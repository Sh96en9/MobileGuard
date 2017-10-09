package cn.edu.gdmec.android.mobileguard.m1home.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asus on 2017/9/21.
 */

public class HomeAdapter extends BaseAdapter {
    int[] imageId = {cn.edu.gdmec.android.mobileguard.R.drawable.safe, cn.edu.gdmec.android.mobileguard.R.drawable.callmsgsafe, cn.edu.gdmec.android.mobileguard.R.drawable.app, cn.edu.gdmec.android.mobileguard.R.drawable.trojan,
            cn.edu.gdmec.android.mobileguard.R.drawable.sysoptimize, cn.edu.gdmec.android.mobileguard.R.drawable.taskmanager, cn.edu.gdmec.android.mobileguard.R.drawable.netmanager, cn.edu.gdmec.android.mobileguard.R.drawable.atools,
            cn.edu.gdmec.android.mobileguard.R.drawable.settings};
    String[] names = {"手机防盗","通讯卫士","软件管家","手机杀毒","缓存清理","进程管理","流量统计","高级工具","设置中心"};
    private Context context;

    public HomeAdapter(Context context){
        this.context= context;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = View.inflate(context, cn.edu.gdmec.android.mobileguard.R.layout.item_home,null);
        ImageView iv_icon = (ImageView) view1.findViewById(cn.edu.gdmec.android.mobileguard.R.id.iv_home);
        TextView tv_name = (TextView) view1.findViewById(cn.edu.gdmec.android.mobileguard.R.id.tv_name);
        iv_icon.setImageResource(imageId[i]);
        tv_name.setText(names[i]);
        return view1;
    }
}
