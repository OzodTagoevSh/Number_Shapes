package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public class Number {
        int number;

        public boolean isTriangular() {
            int sum = 0, i = 0;
            while (sum <= number) {
                i++;
                sum += i;
                if (sum == number) return true;
            }
            return false;
        }

        public boolean isSquare() {
            int sq = 0, i = 0;
            while (sq <= number) {
                i++;
                sq = i * i;
                if (sq == number) return true;
            }
            return false;
        }
    }

    public void checkNumber(View view) {

        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);
        Log.i("Info", "Button Pressed!");

        String message = numberEditText.getText().toString();
        if(numberEditText.getText().toString().isEmpty()) {
            message = "Please enter a number!";
        } else {

            Number num = new Number();
            num.number = Integer.parseInt(numberEditText.getText().toString());

            if (num.isTriangular() && num.isSquare()) {
                message += " is both triangular and square!";
            } else if (num.isTriangular()) {
                message += " is triangular!";
            } else if (num.isSquare()) {
                message += " is square!";
            } else {
                message += " is neither triangular nor square!";
            }
            System.out.println(num.number);
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}