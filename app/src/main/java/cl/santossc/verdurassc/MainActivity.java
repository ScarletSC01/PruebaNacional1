package cl.santossc.verdurassc;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity {
    Button calcular;
    EditText Verduras, Hectarea;
    Button Limpiar;
    Button Almacenar;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Verduras= findViewById(R.id.txtverduras);
        Hectarea = findViewById(R.id.txthectarea);
        calcular = findViewById(R.id.btncalcular);
        Limpiar = findViewById(R.id.btnLimpiar);
        Almacenar = findViewById(R.id.btnAlmacenar);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Segunda_Pantalla.class

                );
                int VerdurasStr = Integer.parseInt(Verduras.getText().toString());
                int HectareasStr = Integer.parseInt(Hectarea.getText().toString());
                int multiplicacionStr = VerdurasStr * HectareasStr;
                String multiplicacion = String.valueOf(multiplicacionStr);
                intent.putExtra("resultado",multiplicacion.toString());
                startActivity(intent);


            }
        });

        Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                int VerdurasStr = Integer.parseInt(Verduras.getText().toString());
                int HectareStr = Integer.parseInt(Hectarea.getText().toString());
                String Limpiar = " ";
                intent.putExtra("Limpiar",Limpiar.toString());
                startActivity(intent);
            }
        });
        Almacenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("Verduras").setValue(Verduras.getText().toString());
                databaseReference.child("Hectarea").setValue(Hectarea.getText().toString());

                // Almacenar datos adicionales
                databaseReference.child("OtroDato").setValue("Otro dato adicional");
                databaseReference.child("Fecha").setValue("2023-11-22");
            }
        });





    }
}