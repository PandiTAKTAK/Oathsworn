package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter2;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT2 extends TimeTrackers {
    private static final String TAG = "GT2";
    Chapter2 chapter2;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT2(Context context, int i) {
        super(context, i);
        this.chapter2 = new Chapter2();
        Log.d(TAG, "GT2: public Constructor calling super");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (r1 > 85) goto L8;
     */
    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int time8() {
        /*
            r4 = this;
            java.lang.String r0 = "GT2"
            java.lang.String r1 = "time8: determine if on path A or B, if path B- redirect to 2b_30_1"
            android.util.Log.d(r0, r1)
            com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton r1 = com.shadowborne_games.oathsworn.gameTrackers.GT2.sharedPreferencesSingleton
            int r2 = r4.chapterNum
            java.lang.String r3 = "nextPositionToken"
            int r1 = r1.getInt(r3, r2)
            r4.nextPositionToken = r1
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter2 r2 = r4.chapter2
            java.util.Objects.requireNonNull(r2)
            r2 = 45
            if (r1 < r2) goto L29
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter2 r2 = r4.chapter2
            java.util.Objects.requireNonNull(r2)
            r2 = 85
            if (r1 <= r2) goto L34
        L29:
            int r1 = r4.nextPositionToken
            com.shadowborne_games.oathsworn.book.Chapter2 r2 = r4.chapter2
            java.util.Objects.requireNonNull(r2)
            r2 = 100
            if (r1 != r2) goto L57
        L34:
            com.shadowborne_games.oathsworn.book.Chapter2 r1 = r4.chapter2
            java.util.Objects.requireNonNull(r1)
            r1 = 66
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
        throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.gameTrackers.GT2.time8():int");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time12() {
        Log.d(TAG, "time12: determine if on path A or B, if path A- redirect to 2a_40_1");
        this.nextPositionToken = sharedPreferencesSingleton.getInt("nextPositionToken", this.chapterNum);
        Log.d(TAG, "time12: nextPositionToken: " + this.nextPositionToken);
        int i = this.nextPositionToken;
        Objects.requireNonNull(this.chapter2);
        if (i > 44) {
            int i2 = this.nextPositionToken;
            Objects.requireNonNull(this.chapter2);
            if (i2 != 99) {
                return -1;
            }
        }
        Objects.requireNonNull(this.chapter2);
        Log.d(TAG, "--- determined " + this.nextPositionToken + " is on path A, redirected to section");
        return 33;
    }
}
