package com.shadowborne_games.oathsworn.mainCampaign;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import com.shadowborne_games.oathsworn.R;
import com.shadowborne_games.oathsworn.gameTrackers.GT1;
import com.shadowborne_games.oathsworn.gameTrackers.GameTrackers;
import com.shadowborne_games.oathsworn.mainNonCampaign.TutorialActivity;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static HttpURLConnection con;
    protected static SharedPreferencesSingleton sharedPreferencesSingleton;
    private Button continueCampaign;
    public GameTrackers gameTrackers;
    private long mLastClickTime = 0;
    private Button newCampaign;
    public Button updateButton;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = 0;
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_main);
        sharedPreferencesSingleton = SharedPreferencesSingleton.getInstance(getApplicationContext());
        Button button = (Button) findViewById(R.id.update_button);
        this.updateButton = button;
        button.setVisibility(8);
        sharedPreferencesSingleton.saveInt("thisVersionNum", 4);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("LOGOUT", false)) {
            closeApp();
        }
        this.newCampaign = (Button) findViewById(R.id.new_campaign);
        this.continueCampaign = (Button) findViewById(R.id.continue_campaign);
        this.gameTrackers = new GT1(getApplicationContext(), 1);
        int color = ResourcesCompat.getColor(getResources(), R.color.test1, null);
        for (int i2 = 1; i2 <= 21; i2++) {
            if (this.gameTrackers.getCurrentSectionNum(i2) != 0) {
                i++;
            }
        }
        if (i == 0) {
            this.continueCampaign.setVisibility(8);
            this.newCampaign.setTextColor(color);
            this.newCampaign.setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainCampaign.MainActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MainActivity.this.newCampaign(view);
                }
            });
            return;
        }
        this.newCampaign.setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainCampaign.MainActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.newCampaign(view);
            }
        });
        this.newCampaign.setTextColor(color);
        this.continueCampaign.setTextColor(color);
        this.continueCampaign.setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainCampaign.MainActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.continueCampaign(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PrimeThread primeThread = new PrimeThread();
        primeThread.start();
        try {
            primeThread.join(60000L);
            primeThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (sharedPreferencesSingleton.getInt("currentVersionNum") != sharedPreferencesSingleton.getInt("thisVersionNum")) {
            this.updateButton.setVisibility(0);
        }
    }

    public void updateApp(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.shadowborne-games.com/oathapp"));
        startActivity(intent);
    }

    public void newCampaign(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ALERT").setMessage("Are you sure you want to start a new campaign? This will DELETE any old campaign.").setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainCampaign.MainActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.newCampaignGo();
            }
        });
        builder.create().show();
    }

    public void newCampaignGo() {
        this.gameTrackers.clearCampaign(1);
        this.gameTrackers.clearCampaign(2);
        this.gameTrackers.clearCampaign(3);
        this.gameTrackers.clearCampaign(4);
        this.gameTrackers.clearCampaign(5);
        this.gameTrackers.clearCampaign(6);
        this.gameTrackers.clearCampaign(7);
        this.gameTrackers.clearCampaign(8);
        this.gameTrackers.clearCampaign(9);
        this.gameTrackers.clearCampaign(10);
        this.gameTrackers.clearCampaign(11);
        this.gameTrackers.clearCampaign(12);
        this.gameTrackers.clearCampaign(13);
        this.gameTrackers.clearCampaign(14);
        this.gameTrackers.clearCampaign(15);
        this.gameTrackers.clearCampaign(16);
        this.gameTrackers.clearCampaign(17);
        this.gameTrackers.clearCampaign(18);
        this.gameTrackers.clearCampaign(19);
        this.gameTrackers.clearCampaign(20);
        this.gameTrackers.clearCampaign(21);
        Intent intent = new Intent(this, CampaignActivity.class);
        intent.putExtra("campaignType", "newCampaign");
        startActivity(intent);
    }

    public void continueCampaign(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, CampaignActivity.class);
        intent.putExtra("campaignType", "continueCampaign");
        startActivity(intent);
    }

    public void tutorial(View view) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        startActivity(new Intent(this, TutorialActivity.class));
    }

    public void closeApp() {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        finishAffinity();
        finishAndRemoveTask();
    }

    /* loaded from: classes.dex */
    private static class PrimeThread extends Thread {
        private static final String TAG = "PrimeThread";

        private PrimeThread() {
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
                java.lang.String r2 = "https://www.shadowborne-games.com/_functions/oathswornversion"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
                java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
                r1.connect()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                java.io.InputStream r0 = r1.getInputStream()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                r2.<init>(r0)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                int r0 = r2.read()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                r3.<init>()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
            L23:
                r4 = -1
                if (r0 == r4) goto L2f
                char r0 = (char) r0     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                r3.append(r0)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                int r0 = r2.read()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                goto L23
            L2f:
                java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                java.lang.String r2 = "\\D+"
                java.lang.String r3 = ""
                java.lang.String r0 = r0.replaceAll(r2, r3)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton r2 = com.shadowborne_games.oathsworn.mainCampaign.MainActivity.sharedPreferencesSingleton     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                java.lang.String r3 = "currentVersionNum"
                r2.saveInt(r3, r0)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L70
                if (r1 == 0) goto L6f
                goto L6c
            L49:
                r0 = move-exception
                goto L54
            L4b:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L71
            L50:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L54:
                java.lang.String r2 = "PrimeThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
                r3.<init>()     // Catch: java.lang.Throwable -> L70
                java.lang.String r4 = "onStart: Exception = "
                r3.append(r4)     // Catch: java.lang.Throwable -> L70
                r3.append(r0)     // Catch: java.lang.Throwable -> L70
                java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L70
                android.util.Log.d(r2, r0)     // Catch: java.lang.Throwable -> L70
                if (r1 == 0) goto L6f
            L6c:
                r1.disconnect()
            L6f:
                return
            L70:
                r0 = move-exception
            L71:
                if (r1 == 0) goto L76
                r1.disconnect()
            L76:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shadowborne_games.oathsworn.mainCampaign.MainActivity.PrimeThread.run():void");
        }
    }
}
