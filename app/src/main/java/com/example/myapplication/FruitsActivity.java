package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FruitsActivity extends AppCompatActivity {
    ListView lista;
    Button btnSalir;

    int[] imgfrutas = {
            R.drawable.banana,
            R.drawable.coco,
            R.drawable.uva,
            R.drawable.manzana,
            R.drawable.pera,
            R.drawable.sandia
    };

    String[] nomfrutas = {
            "BANANA",
            "COCO",
            "UVA",
            "MANZANA",
            "PERA",
            "SANDIA"
    };

    String[] precios = {
            "$2.500/kg",
            "$4.000/unidad",
            "$5.500/kg",
            "$3.200/kg",
            "$3.800/kg",
            "$2.000/kg"
    };

    String[] lugares = {
            "Ecuador",
            "Colombia",
            "Chile",
            "Estados Unidos",
            "Argentina",
            "Colombia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        lista = findViewById(R.id.lvFrutas);
        btnSalir = findViewById(R.id.btnSalir);

        lista.setAdapter(new FruitAdapter(this, nomfrutas, imgfrutas, precios, lugares));

        btnSalir.setOnClickListener(v -> mostrarDialogoSalir());
    }

    private void mostrarDialogoSalir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmación")
               .setMessage("¿Está seguro que desea salir de la aplicación?")
               .setPositiveButton("Sí", (dialog, which) -> {
                   finishAffinity(); // Esto cierra todas las actividades y sale de la aplicación
               })
               .setNegativeButton("No", (dialog, which) -> {
                   dialog.dismiss();
               })
               .show();
    }
}
