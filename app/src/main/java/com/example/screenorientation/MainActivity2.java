package com.example.screenorientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button alertDialog;
    EditText name;
    private View view1;
    private String userName;
    private Boolean alert = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        alertDialog = (Button) findViewById(R.id.alert);

        View inflater = getLayoutInflater().inflate(R.layout.bottom_btn, null);
        name = inflater.findViewById(R.id.show);

        if (savedInstanceState != null && savedInstanceState.getBoolean("dial", false)) {
            userName = savedInstanceState.getString("name");
            name.setText(userName);
            createAlert(view1);
        }

        alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alert = true) {
                    createAlert(view);
                }

            }
        });
    }
    //onStop()
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", userName);
        outState.putBoolean("dial", alert);

    }
    //onCall()
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("name",userName);
        savedInstanceState.getBoolean("dial",alert);

    }

    public void createAlert(View v) {
        AlertDialog.Builder d = new AlertDialog.Builder(MainActivity2.this);
        d.setTitle("Alert");
        final View customLayout = getLayoutInflater().inflate(R.layout.bottom_btn, null);
        d.setView(customLayout);
        EditText ed = customLayout.findViewById(R.id.show);
        toast(ed.getText().toString());
        d.show();
    }

    private void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}