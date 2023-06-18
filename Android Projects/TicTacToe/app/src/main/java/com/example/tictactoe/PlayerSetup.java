package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1 = findViewById(R.id.player1name);
        player2 = findViewById(R.id.player2name);

    }

    public void submitButtonClick(View view) {

        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();

        Intent intentForEmptyName = new Intent(this,PlayerSetup.class);

        if (player1Name.trim().equals(""))
        {
            Toast.makeText(PlayerSetup.this,"Enter player 1 name to start the Game",Toast.LENGTH_SHORT).show();
            startActivity(intentForEmptyName);

        }
        else if (player2Name.trim().equals(""))
        {
            Toast.makeText(PlayerSetup.this,"Enter player 2 name to start the Game",Toast.LENGTH_SHORT).show();
            startActivity(intentForEmptyName);

        }

        else {
            Intent intent = new Intent(this, GameDisplay.class);
            intent.putExtra("PLAYER_NAMES", new String[]{player1Name, player2Name});
            startActivity(intent);
        }

    }


}