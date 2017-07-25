package com.syamsidin.homepedagang.adapter;

/**
 * Created by Syam on 22/07/2017.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.syamsidin.homepedagang.R;
import com.syamsidin.homepedagang.activity.ObrolanActivity;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class AdapterListProduk extends RecyclerView.Adapter<AdapterListProduk.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet,mDataSet2,mDataSet4;
    private int[] mDataSet3;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView,textView2,textView3;
        private final ImageView icon;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pindah = new Intent(v.getContext(),ObrolanActivity.class); v.getContext().startActivity(pindah);
                }
            });
            textView = (TextView) v.findViewById(R.id.nama_prduk);
            textView2 = (TextView) v.findViewById(R.id.des_prduk);
            icon = (ImageView)v.findViewById(R.id.img);
            textView3 = (TextView)v.findViewById(R.id.harga_prduk);

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
        public TextView getTextView3() {
            return textView3;
        }

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public AdapterListProduk(String[] dataSet, String[] dataSet2, int[] dataSet3, String[] dataSet4) {
        this.mDataSet = dataSet;
        this.mDataSet2 = dataSet2;
        this.mDataSet3 = dataSet3;
        this.mDataSet4 = dataSet4;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_produk, viewGroup, false);
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
        viewHolder.getTextView3().setText(mDataSet4[position]);

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
