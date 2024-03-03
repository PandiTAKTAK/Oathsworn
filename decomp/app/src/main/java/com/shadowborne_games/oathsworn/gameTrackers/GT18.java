package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter18;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT18 extends TimeTrackers {
    private static final String TAG = "GT18";
    Chapter18 chapter18;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT18(Context context, int i, ArrayList<Integer> arrayList, HashMap<Integer, Integer> hashMap) {
        super(context, i);
        this.chapter18 = new Chapter18();
        this.deepwoodMap = hashMap;
        this.allDeepwoodTokens = arrayList;
        setupDeepwood(arrayList);
        Log.d(TAG, "GT18: public Constructor calling super, setup deepwoodMap and deepwoodTokens");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time2() {
        StringBuilder sb = new StringBuilder();
        sb.append("time2: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(150);
        sb.append("- 18m_1_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 150;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time5() {
        StringBuilder sb = new StringBuilder();
        sb.append("time5: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(157);
        sb.append("- 18m_2_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 157;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time7() {
        StringBuilder sb = new StringBuilder();
        sb.append("time7: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(167);
        sb.append("- 18m_3_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 167;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time9() {
        StringBuilder sb = new StringBuilder();
        sb.append("time9: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(172);
        sb.append("- 18m_4_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 172;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time12() {
        StringBuilder sb = new StringBuilder();
        sb.append("time12: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(181);
        sb.append("- 18m_5_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 181;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time15() {
        StringBuilder sb = new StringBuilder();
        sb.append("time15: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(186);
        sb.append("- 18m_6_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 186;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time18() {
        StringBuilder sb = new StringBuilder();
        sb.append("time18: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(192);
        sb.append("- 18m_7_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 192;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time21() {
        StringBuilder sb = new StringBuilder();
        sb.append("time21: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(196);
        sb.append("- 18m_8_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 196;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time32() {
        StringBuilder sb = new StringBuilder();
        sb.append("time32: returns plate ");
        Objects.requireNonNull(this.chapter18);
        sb.append(279);
        sb.append("- 18_85_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter18);
        return 279;
    }
}
