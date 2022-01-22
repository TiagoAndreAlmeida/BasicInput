package com.example.basicinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText nameInputLayout;
    private TextInputEditText emailInputLayout;
    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInputLayout = findViewById(R.id.nameEditLayout);
        emailInputLayout = findViewById(R.id.emailEditLayout);
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
    }

    public void onSubmit(View view) {
        String nameValue = nameInputLayout.getText().toString();
        nameTextView.setText(nameValue);
        String emailValue = emailInputLayout.getText().toString();
        emailTextView.setText(emailValue);
        nameInputLayout.clearFocus();
        emailInputLayout.clearFocus();
    }

    public void clearText(View view) {
        nameInputLayout.setText("");
        emailInputLayout.setText("");
        nameTextView.setText("");
        emailTextView.setText("");
    }
}