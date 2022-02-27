package com.androidpprog2.tres_en_raya.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidpprog2.tres_en_raya.R;
import com.androidpprog2.tres_en_raya.model.Player;

public class MainActivity extends AppCompatActivity {
    private Button[][] matrix = new Button[3][3];
    private TextView turnStatus;
    private Toast victory1, victory2, error, draw;

    private String[] playerTurn = new String[2];
    private Player player1 = new Player("X", true);
    private Player player2 = new Player("O", true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        victory1 = Toast.makeText(MainActivity.this, R.string.player1_victory,
                Toast.LENGTH_SHORT);
        victory2 = Toast.makeText(MainActivity.this, R.string.player2_victory,
                Toast.LENGTH_SHORT);
        error = Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT);
        draw = Toast.makeText(MainActivity.this, R.string.draw, Toast.LENGTH_SHORT);

        playerTurn[0] = getResources().getString(R.string.player1_turn);
        playerTurn[1] = getResources().getString(R.string.player2_turn);

        matrix[0][0] = findViewById(R.id.button1);
        matrix[0][1] = findViewById(R.id.button2);
        matrix[0][2] = findViewById(R.id.button3);
        matrix[1][0] = findViewById(R.id.button4);
        matrix[1][1] = findViewById(R.id.button5);
        matrix[1][2] = findViewById(R.id.button6);
        matrix[2][0] = findViewById(R.id.button7);
        matrix[2][1] = findViewById(R.id.button8);
        matrix[2][2] = findViewById(R.id.button9);

        turnStatus = (TextView) findViewById(R.id.text_view_turn);
        turnStatus.setText(playerTurn[0]);

        matrix[0][0].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[0][0]);
            else nextPlayer1(matrix[0][0]);
        });

        matrix[0][1].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[0][1]);
            else nextPlayer1(matrix[0][1]);
        });

        matrix[0][2].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[0][2]);
            else nextPlayer1(matrix[0][2]);
        });

        matrix[1][0].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[1][0]);
            else nextPlayer1(matrix[1][0]);
        });

        matrix[1][1].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[1][1]);
            else nextPlayer1(matrix[1][1]);
        });

        matrix[1][2].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[1][2]);
            else nextPlayer1(matrix[1][2]);
        });

        matrix[2][0].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[2][0]);
            else nextPlayer1(matrix[2][0]);
        });

        matrix[2][1].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[2][1]);
            else nextPlayer1(matrix[2][1]);
        });

        matrix[2][2].setOnClickListener(v -> {
            if (player1.getStatus()) nextPlayer2(matrix[2][2]);
            else nextPlayer1(matrix[2][2]);
        });
    }

    private void nextPlayer1(Button position) {
        if(position.getText().equals(player1.getSymbol()) ||
                position.getText().equals(player2.getSymbol())) {
            showMessage(error);
            turnStatus.setText(playerTurn[1]);
        } else {
            position.setText(player2.getSymbol());
            if (isWon(player2.getSymbol())) {
                showMessage(victory2);
                resetGame();
            } else if (isDraw()) {
                showMessage(draw);
                resetGame();
            } else {
                player2.setStatus(false);
                player1.setStatus(true);
                turnStatus.setText(playerTurn[0]);
            }
        }
    }

    private void nextPlayer2(Button position) {
        if(position.getText().equals(player1.getSymbol()) ||
                position.getText().equals(player2.getSymbol())) {
            showMessage(error);
            turnStatus.setText(playerTurn[0]);
        } else {
            position.setText(player1.getSymbol());
            if (isWon(player1.getSymbol())) {
                showMessage(victory1);
                resetGame();
            } else if (isDraw()) {
                showMessage(draw);
                resetGame();
            } else {
                player1.setStatus(false);
                player2.setStatus(true);
                turnStatus.setText(playerTurn[1]);
            }
        }
    }

    private boolean isWon(String type) {
        int cont;

        for (Button[] value : matrix) {
            cont = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (value[j].getText().equals(type)) cont++;
            }
            if (cont == 3) return true;
        }

        for ( int j = 0 ; j < matrix.length ; j++) {
            cont = 0;
            for (Button[] buttons : matrix) {
                if (buttons[j].getText().equals(type)) cont++;
            }
            if (cont == 3) return true;
        }

        return (matrix[0][0].getText().equals(type) && matrix[1][1].getText().equals(type) &&
                matrix[2][2].getText().equals(type)) || (matrix[0][2].getText().equals(type) &&
                matrix[1][1].getText().equals(type) && matrix[2][0].getText().equals(type));
    }

    public boolean isDraw () {
        int cont = 0;
        for (Button[] buttons : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (buttons[j].getText().equals(player2.getSymbol()) ||
                        buttons[j].getText().equals(player1.getSymbol())) cont++;
            }
        }
        return cont == 9;
    }

    private void resetGame() {
        for (Button[] buttons : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                buttons[j].setText("");
            }
        }
        turnStatus.setText(playerTurn[0]);
        player1 = new Player("X", true);
        player2 = new Player("O", true);
    }

    private void showMessage(Toast toast) {
        toast.show();
    }
}