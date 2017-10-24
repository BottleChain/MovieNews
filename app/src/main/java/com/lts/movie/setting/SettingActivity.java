package com.lts.movie.setting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.lts.movie.R;
import com.lts.movie.base.BaseActivity;
import com.lts.movie.constant.Constant;
import com.lts.movie.movie.ui.MainActivity;
import com.lts.movie.util.SpUtils;

import java.util.Locale;

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
        mMenuDefaultCheckedItem = R.id.action_setting;
        findViewById(R.id.setLanguage).setOnClickListener(this);
        findViewById(R.id.about).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setLanguage:
                onViewClicked();
                break;
            case R.id.about:
                aboutPreject();
                break;
        }

    }

    private void aboutPreject() {

        MaterialDialog dialog = new MaterialDialog.Builder(this).title("说明").titleGravity(GravityEnum.CENTER).content("").show();
        dialog.getContentView().setText(Html.fromHtml("&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;此练习项目API来源于:"
                +"<a href='https://developers.themoviedb.org/3'>The Movie Database API 3</a><br>"
                + "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;使用了诸如:<br>"
                + "<a href='https://github.com/square/retrofit'>Retrofit2.0</a>,"
                + "<a href='https://github.com/ReactiveX/RxJava'>RxJava</a>,"
                + "<a href='https://github.com/greenrobot/greenDAO'>GreenDAO</a>,"
                + "<a href='https://github.com/square/picasso'>Picasso</a>,"
                + " &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;App采用mvp+rxjava+retrofit,源码开源在GitHub<a href='https://github.com/TangBeiLiu/MovieNews'>MovieNews</a>。<br>\n"
                + "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;如果在使用过程中遇到什么问题或者建议 可以发Email到我邮箱liutangbei@gmail.com<br>"));
    }

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
