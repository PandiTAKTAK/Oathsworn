package com.shadowborne_games.oathsworn.mainNonCampaign;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shadowborne_games.oathsworn.R;
import com.shadowborne_games.oathsworn.mainCampaign.MainActivity;

/* loaded from: classes.dex */
public class CloseAppFragment extends Fragment {
    FloatingActionButton btnExit;
    View view;
    private long mLastClickTime = 0;
    public View.OnClickListener btnExitOnClick = new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainNonCampaign.CloseAppFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SystemClock.elapsedRealtime() - CloseAppFragment.this.mLastClickTime < 1000) {
                return;
            }
            CloseAppFragment.this.mLastClickTime = SystemClock.elapsedRealtime();
            AlertDialog.Builder builder = new AlertDialog.Builder(CloseAppFragment.this.getActivity());
            builder.setTitle("ALERT");
            builder.setMessage("Exit Program?");
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainNonCampaign.CloseAppFragment.1.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(CloseAppFragment.this.getActivity(), MainActivity.class);
                    intent.putExtra("LOGOUT", true);
                    CloseAppFragment.this.startActivity(intent);
                }
            });
            builder.setNegativeButton("NO", (DialogInterface.OnClickListener) null);
            builder.show();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_close_app, viewGroup, false);
        InitialUI();
        return this.view;
    }

    public void InitialUI() {
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.view.findViewById(R.id.close);
        this.btnExit = floatingActionButton;
        floatingActionButton.setOnClickListener(this.btnExitOnClick);
    }
}
