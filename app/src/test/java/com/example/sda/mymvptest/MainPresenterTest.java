package com.example.sda.mymvptest;

import com.example.sda.mymvptest.activities.MainPresenter;
import com.example.sda.mymvptest.activities.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by sda on 17.07.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    MainView mainView;

    private MainPresenter presenter;

    @Before
    public void setUp() {
        presenter = new MainPresenter();
        presenter.attachView(mainView);

    }

    @Test
    public void presenterShouldEmptyStringMessage() {
        String s = "";
        presenter.setUpEditText(s);
        verify(mainView).showErrorMessage(R.string.errorMessage);
    }

    @Test
    public void presenterShouldNotNumberStringMessage() {
        String s = "ffff";
        presenter.setUpEditText(s);
        verify(mainView).showErrorMessage(R.string.errorMessage);
    }

    @Test
    public void presenterShouldStringBeValueOfInteger() {
        String s = "1";
        presenter.setUpEditText(s);
        verify(mainView).showNumber(s);
    }

}
