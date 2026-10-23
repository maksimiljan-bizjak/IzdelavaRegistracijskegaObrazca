package com.example.izdelavaregistracijskegaobrazca;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText fullName;
    EditText country;
    EditText email;
    EditText phone;
    EditText password;

    RadioGroup genderGroup;
    CheckBox terms;
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        fullName = findViewById(R.id.fullName);
        country = findViewById(R.id.country);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        genderGroup = findViewById(R.id.genderGroup);
        terms = findViewById(R.id.terms);
        createAccount = findViewById(R.id.createAccount);

        createAccount.setOnClickListener(v -> {

            String usernameText = username.getText().toString();
            String fullNameText = fullName.getText().toString();
            String countryText = country.getText().toString();
            String emailText = email.getText().toString();
            String phoneText = phone.getText().toString();
            String passwordText = password.getText().toString();

            String gender = "Not selected";

            int selectedGender = genderGroup.getCheckedRadioButtonId();

            if (selectedGender == R.id.male) {
                gender = "Male";
            } else if (selectedGender == R.id.female) {
                gender = "Female";
            }

            String termsAccepted;

            if (terms.isChecked()) {
                termsAccepted = "Yes";
            } else {
                termsAccepted = "No";
            }

            String message =
                    "Username: " + usernameText +
                            "\nFull name: " + fullNameText +
                            "\nCountry: " + countryText +
                            "\nEmail: " + emailText +
                            "\nPhone number: " + phoneText +
                            "\nPassword: " + passwordText +
                            "\nGender: " + gender +
                            "\nTerms Accepted: " + termsAccepted;

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Registration Details")
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}