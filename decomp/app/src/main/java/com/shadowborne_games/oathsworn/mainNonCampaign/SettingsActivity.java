package com.shadowborne_games.oathsworn.mainNonCampaign;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.shadowborne_games.oathsworn.R;
import com.shadowborne_games.oathsworn.gameTrackers.GT1;
import com.shadowborne_games.oathsworn.gameTrackers.GameTrackers;
import com.shadowborne_games.oathsworn.mainCampaign.SharedPreferencesSingleton;

/* loaded from: classes.dex */
public class SettingsActivity extends AppCompatActivity {
    protected static SharedPreferencesSingleton sharedPreferencesSingleton;
    private boolean audioOn;
    public GameTrackers gameTrackers;
    private Button turnAudioOnOff;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_settings);
        sharedPreferencesSingleton = SharedPreferencesSingleton.getInstance(getApplicationContext());
        this.gameTrackers = new GT1(getApplicationContext(), 1);
        this.turnAudioOnOff = (Button) findViewById(R.id.turnAudioOnOff2);
        boolean z = sharedPreferencesSingleton.getBoolean("audioOn");
        this.audioOn = z;
        if (z) {
            this.turnAudioOnOff.setText(R.string.turn_audio_off);
        } else {
            this.turnAudioOnOff.setText(R.string.turn_audio_on);
        }
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
}
