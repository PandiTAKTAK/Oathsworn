package com.shadowborne_games.oathsworn.mainCampaign.popUps;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import com.shadowborne_games.oathsworn.R;

/* loaded from: classes.dex */
public class OpenInstructions extends Activity {
    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.content_openinstructions);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout((int) (displayMetrics.widthPixels * 0.9d), (int) (displayMetrics.heightPixels * 0.9d));
    }

    public void close(View view) {
        finish();
    }
}
