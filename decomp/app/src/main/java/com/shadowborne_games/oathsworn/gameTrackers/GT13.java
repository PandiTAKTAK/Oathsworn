package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter13;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT13 extends TimeTrackers {
    private static final String TAG = "GT13";
    Chapter13 chapter13;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT13(Context context, int i) {
        super(context, i);
        this.chapter13 = new Chapter13();
        Log.d(TAG, "GT13: public Constructor calling super");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time11() {
        StringBuilder sb = new StringBuilder();
        sb.append("time11: returns plate ");
        Objects.requireNonNull(this.chapter13);
        sb.append(116);
        sb.append("- 13_30_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter13);
        return 116;
    }
}
