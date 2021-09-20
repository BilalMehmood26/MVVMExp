package com.example.myapplication.ViewModel;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Model.NicePlace;
import com.example.myapplication.Repo.NicePlaceRepo;

import java.util.List;

public class MainActivityVM extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();
    private NicePlaceRepo mRepo;

    public void init() {
        if (mNicePlaces != null) {
            return;
        }
        mRepo = NicePlaceRepo.getInstance();
        mNicePlaces = mRepo.getNicePlaces();
    }

    public LiveData<List<NicePlace>> getNicePlace() {
        return mNicePlaces;
    }

    public void addNewValue(final NicePlace nicePlace) {
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlace =mNicePlaces.getValue();
                currentPlace.add(nicePlace);
                mNicePlaces.postValue(currentPlace);
                mIsUpdating.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<Boolean> getIsUpdateing(){
        return mIsUpdating;
    }
}
