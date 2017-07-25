package com.syamsidin.homepedagang.adapter;

/**
 * Created by Syam on 23/07/2017.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.syamsidin.homepedagang.R;
import com.syamsidin.homepedagang.activity.DetailPenilaianActivity;


/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class AdapterPenilaian extends RecyclerView.Adapter<AdapterPenilaian.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet,mDataSet2;
    private int[] mDataSet3,mDataSet4;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView,textView2;
        private final ImageView icon;
        private final Button button;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            textView = (TextView) v.findViewById(R.id.nama_prduk);
            textView2 = (TextView) v.findViewById(R.id.jumlah_penilaian);
            icon = (ImageView)v.findViewById(R.id.img);
            button = (Button)v.findViewById(R.id.btn_lihat);

        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getTextView2() {
            return textView2;
        }

        public ImageView getImageView() {
            return icon;
        }

        public Button getButton() {
            return button;
        }

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public AdapterPenilaian(String[] dataSet, String[] dataSet2, int[] dataSet3) {
        this.mDataSet = dataSet;
        this.mDataSet2 = dataSet2;
        this.mDataSet3 = dataSet3;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_penilaian_produk, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTextView().setText(mDataSet[position]);
        viewHolder.getTextView2().setText(mDataSet2[position]);
        viewHolder.getImageView().setImageResource(mDataSet3[position]);
        viewHolder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(v.getContext(),DetailPenilaianActivity.class); v.getContext().startActivity(pindah);
            }
        });

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
