package cl.santossc.verdurassc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Segunda_Pantalla extends AppCompatActivity {
    Button botonvolver;
    TextView TextoRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        TextoRecibido = findViewById(R.id.txtresultado1);
        String resultado = getIntent().getStringExtra("resultado");
        TextoRecibido.setText(resultado);
        botonvolver = findViewById(R.id.btnvolver);

        botonvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);
            }
        });



    }
}