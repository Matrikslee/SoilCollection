package cn.edu.ouc.eng.soilcollection;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class samplingSettingsActivity extends AppCompatActivity {
    private static boolean mode = false;

    private LinearLayout groupPointSample;
    private LinearLayout groupPerioSample;

    private TextView txtPointSampleDate;
    private TextView txtPointSampleTime;

    private TextView txtPerioSampleBeginDate;
    private TextView txtPerioSampleBeginTime;
    private TextView txtPerioSampleEndDate;
    private TextView txtPerioSampleEndTime;

    private Button btnModeSwitch;

    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampling_settings);
        setTitle(R.string.sampling_settings);

        btnModeSwitch = (Button) findViewById(R.id.btnModeSwitch);

        groupPointSample = (LinearLayout) findViewById(R.id.groupPointSample);
        groupPerioSample = (LinearLayout) findViewById(R.id.groupPerioSample);

        txtPointSampleDate = (TextView) findViewById(R.id.txtPointSampleDate);
        txtPointSampleTime = (TextView) findViewById(R.id.txtPointSampleTime);

        txtPerioSampleBeginDate = (TextView) findViewById(R.id.txtPerioSampleBeginDate);
        txtPerioSampleBeginTime = (TextView) findViewById(R.id.txtPerioSampleBeginTime);
        txtPerioSampleEndDate = (TextView) findViewById(R.id.txtPerioSampleEndDate);
        txtPerioSampleEndTime = (TextView) findViewById(R.id.txtPerioSampleEndTime);

        setMode();
    }

    private void setMode() {
        Date date = new Date();
        if (mode == false) {
            btnModeSwitch.setText(R.string.point_sampling);
            groupPointSample.setVisibility(View.VISIBLE);
            groupPerioSample.setVisibility(View.GONE);

            txtPointSampleDate.setText(DateFormat.format("yyyy-M-d", date));
            txtPointSampleTime.setText(DateFormat.format("H : m", date));
        } else {
            btnModeSwitch.setText(R.string.perio_sampling);
            groupPerioSample.setVisibility(View.VISIBLE);
            groupPointSample.setVisibility(View.GONE);
            txtPerioSampleBeginDate.setText(DateFormat.format("yyyy-M-d", date));
            txtPerioSampleBeginTime.setText(DateFormat.format("H : m", date));
            txtPerioSampleEndDate.setText(DateFormat.format("yyyy-M-d", date));
            txtPerioSampleEndTime.setText(DateFormat.format("H : m", date));
        }
    }

    public void modeSwitch(View v) {
        mode = !mode;
        setMode();
    }

    public void setTxtPointSampleDate(View v) {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        txtPointSampleDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void setTxtPointSampleTime(View v) {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        txtPointSampleTime.setText(hourOfDay + " : " + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void setTxtPerioSampleBeginDate(View v) {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        txtPerioSampleBeginDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void setTxtPerioSampleBeginTime(View v) {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        txtPointSampleTime.setText(hourOfDay + " : " + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void setTxtPerioSampleEndDate(View v) {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        txtPerioSampleBeginTime.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void setTxtPerioSampleEndTime(View v) {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        txtPerioSampleEndTime.setText(hourOfDay + " : " + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }
}
