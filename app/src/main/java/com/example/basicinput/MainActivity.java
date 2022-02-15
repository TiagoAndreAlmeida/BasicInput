package com.example.basicinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private int progressvalue = 0;
    private ProgressBar horizontalProgress, circularProgress;

    private TextInputEditText nameInputLayout, emailInputLayout;
    private CheckBox redCheckBox, greenCheckBox, blueCheckBox;
    private TextView nameTextView, emailTextView, colorsTextView, sexText, belezaText;
    private RadioGroup radioGroupSex;
    private SeekBar seekBar;

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
        radioGroupSex = findViewById(R.id.radioGroupSex);
        sexText = findViewById(R.id.sexText);
        seekBar = findViewById(R.id.seekBar);
        belezaText = findViewById(R.id.textViewbeleza);

        handleRadioButton();

        horizontalProgress = findViewById(R.id.progressBarHorizontal);
        circularProgress = findViewById(R.id.progressBarCircular);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                belezaText.setText("Beleza é: "+progress+ "/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    private void handleRadioButton () {
        radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != -1) {
                    RadioButton radioButton = findViewById(checkedId);
                    sexText.setText("Sexo: "+radioButton.getText().toString());
                }
            }
        });
    }

    public void onSubmit(View view) {
        String nameValue = nameInputLayout.getText().toString();
        nameTextView.setText(nameValue);
        String emailValue = emailInputLayout.getText().toString();
        emailTextView.setText(emailValue);
        handleCheckBox();
        handleRadioButton();
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
        radioGroupSex.clearCheck();
        sexText.setText("");
    }

    public void loadProgress(View view) {
        if(horizontalProgress.getVisibility() == View.INVISIBLE) {
            horizontalProgress.setVisibility(View.VISIBLE);
            circularProgress.setVisibility(View.VISIBLE);
        }

        if(progressvalue < 100) {
            progressvalue += 10;
            horizontalProgress.setProgress(progressvalue);
        } else {
            horizontalProgress.setVisibility(View.INVISIBLE);
            circularProgress.setVisibility(View.GONE);
            progressvalue = 0;
            Toast.makeText(getApplicationContext(), "Carregado com sucesso", Toast.LENGTH_LONG).show();
        }

    }
}