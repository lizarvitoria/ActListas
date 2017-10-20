package com.example.dm2.actlistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner cmbOpciones;
    private TextView lblOpcionSeleccionada;
    private String[] superficies = new String[] {"505.370km","92.090km","643.801km","243.610km","357.376km"};
    private String[] poblacion = new String[] {"46.468.102 habitantes","10.562.178 habitantes","66.952.000 habitantes","65.217.975 habitantes","82.667.685 habitantes"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmbOpciones =(Spinner) findViewById(R.id.CmbOpciones);
        lblOpcionSeleccionada = (TextView)findViewById(R.id.lblOpcionSeleccionada);
        final String[] datos = new String[] {"España","Portugal",
                "Francia","Reino Unido", "Alemania"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);

        cmbOpciones.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView,
                                               View view, int i, long l) {
                        lblOpcionSeleccionada.setText(adapterView.getItemAtPosition(i)+":"+superficies[adapterView.getSelectedItemPosition()]+"/"+poblacion[adapterView.getSelectedItemPosition()]);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        lblOpcionSeleccionada.setText("No se ha realizado ninguna selección");
                    }
                });
    }

}
