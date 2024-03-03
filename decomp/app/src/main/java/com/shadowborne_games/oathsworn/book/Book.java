package com.shadowborne_games.oathsworn.book;

import android.util.Log;
import android.util.SparseIntArray;
import com.shadowborne_games.oathsworn.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class Book {
    int chapterNum;
    int[] clue;
    int clueLocation;
    int clueLocationSectionNum;
    boolean deepwoodChapter;
    HashMap<Integer, Integer> deepwoodMap;
    List<Integer> deepwoodTokens;
    protected Section[] sections;
    protected int[] timeList;
    protected int z = -1;
    protected int path = -1;
    protected SparseIntArray location = new SparseIntArray();

    public int[] getChapterAndAuthor(int i) {
        int i2;
        Log.d("DEBUG book::", "getChapterAndAuthor(int chapterNum = " + i + " )");
        int i3 = -1;
        switch (i) {
            case 1:
                i3 = R.string.chapterText1;
                i2 = R.string.authorText1;
                break;
            case 2:
                i3 = R.string.chapterText2;
                i2 = R.string.authorText2;
                break;
            case 3:
                i3 = R.string.chapterText3;
                i2 = R.string.authorText3;
                break;
            case 4:
                i3 = R.string.chapterText4;
                i2 = R.string.authorText4;
                break;
            case 5:
                i3 = R.string.chapterText5;
                i2 = R.string.authorText5;
                break;
            case 6:
                i3 = R.string.chapterText6;
                i2 = R.string.authorText6;
                break;
            case 7:
                i3 = R.string.chapterText7;
                i2 = R.string.authorText7;
                break;
            case 8:
                i3 = R.string.chapterText8;
                i2 = R.string.authorText8;
                break;
            case 9:
                i3 = R.string.chapterText9;
                i2 = R.string.authorText9;
                break;
            case 10:
                i3 = R.string.chapterText10;
                i2 = R.string.authorText10;
                break;
            case 11:
                i3 = R.string.chapterText11;
                i2 = R.string.authorText11;
                break;
            case 12:
                i3 = R.string.chapterText12;
                i2 = R.string.authorText12;
                break;
            case 13:
                i3 = R.string.chapterText13;
                i2 = R.string.authorText13;
                break;
            case 14:
                i3 = R.string.chapterText14;
                i2 = R.string.authorText14;
                break;
            case 15:
                i3 = R.string.chapterText15;
                i2 = R.string.authorText15;
                break;
            case 16:
                i3 = R.string.chapterText16;
                i2 = R.string.authorText16;
                break;
            case 17:
                i3 = R.string.chapterText17;
                i2 = R.string.authorText17;
                break;
            case 18:
                i3 = R.string.chapterText18;
                i2 = R.string.authorText18;
                break;
            case 19:
                i3 = R.string.chapterText19;
                i2 = R.string.authorText19;
                break;
            case 20:
                i3 = R.string.chapterText20;
                i2 = R.string.authorText20;
                break;
            case 21:
                i3 = R.string.chapterText21;
                i2 = R.string.authorText21;
                break;
            default:
                i2 = -1;
                break;
        }
        return new int[]{i3, i2};
    }

    public Section getSection(int i) {
        Log.d("DEBUG book::", "getSection(int sectionNum = " + i + " )");
        return this.sections[i];
    }

    public Integer getLocation(int i) {
        Log.d("DEBUG book::", "PART A: SparseIntArray location = " + this.location);
        Log.d("DEBUG book::", "PART B: getLocation(int num = " + i + " )");
        return Integer.valueOf(this.location.get(i));
    }

    public Book getChapter(int i) {
        Log.d("DEBUG book::", "getChapter(int chapterNum = " + i + " )");
        this.chapterNum = i;
        Chapter1 chapter1 = new Chapter1();
        switch (i) {
            case 1:
                return new Chapter1();
            case 2:
                return new Chapter2();
            case 3:
                return new Chapter3();
            case 4:
                return new Chapter4();
            case 5:
                return new Chapter5();
            case 6:
                return new Chapter6();
            case 7:
                return new Chapter7();
            case 8:
                return new Chapter8();
            case 9:
                return new Chapter9();
            case 10:
                return new Chapter10();
            case 11:
                return new Chapter11();
            case 12:
                return new Chapter12();
            case 13:
                return new Chapter13();
            case 14:
                return new Chapter14();
            case 15:
                return new Chapter15();
            case 16:
                return new Chapter16();
            case 17:
                return new Chapter17();
            case 18:
                return new Chapter18();
            case 19:
                return new Chapter19();
            case 20:
                return new Chapter20();
            case 21:
                return new Chapter21();
            case 22:
                return new Chapter11_5();
            default:
                return chapter1;
        }
    }

    public int[] getTimeList() {
        return this.timeList;
    }

    public int getClueLocationSectionNum() {
        return this.clueLocationSectionNum;
    }

    public int[] getClue() {
        return this.clue;
    }

    public int getClueLocation() {
        return this.clueLocation;
    }

    public ArrayList<Integer> getDeepwoodTokens() {
        return (ArrayList) this.deepwoodTokens;
    }

    public HashMap<Integer, Integer> getDeepwoodMap() {
        return this.deepwoodMap;
    }

    public boolean isDeepwoodChapter() {
        return this.deepwoodChapter;
    }
}
