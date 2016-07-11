package cn.evendy.uniots.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;
import cn.evendy.uniots.ui.widget.dialog.UpdateAppDialog;

/**
 * Created by evendy .
 */
public class SettingsActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initViews();
    }

    @Override
    protected void initViews() {
        enableBackBTN();
        setToolbarTitle(R.string.setting);

        getView(R.id.menu_check_newest).setOnClickListener(menuClickListener);
        getView(R.id.menu_use_help).setOnClickListener(menuClickListener);
        getView(R.id.menu_suggestion).setOnClickListener(menuClickListener);
        getView(R.id.menu_about).setOnClickListener(menuClickListener);
    }

    private View.OnClickListener menuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.menu_check_newest: {
                    checkNewestVersion();
                    break;
                }
                case R.id.menu_use_help: {
                    toast("menu_use_help...");
                    break;
                }
                case R.id.menu_suggestion: {
                    startActivity(new Intent(getContext(), SuggestionActivity.class));
                    break;
                }
                case R.id.menu_about: {
                    toast("menu_about...");
                    break;
                }
            }
        }
    };

    private void checkNewestVersion() {
        UpdateAppDialog editNameDialog = new UpdateAppDialog();
        editNameDialog.show(getSupportFragmentManager(), "update");
    }
}
