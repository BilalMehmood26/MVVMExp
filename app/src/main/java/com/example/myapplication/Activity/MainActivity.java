package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myapplication.Adapter.NicePlaceAdapter;
import com.example.myapplication.Model.NicePlace;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.MainActivityVM;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private NicePlaceAdapter mAdapter;
    private ArrayList<NicePlace> nicePlaceArrayList = new ArrayList<>();
    private MainActivityVM mMainActivityVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recycler_view);
        mProgressBar = findViewById(R.id.progress_bar);


        mMainActivityVM = ViewModelProviders.of(this).get(MainActivityVM.class);
        mMainActivityVM.init();
        mMainActivityVM.getNicePlace().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                mAdapter.notifyDataSetChanged();
            }
        });

        mMainActivityVM.getIsUpdateing().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }else{
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(mMainActivityVM.getNicePlace().getValue().size()-1);
                }
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivityVM.addNewValue(new NicePlace("Bamsi","https://i.imgur.com/CdGjn5S.jpeg"));
            }
        });
       // nicePlaceArrayList.add(new NicePlace("Ertugrul","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.peakpx.com%2Fen%2Fhd-wallpaper-desktop-oztuw&psig=AOvVaw3Z21hdkg7K120zdeYdDPxT&ust=1631898800257000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCxgvX-g_MCFQAAAAAdAAAAABAE"));
        initRecycler();
    }

    private void initRecycler() {
        mAdapter = new NicePlaceAdapter(mMainActivityVM.getNicePlace().getValue(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }


    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }
}