package co.domi.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class playGame extends AppCompatActivity {

    Button upButton,leftButton,rightButton,downButton,changeColorButton;
    TCPclient tcp;

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
    }
}