package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter7;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT7 extends TimeTrackers {
    private static final String TAG = "GT7";
    Chapter7 chapter7;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT7(Context context, int i) {
        super(context, i);
        this.chapter7 = new Chapter7();
        Log.d(TAG, "GT7: public Constructor calling super");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (r1 > 143) goto L8;
     */
    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int time9() {
        /*
            r4 = this;
            java.lang.String r0 = "GT7"
            java.lang.String r1 = "time9: determine if on path A or B, if path B- redirect to 7b_12_20"
            android.util.Log.d(r0, r1)
            com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton r1 = com.shadowborne_games.oathsworn.gameTrackers.GT7.sharedPreferencesSingleton
            int r2 = r4.chapterNum
            java.lang.String r3 = "nextPositionToken"
            int r1 = r1.getInt(r3, r2)
            r4.nextPositionToken = r1
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter7 r2 = r4.chapter7
            java.util.Objects.requireNonNull(r2)
            r2 = 64
            if (r1 < r2) goto L29
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter7 r2 = r4.chapter7
            java.util.Objects.requireNonNull(r2)
            r2 = 143(0x8f, float:2.0E-43)
            if (r1 <= r2) goto L34
        L29:
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter7 r2 = r4.chapter7
            java.util.Objects.requireNonNull(r2)
            r2 = 145(0x91, float:2.03E-43)
            if (r1 != r2) goto L57
        L34:
            com.shadowborne_games.oathsworn.book.Chapter7 r1 = r4.chapter7
            java.util.Objects.requireNonNull(r1)
            r1 = 71
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
        throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.gameTrackers.GT7.time9():int");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time14() {
        Log.d(TAG, "time14: determine if on path A or B, if path A- redirect to 7a_30_3");
        this.nextPositionToken = sharedPreferencesSingleton.getInt("nextPositionToken", this.chapterNum);
        int i = this.nextPositionToken;
        Objects.requireNonNull(this.chapter7);
        if (i > 63) {
            int i2 = this.nextPositionToken;
            Objects.requireNonNull(this.chapter7);
            if (i2 != 144) {
                return -1;
            }
        }
        Objects.requireNonNull(this.chapter7);
        Log.d(TAG, "--- determined " + this.nextPositionToken + " is on path A, redirected to section");
        return 63;
    }
}
