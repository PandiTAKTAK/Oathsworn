package com.shadowborne_games.oathsworn.gameTrackers;

import android.content.Context;
import android.util.Log;
import com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class GameTrackers {
    private static final String TAG = "gameTrackers";
    protected static SharedPreferencesSingleton sharedPreferencesSingleton;
    protected int chapterNum;
    protected HashMap<Integer, Integer> deepwoodMap;
    protected final int defaultSectionNum = 0;
    protected ArrayList<Integer> timeAddedList = new ArrayList<>();
    protected ArrayList<Integer> sectionsList = new ArrayList<>();
    protected ArrayList<Integer> locationsList = new ArrayList<>();
    protected ArrayList<Integer> removedLocationsList = new ArrayList<>();
    protected ArrayList<Integer> amountErased = new ArrayList<>();
    protected int nextPositionToken = -1;
    protected ArrayList<Integer> nextPositionTokenWhenTimeWasTripped = new ArrayList<>();
    protected int timeTrackRedirectedSectionNum = -1;
    protected boolean deepwoodChapter = false;
    protected ArrayList<Integer> allDeepwoodTokens = new ArrayList<>();
    protected ArrayList<Integer> unvisitedDeepwoodTokens = new ArrayList<>();

    public abstract void addTime(int i, int i2);

    public abstract void clearAllChapterTime(int i);

    public abstract int getTime(int i);

    protected abstract boolean onNormalPath(int i);

    public abstract void removeTime(int i, int i2);

    public abstract int time1();

    public abstract int time10();

    public abstract int time11();

    public abstract int time12();

    public abstract int time13();

    public abstract int time14();

    public abstract int time15();

    public abstract int time16();

    public abstract int time17();

    public abstract int time18();

    public abstract int time19();

    public abstract int time2();

    public abstract int time20();

    public abstract int time21();

    public abstract int time22();

    public abstract int time23();

    public abstract int time24();

    public abstract int time25();

    public abstract int time26();

    public abstract int time27();

    public abstract int time28();

    public abstract int time29();

    public abstract int time3();

    public abstract int time30();

    public abstract int time31();

    public abstract int time32();

    public abstract int time4();

    public abstract int time5();

    public abstract int time6();

    public abstract int time7();

    public abstract int time8();

    public abstract int time9();

    protected abstract int[] timePop(int i, int i2);

    public GameTrackers(Context context, int i) {
        Log.d(TAG, "gameTrackers: getInstance of sharedPreferencesSingleton and set chapterNum to " + i);
        sharedPreferencesSingleton = SharedPreferencesSingleton.getInstance(context);
        this.chapterNum = i;
    }

    public void setupDeepwood(ArrayList<Integer> arrayList) {
        Log.d(TAG, "setupDeepwood: chp " + this.chapterNum + ": tell app this is a deepwood chapter; re-add all unvisitedDeepwoodTokens if the array is currently empty (issue?)");
        this.deepwoodChapter = true;
        if (sharedPreferencesSingleton.getArray("unvisitedDeepwoodTokens", this.chapterNum).isEmpty()) {
            sharedPreferencesSingleton.saveArray("unvisitedDeepwoodTokens", this.chapterNum, arrayList);
            Log.d(TAG, "---setupDeepwood: re-added unvisitedDeepwoodTokens: " + arrayList);
        }
    }

    public int secondDeepwoodPlateVisitChangesSectionNum(int i) {
        Log.d(TAG, "secondDeepwoodPlateVisitChangesSectionNum: get unvisitedDeepwoodTokens; if next plate is deepwood plate (not just in deepwood chapter), if plate hasn't been visited before- remove it, otherwise redirect to second visit plate");
        this.unvisitedDeepwoodTokens = sharedPreferencesSingleton.getArray("unvisitedDeepwoodTokens", this.chapterNum);
        this.sectionsList = sharedPreferencesSingleton.getArray("sectionsList", this.chapterNum);
        Log.d(TAG, "---secondDeepwoodPlateVisitChangesSectionNum: unvisitedDeepwoodTokens = " + this.unvisitedDeepwoodTokens);
        StringBuilder sb = new StringBuilder();
        sb.append("SSS--- sectionsList.last = ");
        ArrayList<Integer> arrayList = this.sectionsList;
        sb.append(arrayList.get(arrayList.size() - 1));
        Log.d(TAG, sb.toString());
        Log.d(TAG, "SSS--- currentSectionNum = " + i);
        if (this.allDeepwoodTokens.contains(Integer.valueOf(i)) && !this.unvisitedDeepwoodTokens.contains(Integer.valueOf(i))) {
            Integer num = this.deepwoodMap.get(Integer.valueOf(i));
            Log.d(TAG, "SSS--- currentSectionNum - " + i + " - is - " + this.deepwoodMap.get(Integer.valueOf(i)) + " - on deepwoodMap");
            if (num != null) {
                Log.d(TAG, "SSS--- set currentSectionNum - " + i + " - to second visit location - " + num);
                i = num.intValue();
            } else {
                i = -1;
                Log.d(TAG, "SSS--- ERROR: set currentSectionNum to -1");
            }
        }
        if (this.sectionsList.size() >= 1) {
            Log.d(TAG, "SSS--- testing if last plate was a deepwood plate...");
            ArrayList<Integer> arrayList2 = this.allDeepwoodTokens;
            ArrayList<Integer> arrayList3 = this.sectionsList;
            if (arrayList2.contains(arrayList3.get(arrayList3.size() - 1))) {
                Log.d(TAG, "SSS--- last plate was a deepwood plate");
                ArrayList<Integer> arrayList4 = this.unvisitedDeepwoodTokens;
                ArrayList<Integer> arrayList5 = this.sectionsList;
                if (arrayList4.contains(arrayList5.get(arrayList5.size() - 1))) {
                    ArrayList<Integer> arrayList6 = this.unvisitedDeepwoodTokens;
                    ArrayList<Integer> arrayList7 = this.sectionsList;
                    arrayList6.remove(arrayList7.get(arrayList7.size() - 1));
                    sharedPreferencesSingleton.saveArray("unvisitedDeepwoodTokens", this.chapterNum, this.unvisitedDeepwoodTokens);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SSS--- removed - ");
                    ArrayList<Integer> arrayList8 = this.sectionsList;
                    sb2.append(arrayList8.get(arrayList8.size() - 1));
                    sb2.append(" - from unvisitedDeepwoodTokens: ");
                    sb2.append(this.unvisitedDeepwoodTokens);
                    Log.d(TAG, sb2.toString());
                }
            } else {
                Log.d(TAG, "SSS--- last plate was NOT a deepwood plate");
            }
        }
        return i;
    }

    public void reAddDeepwoodPlateIfPressingBackFromFirstDeepwoodPlate(int i) {
        Log.d(TAG, "reAddDeepwoodPlateIfPressingBackFromFirstDeepwoodPlate: if current plate is an actual deepwood plate (not just in a deepwood chapter), add it back to the unvisitedDeepwoodTokens array.");
        ArrayList<Integer> array = sharedPreferencesSingleton.getArray("sectionsList", this.chapterNum);
        this.sectionsList = array;
        if (array.size() >= 2) {
            ArrayList<Integer> arrayList = this.allDeepwoodTokens;
            ArrayList<Integer> arrayList2 = this.sectionsList;
            if (arrayList.contains(arrayList2.get(arrayList2.size() - 2))) {
                ArrayList<Integer> array2 = sharedPreferencesSingleton.getArray("unvisitedDeepwoodTokens", this.chapterNum);
                this.unvisitedDeepwoodTokens = array2;
                ArrayList<Integer> arrayList3 = this.sectionsList;
                array2.add(arrayList3.get(arrayList3.size() - 2));
                sharedPreferencesSingleton.saveArray("unvisitedDeepwoodTokens", this.chapterNum, this.unvisitedDeepwoodTokens);
                StringBuilder sb = new StringBuilder();
                sb.append("SSS---re-added - ");
                ArrayList<Integer> arrayList4 = this.sectionsList;
                sb.append(arrayList4.get(arrayList4.size() - 2));
                sb.append(" - to unvisitedDeepwoodTokens: ");
                sb.append(this.unvisitedDeepwoodTokens);
                Log.d(TAG, sb.toString());
            }
        }
    }

    public void setCurrentSectionNum(int i, int i2, int[] iArr, boolean z, int[] iArr2, int[] iArr3, int i3) {
        int secondDeepwoodPlateVisitChangesSectionNum;
        Log.d(TAG, "setCurrentSectionNum: set clues, redirect to clueLocation, add time, redirect to time popped location, remove specific locations, clear locationsList, add locations to locationsList, redirect to second visit deepwood plate, ");
        this.timeTrackRedirectedSectionNum = sharedPreferencesSingleton.getInt("timeTrackRedirectedSectionNum", i);
        Log.d(TAG, "DDD---timeTrackRedirectedSectionNum1: " + this.timeTrackRedirectedSectionNum);
        if (this.timeTrackRedirectedSectionNum != -1) {
            Log.d(TAG, "--- currentSectionNum - " + i2 + " - changed to time track triggered sectionNum: " + this.timeTrackRedirectedSectionNum);
            i2 = this.timeTrackRedirectedSectionNum;
        }
        if (iArr3[0] != -1) {
            chapterOneAddAndPopClues(i2, iArr3, i3);
            Log.d(TAG, "--- redirected to chapterOneAddAndPopClues method");
        }
        if (iArr2[0] != -1) {
            for (int i4 = 0; i4 < iArr2.length; i4++) {
                if (this.locationsList.contains(Integer.valueOf(iArr2[i4]))) {
                    removeLocation(i, iArr2[i4], i3);
                }
            }
            Log.d(TAG, "--- removed locations: " + Arrays.toString(iArr2));
        }
        if (z) {
            clearLocationsList(i);
            Log.d(TAG, "--- redirected to clearLocationsList method");
        }
        this.locationsList = sharedPreferencesSingleton.getArray("locationsList", i);
        Log.d(TAG, "XXX---setCurrentSectionNum: locationsList = " + this.locationsList);
        if (iArr[0] != -1) {
            for (int i5 : iArr) {
                this.locationsList.add(Integer.valueOf(i5));
                Log.d(TAG, "--- added locations to locationsList: " + Arrays.toString(iArr));
            }
            Collections.sort(this.locationsList);
            sharedPreferencesSingleton.saveArray("locationsList", i, this.locationsList);
            Log.d(TAG, "--- saved locationsList: " + this.locationsList);
        }
        if (this.deepwoodChapter && (secondDeepwoodPlateVisitChangesSectionNum = secondDeepwoodPlateVisitChangesSectionNum(i2)) != -1) {
            Log.d(TAG, "--- changed currentSectionNum " + i2 + " to second visit plate: " + secondDeepwoodPlateVisitChangesSectionNum);
            i2 = secondDeepwoodPlateVisitChangesSectionNum;
        }
        ArrayList<Integer> array = sharedPreferencesSingleton.getArray("sectionsList", i);
        this.sectionsList = array;
        if (i2 != 0) {
            array.add(Integer.valueOf(i2));
        }
        sharedPreferencesSingleton.saveArray("sectionsList", i, this.sectionsList);
        Log.d(TAG, "--- added currentSectionNum - " + i2 + " - to sectionsList: " + this.sectionsList);
    }

    public void manageTime(GameTrackers gameTrackers, int i, int i2) {
        ArrayList<Integer> array = sharedPreferencesSingleton.getArray("timeAddedList", this.chapterNum);
        this.timeAddedList = array;
        array.add(Integer.valueOf(i));
        sharedPreferencesSingleton.saveArray("timeAddedList", this.chapterNum, this.timeAddedList);
        Log.d(TAG, "--- added timeAdded - " + i + " - to timeAddedList: " + this.timeAddedList);
        if (i != -1) {
            gameTrackers.addTime(this.chapterNum, i);
            Log.d(TAG, "--- redirected to addTime method");
        }
        if (i != -1 && i2 != -3 && gameTrackers.onNormalPath(i2)) {
            this.nextPositionToken = i2;
            sharedPreferencesSingleton.saveInt("nextPositionToken", this.chapterNum, i2);
            Log.d(TAG, "--- set nextPositionToken - " + this.nextPositionToken);
        }
        Log.d(TAG, "DDD---timeTrackRedirectedSectionNum2a: " + this.timeTrackRedirectedSectionNum);
        this.timeTrackRedirectedSectionNum = gameTrackers.timePop(this.chapterNum, i)[0];
        Log.d(TAG, "DDD---timeTrackRedirectedSectionNum2b: " + this.timeTrackRedirectedSectionNum);
        sharedPreferencesSingleton.saveInt("timeTrackRedirectedSectionNum", this.chapterNum, this.timeTrackRedirectedSectionNum);
        Log.d(TAG, "--- set timeTrackRedirectedSectionNum - " + this.timeTrackRedirectedSectionNum);
    }

    public int returnToNextPositionToken(int i) {
        Log.d(TAG, "returnToNextPositionToken: if time track redirected player elsewhere, redirect back- get the nextPositionToken and add it to the sectionsList");
        this.sectionsList = sharedPreferencesSingleton.getArray("sectionsList", i);
        this.nextPositionToken = sharedPreferencesSingleton.getInt("nextPositionToken", i);
        Log.d(TAG, "--- nextPositionToken: " + this.nextPositionToken);
        sharedPreferencesSingleton.saveArray("sectionsList", i, this.sectionsList);
        return this.nextPositionToken;
    }

    public int diedRestartChapter(int i) {
        clearCampaign(i);
        return 0;
    }

    public int getCurrentSectionNum(int i) {
        int i2;
        Log.d(TAG, "getCurrentSectionNum: if at least one plate has been visited- get currentSectionNum, otherwise- add defaultSectionNum and get that.");
        ArrayList<Integer> array = sharedPreferencesSingleton.getArray("sectionsList", i);
        this.sectionsList = array;
        if (array.size() > 0) {
            ArrayList<Integer> arrayList = this.sectionsList;
            i2 = arrayList.get(arrayList.size() - 1).intValue();
            Log.d(TAG, "--- set currentSectionNum to currentSectionNum - " + i2);
        } else {
            this.sectionsList.add(0);
            int intValue = this.sectionsList.get(0).intValue();
            sharedPreferencesSingleton.saveArray("sectionsList", i, this.sectionsList);
            Log.d(TAG, "--- set currentSectionNum to defaultSectionNum - 0, then saved it to sectionsList");
            i2 = intValue;
        }
        Log.d(TAG, "--- returned currentSectionNum - " + i2);
        return i2;
    }

    public void removeCurrentSectionNum(int i, int[] iArr, boolean z, boolean z2, int[] iArr2, int i2, int[] iArr3, int i3, int[] iArr4, int i4, GameTrackers gameTrackers) {
        int i5;
        Log.d(TAG, "removeCurrentSectionNum: get currentSectionNum; if time added- remove it; removeTimePoppedSectionNumTime; if deepwoodChapter and first visit to a deepwood plate- re-add its plate number to unvisitedDeepwoodTokens; if clueLocation (i.e. chapter 1 location 4)- add clueLocation to removedLocationsList; if plate added clues- remove and unpop clues; remove newly added locations from locationsList; undo clear locationsList; re-add specific locations to locationsList that had been removed; re-add currentSectionNum to locationsList since it is a location; if more than one plate has been visited- remove the current plate");
        int currentSectionNum = getCurrentSectionNum(i);
        Log.d(TAG, "--- set currentSectionNum by redirecting to getCurrentSectionNum method");
        ArrayList<Integer> array = sharedPreferencesSingleton.getArray("timeAddedList", i);
        this.timeAddedList = array;
        if (array.size() >= 1) {
            ArrayList<Integer> arrayList = this.timeAddedList;
            i5 = arrayList.get(arrayList.size() - 1).intValue();
        } else {
            i5 = -1;
        }
        Log.d(TAG, "--- currentTimeAdded = " + i5);
        if (i5 != -1) {
            gameTrackers.removeTime(i, i5);
        }
        if (this.timeAddedList.size() >= 1) {
            ArrayList<Integer> array2 = sharedPreferencesSingleton.getArray("timeAddedList", i);
            this.timeAddedList = array2;
            array2.remove(array2.size() - 1);
            sharedPreferencesSingleton.saveArray("timeAddedList", i, this.timeAddedList);
        }
        if (this.deepwoodChapter) {
            Log.d(TAG, "--- redirected to reAddDeepwoodPlateIfPressingBackFromFirstDeepwoodPlate()");
            reAddDeepwoodPlateIfPressingBackFromFirstDeepwoodPlate(currentSectionNum);
        }
        if (currentSectionNum == i3) {
            ArrayList<Integer> array3 = sharedPreferencesSingleton.getArray("removedLocationsList", i);
            this.removedLocationsList = array3;
            array3.add(Integer.valueOf(i4));
            sharedPreferencesSingleton.saveArray("removedLocationsList", i, this.removedLocationsList);
            Log.d(TAG, "--- added clueLocation - " + i4 + " - to removedLocationsList");
        }
        if (iArr4[0] != -1) {
            chapterOneRemoveAndUnPopClues(currentSectionNum, iArr4, i4);
            Log.d(TAG, "--- redirected to chapterOneRemoveAndUnPopClues");
        }
        if (iArr[0] != -1) {
            this.locationsList = sharedPreferencesSingleton.getArray("locationsList", i);
            for (int i6 : iArr) {
                this.locationsList.remove(Integer.valueOf(i6));
                Log.d(TAG, "--- removed locations " + Arrays.toString(iArr) + " from locationsList");
            }
            sharedPreferencesSingleton.saveArray("locationsList", i, this.locationsList);
        }
        if (z2) {
            undoClearLocationsList(i);
            Log.d(TAG, "--- redirected to undoClearLocationsList");
        }
        if (iArr2[0] != -1) {
            for (int i7 : iArr2) {
                if (this.removedLocationsList.contains(Integer.valueOf(i7))) {
                    reAddLocation(i);
                }
                Log.d(TAG, "--- redirected to reAddLocation method- for every specific location removed");
            }
        }
        if (z) {
            reAddLocation(i);
            Log.d(TAG, "--- redirected to reAddLocation method- for the currentSectionNum since it is a location");
        }
        ArrayList<Integer> array4 = sharedPreferencesSingleton.getArray("nextPositionTokenWhenTimeWasTripped", i);
        this.nextPositionTokenWhenTimeWasTripped = array4;
        if (array4.size() >= 1) {
            ArrayList<Integer> arrayList2 = this.nextPositionTokenWhenTimeWasTripped;
            if (arrayList2.get(arrayList2.size() - 1).intValue() == currentSectionNum) {
                reAddLocation(i);
                Log.d(TAG, "--- last location re-added to locationsList: " + this.locationsList);
                Log.d(TAG, "--- nextPositionTokenWhenTimeWasTripped: " + this.nextPositionTokenWhenTimeWasTripped);
            }
        }
        if (this.sectionsList.size() > 1) {
            ArrayList<Integer> arrayList3 = this.sectionsList;
            arrayList3.remove(arrayList3.size() - 1);
            Log.d(TAG, "DDD---timeTrackRedirectedSectionNum3: " + this.timeTrackRedirectedSectionNum);
            sharedPreferencesSingleton.saveArray("sectionsList", i, this.sectionsList);
        }
    }

    public void clearCampaign(int i) {
        Log.d(TAG, "clearCampaign: clear all chapters and restart game");
        sharedPreferencesSingleton.saveArray("unvisitedDeepwoodTokens", i, new ArrayList());
        Log.d(TAG, "---clearCampaign: unvisitedDeepwoodTokens = " + this.unvisitedDeepwoodTokens);
        sharedPreferencesSingleton.saveArray("sectionsList", i, new ArrayList());
        sharedPreferencesSingleton.saveArray("locationsList", i, new ArrayList());
        sharedPreferencesSingleton.saveArray("amountErased", i, new ArrayList());
        sharedPreferencesSingleton.saveArray("removedLocationsList", i, new ArrayList());
        sharedPreferencesSingleton.saveArray("timeAddedList", i, new ArrayList());
        sharedPreferencesSingleton.saveArray("nextPositionTokenWhenTimeWasTripped", i, new ArrayList());
        Log.d(TAG, "--- cleared unvisitedDeepwoodTokens: " + this.unvisitedDeepwoodTokens.size() + ", sectionsList: " + this.sectionsList.size() + ", locationsList: " + this.locationsList.size() + ", amountErased: " + this.amountErased.size() + ", removedLocationsList: " + this.removedLocationsList.size() + ", nextPositionTokenWhenTimeWasTripped: " + this.nextPositionTokenWhenTimeWasTripped.size());
        clearAllChapterTime(i);
        Log.d(TAG, "--- redirected to clearAllChapterTime");
        this.sectionsList.add(0);
        StringBuilder sb = new StringBuilder();
        sb.append("--- reset sectionsList: ");
        sb.append(this.sectionsList);
        Log.d(TAG, sb.toString());
        sharedPreferencesSingleton.saveBoolean("clue1", i, false);
        sharedPreferencesSingleton.saveBoolean("clue2", i, false);
        sharedPreferencesSingleton.saveInt("timeTrackRedirectedSectionNum", i, -1);
        sharedPreferencesSingleton.saveInt("nextPositionToken", i, -1);
        Log.d(TAG, "--- reset clue1, clue2, timeTrackRedirectedSectionNum and nextPositionToken to defaults");
    }

    private void clearLocationsList(int i) {
        Log.d(TAG, "clearLocationsList: adds size of locationsList to amountErased array, adds all locations in locationsList to removedLocationsList, then clears locationsList");
        this.locationsList = sharedPreferencesSingleton.getArray("locationsList", i);
        this.amountErased = sharedPreferencesSingleton.getArray("amountErased", i);
        this.removedLocationsList = sharedPreferencesSingleton.getArray("removedLocationsList", i);
        Log.d(TAG, "--- added int " + this.locationsList.size() + " to amountErased array");
        this.amountErased.add(Integer.valueOf(this.locationsList.size()));
        Log.d(TAG, "--- moved " + this.locationsList + " from locationsList to removedLocationsList, then cleared locationsList");
        this.removedLocationsList.addAll(this.locationsList);
        this.locationsList.clear();
        sharedPreferencesSingleton.saveArray("locationsList", i, this.locationsList);
        sharedPreferencesSingleton.saveArray("amountErased", i, this.amountErased);
        sharedPreferencesSingleton.saveArray("removedLocationsList", i, this.removedLocationsList);
    }

    private void undoClearLocationsList(int i) {
        Log.d(TAG, "undoClearLocationsList: undoes clearing of locationsList");
        this.locationsList = sharedPreferencesSingleton.getArray("locationsList", i);
        this.amountErased = sharedPreferencesSingleton.getArray("amountErased", i);
        this.removedLocationsList = sharedPreferencesSingleton.getArray("removedLocationsList", i);
        int i2 = 0;
        while (true) {
            ArrayList<Integer> arrayList = this.amountErased;
            if (i2 < arrayList.get(arrayList.size() - 1).intValue()) {
                ArrayList<Integer> arrayList2 = this.locationsList;
                ArrayList<Integer> arrayList3 = this.removedLocationsList;
                arrayList2.add(arrayList3.get(arrayList3.size() - 1));
                ArrayList<Integer> arrayList4 = this.removedLocationsList;
                arrayList4.remove(arrayList4.size() - 1);
                StringBuilder sb = new StringBuilder();
                sb.append("--- moved ");
                ArrayList<Integer> arrayList5 = this.locationsList;
                sb.append(arrayList5.get(arrayList5.size() - 1));
                sb.append(" from removedLocationsList to locationsList");
                Log.d(TAG, sb.toString());
                i2++;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("--- removed int ");
                sb2.append(this.amountErased.size() - 1);
                sb2.append(" from amountErased array");
                Log.d(TAG, sb2.toString());
                ArrayList<Integer> arrayList6 = this.amountErased;
                arrayList6.remove(arrayList6.size() - 1);
                Collections.sort(this.locationsList);
                sharedPreferencesSingleton.saveArray("locationsList", i, this.locationsList);
                sharedPreferencesSingleton.saveArray("amountErased", i, this.amountErased);
                sharedPreferencesSingleton.saveArray("removedLocationsList", i, this.removedLocationsList);
                return;
            }
        }
    }

    public ArrayList<Integer> getLocationsList(int i) {
        this.locationsList = sharedPreferencesSingleton.getArray("locationsList", i);
        Log.d(TAG, "getLocationsList: return locationsList: " + this.locationsList);
        return this.locationsList;
    }

    public void removeLocation(int i, int i2, int i3) {
        Log.d(TAG, "removeLocation: remove a specific location.");
        this.locationsList = sharedPreferencesSingleton.getArray("locationsList", i);
        this.removedLocationsList = sharedPreferencesSingleton.getArray("removedLocationsList", i);
        this.nextPositionTokenWhenTimeWasTripped = sharedPreferencesSingleton.getArray("nextPositionTokenWhenTimeWasTripped", i);
        this.locationsList.remove(Integer.valueOf(i2));
        if (i2 != i3) {
            this.removedLocationsList.add(Integer.valueOf(i2));
            this.nextPositionTokenWhenTimeWasTripped.add(Integer.valueOf(this.timeTrackRedirectedSectionNum));
        }
        sharedPreferencesSingleton.saveArray("locationsList", i, this.locationsList);
        sharedPreferencesSingleton.saveArray("removedLocationsList", i, this.removedLocationsList);
        sharedPreferencesSingleton.saveArray("nextPositionTokenWhenTimeWasTripped", i, this.nextPositionTokenWhenTimeWasTripped);
        Log.d(TAG, "--- removed location " + i2 + " from locationsList: " + this.locationsList);
        Log.d(TAG, "--- added location " + i2 + " to removedLocationsList: " + this.removedLocationsList);
        Log.d(TAG, "--- added timeTrackRedirectedSectionNum - " + this.timeTrackRedirectedSectionNum + " - to nextPositionTokenWhenTimeWasTripped: " + this.nextPositionTokenWhenTimeWasTripped);
    }

    public void reAddLocation(int i) {
        Log.d(TAG, "reAddLocation: re-add last element of removedLocationsList to locationsList, and remove it from removedLocationsList");
        this.locationsList = sharedPreferencesSingleton.getArray("locationsList", i);
        this.removedLocationsList = sharedPreferencesSingleton.getArray("removedLocationsList", i);
        this.nextPositionTokenWhenTimeWasTripped = sharedPreferencesSingleton.getArray("nextPositionTokenWhenTimeWasTripped", i);
        if (this.removedLocationsList.size() > 0) {
            ArrayList<Integer> arrayList = this.locationsList;
            ArrayList<Integer> arrayList2 = this.removedLocationsList;
            arrayList.add(arrayList2.get(arrayList2.size() - 1));
            ArrayList<Integer> arrayList3 = this.removedLocationsList;
            arrayList3.remove(arrayList3.size() - 1);
            if (this.nextPositionTokenWhenTimeWasTripped.size() > 0) {
                ArrayList<Integer> arrayList4 = this.nextPositionTokenWhenTimeWasTripped;
                arrayList4.remove(arrayList4.size() - 1);
            }
        }
        Collections.sort(this.locationsList);
        sharedPreferencesSingleton.saveArray("locationsList", i, this.locationsList);
        sharedPreferencesSingleton.saveArray("removedLocationsList", i, this.removedLocationsList);
        sharedPreferencesSingleton.saveArray("nextPositionTokenWhenTimeWasTripped", i, this.nextPositionTokenWhenTimeWasTripped);
        Log.d(TAG, "--- locationsList.add(last element of removedLocationsList): " + this.locationsList);
        Log.d(TAG, "--- removedLocationsList.remove(last): " + this.removedLocationsList);
        Log.d(TAG, "--- nextPositionTokenWhenTimeWasTripped.removed(last) = " + this.nextPositionTokenWhenTimeWasTripped);
    }

    private void chapterOneAddAndPopClues(int i, int[] iArr, int i2) {
        Log.d(TAG, "chapterOneAddAndPopClues: if currentSectionNum adds a clue- save it, if player has both clues- add location 4.");
        if (i == iArr[0]) {
            saveClue1();
            Log.d(TAG, "--- redirected to saveClue1 method");
        }
        if (i == iArr[1]) {
            saveClue2();
            Log.d(TAG, "--- redirected to saveClue2 method");
        }
        if ((i == iArr[0] || i == iArr[1]) && (getClue1() && getClue2())) {
            ArrayList<Integer> array = sharedPreferencesSingleton.getArray("locationsList", this.chapterNum);
            this.locationsList = array;
            array.add(Integer.valueOf(i2));
            Collections.sort(this.locationsList);
            sharedPreferencesSingleton.saveArray("locationsList", this.chapterNum, this.locationsList);
            Log.d(TAG, "--- added clueLocation " + i2 + " to locationsList");
        }
    }

    private void chapterOneRemoveAndUnPopClues(int i, int[] iArr, int i2) {
        Log.d(TAG, "chapterOneRemoveAndUnPopClues: if currentSectionNum added a clue- remove it");
        if (i == iArr[0]) {
            if (getClue1() && getClue2()) {
                removeLocation(this.chapterNum, i2, i2);
                Log.d(TAG, "--- redirected to removeLocation method");
            }
            removeClue1();
            Log.d(TAG, "--- redirected to removeClue1 method");
        }
        if (i == iArr[1]) {
            if (getClue1() && getClue2()) {
                removeLocation(this.chapterNum, i2, i2);
                Log.d(TAG, "--- redirected to removeLocation method");
            }
            removeClue2();
            Log.d(TAG, "--- redirected to removeClue2 method");
        }
    }

    private void saveClue1() {
        Log.d(TAG, "saveClue1: saved clue 1 as true");
        sharedPreferencesSingleton.saveBoolean("clue1", this.chapterNum, true);
    }

    private void saveClue2() {
        Log.d(TAG, "saveClue2: saved clue 2 as true");
        sharedPreferencesSingleton.saveBoolean("clue2", this.chapterNum, true);
    }

    private void removeClue1() {
        Log.d(TAG, "removeClue1: saved clue 1 as false");
        sharedPreferencesSingleton.saveBoolean("clue1", this.chapterNum, false);
    }

    private void removeClue2() {
        Log.d(TAG, "removeClue2: saved clue 2 as false");
        sharedPreferencesSingleton.saveBoolean("clue2", this.chapterNum, false);
    }

    private boolean getClue1() {
        Log.d(TAG, "getClue1: retrieved clue 1");
        return sharedPreferencesSingleton.getBoolean("clue1", this.chapterNum);
    }

    private boolean getClue2() {
        Log.d(TAG, "getClue2: retrieved clue 2");
        return sharedPreferencesSingleton.getBoolean("clue2", this.chapterNum);
    }

    public void turnVoiceOverOn() {
        Log.d(TAG, "turnVoiceOverOn: save audioOn as true");
        sharedPreferencesSingleton.saveBoolean("audioOn", true);
    }

    public boolean getVoiceOverState() {
        Log.d(TAG, "getVoiceOverState: get audioOn");
        return sharedPreferencesSingleton.getBoolean("audioOn");
    }
}
