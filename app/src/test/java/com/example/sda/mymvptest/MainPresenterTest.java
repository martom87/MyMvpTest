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
// ta andnotacja umożliwia mockovanie obiektów
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    // Mockujemy obiekt mainView żeby zobaczyć czy wyświetla to co trzeba w zależności od podanego przez usera inputu
    @Mock
    MainView mainView;

    //musimy stworzyć obiekt presentera żeby móc wywoływać na nim metody które prowadzą do efektu w postaci wyświetlenia w MainActivity która realizuje widok
    private MainPresenter presenter;

    // przed przystąpmieniem do trzeba zalokować pamieć do obiektu presenter oraz podłączyć do niego widok mainView który zrealizuje MainActivity
    @Before
    public void setUp() {
        presenter = new MainPresenter();
        presenter.attachView(mainView);

    }

    @Test
    public void presenterShouldEmptyStringMessage() {
        String s = ""; // nie można wstawić tutaj nulla bo wtedy nie ma tego obiektu w pamięci a edit text zapisuje obiekt który może być pusty
        presenter.setUpEditText(s);
        verify(mainView).showErrorMessage(R.string.errorMessage);
    }

    @Test
    public void presenterShouldStringBeNotValueOfInteger() {
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
