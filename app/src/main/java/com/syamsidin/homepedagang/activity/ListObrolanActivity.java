package com.syamsidin.homepedagang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.syamsidin.homepedagang.R;
import com.syamsidin.homepedagang.adapter.AdapterListObrolan;

public class ListObrolanActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }
    protected LayoutManagerType mCurrentLayoutManagerType;
    protected RecyclerView mRecyclerView;
    protected AdapterListObrolan mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset,mDataset2,mDataset4;
    protected int[] mDataset3;

    //neme di dalam bentuk array
    int [] icon = {R.drawable.user_image,R.drawable.user_image,R.drawable.user_image,R.drawable.user_image,R.drawable.user_image,R.drawable.user_image,R.drawable.user_image,R.drawable.user_image,R.drawable.user_image,R.drawable.user_image};
    String[] judul = {"Samsidin","Ade Fulki Hadian","Risa Aprilia","Chandra Abdul Fatah","Bayu Arafli","Nurul Mardiah","Mulyati","Diaz Chikal Setiawan","Riki Sukmawan","Yusup Abdul Majid"};
    String [] deskripsi ={"20   /8/2017","20/08/2017","20/08/2017","20/08/2017","20/08/2017","20/08/2017","20/08/2017","20/08/2017","20/08/2017","20/08/2017"};
    String [] deskripsi2 ={"09.20","09.20","09.20","09.20","09.20","09.20","09.20","09.20","09.20","09.20"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_obrolan);

        setTitle("List Obrolan");
        initDataset();
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(this);

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new AdapterListObrolan(mDataset,mDataset2,mDataset3,mDataset4);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(this, SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new String[judul.length];
        mDataset2 = new String[deskripsi.length];
        mDataset3 = new int[icon.length];
        mDataset4 = new String[deskripsi2.length];
        for (int i = 0; i < judul.length; i++) {
            mDataset[i] = judul[i];
            mDataset2[i] = deskripsi[i];
            mDataset3[i] = icon[i];
            mDataset4[i] = deskripsi2[i];
        }
    }
}
