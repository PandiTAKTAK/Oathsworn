package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter17;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT17 extends TimeTrackers {
    private static final String TAG = "GT17";
    Chapter17 chapter17;

    public GT17(Context context, int i, ArrayList<Integer> arrayList, HashMap<Integer, Integer> hashMap) {
        super(context, i);
        this.chapter17 = new Chapter17();
        this.deepwoodMap = hashMap;
        this.allDeepwoodTokens = arrayList;
        setupDeepwood(arrayList);
        Log.d(TAG, "GT17: public Constructor calling super, setup deepwoodMap and deepwoodTokens");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time1() {
        StringBuilder sb = new StringBuilder();
        sb.append("time1: returns plate ");
        Objects.requireNonNull(this.chapter17);
        sb.append(101);
        sb.append("- 17m_1_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter17);
        return 101;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time3() {
        StringBuilder sb = new StringBuilder();
        sb.append("time3: returns plate ");
        Objects.requireNonNull(this.chapter17);
        sb.append(105);
        sb.append("- 17m_2_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter17);
        return 105;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time6() {
        StringBuilder sb = new StringBuilder();
        sb.append("time6: returns plate ");
        Objects.requireNonNull(this.chapter17);
        sb.append(106);
        sb.append("- 17m_3_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter17);
        return 106;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time11() {
        StringBuilder sb = new StringBuilder();
        sb.append("time11: returns plate ");
        Objects.requireNonNull(this.chapter17);
        sb.append(117);
        sb.append("- 17m_4_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter17);
        return 117;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time15() {
        StringBuilder sb = new StringBuilder();
        sb.append("time15: returns plate ");
        Objects.requireNonNull(this.chapter17);
        sb.append(126);
        sb.append("- 17m_5_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter17);
        return 126;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time20() {
        StringBuilder sb = new StringBuilder();
        sb.append("time20: returns plate ");
        Objects.requireNonNull(this.chapter17);
        sb.append(134);
        sb.append("- 17m_6_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter17);
        return 134;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time25() {
        StringBuilder sb = new StringBuilder();
        sb.append("time25: returns plate ");
        Objects.requireNonNull(this.chapter17);
        sb.append(135);
        sb.append("- 17m_7_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter17);
        return 135;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time30() {
        StringBuilder sb = new StringBuilder();
        sb.append("time30: returns plate ");
        Objects.requireNonNull(this.chapter17);
        sb.append(136);
        sb.append("- 17m_8_1");
        Log.d(TAG, sb.toString());
        Objects.requireNonNull(this.chapter17);
        return 136;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r2 > 100) goto L7;
     */
    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean onNormalPath(int r2) {
        /*
            r1 = this;
            com.shadowborne_games.oathsworn.book.Chapter17 r0 = r1.chapter17
            java.util.Objects.requireNonNull(r0)
            if (r2 < 0) goto L10
            com.shadowborne_games.oathsworn.book.Chapter17 r0 = r1.chapter17
            java.util.Objects.requireNonNull(r0)
            r0 = 100
            if (r2 <= r0) goto L19
        L10:
            com.shadowborne_games.oathsworn.book.Chapter17 r0 = r1.chapter17
            java.util.Objects.requireNonNull(r0)
            r0 = 139(0x8b, float:1.95E-43)
            if (r2 < r0) goto L1b
        L19:
            r2 = 1
            goto L1c
        L1b:
            r2 = 0
        L1c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.gameTrackers.GT17.onNormalPath(int):boolean");
    }
}
