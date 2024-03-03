package com.shadowborne_games.oathsworn.mainNonCampaign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.shadowborne_games.oathsworn.R;

/* loaded from: classes.dex */
public class TutorialActivity extends AppCompatActivity {
    private long mLastClickTime = 0;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_tutorial);
    }

    public void tutorialOnClick(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
    }

    public void tutorial1(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=uojH9Ce85Tg"));
        startActivity(intent);
    }

    public void tutorial2(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=mjTM776wImo&list=PLQm09Ga0Jts22xyE_mIIvD6f1KMZizYBk&index=2"));
        startActivity(intent);
    }

    public void tutorial3(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=fhk4eK5KZrc"));
        startActivity(intent);
    }

    public void tutorial4(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=td_YB8NJdxQ&list=PLQm09Ga0Jts22xyE_mIIvD6f1KMZizYBk&index=3"));
        startActivity(intent);
    }

    public void tutorial5(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=Udr_jJqZj7s&list=PLQm09Ga0Jts22xyE_mIIvD6f1KMZizYBk&index=4"));
        startActivity(intent);
    }

    public void tutorial6(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=oBjY8TqKZZ0&list=PLQm09Ga0Jts22xyE_mIIvD6f1KMZizYBk&index=5"));
        startActivity(intent);
    }

    public void tutorial7(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/4xt39VlQiNI"));
        startActivity(intent);
    }

    public void tutorial8_0(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/eAvaVUL_cCw"));
        startActivity(intent);
    }

    public void tutorial8_1(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/tGqTffxPPcI"));
        startActivity(intent);
    }

    public void tutorial8_2(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/HhVuB8fsrsU"));
        startActivity(intent);
    }

    public void tutorial8_3(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/fXJQdWa5VqQ"));
        startActivity(intent);
    }

    public void tutorial9(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/36UMOiEktQw"));
        startActivity(intent);
    }

    public void tutorial10(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/EX0rGEx2r-Y"));
        startActivity(intent);
    }

    public void tutorial11(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/ozIILE8oEDk"));
        startActivity(intent);
    }

    public void tutorial12(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/5e6azd9pIRQ"));
        startActivity(intent);
    }

    public void tutorial13(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/UTnFgyxykkI"));
        startActivity(intent);
    }

    public void tutorial14(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/16BBAlGhBrs"));
        startActivity(intent);
    }

    public void tutorial15(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://youtu.be/NtE2JDN0-0g"));
        startActivity(intent);
    }
}
