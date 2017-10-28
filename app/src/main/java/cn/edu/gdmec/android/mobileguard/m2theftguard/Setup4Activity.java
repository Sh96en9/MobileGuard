package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by asus on 2017/10/11.
 */

public class Setup4Activity extends BaseSetupActivity {
    private TextView mStatusTV;
    private ToggleButton mToggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_4);
        //设置第二个小圆点的颜色
        ((RadioButton)findViewById(R.id.rb_four)).setChecked(true);
        intiView();
    }
    private void intiView(){
        ((RadioButton)findViewById(R.id.rb_four)).setChecked(true);
        mStatusTV = (TextView)findViewById(R.id.tv_setup4_status);
        mToggleButton = (ToggleButton)findViewById(R.id.togglebtn_securityfunction);
        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mStatusTV.setText("防盗保护已经开启");
                }else {
                    mStatusTV.setText("防盗保护没有开启");
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("protecting",true);
                editor.commit();
            }
        });

        boolean protecting = sp.getBoolean("protecting",true);
        if (protecting){
            mStatusTV.setText("防盗保护已经开启");
            mToggleButton.setChecked(true);
        }else {
            mStatusTV.setText("防盗保护没有开启");
            mToggleButton.setChecked(false);
        }
    }


    @Override
    public void showNext(){
        //跳转至防盗保护页面
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isSetup",true);
        editor.commit();
        startActivityAndFinishSelf(LostFindActivity.class);

    }
    @Override
    public void showPre(){
        startActivityAndFinishSelf(Setup3Activity.class);
    }
}
