package com.shadowborne_games.oathsworn.mainCampaign;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shadowborne_games.oathsworn.R;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private static final String TAG = "RecyclerViewAdapter";
    private final int count_plate_sections;
    private ArrayList<String> mButtonNames;
    private final OnPopupListener mOnPopupListener;
    private final TreeMap<Integer, Object> plate_sections;
    private int position;
    private final int totalCount;

    /* loaded from: classes.dex */
    public interface OnPopupListener {
        public static final String TAG = "OnPopupListener: interface created.";

        void onButtonClick(int i, int i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    public RecyclerViewAdapter(TreeMap<Integer, Object> treeMap, int i, ArrayList<String> arrayList, int i2, OnPopupListener onPopupListener) {
        this.mButtonNames = new ArrayList<>();
        Log.d(TAG, "RecyclerViewAdapter: created object.");
        this.mButtonNames.clear();
        this.plate_sections = treeMap;
        this.mButtonNames = arrayList;
        this.totalCount = i2;
        this.mOnPopupListener = onPopupListener;
        this.count_plate_sections = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: inflated recycler.");
        this.position = i;
        boolean z = i >= this.count_plate_sections;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (!z) {
            if (this.plate_sections.keySet().toArray()[i].equals(2) || this.plate_sections.keySet().toArray()[i].equals(6) || this.plate_sections.keySet().toArray()[i].equals(10) || this.plate_sections.keySet().toArray()[i].equals(14)) {
                return new ViewHolderOne(from.inflate(R.layout.content_recycler, viewGroup, false));
            }
            if (this.plate_sections.keySet().toArray()[i].equals(4) || this.plate_sections.keySet().toArray()[i].equals(8) || this.plate_sections.keySet().toArray()[i].equals(12) || this.plate_sections.keySet().toArray()[i].equals(16)) {
                return new ViewHolderTwo(from.inflate(R.layout.content_recycler2, viewGroup, false), this.mOnPopupListener);
            }
            return new ViewHolderThree(from.inflate(R.layout.content_recycler3, viewGroup, false));
        }
        return new ViewHolderFour(from.inflate(R.layout.content_recycler4, viewGroup, false), this.mOnPopupListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: binded content to each viewHolder.");
        try {
            if (i < this.count_plate_sections) {
                if (!this.plate_sections.keySet().toArray()[i].equals(2) && !this.plate_sections.keySet().toArray()[i].equals(6) && !this.plate_sections.keySet().toArray()[i].equals(10) && !this.plate_sections.keySet().toArray()[i].equals(14)) {
                    if (!this.plate_sections.keySet().toArray()[i].equals(4) && !this.plate_sections.keySet().toArray()[i].equals(8) && !this.plate_sections.keySet().toArray()[i].equals(12) && !this.plate_sections.keySet().toArray()[i].equals(16)) {
                        if (this.plate_sections.keySet().toArray()[i].equals(1) || this.plate_sections.keySet().toArray()[i].equals(3) || this.plate_sections.keySet().toArray()[i].equals(5) || this.plate_sections.keySet().toArray()[i].equals(7) || this.plate_sections.keySet().toArray()[i].equals(9) || this.plate_sections.keySet().toArray()[i].equals(11) || this.plate_sections.keySet().toArray()[i].equals(13) || this.plate_sections.keySet().toArray()[i].equals(15) || this.plate_sections.keySet().toArray()[i].equals(17)) {
                            int intValue = ((Integer) this.plate_sections.keySet().toArray()[i]).intValue();
                            ImageView imageView = ((ViewHolderThree) viewHolder).plate_image;
                            Object obj = this.plate_sections.get(Integer.valueOf(intValue));
                            Objects.requireNonNull(obj);
                            imageView.setImageResource(((Integer) obj).intValue());
                        }
                    }
                    ViewHolderTwo viewHolderTwo = (ViewHolderTwo) viewHolder;
                    int intValue2 = ((Integer) this.plate_sections.keySet().toArray()[i]).intValue();
                    viewHolderTwo.popUpNum = intValue2;
                    TextView textView = viewHolderTwo.plate_popup;
                    Object obj2 = this.plate_sections.get(Integer.valueOf(intValue2));
                    Objects.requireNonNull(obj2);
                    textView.setText(obj2.toString());
                }
                Log.d(TAG, "AAA-onBindViewHolder: all plate sections keys: " + this.plate_sections.keySet());
                Log.d(TAG, "AAA-onBindViewHolder: all plate sections content: " + this.plate_sections);
                Log.d(TAG, "AAA-onBindViewHolder: plate section: " + this.plate_sections.keySet().toArray()[i]);
                int intValue3 = ((Integer) this.plate_sections.keySet().toArray()[i]).intValue();
                TextView textView2 = ((ViewHolderOne) viewHolder).plate_textView;
                Object obj3 = this.plate_sections.get(Integer.valueOf(intValue3));
                Objects.requireNonNull(obj3);
                textView2.setText(obj3.toString());
            } else {
                ((ViewHolderFour) viewHolder).choice_button.setText(this.mButtonNames.get(i - this.count_plate_sections));
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + this.totalCount);
        return this.totalCount;
    }

    /* loaded from: classes.dex */
    public static class ViewHolderOne extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolderOne";
        private final LinearLayout linear_plate_content;
        private final TextView plate_textView;

        public ViewHolderOne(View view) {
            super(view);
            Log.d(TAG, "ViewHolderOne: created ViewHolder object.");
            this.linear_plate_content = (LinearLayout) view.findViewById(R.id.linear_plate_content);
            this.plate_textView = (TextView) view.findViewById(R.id.plate_textView);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHolderTwo extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ViewHolderTwo";
        private final LinearLayout linear_plate_content2;
        OnPopupListener mOnPopupListener;
        private final TextView plate_popup;
        private int popUpNum;

        public ViewHolderTwo(View view, OnPopupListener onPopupListener) {
            super(view);
            Log.d(TAG, "ViewHolderTwo: created ViewHolder object.");
            this.linear_plate_content2 = (LinearLayout) view.findViewById(R.id.linear_plate_content2);
            this.plate_popup = (TextView) view.findViewById(R.id.plate_popup);
            this.mOnPopupListener = onPopupListener;
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d(TAG, "onClick: when clicked, got position of ViewHolder clicked.");
            this.mOnPopupListener.onButtonClick(getAdapterPosition(), this.popUpNum);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHolderThree extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolderThree";
        private final LinearLayout linear_plate_content3;
        private final ImageView plate_image;

        public ViewHolderThree(View view) {
            super(view);
            Log.d(TAG, "ViewHolderThree: created ViewHolder object.");
            this.linear_plate_content3 = (LinearLayout) view.findViewById(R.id.linear_plate_content3);
            this.plate_image = (ImageView) view.findViewById(R.id.plate_image);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHolderFour extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ViewHolderFour";
        private final TextView choice_button;
        OnPopupListener mOnPopupListener;
        private final LinearLayout relative_choice_buttons;

        public ViewHolderFour(View view, OnPopupListener onPopupListener) {
            super(view);
            Log.d(TAG, "ViewHolderTwo: created ViewHolder object.");
            this.relative_choice_buttons = (LinearLayout) view.findViewById(R.id.relative_choice_buttons);
            this.choice_button = (TextView) view.findViewById(R.id.choice_button);
            this.mOnPopupListener = onPopupListener;
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d(TAG, "onClick: when clicked, got position of ViewHolder clicked.");
            this.mOnPopupListener.onButtonClick(getAdapterPosition(), -1);
        }
    }
}
