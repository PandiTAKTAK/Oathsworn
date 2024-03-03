package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter12;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT12 extends TimeTrackers {
    private static final String TAG = "GT12";
    Chapter12 chapter12;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT12(Context context, int i) {
        super(context, i);
        this.chapter12 = new Chapter12();
        Log.d(TAG, "GT12: public Constructor calling super");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time1() {
        StringBuilder sb = new StringBuilder();
        sb.append("time1: returns plate ");
        Objects.requireNonNull(this.chapter12);
        sb.append(151);
        sb.append("- 12m_1_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter12);
        return 151;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time2() {
        StringBuilder sb = new StringBuilder();
        sb.append("time2: returns plate ");
        Objects.requireNonNull(this.chapter12);
        sb.append(154);
        sb.append("- 12m_2_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter12);
        return 154;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time3() {
        StringBuilder sb = new StringBuilder();
        sb.append("time3: returns plate ");
        Objects.requireNonNull(this.chapter12);
        sb.append(156);
        sb.append("- 12m_3_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter12);
        return 156;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time4() {
        StringBuilder sb = new StringBuilder();
        sb.append("time4: returns plate ");
        Objects.requireNonNull(this.chapter12);
        sb.append(159);
        sb.append("- 12m_4_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter12);
        return 159;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time5() {
        StringBuilder sb = new StringBuilder();
        sb.append("time5: returns plate ");
        Objects.requireNonNull(this.chapter12);
        sb.append(161);
        sb.append("- 12m_5_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter12);
        return 161;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time6() {
        StringBuilder sb = new StringBuilder();
        sb.append("time6: returns plate ");
        Objects.requireNonNull(this.chapter12);
        sb.append(163);
        sb.append("- 12m_6_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter12);
        return 163;
    }
}
