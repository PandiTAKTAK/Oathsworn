package com.shadowborne_games.oathsworn.mainCampaign;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shadowborne_games.oathsworn.R;
import com.shadowborne_games.oathsworn.book.Book;
import com.shadowborne_games.oathsworn.book.Section;
import com.shadowborne_games.oathsworn.gameTrackers.GT1;
import com.shadowborne_games.oathsworn.gameTrackers.GT10;
import com.shadowborne_games.oathsworn.gameTrackers.GT11;
import com.shadowborne_games.oathsworn.gameTrackers.GT11_5;
import com.shadowborne_games.oathsworn.gameTrackers.GT12;
import com.shadowborne_games.oathsworn.gameTrackers.GT13;
import com.shadowborne_games.oathsworn.gameTrackers.GT14;
import com.shadowborne_games.oathsworn.gameTrackers.GT15;
import com.shadowborne_games.oathsworn.gameTrackers.GT16;
import com.shadowborne_games.oathsworn.gameTrackers.GT17;
import com.shadowborne_games.oathsworn.gameTrackers.GT18;
import com.shadowborne_games.oathsworn.gameTrackers.GT19;
import com.shadowborne_games.oathsworn.gameTrackers.GT2;
import com.shadowborne_games.oathsworn.gameTrackers.GT20;
import com.shadowborne_games.oathsworn.gameTrackers.GT21;
import com.shadowborne_games.oathsworn.gameTrackers.GT3;
import com.shadowborne_games.oathsworn.gameTrackers.GT4;
import com.shadowborne_games.oathsworn.gameTrackers.GT5;
import com.shadowborne_games.oathsworn.gameTrackers.GT6;
import com.shadowborne_games.oathsworn.gameTrackers.GT7;
import com.shadowborne_games.oathsworn.gameTrackers.GT8;
import com.shadowborne_games.oathsworn.gameTrackers.GT9;
import com.shadowborne_games.oathsworn.gameTrackers.GameTrackers;
import com.shadowborne_games.oathsworn.mainCampaign.RecyclerViewAdapter;
import com.shadowborne_games.oathsworn.mainCampaign.popUps.OpenInstructions;
import com.shadowborne_games.oathsworn.mainCampaign.popUps.PopUp;
import com.shadowborne_games.oathsworn.mainCampaign.popUps.PopUpMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class DisplayActivity extends AppCompatActivity implements RecyclerViewAdapter.OnPopupListener {
    private static final String TAG = "DisplayActivity";
    private int audio;
    private int audio2;
    private int audio3;
    private int audio4;
    private TextView author;
    private TextView chapter;
    private int chapterNum;
    private Section currentSection;
    public GameTrackers gameTrackers;
    private MediaPlayer mediaPlayer;
    private Section nextSection;
    private int nextSectionNum;
    private int numOfButtons;
    private int numOfSections;
    private int popUpText;
    private int popUpText2;
    private int popUpText3;
    private int popUpText4;
    private TextView textView_time;
    private Book wholeChapter = new Book();
    private boolean openedPopUp1 = false;
    private boolean openedPopUp2 = false;
    private boolean openedPopUp3 = false;
    private boolean openedPopUp4 = false;
    private int trackTracker = 1;
    private int timeWhenPaused = 0;
    private int previousPushed = 0;
    private long mLastClickTime = 0;
    private int popUpTextNum = -1;
    private int totalSectionTexts = 0;
    private final TreeMap<Integer, Object> plate_sections = new TreeMap<>();
    private final ArrayList<String> button_names = new ArrayList<>();
    private final ArrayList<Integer> button_locations = new ArrayList<>();
    private final ArrayList<Integer> location_locations = new ArrayList<>();

    private void initTexts() {
        String substring;
        int[] imagePositions;
        Log.d(TAG, "initTexts: prepare recyclerview- DISPLAY IMAGES ON PLATES IN CORRECT POSITIONS, GET SECTION TEXTS, DISPLAY SECTION TEXTS ON PLATE, GET AUDIO TRACKS, IF AUDIO TRACKS AREN'T EMPTY, ASSIGN trackTracker NUMBERS, AUTO-START AUDIO WHEN STORY TEXT IS FIRST ELEMENT ON PLATE, GET POPUP TEXT, DISPLAY POPUP BUTTONS, SET LOCATION NAMES FOR LOCATION BUTTONS, SEND PLATE CONTENTS TO initRecyclerView()");
        this.numOfSections = 0;
        this.numOfButtons = 0;
        this.totalSectionTexts = 0;
        this.plate_sections.clear();
        this.button_names.clear();
        this.button_locations.clear();
        this.location_locations.clear();
        this.chapter = (TextView) findViewById(R.id.chapter);
        this.author = (TextView) findViewById(R.id.author);
        this.chapter.setVisibility(8);
        this.author.setVisibility(8);
        int i = this.chapterNum;
        if (i != 22 && this.gameTrackers.getCurrentSectionNum(i) == 0) {
            this.chapter.setText(this.wholeChapter.getChapterAndAuthor(this.chapterNum)[0]);
            this.author.setText(this.wholeChapter.getChapterAndAuthor(this.chapterNum)[1]);
            this.chapter.setVisibility(0);
            this.author.setVisibility(0);
        }
        if (this.currentSection.getImagePositions().hasImagePositions()) {
            int i2 = -1;
            for (int i3 : this.currentSection.getImagePositions().getImagePositions()) {
                i2++;
                this.plate_sections.put(Integer.valueOf(i3 + (i3 - 1)), Integer.valueOf(this.currentSection.getImageLinks().getImageLinks()[i2]));
            }
        }
        int sectionText = this.currentSection.getSectionText();
        int sectionText2 = this.currentSection.getSectionText2();
        int sectionText3 = this.currentSection.getSectionText3();
        int sectionText4 = this.currentSection.getSectionText4();
        if (sectionText != -1) {
            this.plate_sections.put(2, getString(sectionText));
            this.totalSectionTexts = 1;
        }
        if (sectionText2 != -1) {
            this.plate_sections.put(6, getString(sectionText2));
            this.totalSectionTexts = 2;
        }
        if (sectionText3 != -1) {
            this.plate_sections.put(10, getString(sectionText3));
            this.totalSectionTexts = 3;
        }
        if (sectionText4 != -1) {
            this.plate_sections.put(14, getString(sectionText4));
            this.totalSectionTexts = 4;
        }
        this.audio = this.currentSection.getAudio();
        this.audio2 = this.currentSection.getAudio2();
        this.audio3 = this.currentSection.getAudio3();
        int audio4 = this.currentSection.getAudio4();
        this.audio4 = audio4;
        if (this.audio != -1) {
            this.trackTracker = 1;
        } else if (this.audio2 != -1) {
            this.trackTracker = 2;
        } else if (this.audio3 != -1) {
            this.trackTracker = 3;
        } else if (audio4 != -1) {
            this.trackTracker = 4;
        }
        selectVoiceOver();
        if (this.audio != -1) {
            playVoiceOver();
        }
        this.popUpText = this.currentSection.getPopUpText();
        this.popUpText2 = this.currentSection.getPopUpText2();
        this.popUpText3 = this.currentSection.getPopUpText3();
        this.popUpText4 = this.currentSection.getPopUpText4();
        if (this.popUpText != -1) {
            this.plate_sections.put(4, getString(R.string.open_popup));
        }
        if (this.popUpText2 != -1) {
            this.plate_sections.put(8, getString(R.string.open_popup));
        }
        if (this.popUpText3 != -1) {
            this.plate_sections.put(12, getString(R.string.open_popup));
        }
        if (this.popUpText4 != -1) {
            this.plate_sections.put(16, getString(R.string.open_popup));
        }
        this.numOfSections = this.plate_sections.size();
        this.numOfButtons = this.currentSection.getNumOfButtons();
        int i4 = 1;
        while (true) {
            int i5 = this.numOfButtons;
            if (i4 <= i5) {
                switch (i4) {
                    case 1:
                        this.button_names.add(getString(this.currentSection.getChoice1().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice1().getNextSectionNum()));
                        break;
                    case 2:
                        this.button_names.add(getString(this.currentSection.getChoice2().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice2().getNextSectionNum()));
                        break;
                    case 3:
                        this.button_names.add(getString(this.currentSection.getChoice3().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice3().getNextSectionNum()));
                        break;
                    case 4:
                        this.button_names.add(getString(this.currentSection.getChoice4().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice4().getNextSectionNum()));
                        break;
                    case 5:
                        this.button_names.add(getString(this.currentSection.getChoice5().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice5().getNextSectionNum()));
                        break;
                    case 6:
                        this.button_names.add(getString(this.currentSection.getChoice6().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice6().getNextSectionNum()));
                        break;
                    case 7:
                        this.button_names.add(getString(this.currentSection.getChoice7().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice7().getNextSectionNum()));
                        break;
                    case 8:
                        this.button_names.add(getString(this.currentSection.getChoice8().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice8().getNextSectionNum()));
                        break;
                    case 9:
                        this.button_names.add(getString(this.currentSection.getChoice9().getChoiceText()));
                        this.button_locations.add(Integer.valueOf(this.currentSection.getChoice9().getNextSectionNum()));
                        break;
                }
                i4++;
            } else {
                int i6 = this.numOfSections + i5;
                if (this.currentSection.getShowLocations().getShowLocations()) {
                    this.location_locations.addAll(this.gameTrackers.getLocationsList(this.chapterNum));
                    int size = this.location_locations.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        String num = this.location_locations.get(i7).toString();
                        if (num.charAt(1) == '0') {
                            substring = num.substring(2);
                        } else {
                            substring = num.substring(1);
                        }
                        this.button_names.add(getString(R.string.location_starter, new Object[]{substring}));
                    }
                    i6 += size;
                }
                Log.d(TAG, "initTexts: plate_sections: " + this.plate_sections + "; numOfSections: " + this.numOfSections + "; button_names: " + this.button_names + "; totalCount: " + i6);
                initRecyclerView(this.plate_sections, this.numOfSections, this.button_names, i6);
                return;
            }
        }
    }

    private void initRecyclerView(TreeMap<Integer, Object> treeMap, int i, ArrayList<String> arrayList, int i2) {
        Log.d(TAG, "initRecyclerView: setup the recyclerview adapter and layoutmanager.");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new RecyclerViewAdapter(treeMap, i, arrayList, i2, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override // com.shadowborne_games.oathsworn.mainCampaign.RecyclerViewAdapter.OnPopupListener
    public void onButtonClick(int i, int i2) {
        Log.d(TAG, "onButtonClick: either a popup, choice or location button has been clicked.");
        if (i2 == -1) {
            int i3 = i - this.numOfSections;
            int i4 = this.numOfButtons;
            if (i3 < i4) {
                Log.d(TAG, "--- CHOICE BUTTON SELECTED.");
                choiceButtons(this.button_locations.get(i3).intValue());
                return;
            }
            locationButtons(this.location_locations.get(i3 - i4).intValue(), this.wholeChapter.getLocation(this.location_locations.get(i3 - this.numOfButtons).intValue()).intValue());
        } else if (i2 == 4) {
            popUpButtons(1, 2, this.popUpText);
        } else if (i2 == 8) {
            popUpButtons(2, 3, this.popUpText2);
        } else if (i2 == 12) {
            popUpButtons(3, 4, this.popUpText3);
        } else if (i2 != 16) {
        } else {
            popUpButtons(4, 0, this.popUpText4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_display);
        Log.d(TAG, "onCreate: GET ALL VIEW ELEMENTS, GRAB chapterNum FROM CampaignActivity, CALL LOAD PLATE");
        this.openedPopUp1 = false;
        this.openedPopUp2 = false;
        this.openedPopUp3 = false;
        this.openedPopUp4 = false;
        this.textView_time = (TextView) findViewById(R.id.textView_time);
        ((Button) findViewById(R.id.backButton)).setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainCampaign.DisplayActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DisplayActivity.this.backButton(view);
            }
        });
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i = extras.getInt("chapter");
            this.chapterNum = i;
            this.wholeChapter = this.wholeChapter.getChapter(i);
            createGameTrackers();
        }
        loadSection(false);
    }

    public void backButton(View view) {
        Log.d(TAG, "backButton: back button clicked.");
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ALERT").setMessage("Are you sure you want to go back?").setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainCampaign.DisplayActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DisplayActivity.this.m27xe00b7a36(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$backButton$0$com-shadowborne_games-oathsworn-mainCampaign-DisplayActivity  reason: not valid java name */
    public /* synthetic */ void m27xe00b7a36(DialogInterface dialogInterface, int i) {
        backButtonConfirmed();
    }

    public void backButtonConfirmed() {
        Log.d(TAG, "backButtonConfirmed: after clicking back, the user confirmed their choice.");
        releaseVoiceOver();
        this.gameTrackers.removeCurrentSectionNum(this.chapterNum, this.currentSection.getLocationsAdded().getLocationsAdded(), this.currentSection.getIsLocation().getIsLocation(), this.currentSection.getClearLocationsList().getClearLocationsList(), this.currentSection.getRemoveSpecificLocations().getRemoveSpecificLocations(), this.currentSection.getTimeAdded().getTimeAdded(), this.wholeChapter.getTimeList(), this.wholeChapter.getClueLocationSectionNum(), this.wholeChapter.getClue(), this.wholeChapter.getClueLocation(), this.gameTrackers);
        loadSection(true);
    }

    private void pauseVoiceOver(int i, int i2) {
        Log.d(TAG, "pauseVoiceOver: pause audio track and save position where it was paused.");
        try {
            if (this.gameTrackers.getVoiceOverState() && this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause();
                if (i != -1) {
                    this.timeWhenPaused = i;
                } else {
                    this.timeWhenPaused = this.mediaPlayer.getCurrentPosition();
                }
            }
        } catch (Exception unused) {
            if (this.gameTrackers.getVoiceOverState()) {
                resetVoiceOver(1, i, i2);
            }
            Log.d(TAG, "--- ERROR: occurred while trying to pause audio track.");
        }
    }

    private void releaseVoiceOver() {
        Log.d(TAG, "releaseVoiceOver: release audio track.");
        try {
            if (this.gameTrackers.getVoiceOverState()) {
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.pause();
                }
                this.mediaPlayer.release();
            }
        } catch (Exception unused) {
            if (this.gameTrackers.getVoiceOverState()) {
                resetVoiceOver(2, -1, -1);
            }
            Log.d(TAG, "--- Error: occurred while releasing audio.");
        }
    }

    private void playVoiceOver() {
        Log.d(TAG, "playVoiceOver: ready the audio track.");
        try {
            if (this.audio != R.raw.encounter_audio) {
                this.mediaPlayer.setLooping(false);
            } else {
                this.mediaPlayer.setLooping(true);
            }
            this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.shadowborne_games.oathsworn.mainCampaign.DisplayActivity$$ExternalSyntheticLambda1
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    DisplayActivity.this.m28xdf0d0bb6(mediaPlayer);
                }
            });
            if (this.gameTrackers.getVoiceOverState()) {
                int i = this.trackTracker;
                if (i == 1 || i == 2 || i == 3 || i == 4) {
                    this.mediaPlayer.start();
                }
            }
        } catch (Exception unused) {
            if (this.gameTrackers.getVoiceOverState()) {
                resetVoiceOver(3, -1, -1);
            }
            Log.d(TAG, "--- Error: occurred while trying to play audio.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$playVoiceOver$1$com-shadowborne_games-oathsworn-mainCampaign-DisplayActivity  reason: not valid java name */
    public /* synthetic */ void m28xdf0d0bb6(MediaPlayer mediaPlayer) {
        int i = this.trackTracker + 1;
        this.trackTracker = i;
        this.timeWhenPaused = 0;
        if (i > 4) {
            this.trackTracker = 1;
        }
        selectVoiceOver();
    }

    private void resetVoiceOver(int i, int i2, int i3) {
        Log.d(TAG, "resetVoiceOver: reset audio track when its been broken.");
        try {
            if (this.gameTrackers.getVoiceOverState()) {
                this.mediaPlayer.reset();
                if (i == 1) {
                    pauseVoiceOver(i2, i3);
                } else if (i == 2) {
                    releaseVoiceOver();
                } else if (i == 3) {
                    playVoiceOver();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void playPrevious(View view) {
        Log.d(TAG, "playPrevious: play previous audio track.");
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 100) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        this.previousPushed++;
        pauseVoiceOver(0, -1);
        if (this.previousPushed > 1) {
            resetVoiceOver(-1, -1, -1);
            int i = this.trackTracker - 1;
            this.trackTracker = i;
            if (i < 1) {
                this.trackTracker = 1;
            }
        }
        if (this.trackTracker == 1 && this.audio == -1) {
            this.trackTracker = 2;
        }
        if (this.trackTracker == 2 && this.audio2 == -1) {
            this.trackTracker = 3;
        }
        if (this.trackTracker == 3 && this.audio3 == -1) {
            this.trackTracker = 4;
        }
        if (this.trackTracker == 4 && this.audio4 == -1) {
            this.trackTracker = 0;
        }
        if (this.trackTracker != 0) {
            selectVoiceOver();
            playVoiceOver();
        }
    }

    public void pauseAndPlay(View view) {
        Log.d(TAG, "pauseAndPlay: play/pause the audio track.");
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 100) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        try {
            this.previousPushed = 0;
            if (!this.gameTrackers.getVoiceOverState()) {
                this.gameTrackers.turnVoiceOverOn();
                selectVoiceOver();
            }
            if (!this.mediaPlayer.isPlaying()) {
                int i = this.timeWhenPaused;
                if (i != 0) {
                    this.mediaPlayer.seekTo(i);
                } else {
                    selectVoiceOver();
                }
                playVoiceOver();
                return;
            }
            pauseVoiceOver(-1, -1);
        } catch (Exception unused) {
            if (this.gameTrackers.getVoiceOverState()) {
                resetVoiceOver(4, -1, -1);
            }
            Log.d(TAG, "--- ERROR: occurred when clicking pause and play button.");
        }
    }

    public void playNext(View view) {
        Log.d(TAG, "playNext: play next audio track.");
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 100) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        pauseVoiceOver(0, -1);
        resetVoiceOver(-1, -1, -1);
        int i = this.trackTracker + 1;
        this.trackTracker = i;
        if (i > 4) {
            this.trackTracker = 4;
        }
        if (this.trackTracker == 4 && this.audio4 == -1) {
            this.trackTracker = 3;
        }
        if (this.trackTracker == 3 && this.audio3 == -1) {
            this.trackTracker = 2;
        }
        if (this.trackTracker == 2 && this.audio2 == -1) {
            this.trackTracker = 1;
        }
        if (this.trackTracker == 1 && this.audio == -1) {
            this.trackTracker = 0;
        }
        if (this.trackTracker != 0) {
            selectVoiceOver();
            playVoiceOver();
        }
    }

    private void selectVoiceOver() {
        Log.d(TAG, "selectVoiceOver: determine which voiceOver to send to MediaPlayer.");
        try {
            int i = this.trackTracker;
            if (i == 1) {
                this.mediaPlayer = MediaPlayer.create(this, this.audio);
            } else if (i == 2) {
                this.mediaPlayer = MediaPlayer.create(this, this.audio2);
            } else if (i == 3) {
                this.mediaPlayer = MediaPlayer.create(this, this.audio3);
            } else if (i == 4) {
                this.mediaPlayer = MediaPlayer.create(this, this.audio4);
            }
            this.mediaPlayer.prepare();
        } catch (Exception unused) {
            Log.d(TAG, "--- ERROR: occurred while selecting audio track.");
        }
    }

    public void menuButton(View view) {
        Log.d(TAG, "menuButton: opens the menu after checking if its the final plate; if its the final plate- it sends chapterNum to CampaignActivity so it can change the colour");
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        pauseVoiceOver(-1, -1);
        releaseVoiceOver();
        try {
            Log.d(TAG, "--- currentSection.getChoice1().getNextSectionNum(): " + this.currentSection.getChoice1().getNextSectionNum());
            if (this.currentSection.getChoice1().getNextSectionNum() == -1) {
                Log.d(TAG, "--- sent chapterFinished - " + this.chapterNum + " - to CampaignActivity");
                Intent intent = new Intent(this, PopUpMenu.class);
                intent.putExtra("chapterFinished", this.chapterNum);
                startActivity(intent);
            } else {
                startActivity(new Intent(this, PopUpMenu.class));
                selectVoiceOver();
            }
        } catch (Exception unused) {
            Log.d(TAG, "--- DON'T REMOVE: This try catch fixes an issue where sometimes currentSection.getChoice1().getChoiceText() is null... this only happens when no buttons are available to select i.e. when there is already an error");
            startActivity(new Intent(this, PopUpMenu.class));
            selectVoiceOver();
        }
    }

    public void loadSection(boolean z) {
        Log.d(TAG, "loadSection: load the plate contents.");
        int currentSectionNum = this.gameTrackers.getCurrentSectionNum(this.chapterNum);
        this.nextSectionNum = currentSectionNum;
        this.currentSection = this.wholeChapter.getSection(currentSectionNum);
        if (this.nextSectionNum == 0 && !z) {
            Log.d(TAG, "--- LocationsAdded: " + Arrays.toString(this.currentSection.getLocationsAdded().getLocationsAdded()));
            this.gameTrackers.setCurrentSectionNum(this.chapterNum, this.nextSectionNum, this.currentSection.getLocationsAdded().getLocationsAdded(), this.currentSection.getClearLocationsList().getClearLocationsList(), this.currentSection.getRemoveSpecificLocations().getRemoveSpecificLocations(), this.wholeChapter.getClue(), this.wholeChapter.getClueLocation());
        }
        int time = this.gameTrackers.getTime(this.chapterNum);
        TextView textView = this.textView_time;
        textView.setText("TIME: " + time);
        initTexts();
    }

    private void popUpButtons(int i, int i2, int i3) {
        Log.d(TAG, "popUpButtons: when an instructions button is pressed, this determines which text to show and relays that info to the PopUp.class");
        this.popUpTextNum = i3;
        pauseVoiceOver(-1, i2);
        if (i == 1) {
            this.openedPopUp1 = true;
        } else if (i == 2) {
            this.openedPopUp2 = true;
        } else if (i == 3) {
            this.openedPopUp3 = true;
        } else if (i == 4) {
            this.openedPopUp4 = true;
        }
        Intent intent = new Intent(this, PopUp.class);
        intent.putExtra("chapterNum", this.chapterNum);
        intent.putExtra("popUpText", i3);
        startActivityForResult(intent, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2 && this.gameTrackers.getVoiceOverState()) {
            if (this.audio != R.raw.encounter_audio) {
                int i3 = this.popUpTextNum;
                int i4 = this.popUpText4;
                if (i3 != i4 || i4 == -1) {
                    if (i3 != this.popUpText3 || this.totalSectionTexts > 3) {
                        if (i3 != this.popUpText2 || this.totalSectionTexts > 2) {
                            if (i3 != this.popUpText || this.totalSectionTexts > 1) {
                                Log.d(TAG, "onActivityResult: playVoiceOver()");
                                playVoiceOver();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            playVoiceOver();
        }
    }

    private void choiceButtons(int i) {
        Log.d(TAG, "choiceButtons: when a choice button is clicked determine what to do.");
        if ((this.popUpText == -1 || this.openedPopUp1) && ((this.popUpText2 == -1 || this.openedPopUp2) && ((this.popUpText3 == -1 || this.openedPopUp3) && (this.popUpText4 == -1 || this.openedPopUp4)))) {
            releaseVoiceOver();
            if (i != -1) {
                GameTrackers gameTrackers = this.gameTrackers;
                gameTrackers.manageTime(gameTrackers, this.currentSection.getTimeAdded().getTimeAdded(), i);
                if (i == -3) {
                    i = this.gameTrackers.returnToNextPositionToken(this.chapterNum);
                } else if (i == -2) {
                    i = this.gameTrackers.diedRestartChapter(this.chapterNum);
                    if (this.wholeChapter.isDeepwoodChapter()) {
                        this.gameTrackers.setupDeepwood(this.wholeChapter.getDeepwoodTokens());
                    }
                }
                int i2 = i;
                Section section = this.wholeChapter.getSection(i2);
                this.nextSection = section;
                this.gameTrackers.setCurrentSectionNum(this.chapterNum, i2, section.getLocationsAdded().getLocationsAdded(), this.nextSection.getClearLocationsList().getClearLocationsList(), this.nextSection.getRemoveSpecificLocations().getRemoveSpecificLocations(), this.wholeChapter.getClue(), this.wholeChapter.getClueLocation());
                startActivity(getIntent());
                return;
            }
            Log.d(TAG, "--- redirected to CampaignActivity");
            Intent intent = new Intent(this, CampaignActivity.class);
            intent.putExtra("chapterFinished", this.chapterNum);
            startActivity(intent);
            return;
        }
        pauseVoiceOver(-1, -1);
        startActivity(new Intent(this, OpenInstructions.class));
    }

    private void locationButtons(int i, int i2) {
        Log.d(TAG, "locationButtons: when a location button is clicked determine what to do.");
        if ((this.popUpText == -1 || this.openedPopUp1) && ((this.popUpText2 == -1 || this.openedPopUp2) && ((this.popUpText3 == -1 || this.openedPopUp3) && (this.popUpText4 == -1 || this.openedPopUp4)))) {
            GameTrackers gameTrackers = this.gameTrackers;
            gameTrackers.manageTime(gameTrackers, this.currentSection.getTimeAdded().getTimeAdded(), i2);
            releaseVoiceOver();
            this.gameTrackers.removeLocation(this.chapterNum, i, this.wholeChapter.getClueLocation());
            if (i2 == -3) {
                i2 = this.gameTrackers.returnToNextPositionToken(this.chapterNum);
            } else if (i2 == -2) {
                i2 = this.gameTrackers.diedRestartChapter(this.chapterNum);
                if (this.wholeChapter.isDeepwoodChapter()) {
                    this.gameTrackers.setupDeepwood(this.wholeChapter.getDeepwoodTokens());
                }
            }
            int i3 = i2;
            Section section = this.wholeChapter.getSection(i3);
            this.nextSection = section;
            this.gameTrackers.setCurrentSectionNum(this.chapterNum, i3, section.getLocationsAdded().getLocationsAdded(), this.nextSection.getClearLocationsList().getClearLocationsList(), this.nextSection.getRemoveSpecificLocations().getRemoveSpecificLocations(), this.wholeChapter.getClue(), this.wholeChapter.getClueLocation());
            startActivity(getIntent());
            return;
        }
        pauseVoiceOver(-1, -1);
        startActivity(new Intent(this, OpenInstructions.class));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    void createGameTrackers() {
        Log.d(TAG, "createGameTrackers: creates each GT child class.");
        Context applicationContext = getApplicationContext();
        switch (this.chapterNum) {
            case 1:
                this.gameTrackers = new GT1(applicationContext, this.chapterNum);
                return;
            case 2:
                this.gameTrackers = new GT2(applicationContext, this.chapterNum);
                return;
            case 3:
                this.gameTrackers = new GT3(applicationContext, this.chapterNum);
                return;
            case 4:
                this.gameTrackers = new GT4(applicationContext, this.chapterNum, this.wholeChapter.getDeepwoodTokens(), this.wholeChapter.getDeepwoodMap());
                return;
            case 5:
                this.gameTrackers = new GT5(applicationContext, this.chapterNum);
                return;
            case 6:
                this.gameTrackers = new GT6(applicationContext, this.chapterNum);
                return;
            case 7:
                this.gameTrackers = new GT7(applicationContext, this.chapterNum);
                return;
            case 8:
                this.gameTrackers = new GT8(applicationContext, this.chapterNum);
                return;
            case 9:
                this.gameTrackers = new GT9(applicationContext, this.chapterNum);
                return;
            case 10:
                this.gameTrackers = new GT10(applicationContext, this.chapterNum, this.wholeChapter.getDeepwoodTokens(), this.wholeChapter.getDeepwoodMap());
                return;
            case 11:
                this.gameTrackers = new GT11(applicationContext, this.chapterNum);
                break;
            case 12:
                this.gameTrackers = new GT12(applicationContext, this.chapterNum);
                return;
            case 13:
                this.gameTrackers = new GT13(applicationContext, this.chapterNum);
                return;
            case 14:
                this.gameTrackers = new GT14(applicationContext, this.chapterNum, this.wholeChapter.getDeepwoodTokens(), this.wholeChapter.getDeepwoodMap());
                return;
            case 15:
                this.gameTrackers = new GT15(applicationContext, this.chapterNum);
                return;
            case 16:
                this.gameTrackers = new GT16(applicationContext, this.chapterNum);
                return;
            case 17:
                this.gameTrackers = new GT17(applicationContext, this.chapterNum, this.wholeChapter.getDeepwoodTokens(), this.wholeChapter.getDeepwoodMap());
                return;
            case 18:
                this.gameTrackers = new GT18(applicationContext, this.chapterNum, this.wholeChapter.getDeepwoodTokens(), this.wholeChapter.getDeepwoodMap());
                return;
            case 19:
                this.gameTrackers = new GT19(applicationContext, this.chapterNum);
                return;
            case 20:
                this.gameTrackers = new GT20(applicationContext, this.chapterNum);
                return;
            case 21:
                this.gameTrackers = new GT21(applicationContext, this.chapterNum);
                return;
            case 22:
                break;
            default:
                return;
        }
        this.gameTrackers = new GT11_5(applicationContext, this.chapterNum);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: disables mobile back button, forcing user to user ours.");
    }
}
