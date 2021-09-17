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
    Button alertDialogButton;
    String name;
    private View view1;
    private Boolean alert = false;
    private AlertDialog.Builder dialpg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        alertDialogButton = (Button) findViewById(R.id.alert);

        view1 = LayoutInflater.from(this).inflate(R.layout.bottom_btn,null);
        EditText ed = view1.findViewById(R.id.show);
        name = ed.getText().toString();

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            ed.setText(name);
            alertDialog();
        }


        alertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alert = true) {
                    alertDialog();
                }

            }
        });
    }
    //onStop()
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText ed = view1.findViewById(R.id.show);
        String userName = ed.getText().toString();
        outState.putString("name",userName);
        outState.putBoolean("dial", alert);
    }
    //onCall()
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("name",name);
        savedInstanceState.getBoolean("dial",alert);
    }

    //show alert
    public void alertDialog(){
        dialpg = new AlertDialog.Builder(MainActivity2.this);
        dialpg.setTitle("Alert").setMessage("Rotate your screen").show();
        dialpg.setView(view1);
        dialpg.create();
        dialpg.show();
    }
    //toast message if needed..
    private void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}