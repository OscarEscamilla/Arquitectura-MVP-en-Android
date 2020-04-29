package com.example.mvp.Interactors;

import com.example.mvp.Interfaces.MainInteractorI;
import com.example.mvp.Interfaces.MainPresenterI;
import com.example.mvp.Presenters.MainPresenter;

public class MainInteractor implements MainInteractorI {

    private MainPresenterI presenter;

    private Double result;

    public MainInteractor(MainPresenterI presenter) {
        this.presenter = presenter;
    }


    @Override
    public void realizarSuma(String num1, String num2) {
        if(num1.equals("") || num2.equals("")){
            presenter.showErrorPresenterI("Complete los campos");
        }else{
            try {
                result = Double.valueOf(num1) + Double.valueOf(num2);
                presenter.setResult(result.toString());

            } catch (Exception e) {
                presenter.showErrorPresenterI("Ingrese solo numeros");
            }
        }
    }
}
