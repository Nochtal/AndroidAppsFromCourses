package com.modnarecid.noch.datetimeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ITimeDialog, IDateDialog {
    EditText txtTime, txtDate;
    Button btnDate, btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTime = (Button)findViewById(R.id.abtnTimeDialogue);
        txtTime = (EditText)findViewById(R.id.atxtTime);
        btnDate = (Button)findViewById(R.id.abtnDateDialog);
        txtDate = (EditText)findViewById(R.id.atxtDate);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create Time Dialog and show it via txtTime control
                txtTime.setText("");
                TimeLord who = new TimeLord();
                who.show(getFragmentManager(), "TARTIS");
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDate.setText("");
                DateLord when = new DateLord();
                when.show(getFragmentManager(), "TARTIS");
            }
        });
    }

    @Override
    public void sendTime(int hour, int minute) {
        // This is a call-back method.
        // The dialog/library will call the main form/activity to pass information to it
        // This method will get called by TimeLord  (DialogFragment)
        // it gets passed the hour and minute selected by the user
        String h;
        String m;
        // display the selected hour, minute in the editText
        if (hour < 10) {
            h = "0" + hour + "";
        } else {
            h = hour + "";
        }
        if (minute < 10) {
            m = "0" + minute;
        } else {
            m = minute + "";
        }
        txtTime.setText(h + ":" + m);
    }

    @Override
    public void sendDate(int day, int month, int year) {
        String d, m, y;
        d = day + "-";
        m = month + "-";
        y = year +"";
        txtDate.setText(d + m + y);
    }
}
