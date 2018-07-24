package com.modnarecid.noch.datetimeapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Noch on 3/16/2016.
 */
public class DateLord extends DialogFragment {
    IDateDialog listener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // This is to ensure the Activity (that is using this dialog)
            // implements the ITimeDialog interface
            listener = (IDateDialog) activity;
        } catch (ClassCastException cce) {
            Toast.makeText(getActivity(),cce.getMessage(), Toast.LENGTH_LONG);
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //get current date to initialize the DatePicker dialog
        final Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);

        //create a DatePickerDialog and return it
        DatePickerDialog datePicker =
                new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                  int dayOfMonth) {
                                listener.sendDate(dayOfMonth, monthOfYear, year);
                            }
                        },year,month,day);

        return datePicker;
    }

}
