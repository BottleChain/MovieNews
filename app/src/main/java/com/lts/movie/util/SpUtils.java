package com.lts.movie.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.lts.movie.App;
import com.lts.movie.constant.Constant;

/**
 * Created by lts on 2017/8/28.
 * Fuction:SharedPreferences工具类
 * Update:
 */

public class SpUtils {

    /**
     * 获取sp里面String 类型的值
     * @param key 存储的key
     * @return 存储的value
     */
    public static String readString(String key) {
        return getSharedPreferences().getString(key, "");
    }

    /**
     * 将String类型的值存入Sp
     * @param key 存储的key
     * @param value 存储的value
     */
    public static void writeString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    /**
     * 获取sp里面boolean值
     * @param key 存储的key
     * @return Boolean
     */
    public static boolean readBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    /**
     * 将Boolean类型的值存入sp
     * @param key 存储Boolean的key
     * @param value 要存入的value
     */
    public static void writeBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    /**
     * 获取sp里面int 型的值
     * @param key 获取的key
     * @return 之前存入的int 值
     */
    public static int readInt(String key) {
        return getSharedPreferences().getInt(key, 0);
    }

    /**
     * 读取sp里面int 型的值
     * @param key 读取的key
     * @param value value
     * @return value
     */
    public static int readInt(String key, int value) {
        return getSharedPreferences().getInt(key, value);
    }

    public static void writeInt(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    public static long readLong(String key) {
        return getSharedPreferences().getLong(key, 0);
    }

    public static void writeLong(String key, long value) {
        getSharedPreferences().edit().putLong(key, value).apply();
    }

    /**
     * 清楚某个键的值
     * @param key key
     */
    public static void remove(String key) {
        getSharedPreferences().edit().remove(key).apply();
    }

    /**
     * 清楚sp里面的所有数据
     */
    public static void removeAll() {
        getSharedPreferences().edit().clear().apply();
    }

    public static SharedPreferences getSharedPreferences() {
        return App.getContext()
                .getSharedPreferences(Constant.APP_NAME, Context.MODE_PRIVATE);
    }
}
