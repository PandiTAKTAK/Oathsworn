package com.shadowborne_games.oathsworn.mainCampaign;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SharedPreferencesSingleton {
    private static final String TAG = "SharedPreferencesS";
    private static SharedPreferencesSingleton firstInstance;
    private final SharedPreferences.Editor editor;
    private final SharedPreferences sharedPreferences;
    private final String STORYLINE_TRACKER = "com.shadowborne_games.deepwood_app.STORYLINE_TRACKER";
    private final Gson gson = new Gson();

    public static SharedPreferencesSingleton getInstance(Context context) {
        if (firstInstance == null) {
            firstInstance = new SharedPreferencesSingleton(context);
        }
        return firstInstance;
    }

    private SharedPreferencesSingleton(Context context) {
        Log.d(TAG, "private Constructor");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.shadowborne_games.deepwood_app.STORYLINE_TRACKER", 0);
        this.sharedPreferences = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.editor = edit;
        edit.putBoolean("audioOn", true);
        edit.apply();
    }

    public void saveArray(String str, int i, ArrayList arrayList) {
        String json = this.gson.toJson(arrayList);
        Log.d(TAG, "---- " + str + i + " --- saveArray: []: " + json);
        SharedPreferences.Editor editor = this.editor;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        editor.putString(sb.toString(), json);
        this.editor.commit();
    }

    public ArrayList<Integer> getArray(String str, int i) {
        ArrayList<Integer> arrayList;
        SharedPreferences sharedPreferences = this.sharedPreferences;
        String string = sharedPreferences.getString(str + i, null);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (string != null) {
            try {
                arrayList = (ArrayList) this.gson.fromJson(string, new TypeToken<ArrayList<Integer>>() { // from class: com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton.1
                }.getType());
            } catch (ArrayIndexOutOfBoundsException e) {
                e = e;
            } catch (NullPointerException e2) {
                e = e2;
            }
            try {
                Log.d(TAG, "--- " + str + i + " --- getArray: []: " + arrayList);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException e3) {
                e = e3;
                arrayList2 = arrayList;
                Log.d(TAG, "getArray: ArrayIndexOutOfBoundsException e = " + e);
                return arrayList2;
            } catch (NullPointerException e4) {
                e = e4;
                arrayList2 = arrayList;
                Log.d(TAG, "getArray: NullPointerException e = " + e);
                return arrayList2;
            }
        }
        return arrayList2;
    }

    public void saveArray(String str, ArrayList arrayList) {
        String json = this.gson.toJson(arrayList);
        Log.d(TAG, "--- " + str + " --- saveArray: []: " + json);
        this.editor.putString(str, json);
        this.editor.commit();
    }

    public ArrayList<Integer> getArray(String str) {
        String string = this.sharedPreferences.getString(str, null);
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (string == null) {
            return arrayList;
        }
        try {
            ArrayList<Integer> arrayList2 = (ArrayList) this.gson.fromJson(string, new TypeToken<ArrayList<Integer>>() { // from class: com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton.2
            }.getType());
            try {
                Log.d(TAG, "--- " + str + " --- getArray: []: " + arrayList2);
                return arrayList2;
            } catch (ArrayIndexOutOfBoundsException e) {
                e = e;
                arrayList = arrayList2;
                Log.d(TAG, "getArray: ArrayIndexOutOfBoundsException e = " + e);
                return arrayList;
            } catch (NullPointerException e2) {
                e = e2;
                arrayList = arrayList2;
                Log.d(TAG, "getArray: NullPointerException e = " + e);
                return arrayList;
            }
        } catch (ArrayIndexOutOfBoundsException e3) {
            e = e3;
        } catch (NullPointerException e4) {
            e = e4;
        }
    }

    public void saveBoolean(String str, int i, boolean z) {
        Log.d(TAG, "--- " + str + " --- saveBoolean: to " + z);
        SharedPreferences.Editor editor = this.editor;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        editor.putBoolean(sb.toString(), z);
        this.editor.commit();
    }

    public boolean getBoolean(String str, int i) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        boolean z = sharedPreferences.getBoolean(str + i, false);
        Log.d(TAG, "--- " + str + " --- getBoolean: (" + z + ")");
        return z;
    }

    public void saveBoolean(String str, boolean z) {
        Log.d(TAG, "--- " + str + " --- saveBoolean: to " + z);
        this.editor.putBoolean(str, z);
        this.editor.commit();
    }

    public boolean getBoolean(String str) {
        boolean z = this.sharedPreferences.getBoolean(str, false);
        Log.d(TAG, "--- " + str + " --- getBoolean: (" + z + ")");
        return z;
    }

    public void saveInt(String str, int i, int i2) {
        Log.d(TAG, "--- " + str + " --- saveInt: to " + i2);
        SharedPreferences.Editor editor = this.editor;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        editor.putInt(sb.toString(), i2);
        this.editor.commit();
    }

    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        int i2 = sharedPreferences.getInt(str + i, -1);
        Log.d(TAG, "--- " + str + " --- getInt: (" + i2 + ")");
        return i2;
    }

    public void saveInt(String str, int i) {
        Log.d(TAG, "--- " + str + " --- saveInt: to " + i);
        this.editor.putInt(str, i);
        this.editor.commit();
    }

    public int getInt(String str) {
        int i = this.sharedPreferences.getInt(str, -1);
        Log.d(TAG, "--- " + str + " --- getInt: (" + i + ")");
        return i;
    }
}
