package com.shadowborne_games.oathsworn.mainNonCampaign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.shadowborne_games.oathsworn.R;

/* loaded from: classes.dex */
public class LinksActivity extends AppCompatActivity {
    private long mLastClickTime = 0;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_links);
    }

    public void link1(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.shadowborne-games.com/"));
        startActivity(intent);
    }

    public void link2(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://boardgamegeek.com/boardgame/251661/oathsworn-deepwood"));
        startActivity(intent);
    }

    public void link3(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.facebook.com/groups/559814268090749/"));
        startActivity(intent);
    }
}
