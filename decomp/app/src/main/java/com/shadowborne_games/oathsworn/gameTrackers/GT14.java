package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter14;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT14 extends TimeTrackers {
    private static final String TAG = "GT14";
    Chapter14 chapter14;

    public GT14(Context context, int i, ArrayList<Integer> arrayList, HashMap<Integer, Integer> hashMap) {
        super(context, i);
        this.chapter14 = new Chapter14();
        this.deepwoodMap = hashMap;
        this.allDeepwoodTokens = arrayList;
        setupDeepwood(arrayList);
        Log.d(TAG, "GT14: public Constructor calling super, setup deepwoodMap and deepwoodTokens");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time8() {
        StringBuilder sb = new StringBuilder();
        sb.append("time8: returns plate ");
        Objects.requireNonNull(this.chapter14);
        sb.append(86);
        sb.append("- 14_55_30");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter14);
        return 86;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time16() {
        StringBuilder sb = new StringBuilder();
        sb.append("time16: returns plate ");
        Objects.requireNonNull(this.chapter14);
        sb.append(94);
        sb.append("- 14_55_40");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter14);
        return 94;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time24() {
        StringBuilder sb = new StringBuilder();
        sb.append("time24: returns plate ");
        Objects.requireNonNull(this.chapter14);
        sb.append(102);
        sb.append("- 14_55_50");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter14);
        return 102;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r2 > 149) goto L7;
     */
    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean onNormalPath(int r2) {
        /*
            r1 = this;
            com.shadowborne_games.oathsworn.book.Chapter14 r0 = r1.chapter14
            java.util.Objects.requireNonNull(r0)
            if (r2 < 0) goto L10
            com.shadowborne_games.oathsworn.book.Chapter14 r0 = r1.chapter14
            java.util.Objects.requireNonNull(r0)
            r0 = 149(0x95, float:2.09E-43)
            if (r2 <= r0) goto L19
        L10:
            com.shadowborne_games.oathsworn.book.Chapter14 r0 = r1.chapter14
            java.util.Objects.requireNonNull(r0)
            r0 = 162(0xa2, float:2.27E-43)
            if (r2 < r0) goto L1b
        L19:
            r2 = 1
            goto L1c
        L1b:
            r2 = 0
        L1c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.gameTrackers.GT14.onNormalPath(int):boolean");
    }
}
