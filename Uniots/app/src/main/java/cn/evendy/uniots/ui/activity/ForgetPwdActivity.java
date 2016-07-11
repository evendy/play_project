package cn.evendy.uniots.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class ForgetPwdActivity extends BaseActivity implements View.OnClickListener {
    private TextView sendVerityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        initViews();
    }

    protected void initViews() {
        setToolbarTitle(R.string.find_password);
        enableBackBTN();

        sendVerityBtn = getView(R.id.send_verity);
        sendVerityBtn.setOnClickListener(this);

        getView(R.id.modify_password).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.modify_password: {
                toast(R.string.modify_password_success);
                finish();
                break;
            }
            case R.id.send_verity: {
                toast(R.string.sent_veritycode);
                sendVerityBtn.setEnabled(false);
                break;
            }
        }
    }
}
