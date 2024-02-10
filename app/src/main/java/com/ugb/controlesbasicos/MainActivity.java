package com.ugb.controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView temVal;
    Button btn;
    RadioGroup opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btncalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temVal = findViewById(R.id.txtnum1);
                double num1 = Double.parseDouble(temVal.getText().toString());

                temVal = findViewById(R.id.txtnum2);
                double num2 = Double.parseDouble(temVal.getText().toString());

                double respuesta = 0;
                opt = findViewById(R.id.optOpciones);
                switch (opt.getCheckedRadioButtonId()){
                    case R.id.optSuma:
                        respuesta = num1 + num2;
                        break;
                    case R.id.optResta:
                        respuesta=num1-num2;
                        break;
                    case R.id.optMultiplicacion:
                        respuesta=num1*num2;
                        break;
                    case R.id.optDivision:
                        respuesta=num1/num2;
                        break;
                    case R.id.optPorcentaje:
                        respuesta = (num1 / 100) * num2;
                        break;
                    case R.id.optExponenciacion:
                        respuesta = Math.pow(num1, num2);
                        break;
                    case R.id.optFactorial:
                        respuesta = factorial((int) num1);
                        break;
                    case R.id.optRaiz:
                        respuesta = Math.sqrt(num1);
                        break;
                }

                temVal = findViewById(R.id.lblrespuesta);
                temVal.setText("respuesta: "+ respuesta);
            }
        });
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

