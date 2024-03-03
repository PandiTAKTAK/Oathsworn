package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter9;

/* loaded from: classes.dex */
public class GT9 extends TimeTrackers {
    private static final String TAG = "GT9";
    Chapter9 chapter9;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT9(Context context, int i) {
        super(context, i);
        this.chapter9 = new Chapter9();
        Log.d(TAG, "GT9: public Constructor calling super");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (r1 > 146) goto L8;
     */
    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int time10() {
        /*
            r4 = this;
            java.lang.String r0 = "GT9"
            java.lang.String r1 = "time10: determine if on path A or B, if path B- redirect to 9b_18_1"
            android.util.Log.d(r0, r1)
            com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton r1 = com.shadowborne_games.oathsworn.gameTrackers.GT9.sharedPreferencesSingleton
            int r2 = r4.chapterNum
            java.lang.String r3 = "nextPositionToken"
            int r1 = r1.getInt(r3, r2)
            r4.nextPositionToken = r1
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter9 r2 = r4.chapter9
            java.util.Objects.requireNonNull(r2)
            r2 = 106(0x6a, float:1.49E-43)
            if (r1 < r2) goto L29
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter9 r2 = r4.chapter9
            java.util.Objects.requireNonNull(r2)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 <= r2) goto L34
        L29:
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter9 r2 = r4.chapter9
            java.util.Objects.requireNonNull(r2)
            r2 = 148(0x94, float:2.07E-43)
            if (r1 != r2) goto L57
        L34:
            com.shadowborne_games.oathsworn.book.Chapter9 r1 = r4.chapter9
            java.util.Objects.requireNonNull(r1)
            r1 = 131(0x83, float:1.84E-43)
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
            goto L58
        L57:
            r1 = -1
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.gameTrackers.GT9.time10():int");
    }
}
