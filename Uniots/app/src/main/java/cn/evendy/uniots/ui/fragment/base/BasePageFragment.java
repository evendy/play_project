package cn.evendy.uniots.ui.fragment.base;

import android.os.Bundle;

/**
 * Created by evendy .
 */
public abstract class BasePageFragment extends BaseFragment {

    protected abstract void initToolbar();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initToolbar();
    }

    /**
     * @return fragment消费back键返回true, 反之返回false
     */
    public boolean onBackPressed() {
        return false;
    }

}
