package com.syamsidin.homepedagang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.syamsidin.homepedagang.R;
import com.syamsidin.homepedagang.adapter.AdapterDetailPenilaian;

public class DetailPenilaianActivity extends AppCompatActivity {
    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }
    protected DetailPenilaianActivity.LayoutManagerType mCurrentLayoutManagerType;
    protected RecyclerView mRecyclerView;
    protected AdapterDetailPenilaian mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset,mDataset2;
    protected int[] mDataset3,mDataset4;

    //neme di dalam bentuk array
    int [] image_produk = {R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image};
    String[] nama_produk = {"Martabak Coklat","Es Kalapa Muda","Coklat Susu","Tamulawak","Kolek Cau","Salak Pondoh","Sirup Marjan","Goreng Ulen","Tutug Oncom","Mie Tektek"};
    String [] nama_pemberi ={"200 Penilaian","200 Penilaian","100 Penilaian","50 Penilaian","200 Penilaian","542 Penilaian","432 Penilaian","238 Penilaian","243 Penilaian","312 Penilaian"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penilaian);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Detail Penilaian");
        initDataset();
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(this);

        mCurrentLayoutManagerType = DetailPenilaianActivity.LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (DetailPenilaianActivity.LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new AdapterDetailPenilaian(mDataset,mDataset2,mDataset3);
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
        }if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

    public void setRecyclerViewLayoutManager(DetailPenilaianActivity.LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(this, SPAN_COUNT);
                mCurrentLayoutManagerType = DetailPenilaianActivity.LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(this);
                mCurrentLayoutManagerType = DetailPenilaianActivity.LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(this);
                mCurrentLayoutManagerType = DetailPenilaianActivity.LayoutManagerType.LINEAR_LAYOUT_MANAGER;
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
        mDataset = new String[nama_produk.length];
        mDataset2 = new String[nama_pemberi.length];
        mDataset3 = new int[image_produk.length];
        for (int i = 0; i < nama_produk.length; i++) {
            mDataset[i] = nama_produk[i];
            mDataset2[i] = nama_pemberi[i];
            mDataset3[i] = image_produk[i];
        }
    }
}
