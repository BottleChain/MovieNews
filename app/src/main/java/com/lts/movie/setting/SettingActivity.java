package com.lts.movie.setting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;
import com.lts.movie.constant.Constant;
import com.lts.movie.movie.ui.MainActivity;
import com.lts.movie.util.SpUtils;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lts on 2017/9/4.
 * Fuction:
 * Update:
 */

public class SettingActivity extends BaseActivity {


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public int bindingView() {
        return R.layout.activity_setting;
    }

    @Override
    public boolean isHasNavigationView() {
        return true;
    }

    @Override
    public void initView() {
        ButterKnife.inject(this);
        mMenuDefaultCheckedItem = R.id.action_setting;

    }


    @OnClick(R.id.setLanguage)
    public void onViewClicked() {
        String [] choice = {getResources().getString(R.string.auto),getResources().getString(R.string.chinese),getResources().getString(R.string.english)};

        final Configuration configuration = getResources().getConfiguration();
        final DisplayMetrics dm = getResources().getDisplayMetrics();
        new AlertDialog.Builder(this)
                .setSingleChoiceItems(choice, SpUtils.readInt(Constant.LOCALE), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                configuration.locale = Locale.getDefault();
                                SpUtils.writeInt(Constant.LOCALE,which);
                                break;
                            case 1:
                                configuration.locale = Locale.SIMPLIFIED_CHINESE;
                                SpUtils.writeInt(Constant.LOCALE,which);
                                break;
                            case 2:
                                configuration.locale = Locale.US;
                                SpUtils.writeInt(Constant.LOCALE,which);
                                break;
                        }
                    }
                })
                .setPositiveButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getResources().updateConfiguration(configuration, dm);
                        Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(0);

                    }
                })
                .create()
                .show();
    }
}
