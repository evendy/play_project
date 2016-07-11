package cn.evendy.uniots.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yongchun.library.view.ImageSelectorActivity;

import java.util.ArrayList;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class MyInfoActivity extends BaseActivity implements View.OnClickListener {
    private ImageView avatar;
    private TextView text_neck_name, text_gender, text_born, text_weight, text_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        initViews();
    }

    @Override
    protected void initViews() {
        enableBackBTN();
        setToolbarTitle(R.string.info);

        avatar = getView(R.id.avatar);
        avatar.setOnClickListener(this);

        getView(R.id.quit).setOnClickListener(this);

        text_neck_name = getView(R.id.text_neck_name);
        text_gender = getView(R.id.text_neck_name);
        text_born = getView(R.id.text_neck_name);
        text_weight = getView(R.id.text_neck_name);
        text_height = getView(R.id.text_neck_name);

        getView(R.id.menu_neck_name).setOnClickListener(menuClickListener);
        getView(R.id.menu_gender).setOnClickListener(menuClickListener);
        getView(R.id.menu_born).setOnClickListener(menuClickListener);
        getView(R.id.menu_weight).setOnClickListener(menuClickListener);
        getView(R.id.menu_height).setOnClickListener(menuClickListener);

    }


    private View.OnClickListener menuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.menu_neck_name: {
                    Intent it = new Intent(getContext(), InitAccountActivity.class);
                    it.putExtra(Common.StringEventModify, Common.EventModify);
                    startActivity(it);
                    break;
                }
                case R.id.menu_gender: {
                    Intent it = new Intent(getContext(), InitGenderActivity.class);
                    it.putExtra(Common.StringEventModify, Common.EventModify);
                    startActivity(it);
                    break;
                }
                case R.id.menu_born: {
                    Intent it = new Intent(getContext(), InitBornActivity.class);
                    it.putExtra(Common.StringEventModify, Common.EventModify);
                    startActivity(it);
                    break;
                }
                case R.id.menu_weight: {
                    Intent it = new Intent(getContext(), InitWeightActivity.class);
                    it.putExtra(Common.StringEventModify, Common.EventModify);
                    startActivity(it);
                    break;
                }
                case R.id.menu_height: {
                    Intent it = new Intent(getContext(), InitHeightActivity.class);
                    it.putExtra(Common.StringEventModify, Common.EventModify);
                    startActivity(it);
                    break;
                }
            }
        }
    };

    @Override
    public void onClick(View v) {
        if (R.id.avatar == v.getId()) {
            ImageSelectorActivity.start(MyInfoActivity.this, 1, ImageSelectorActivity.MODE_SINGLE, true, true, true);
        } else {
            toast("quit login...");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == ImageSelectorActivity.REQUEST_IMAGE) {
            ArrayList<String> images = (ArrayList<String>) data.getSerializableExtra(ImageSelectorActivity.REQUEST_OUTPUT);
            // do something
            toast(images.get(0));
        }
    }
}
