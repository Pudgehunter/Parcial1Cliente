package co.domi.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import co.domi.parcial1.model.Jugador;

public class MainActivity extends AppCompatActivity implements onMessageListener{
    Button okButtonId;
    EditText nombreId;
    TCPclient tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okButtonId = findViewById(R.id.okButtonId);
        nombreId = findViewById(R.id.nombreId);

        tcp = TCPclient.getInstance();

        okButtonId.setOnClickListener(
               (v) -> {
                    Gson gson = new Gson();
                    String user = nombreId.getText().toString();
                    int x = 50;
                    int y = 50;
                    String detalles = "El nombre del jugador empieza siempre en esta coordenada 50,50";

                    Jugador obj = new Jugador(user,x,y,detalles);
                   String json = gson.toJson(obj);

                   tcp.Message(json);
                   Intent i = new Intent(this,playGame.class);
                   startActivity(i);
                }
        );

    }

    @Override
    public void message(String msg) {
       runOnUiThread(
                () -> {
                    //mensajes
               }
        );
    }
}