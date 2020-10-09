package co.domi.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import co.domi.parcial1.model.Jugador;

public class playGame extends AppCompatActivity {

    Button upButton,leftButton,rightButton,downButton,changeColorButton;
    TCPclient tcp;
    int x,y;
    String user,detalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

       upButton = findViewById(R.id.upButton);
       leftButton = findViewById(R.id.leftButton);
       rightButton = findViewById(R.id.rightButton);
       downButton = findViewById(R.id.downButton);
       changeColorButton = findViewById(R.id.changeColorButton);

       //Singleton
        tcp = TCPclient.getInstance();
        String a = getIntent().getExtras().getString("a");
        int b = getIntent().getExtras().getInt("b");
        int c = getIntent().getExtras().getInt("c");
        String d = getIntent().getExtras().getString("d");
        user = a;
        x = b;
        y = c;
        detalles = d;

        downButton.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    y = y + 50;
                    Jugador obj = new Jugador(user,x,y,detalles);
                    String json = gson.toJson(obj);
                    tcp.Message(json);
                }
        );
        rightButton.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    x = x + 50;
                    Jugador obj = new Jugador(user,x,y,detalles);
                    String json = gson.toJson(obj);
                    tcp.Message(json);
                }
        );
        leftButton.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    x = x - 50;
                    Jugador obj = new Jugador(user,x,y,detalles);
                    String json = gson.toJson(obj);
                    tcp.Message(json);
                }
        );
        upButton.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    y = y - 50;
                    Jugador obj = new Jugador(user,x,y,detalles);
                    String json = gson.toJson(obj);
                    tcp.Message(json);
                }
        );

    }
}