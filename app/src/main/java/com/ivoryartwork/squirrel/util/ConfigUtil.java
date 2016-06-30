package com.ivoryartwork.squirrel.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Yaochao on 2016/6/22.
 * 保存/获取用户的一些配置信息
 */
public class ConfigUtil {

    private static SharedPreferences sp;

    private static SharedPreferences.Editor editor;

    private static final String ACCOUNT = "account";

    private static final String PASSWORD = "password";

    private static final String TOKEN = "token";

    public ConfigUtil(Context context) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 保存用户登录状态
     *
     * @param account
     * @param password
     * @param token
     */
    public static void saveLoginStatus(String account, String password, String token) {
        editor.putString(ACCOUNT, account);
        editor.putString(PASSWORD, password);
        editor.putString(TOKEN, token);
        editor.commit();
    }

    /**
     * 获取用户账户
     *
     * @return
     */
    public static String getAccount() {
        return sp.getString(ACCOUNT, "");
    }

    /**
     * 获取用户密码
     *
     * @return
     */
    public static String getPassword() {
        return sp.getString(PASSWORD, "");
    }

    /**
     * 获取用户登录凭证
     *
     * @return
     */
    public static String getToken() {
        return sp.getString(TOKEN, "");
    }
}
