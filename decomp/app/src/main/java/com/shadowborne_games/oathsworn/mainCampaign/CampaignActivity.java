package com.shadowborne_games.oathsworn.mainCampaign;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import com.shadowborne_games.oathsworn.R;
import com.shadowborne_games.oathsworn.gameTrackers.GT1;

/* loaded from: classes.dex */
public class CampaignActivity extends AppCompatActivity {
    private static final String TAG = "CampaignActivity";
    protected static SharedPreferencesSingleton sharedPreferencesSingleton;
    private long mLastClickTime = 0;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_campaign);
        GT1 gt1 = new GT1(getApplicationContext(), 1);
        ResourcesCompat.getColor(getResources(), R.color.test1, null);
        SharedPreferencesSingleton sharedPreferencesSingleton2 = SharedPreferencesSingleton.getInstance(getApplicationContext());
        sharedPreferencesSingleton = sharedPreferencesSingleton2;
        try {
            sharedPreferencesSingleton2.getInt("chapterNum");
        } catch (Exception unused) {
            sharedPreferencesSingleton.saveInt("chapterNum", 1);
            sharedPreferencesSingleton.getInt("chapterNum");
        }
        for (int i = 1; i <= 22; i++) {
            if (gt1.getCurrentSectionNum(i) != 0) {
                Resources resources = getResources();
                Button button = (Button) findViewById(resources.getIdentifier("chapter" + i, "id", getPackageName()));
            }
        }
    }

    public void chapter1(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 1);
        intent.putExtra("chapter", 1);
        startActivity(intent);
    }

    public void chapter2(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 2);
        intent.putExtra("chapter", 2);
        startActivity(intent);
    }

    public void chapter3(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 3);
        intent.putExtra("chapter", 3);
        startActivity(intent);
    }

    public void chapter4(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 4);
        intent.putExtra("chapter", 4);
        startActivity(intent);
    }

    public void chapter5(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 5);
        intent.putExtra("chapter", 5);
        startActivity(intent);
    }

    public void chapter6(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 6);
        intent.putExtra("chapter", 6);
        startActivity(intent);
    }

    public void chapter7(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 7);
        intent.putExtra("chapter", 7);
        startActivity(intent);
    }

    public void chapter8(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 8);
        intent.putExtra("chapter", 8);
        startActivity(intent);
    }

    public void chapter9(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 9);
        intent.putExtra("chapter", 9);
        startActivity(intent);
    }

    public void chapter10(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 10);
        intent.putExtra("chapter", 10);
        startActivity(intent);
    }

    public void chapter11(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 11);
        intent.putExtra("chapter", 11);
        startActivity(intent);
    }

    public void chapter11_5(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 22);
        intent.putExtra("chapter", 22);
        startActivity(intent);
    }

    public void chapter12(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 12);
        intent.putExtra("chapter", 12);
        startActivity(intent);
    }

    public void chapter13(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 13);
        intent.putExtra("chapter", 13);
        startActivity(intent);
    }

    public void chapter14(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 14);
        intent.putExtra("chapter", 14);
        startActivity(intent);
    }

    public void chapter15(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 15);
        intent.putExtra("chapter", 15);
        startActivity(intent);
    }

    public void chapter16(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 16);
        intent.putExtra("chapter", 16);
        startActivity(intent);
    }

    public void chapter17(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 17);
        intent.putExtra("chapter", 17);
        startActivity(intent);
    }

    public void chapter18(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 18);
        intent.putExtra("chapter", 18);
        startActivity(intent);
    }

    public void chapter19(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 19);
        intent.putExtra("chapter", 19);
        startActivity(intent);
    }

    public void chapter20(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 20);
        intent.putExtra("chapter", 20);
        startActivity(intent);
    }

    public void chapter21(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, DisplayActivity.class);
        sharedPreferencesSingleton.saveInt("chapterNum", 21);
        intent.putExtra("chapter", 21);
        startActivity(intent);
    }
}
