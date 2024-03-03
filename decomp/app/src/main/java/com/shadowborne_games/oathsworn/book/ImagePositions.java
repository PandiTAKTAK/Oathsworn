package com.shadowborne_games.oathsworn.book;

/* loaded from: classes.dex */
public final class ImagePositions {
    private final int[] imagePositions;

    public ImagePositions(int[] iArr) {
        this.imagePositions = iArr;
    }

    public boolean hasImagePositions() {
        return this.imagePositions[0] != -1;
    }

    public int[] getImagePositions() {
        return this.imagePositions;
    }
}
