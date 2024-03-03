package com.shadowborne_games.oathsworn.mainCampaign.popUps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import com.shadowborne_games.oathsworn.R;
import com.shadowborne_games.oathsworn.mainCampaign.CampaignActivity;
import com.shadowborne_games.oathsworn.mainCampaign.MainActivity;
import com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton;

/* loaded from: classes.dex */
public class PopUpMenu extends Activity {
    private static final String TAG = "PopUpMenu";
    protected static SharedPreferencesSingleton sharedPreferencesSingleton;
    private boolean audioOn;
    private Button turnAudioOnOff;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.content_popupmenu);
        sharedPreferencesSingleton = SharedPreferencesSingleton.getInstance(getApplicationContext());
        this.turnAudioOnOff = (Button) findViewById(R.id.turnAudioOnOff);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout((int) (displayMetrics.widthPixels * 0.9d), (int) (displayMetrics.heightPixels * 0.9d));
        boolean z = sharedPreferencesSingleton.getBoolean("audioOn");
        this.audioOn = z;
        if (z) {
            this.turnAudioOnOff.setText(R.string.turn_audio_off);
        } else {
            this.turnAudioOnOff.setText(R.string.turn_audio_on);
        }
    }

    public void mainMenu(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void chapterList(View view) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i = extras.getInt("chapterFinished");
            Intent intent = new Intent(this, CampaignActivity.class);
            intent.putExtra("chapterFinished", i);
            startActivity(intent);
            return;
        }
        startActivity(new Intent(this, CampaignActivity.class));
    }

    public void turnAudioOnOff(View view) {
        boolean z = sharedPreferencesSingleton.getBoolean("audioOn");
        this.audioOn = z;
        if (z) {
            sharedPreferencesSingleton.saveBoolean("audioOn", false);
            this.turnAudioOnOff.setText(R.string.turn_audio_on);
            return;
        }
        sharedPreferencesSingleton.saveBoolean("audioOn", true);
        this.turnAudioOnOff.setText(R.string.turn_audio_off);
    }

    public void saveAndExit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ALERT");
        builder.setMessage("Exit Program?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainCampaign.popUps.PopUpMenu.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(PopUpMenu.this, MainActivity.class);
                intent.putExtra("LOGOUT", true);
                PopUpMenu.this.startActivity(intent);
            }
        });
        builder.setNegativeButton("NO", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void close(View view) {
        finish();
    }
}
