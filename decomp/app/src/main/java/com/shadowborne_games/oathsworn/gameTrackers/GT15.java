package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.book.Chapter15;
import java.util.Objects;

/* loaded from: classes.dex */
public class GT15 extends TimeTrackers {
    private static final String TAG = "GT15";
    Chapter15 chapter15;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected boolean onNormalPath(int i) {
        return true;
    }

    public GT15(Context context, int i) {
        super(context, i);
        this.chapter15 = new Chapter15();
        Log.d(TAG, "GT15: public Constructor calling super");
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time5() {
        Log.d(TAG, "time5: determine if on path A or B, if path B- redirect to 15b_30_1");
        this.nextPositionToken = sharedPreferencesSingleton.getInt("nextPositionToken", this.chapterNum);
        int i = this.nextPositionToken;
        Objects.requireNonNull(this.chapter15);
        if (i >= 106) {
            int i2 = this.nextPositionToken;
            Objects.requireNonNull(this.chapter15);
            if (i2 <= 218) {
                Objects.requireNonNull(this.chapter15);
                Log.d(TAG, "--- determined " + this.nextPositionToken + " is on path B, redirected to section");
                return 195;
            }
        }
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.TimeTrackers, com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time10() {
        Log.d(TAG, "time10: determine if on path A or B, if path A- redirect to 15a_8_1");
        this.nextPositionToken = sharedPreferencesSingleton.getInt("nextPositionToken", this.chapterNum);
        int i = this.nextPositionToken;
        Objects.requireNonNull(this.chapter15);
        if (i >= 106) {
            int i2 = this.nextPositionToken;
            Objects.requireNonNull(this.chapter15);
            if (i2 <= 218) {
                return -1;
            }
        }
        Objects.requireNonNull(this.chapter15);
        Log.d(TAG, "--- determined " + this.nextPositionToken + " is on path A, redirected to section");
        return 33;
    }
}
