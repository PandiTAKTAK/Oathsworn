package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT4 extends TimeTrackers {
    private static final String TAG = "GT4";
    Chapter4 chapter4;

    public GT4(Context context, int i, ArrayList<Integer> arrayList, HashMap<Integer, Integer> hashMap) {
        super(context, i);
        this.chapter4 = new Chapter4();
        this.deepwoodMap = hashMap;
        this.allDeepwoodTokens = arrayList;
        setupDeepwood(arrayList);
        Log.d(TAG, "GT4: public Constructor calling super, setup deepwoodMap and deepwoodTokens");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time1() {
        StringBuilder sb = new StringBuilder();
        sb.append("time1: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(58);
        sb.append("- Journal Entry 1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 58;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time2() {
        StringBuilder sb = new StringBuilder();
        sb.append("time2: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(61);
        sb.append("- Journal Entry 2");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 61;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time5() {
        StringBuilder sb = new StringBuilder();
        sb.append("time5: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(64);
        sb.append("- Journal Entry 3");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 64;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time8() {
        StringBuilder sb = new StringBuilder();
        sb.append("time8: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(66);
        sb.append("- Journal Entry 4");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 66;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time10() {
        StringBuilder sb = new StringBuilder();
        sb.append("time10: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(75);
        sb.append("- Journal Entry 5");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 75;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time11() {
        StringBuilder sb = new StringBuilder();
        sb.append("time11: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(76);
        sb.append("- Journal Entry 6");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 76;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time14() {
        StringBuilder sb = new StringBuilder();
        sb.append("time14: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(77);
        sb.append("- Journal Entry 7");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 77;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time19() {
        StringBuilder sb = new StringBuilder();
        sb.append("time19: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(80);
        sb.append("- Journal Entry 8");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 80;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time22() {
        StringBuilder sb = new StringBuilder();
        sb.append("time22: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(81);
        sb.append("- Journal Entry 9");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 81;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time25() {
        StringBuilder sb = new StringBuilder();
        sb.append("time25: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(83);
        sb.append("- Journal Entry 10");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 83;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time29() {
        StringBuilder sb = new StringBuilder();
        sb.append("time29: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(84);
        sb.append("- Journal Entry 11");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 84;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time32() {
        StringBuilder sb = new StringBuilder();
        sb.append("time32: returns plate ");
        Objects.requireNonNull(this.chapter4);
        sb.append(125);
        sb.append("- Journal Entry 12");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter4);
        return 125;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r2 > 57) goto L7;
     */
    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean onNormalPath(int r2) {
        /*
            r1 = this;
            com.shadowborne_games.oathsworn.book.Chapter4 r0 = r1.chapter4
            java.util.Objects.requireNonNull(r0)
            if (r2 < 0) goto L10
            com.shadowborne_games.oathsworn.book.Chapter4 r0 = r1.chapter4
            java.util.Objects.requireNonNull(r0)
            r0 = 57
            if (r2 <= r0) goto L22
        L10:
            com.shadowborne_games.oathsworn.book.Chapter4 r0 = r1.chapter4
            java.util.Objects.requireNonNull(r0)
            r0 = 90
            if (r2 < r0) goto L24
            com.shadowborne_games.oathsworn.book.Chapter4 r0 = r1.chapter4
            java.util.Objects.requireNonNull(r0)
            r0 = 124(0x7c, float:1.74E-43)
            if (r2 > r0) goto L24
        L22:
            r2 = 1
            goto L25
        L24:
            r2 = 0
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.gameTrackers.GT4.onNormalPath(int):boolean");
    }
}
