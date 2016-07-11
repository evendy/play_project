package cn.evendy.uniots.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText accountInputBox, pwdInputBox, verifyInputBox;
    private TextView sendVerityBtn, verityError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
    }

    protected void initViews() {
        setToolbarTitle(R.string.register);
        enableBackBTN();

        accountInputBox = getView(R.id.register_account);
        pwdInputBox = getView(R.id.register_password);
        verifyInputBox = getView(R.id.register_verifyCode);

        verityError = getView(R.id.verify_error);
        sendVerityBtn = getView(R.id.send_verity);
        sendVerityBtn.setOnClickListener(this);
        getView(R.id.register_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.register_btn: {
                register();
                break;
            }
            case R.id.send_verity: {
                toast(R.string.sent_veritycode);
                sendVerityBtn.setEnabled(false);
                break;
            }
        }
    }

    private void register() {
        if (true) {
            toast(R.string.register_success);
            finish();
        } else {
            verityError.setVisibility(View.VISIBLE);
        }

    }
}
