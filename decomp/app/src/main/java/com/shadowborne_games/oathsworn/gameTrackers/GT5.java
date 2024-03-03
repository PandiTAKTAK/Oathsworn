package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter5;

/* loaded from: classes.dex */
public class GT5 extends TimeTrackers {
    private static final String TAG = "GT5";
    Chapter5 chapter5;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT5(Context context, int i) {
        super(context, i);
        this.chapter5 = new Chapter5();
        Log.d(TAG, "GT5: public Constructor calling super");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (r1 > 96) goto L8;
     */
    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int time10() {
        /*
            r4 = this;
            java.lang.String r0 = "GT5"
            java.lang.String r1 = "time10: determine if on path A or B, if path B- redirect to 5b_30_1"
            android.util.Log.d(r0, r1)
            com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton r1 = com.shadowborne_games.oathsworn.gameTrackers.GT5.sharedPreferencesSingleton
            int r2 = r4.chapterNum
            java.lang.String r3 = "nextPositionToken"
            int r1 = r1.getInt(r3, r2)
            r4.nextPositionToken = r1
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter5 r2 = r4.chapter5
            java.util.Objects.requireNonNull(r2)
            r2 = 49
            if (r1 < r2) goto L29
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter5 r2 = r4.chapter5
            java.util.Objects.requireNonNull(r2)
            r2 = 96
            if (r1 <= r2) goto L39
        L29:
            com.shadowborne_games.oathsworn.book.Chapter5 r1 = r4.chapter5
            java.util.List<java.lang.Integer> r1 = r1.additionalPathB
            int r2 = r4.nextPositionToken
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L5c
        L39:
            com.shadowborne_games.oathsworn.book.Chapter5 r1 = r4.chapter5
            java.util.Objects.requireNonNull(r1)
            r1 = 93
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "--- determined "
            r2.append(r3)
            int r3 = r4.nextPositionToken
            r2.append(r3)
            java.lang.String r3 = " is on path B, redirected to section"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r0, r2)
            goto L5d
        L5c:
            r1 = -1
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.gameTrackers.GT5.time10():int");
    }
}
