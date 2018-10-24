package br.com.smartirrigation.smartirrigation.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SaveSharedPreference {

    static final String PREF_USER_NAME= "username";
    static final String ID_EQUIP = "" ;

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setIdEquip(Context ctx,String equip)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(ID_EQUIP, equip);
        editor.commit();
    }

    public static void setUserName(Context ctx, String userName)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
    }
    public static void clearuser(Context ctx){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
    }

    public static String getUserName(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    public static String getIdEquip(Context ctx)
    {
        return getSharedPreferences(ctx).getString(ID_EQUIP, "");
    }
}
