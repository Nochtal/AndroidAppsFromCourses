package com.modnarecid.noch.datetimeapp;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Noch on 3/16/2016.
 */
public class TimeLord extends DialogFragment {
    // Fuck yeah! Making a Time Lord! XD
    ITimeDialog listener;
    // Override method for onAttach
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // This is to ensure the Activity (that is using this dialog)
            // implements the ITimeDialog interface
            listener = (ITimeDialog) activity;
        } catch (ClassCastException cce) {
            Toast.makeText(getActivity(),cce.getMessage(), Toast.LENGTH_LONG);
        }
    }
    // override method for onCreateDialog
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar now = Calendar.getInstance();
        final int hour = now.get(Calendar.HOUR);
        final int minute = now.get(Calendar.MINUTE);
        TimePickerDialog Who = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        listener.sendTime(hourOfDay, minute);
                    }
                }, hour, minute, true);
        return Who;
    }
}
