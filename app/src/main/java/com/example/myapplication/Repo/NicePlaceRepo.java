package com.example.myapplication.Repo;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Model.NicePlace;

import java.util.ArrayList;
import java.util.List;

/*
 * Singleton Pattern
 * */
public class NicePlaceRepo {

    private static NicePlaceRepo instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepo getInstance() {
        if (instance == null) {
            instance = new NicePlaceRepo();
        }
        return instance;
    }

    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        setNicePlace();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }



    public void setNicePlace() {

        dataSet.add(new NicePlace("Ertugrul", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.peakpx.com%2Fen%2Fhd-wallpaper-desktop-oztuw&psig=AOvVaw3Z21hdkg7K120zdeYdDPxT&ust=1631898800257000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCxgvX-g_MCFQAAAAAdAAAAABAE"));

        dataSet.add(new NicePlace("Ertugrul", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.peakpx.com%2Fen%2Fhd-wallpaper-desktop-oztuw&psig=AOvVaw3Z21hdkg7K120zdeYdDPxT&ust=1631898800257000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCxgvX-g_MCFQAAAAAdAAAAABAE"));

        dataSet.add(new NicePlace("Ertugrul", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.peakpx.com%2Fen%2Fhd-wallpaper-desktop-oztuw&psig=AOvVaw3Z21hdkg7K120zdeYdDPxT&ust=1631898800257000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCxgvX-g_MCFQAAAAAdAAAAABAE"));

        dataSet.add(new NicePlace("Ertugrul", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.peakpx.com%2Fen%2Fhd-wallpaper-desktop-oztuw&psig=AOvVaw3Z21hdkg7K120zdeYdDPxT&ust=1631898800257000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCxgvX-g_MCFQAAAAAdAAAAABAE"));

        dataSet.add(new NicePlace("Ertugrul", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.peakpx.com%2Fen%2Fhd-wallpaper-desktop-oztuw&psig=AOvVaw3Z21hdkg7K120zdeYdDPxT&ust=1631898800257000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCxgvX-g_MCFQAAAAAdAAAAABAE"));

        dataSet.add(new NicePlace("Ertugrul", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.peakpx.com%2Fen%2Fhd-wallpaper-desktop-oztuw&psig=AOvVaw3Z21hdkg7K120zdeYdDPxT&ust=1631898800257000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCxgvX-g_MCFQAAAAAdAAAAABAE"));

    }
}
