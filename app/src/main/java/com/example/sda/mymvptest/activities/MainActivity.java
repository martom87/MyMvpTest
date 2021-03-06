package com.example.sda.mymvptest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sda.mymvptest.App;
import com.example.sda.mymvptest.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.editText)
    EditText editSomeText;

    @BindView(R.id.textView)
    TextView viewSomeText;


    @OnClick(R.id.button)
    public void onClick() {
        // w modelu MVP w Activity powinno sie wykownac tylko rzeczy związane z widokiem- który realizuje aktywność
        // a który z presentera przenosi intefejs View.

        mainPresenter.setUpEditText(editSomeText.getText().toString());

        // powyższe wyrażenie ^ jest tożsame z poniższym umożliwami wprowadzenie String s przez użytkownika
        //  String s = editSomeText.getText().toString();
        //  mainPresenter.setUpEditText(s);
    }

    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((App) getApplication()).getAppComponent().inject(this);
        mainPresenter.attachView(this);

    }

    @Override
    protected void onDestroy() {
        mainPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showNumber(String s) {
        viewSomeText.setText(s);
    }


    @Override
    public void showErrorMessage(int resId) {
        editSomeText.setText(getString(resId));
    }
}
