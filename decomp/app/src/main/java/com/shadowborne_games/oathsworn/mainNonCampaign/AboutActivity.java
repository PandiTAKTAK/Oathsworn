package com.shadowborne_games.oathsworn.mainNonCampaign;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.shadowborne_games.oathsworn.R;

/* loaded from: classes.dex */
public class AboutActivity extends AppCompatActivity {
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_about);
    }
}
