package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public class GT6 extends TimeTrackers {
    private static final String TAG = "GT6";

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT6(Context context, int i) {
        super(context, i);
        Log.d(TAG, "GT6: public Constructor calling super");
    }
}
