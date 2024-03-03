package com.shadowborne_games.oathsworn.book;

/* loaded from: classes.dex */
public final class Choice {
    private final int choiceText;
    private final int nextSectionNum;

    public Choice(int i, int i2) {
        this.choiceText = i;
        this.nextSectionNum = i2;
    }

    public int getChoiceText() {
        return this.choiceText;
    }

    public int getNextSectionNum() {
        return this.nextSectionNum;
    }
}
