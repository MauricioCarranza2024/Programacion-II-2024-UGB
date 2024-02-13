package com.ugb.controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    TextView tempval;
    Spinner spn;
    Button btnLongitud;
    Button btnVolumen; // Botón para la conversión de volumen
    conversores miObj = new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversor);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("LON").setContent(R.id.tabLongitud).setIndicator("LONGITUD", null));
        tbh.addTab(tbh.newTabSpec("VOL").setContent(R.id.tabVolumen).setIndicator("VOLUMEN", null));
        tbh.addTab(tbh.newTabSpec("MAS").setContent(R.id.tabMasa).setIndicator("MASA", null));

        // Botón para conversión de longitud
        btnLongitud = findViewById(R.id.btnConvertirLongitud);
        btnLongitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica de conversión de longitud
                spn = findViewById(R.id.spnDElongitud);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAlongitud);
                int a = spn.getSelectedItemPosition();

                tempval = findViewById(R.id.txtCantidadLongitud);
                double cantidad = Double.parseDouble(tempval.getText().toString());
                double resp = miObj.convertir(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta:" + resp, Toast.LENGTH_LONG).show();
            }
        });

        // Botón para conversión de volumen
        btnVolumen = findViewById(R.id.btnConvertirVolumen);
        btnVolumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica de conversión de volumen
                spn = findViewById(R.id.spnDEVolumen);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAVolumen);
                int a = spn.getSelectedItemPosition();

                tempval = findViewById(R.id.txtCantidadDeVolumen);
                double cantidad = Double.parseDouble(tempval.getText().toString());
                double resp = miObj.convertir(1, de, a, cantidad); // Se pasa 1 como opción para la conversión de volumen
                Toast.makeText(getApplicationContext(), "Respuesta:" + resp, Toast.LENGTH_LONG).show();
            }
        });
        btnLongitud = findViewById(R.id.btnConvertirMasa);
        btnLongitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica de conversión de longitud
                spn = findViewById(R.id.spnDEMasa);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAMasa);
                int a = spn.getSelectedItemPosition();

                tempval = findViewById(R.id.txtCantidadDeMasa);
                double cantidad = Double.parseDouble(tempval.getText().toString());
                double resp = miObj.convertir(2, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta:" + resp, Toast.LENGTH_LONG).show();
            }
        });
    }
}

class conversores {
    double[][] valores = {
            // Longitud
            {1, 100, 39.3701, 3.28084, 1.193, 1.09361, 0.001, 0.000621371},
            // Volumen
            {1, 1000, 0.001},
            // Masa
            {1, 1000, 0.00220462, 0.035274, 0.001, 1e+6, 9.8421e-7, 1.1023e-6},
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

