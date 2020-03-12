package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context=this;

        // Components Variables
        final EditText InputOne = (EditText) findViewById(R.id.Number1Input);
        final EditText InputTwo = (EditText) findViewById(R.id.Number2Input);
        final TextView Addition=(TextView)findViewById(R.id.Addition);
        final TextView Substraction=(TextView)findViewById(R.id.Substraction);
        final TextView Multiplication=(TextView)findViewById(R.id.Multiplication);
        final TextView Division=(TextView)findViewById(R.id.Division);
        Button calculateButton = (Button) findViewById(R.id.Calculate);
        final TextView Message=(TextView)findViewById(R.id.Message);

        // Initialize TextView
        Addition.setText("");
        Substraction.setText("");
        Multiplication.setText("");
        Division.setText("");
        Message.setText("");

        // onClick Functions
        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    int num1 = Integer.parseInt(InputOne.getText().toString());
                    int num2 = Integer.parseInt(InputTwo.getText().toString());
                    Addition.setText("Addition is: "+Double.toString(num1+num2));
                    Addition.setPadding(30,30,30,30);
                    Substraction.setText("Substraction is: "+Double.toString(num1-num2));
                    Substraction.setPadding(30,30,30,30);
                    Multiplication.setText("Multiplication is:  "+Double.toString(num1*num2));
                    Multiplication.setPadding(30,30,30,30);
                    Division.setText("Division is:  "+Double.toString(num1/num2));
                    Division.setPadding(30,30,30,30);

                    String result = "Addition is:  "+Double.toString(num1+num2)+
                            "\nSubstraction is:  "+Double.toString(num1-num2)+
                            "\nMultiplication is:  "+Double.toString(num1*num2)+
                            "\nDivision is:  "+Double.toString(num1/num2);
                    writeToFile(result,context);

                    InputOne.clearComposingText();
                    InputTwo.clearComposingText();
                    Message.setText("");

                }catch(Exception e){
                    Message.setText("Please, Type a correct number and try again");
                    Addition.setText(null);
                    Addition.setPadding(0,0,0,0);
                    Substraction.setText(null);
                    Substraction.setPadding(0,0,0,0);
                    Multiplication.setText(null);
                    Multiplication.setPadding(0,0,0,0);
                    Division.setText(null);
                    Division.setPadding(0,0,0,0);
                    Substraction.clearComposingText();
                    Multiplication.clearComposingText();
                    Division.clearComposingText();
                }
            }
            private void writeToFile(String data, Context context) {
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Result.txt", Context.MODE_PRIVATE));
                    outputStreamWriter.write(data);
                    outputStreamWriter.close();

                    Toast.makeText(context, "Saved to " + getFilesDir() + "/Result.txt", Toast.LENGTH_LONG).show();
                }
                catch (IOException e) {
                    Toast.makeText(context, "Error Occured While trying to save Result", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void onClick(View v) {
        Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
    }
}
