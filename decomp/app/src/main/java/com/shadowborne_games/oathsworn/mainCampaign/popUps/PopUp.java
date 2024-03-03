package com.shadowborne_games.oathsworn.mainCampaign.popUps;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.shadowborne_games.oathsworn.R;
import com.shadowborne_games.oathsworn.gameTrackers.GT1;
import com.shadowborne_games.oathsworn.gameTrackers.GameTrackers;

/* loaded from: classes.dex */
public class PopUp extends Activity {
    private static final String TAG = "PopUp";
    public GameTrackers gameTrackers;

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.content_popup);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout((int) (displayMetrics.widthPixels * 0.9d), (int) (displayMetrics.heightPixels * 0.9d));
        TextView textView = (TextView) findViewById(R.id.popUpTextView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i = extras.getInt("chapterNum", -1);
            textView.setText(extras.getInt("popUpText", -1));
            if (i == 1) {
                this.gameTrackers = new GT1(getApplicationContext(), 1);
            }
        }
    }

    public void close(View view) {
        finish();
    }
}
