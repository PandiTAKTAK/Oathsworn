package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class TimeTrackers extends GameTrackers {
    private static final String TAG = "TimeTrackers";
    protected int timeTrackList;

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected abstract boolean onNormalPath(int i);

    public TimeTrackers(Context context, int i) {
        super(context, i);
        this.timeTrackList = 0;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public void clearAllChapterTime(int i) {
        Log.d(TAG, "clearAllChapterTime: clear all time from chapter's time track");
        this.timeTrackList = 0;
        sharedPreferencesSingleton.saveInt("timeTrackList", i, this.timeTrackList);
        Log.d(TAG, "--- cleared all time from chapter's time track: " + this.timeTrackList);
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public void addTime(int i, int i2) {
        this.timeTrackList = sharedPreferencesSingleton.getInt("timeTrackList", i) + i2;
        sharedPreferencesSingleton.saveInt("timeTrackList", i, this.timeTrackList);
        Log.d(TAG, "--- added - " + i2 + " - time to timeTrackList: " + this.timeTrackList);
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public void removeTime(int i, int i2) {
        int i3 = sharedPreferencesSingleton.getInt("timeTrackList", i);
        this.timeTrackList = i3;
        if (i3 >= i2 - 1) {
            this.timeTrackList = i3 - i2;
        }
        sharedPreferencesSingleton.saveInt("timeTrackList", i, this.timeTrackList);
        Log.d(TAG, "--- removed " + i2 + " time from timeTrackList- size: " + this.timeTrackList);
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time1() {
        Log.d(TAG, "time1: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time2() {
        Log.d(TAG, "time2: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time3() {
        Log.d(TAG, "time3: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time4() {
        Log.d(TAG, "time4: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time5() {
        Log.d(TAG, "time5: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time6() {
        Log.d(TAG, "time6: returns -1)");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time7() {
        Log.d(TAG, "time7: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time8() {
        Log.d(TAG, "time8: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time9() {
        Log.d(TAG, "time9: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time10() {
        Log.d(TAG, "time10: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time11() {
        Log.d(TAG, "time11: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time12() {
        Log.d(TAG, "time12: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time13() {
        Log.d(TAG, "time13: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time14() {
        Log.d(TAG, "time14: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time15() {
        Log.d(TAG, "time15: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time16() {
        Log.d(TAG, "time16: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time17() {
        Log.d(TAG, "time17: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time18() {
        Log.d(TAG, "time18: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time19() {
        Log.d(TAG, "time19: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time20() {
        Log.d(TAG, "time20: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time21() {
        Log.d(TAG, "time21: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time22() {
        Log.d(TAG, "time22: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time23() {
        Log.d(TAG, "time23: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time24() {
        Log.d(TAG, "time24: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time25() {
        Log.d(TAG, "time25: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time26() {
        Log.d(TAG, "time26: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time27() {
        Log.d(TAG, "time27: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time28() {
        Log.d(TAG, "time28: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time29() {
        Log.d(TAG, "time29: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time30() {
        Log.d(TAG, "time30: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time31() {
        Log.d(TAG, "time31: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int time32() {
        Log.d(TAG, "time32: returns -1");
        return -1;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    public int getTime(int i) {
        this.timeTrackList = sharedPreferencesSingleton.getInt("timeTrackList", i);
        Log.d(TAG, "getTime: return timeTrackList: " + this.timeTrackList);
        return this.timeTrackList;
    }

    @Override // com.shadowborne_games.oathsworn.gameTrackers.GameTrackers
    protected int[] timePop(int i, int i2) {
        Log.d(TAG, "timePop: set timeTrackRedirectedSectionNum to time popped value (or -1 if time didn't pop) and return it");
        int time = getTime(i) - i2;
        int i3 = -1;
        int i4 = 1;
        int i5 = -1;
        while (true) {
            if (i4 <= i2) {
                time += i4;
                switch (time) {
                    case 1:
                        i5 = time1();
                        break;
                    case 2:
                        i5 = time2();
                        break;
                    case 3:
                        i5 = time3();
                        break;
                    case 4:
                        i5 = time4();
                        break;
                    case 5:
                        i5 = time5();
                        break;
                    case 6:
                        i5 = time6();
                        break;
                    case 7:
                        i5 = time7();
                        break;
                    case 8:
                        i5 = time8();
                        break;
                    case 9:
                        i5 = time9();
                        break;
                    case 10:
                        i5 = time10();
                        break;
                    case 11:
                        i5 = time11();
                        break;
                    case 12:
                        i5 = time12();
                        break;
                    case 13:
                        i5 = time13();
                        break;
                    case 14:
                        i5 = time14();
                        break;
                    case 15:
                        i5 = time15();
                        break;
                    case 16:
                        i5 = time16();
                        break;
                    case 17:
                        i5 = time17();
                        break;
                    case 18:
                        i5 = time18();
                        break;
                    case 19:
                        i5 = time19();
                        break;
                    case 20:
                        i5 = time20();
                        break;
                    case 21:
                        i5 = time21();
                        break;
                    case 22:
                        i5 = time22();
                        break;
                    case 23:
                        i5 = time23();
                        break;
                    case 24:
                        i5 = time24();
                        break;
                    case 25:
                        i5 = time25();
                        break;
                    case 26:
                        i5 = time26();
                        break;
                    case 27:
                        i5 = time27();
                        break;
                    case 28:
                        i5 = time28();
                        break;
                    case 29:
                        i5 = time29();
                        break;
                    case 30:
                        i5 = time30();
                        break;
                    case 31:
                        i5 = time31();
                        break;
                    case 32:
                        i5 = time32();
                        break;
                }
                if (i5 == -1) {
                    i4++;
                } else if (i4 < i2) {
                    i3 = i2 - i4;
                }
            }
        }
        int[] iArr = {i5, i3};
        Log.d(TAG, "--- returned timeTrackRedirectedSectionNum: " + i5);
        return iArr;
    }
}
