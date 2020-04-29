package com.example.mvp.Presenters;

import com.example.mvp.Interactors.MainInteractor;
import com.example.mvp.Interfaces.MainInteractorI;
import com.example.mvp.Interfaces.MainPresenterI;
import com.example.mvp.Interfaces.MainViewI;

public class MainPresenter implements MainPresenterI {

    private MainViewI view;
    private MainInteractorI interactor;

    // inyectamos la vista para poder ejecutar los metodos de la vista en el presenter
    public MainPresenter(MainViewI view) {
        this.view = view;
        interactor = new MainInteractor(this);
    }

    @Override
    public void realizarOperacion(String num1, String num2) {
        if (view != null) {
            // aqui mandamos traer el interactor para que realize la logica
            interactor.realizarSuma(num1, num2);
        }
    }

    @Override
    public void showErrorPresenterI(String error) {
        if (view != null) {
            view.showError(error);
        }
    }

    @Override
    public void setResult(String result) {
        view.setResult(result);
    }


}
