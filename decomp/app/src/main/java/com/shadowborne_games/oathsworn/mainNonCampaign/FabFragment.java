package com.shadowborne_games.oathsworn.mainNonCampaign;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shadowborne_games.oathsworn.R;

/* loaded from: classes.dex */
public class FabFragment extends Fragment {
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;
    private FloatingActionButton fab4;
    private boolean isFABOpen;
    private long mLastClickTime = 0;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_fab, viewGroup, false);
        this.fab1 = (FloatingActionButton) inflate.findViewById(R.id.fab1);
        this.fab2 = (FloatingActionButton) inflate.findViewById(R.id.fab2);
        this.fab3 = (FloatingActionButton) inflate.findViewById(R.id.fab3);
        this.fab4 = (FloatingActionButton) inflate.findViewById(R.id.fab4);
        this.fab1.setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainNonCampaign.FabFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!FabFragment.this.isFABOpen) {
                    FabFragment.this.showFABMenu();
                } else {
                    FabFragment.this.closeFABMenu();
                }
            }
        });
        return inflate;
    }

    public void showFABMenu() {
        this.isFABOpen = true;
        this.fab1.setImageResource(R.drawable.menu_button_close);
        this.fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        this.fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        this.fab4.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
        this.fab4.setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainNonCampaign.FabFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - FabFragment.this.mLastClickTime < 1000) {
                    return;
                }
                FabFragment.this.mLastClickTime = SystemClock.elapsedRealtime();
                FabFragment.this.startActivity(new Intent(FabFragment.this.getActivity(), AboutActivity.class));
            }
        });
        this.fab3.setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainNonCampaign.FabFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - FabFragment.this.mLastClickTime < 1000) {
                    return;
                }
                FabFragment.this.mLastClickTime = SystemClock.elapsedRealtime();
                FabFragment.this.startActivity(new Intent(FabFragment.this.getActivity(), LinksActivity.class));
            }
        });
        this.fab2.setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainNonCampaign.FabFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - FabFragment.this.mLastClickTime < 1000) {
                    return;
                }
                FabFragment.this.mLastClickTime = SystemClock.elapsedRealtime();
                FabFragment.this.startActivity(new Intent(FabFragment.this.getActivity(), SettingsActivity.class));
            }
        });
    }

    public void closeFABMenu() {
        this.isFABOpen = false;
        this.fab1.setImageResource(R.drawable.menu_button_open);
        this.fab2.animate().translationY(0.0f);
        this.fab3.animate().translationY(0.0f);
        this.fab4.animate().translationY(0.0f);
    }
}
