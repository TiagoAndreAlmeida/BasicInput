package com.example.basicinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText nameInputLayout, emailInputLayout;
    private CheckBox redCheckBox, greenCheckBox, blueCheckBox;
    private TextView nameTextView, emailTextView, colorsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInputLayout = findViewById(R.id.nameEditLayout);
        emailInputLayout = findViewById(R.id.emailEditLayout);
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        colorsTextView = findViewById(R.id.colorsChecked);
        redCheckBox = findViewById(R.id.red);
        greenCheckBox = findViewById(R.id.green);
        blueCheckBox = findViewById(R.id.blue);
    }

    private void handleCheckBox () {
        String selectedBox = "Cores selecionadas: ";
        if(redCheckBox.isChecked()) {
            selectedBox += " "+redCheckBox.getText().toString();
        }
        if(greenCheckBox.isChecked()) {
            selectedBox += " "+greenCheckBox.getText().toString();
        }
        if(blueCheckBox.isChecked()) {
            selectedBox += " "+blueCheckBox.getText().toString();
        }

        colorsTextView.setText(selectedBox);
    }

    public void onSubmit(View view) {
        String nameValue = nameInputLayout.getText().toString();
        nameTextView.setText(nameValue);
        String emailValue = emailInputLayout.getText().toString();
        emailTextView.setText(emailValue);
        handleCheckBox();
    }

    public void clearText(View view) {
        nameInputLayout.setText("");
        emailInputLayout.setText("");
        nameTextView.setText("");
        emailTextView.setText("");
        colorsTextView.setText("");
        redCheckBox.setChecked(false);
        greenCheckBox.setChecked(false);
        blueCheckBox.setChecked(false);
    }
}