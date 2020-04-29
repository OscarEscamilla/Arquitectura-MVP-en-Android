package com.example.mvp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.Interfaces.MainPresenterI;
import com.example.mvp.Interfaces.MainViewI;
import com.example.mvp.Presenters.MainPresenter;
import com.example.mvp.R;

public class MainActivity extends AppCompatActivity implements MainViewI {


    private EditText ed_num_1;
    private EditText ed_num_2;
    private Button btn_sumar;

    private MainPresenterI presenterI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // pasamos al constructor el View del presenter
        presenterI = new MainPresenter(this);
        initComponents();
    }

    private void initComponents(){
        ed_num_1 = findViewById(R.id.et_num1);
        ed_num_2 = findViewById(R.id.et_num2);
        btn_sumar = findViewById(R.id.btn_sumar);
    }

    @Override
    public void setResult(String result) {
        Toast.makeText(MainActivity.this, "El resultado es: " + result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    public void suma(View view){
        // cuando se haga click en suma mandamos traer un metodo del Presenter a traves de su interface
        presenterI.realizarOperacion(ed_num_1.getText().toString(), ed_num_2.getText().toString());
    }
}
