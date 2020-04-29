package com.example.mvp.Interfaces;

import java.lang.ref.SoftReference;

public interface MainPresenterI {


    void realizarOperacion(String num1, String num2);

    void showErrorPresenterI(String error);

    void setResult(String result);
}
