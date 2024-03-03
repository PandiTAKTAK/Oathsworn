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
import com.shadowborne_games.oathsworn.mainCampaign.MainActivity;

/* loaded from: classes.dex */
public class BackButtonFragment extends Fragment {
    private long mLastClickTime = 0;
    private FloatingActionButton upImage;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_back_button, viewGroup, false);
        FloatingActionButton floatingActionButton = (FloatingActionButton) inflate.findViewById(R.id.upImageTest);
        this.upImage = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.shadowborne_games.oathsworn.mainNonCampaign.BackButtonFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - BackButtonFragment.this.mLastClickTime < 1000) {
                    return;
                }
                BackButtonFragment.this.mLastClickTime = SystemClock.elapsedRealtime();
                BackButtonFragment.this.startActivity(new Intent(BackButtonFragment.this.getActivity(), MainActivity.class));
            }
        });
        return inflate;
    }
}
