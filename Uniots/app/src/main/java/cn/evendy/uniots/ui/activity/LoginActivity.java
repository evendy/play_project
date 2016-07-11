package cn.evendy.uniots.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private TextView loginBtn, registerBtn, forgetPwdBtn;
    private EditText accountInputBox, pwdInputBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    protected void initViews() {
        loginBtn = getView(R.id.login);

        accountInputBox = getView(R.id.login_account);
        pwdInputBox = getView(R.id.login_password);
        registerBtn = getView(R.id.register);
        forgetPwdBtn = getView(R.id.forgetPwd);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        forgetPwdBtn.setOnClickListener(this);

        getView(R.id.login_qq).setOnClickListener(this);
        getView(R.id.login_wechat).setOnClickListener(this);
        getView(R.id.login_weibo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.login_qq: {
                checkAccountExist();
                break;
            }
            case R.id.login_wechat: {
                checkAccountExist();
                break;
            }
            case R.id.login_weibo: {
                checkAccountExist();
                break;
            }
            case R.id.login: {
                checkInput();
                break;
            }
            case R.id.forgetPwd: {
                startActivity(new Intent(getContext(), ForgetPwdActivity.class));
                break;
            }
            case R.id.register: {
                startActivity(new Intent(getContext(), RegisterActivity.class));
                break;
            }
        }
    }

    private void checkAccountExist() {
        if (true) {
            startActivity(new Intent(getContext(), MainActivity.class));
        } else {
            startActivity(new Intent(getContext(), InitAccountActivity.class));
        }
    }

    private void checkInput() {
        if (true) {
            checkAccountExist();
        } else {

        }
    }

}
