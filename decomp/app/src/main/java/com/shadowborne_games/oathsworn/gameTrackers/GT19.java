package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter19;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT19 extends TimeTrackers {
    private static final String TAG = "GT19";
    Chapter19 chapter19;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT19(Context context, int i) {
        super(context, i);
        this.chapter19 = new Chapter19();
        Log.d(TAG, "GT19: public Constructor calling super");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time3() {
        StringBuilder sb = new StringBuilder();
        sb.append("time3: returns plate ");
        Objects.requireNonNull(this.chapter19);
        sb.append(140);
        sb.append("- 19m_1_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter19);
        return 140;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time6() {
        StringBuilder sb = new StringBuilder();
        sb.append("time6: returns plate ");
        Objects.requireNonNull(this.chapter19);
        sb.append(151);
        sb.append("- 19m_2_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter19);
        return 151;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time9() {
        StringBuilder sb = new StringBuilder();
        sb.append("time9: returns plate ");
        Objects.requireNonNull(this.chapter19);
        sb.append(158);
        sb.append("- 19m_3_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter19);
        return 158;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time13() {
        StringBuilder sb = new StringBuilder();
        sb.append("time13: returns plate ");
        Objects.requireNonNull(this.chapter19);
        sb.append(163);
        sb.append("- 19m_4_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter19);
        return 163;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time16() {
        StringBuilder sb = new StringBuilder();
        sb.append("time16: returns plate ");
        Objects.requireNonNull(this.chapter19);
        sb.append(167);
        sb.append("- 19m_5_0");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter19);
        return 167;
    }
}
