package cn.edu.gdmec.android.mobileguard.m2theftguard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by asus on 2017/10/1.
 */
//
public class SetupPasswordDialog extends Dialog implements View.OnClickListener {
    //标题栏
    private TextView mTitleTV;
    //首次输入密码文本框
    public EditText mFirstPWDET;
    //确认密码文本框
    public EditText mAffirmET;
    //回调接口
    private MyCallBack myCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(cn.edu.gdmec.android.mobileguard.R.layout.setup_password_dialog);
        super.onCreate(savedInstanceState);
        initView();
    }
    public SetupPasswordDialog(@NonNull Context context) {
        super(context, cn.edu.gdmec.android.mobileguard.R.style.dialog_custom);
    }

    //初始化控件
    private void initView(){
        mTitleTV = (TextView)findViewById(cn.edu.gdmec.android.mobileguard.R.id.tv_setuppwd_title);
        mFirstPWDET = (EditText)findViewById(cn.edu.gdmec.android.mobileguard.R.id.et_firstpwd);
        mAffirmET = (EditText)findViewById(cn.edu.gdmec.android.mobileguard.R.id.et_affirm_password);
        findViewById(cn.edu.gdmec.android.mobileguard.R.id.btn_ok).setOnClickListener(this);
        findViewById(cn.edu.gdmec.android.mobileguard.R.id.btn_cancel).setOnClickListener(this);
    }

    //设置对话框标题栏
    //@param title
    public void setTitle(String title){
        if(!TextUtils.isEmpty(title)){
            mTitleTV.setText(title);
        }
    }

    public void setCallBack(MyCallBack myCallBack){
        this.myCallBack = myCallBack;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case cn.edu.gdmec.android.mobileguard.R.id.btn_ok:
                System.out.print("SetupPasswordDialog");
                myCallBack.ok();
                break;
            case cn.edu.gdmec.android.mobileguard.R.id.btn_cancel:
                myCallBack.cancel();
                break;
        }
    }

    public interface MyCallBack{
        void ok();
        void cancel();
    }
}
