package com.example.sda.mymvptest.activities;

import com.example.sda.mymvptest.R;

import javax.inject.Inject;

/**
 * Created by sda on 15.07.17.
 */

public class MainPresenter {

    private MainView view;

    @Inject
    public MainPresenter() {

    }

    public void attachView(MainView view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }


    public void onClick(String s) {
        if (s.isEmpty()) {
            view.showErrorMessage(R.string.errorMessage);

        } else {
            view.showNumber(s);
        }
    }


}

