package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter10;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT10 extends TimeTrackers {
    private static final String TAG = "GT10";
    Chapter10 chapter10;

    public GT10(Context context, int i, ArrayList<Integer> arrayList, HashMap<Integer, Integer> hashMap) {
        super(context, i);
        this.chapter10 = new Chapter10();
        this.deepwoodMap = hashMap;
        this.allDeepwoodTokens = arrayList;
        setupDeepwood(arrayList);
        Log.d(TAG, "GT10: public Constructor calling super, setup deepwoodMap and deepwoodTokens");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time5() {
        StringBuilder sb = new StringBuilder();
        sb.append("time5: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(39);
        sb.append("- 10_28_10");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 39;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time11() {
        StringBuilder sb = new StringBuilder();
        sb.append("time11: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(137);
        sb.append("- Journal Entry 1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 137;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time13() {
        StringBuilder sb = new StringBuilder();
        sb.append("time13: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(140);
        sb.append("- Journal Entry 2");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 140;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time15() {
        StringBuilder sb = new StringBuilder();
        sb.append("time15: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(144);
        sb.append("- Journal Entry 3");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 144;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time17() {
        StringBuilder sb = new StringBuilder();
        sb.append("time17: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(148);
        sb.append("- Journal Entry 4");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 148;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time19() {
        StringBuilder sb = new StringBuilder();
        sb.append("time19: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(149);
        sb.append("- Journal Entry 5");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 149;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time21() {
        StringBuilder sb = new StringBuilder();
        sb.append("time21: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(154);
        sb.append("- Journal Entry 6");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 154;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time23() {
        StringBuilder sb = new StringBuilder();
        sb.append("time23: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(156);
        sb.append("- Journal Entry 7");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 156;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time29() {
        StringBuilder sb = new StringBuilder();
        sb.append("time29: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(160);
        sb.append("- Journal Entry 8");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 160;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time32() {
        StringBuilder sb = new StringBuilder();
        sb.append("time32: returns plate ");
        Objects.requireNonNull(this.chapter10);
        sb.append(251);
        sb.append("- 10_136_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter10);
        return 251;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r2 > 136) goto L7;
     */
    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean onNormalPath(int r2) {
        /*
            r1 = this;
            com.shadowborne_games.oathsworn.book.Chapter10 r0 = r1.chapter10
            java.util.Objects.requireNonNull(r0)
            if (r2 < 0) goto L10
            com.shadowborne_games.oathsworn.book.Chapter10 r0 = r1.chapter10
            java.util.Objects.requireNonNull(r0)
            r0 = 136(0x88, float:1.9E-43)
            if (r2 <= r0) goto L22
        L10:
            com.shadowborne_games.oathsworn.book.Chapter10 r0 = r1.chapter10
            java.util.Objects.requireNonNull(r0)
            r0 = 199(0xc7, float:2.79E-43)
            if (r2 < r0) goto L24
            com.shadowborne_games.oathsworn.book.Chapter10 r0 = r1.chapter10
            java.util.Objects.requireNonNull(r0)
            r0 = 250(0xfa, float:3.5E-43)
            if (r2 > r0) goto L24
        L22:
            r2 = 1
            goto L25
        L24:
            r2 = 0
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.gameTrackers.GT10.onNormalPath(int):boolean");
    }
}
