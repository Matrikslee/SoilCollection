package cn.edu.ouc.eng.soilcollection;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class dataQueryActivity extends AppCompatActivity {
    private TextView txtBeginQueryDate;
    private TextView txtBeginQueryTime;
    private TextView txtEndQueryDate;
    private TextView txtEndQueryTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_query);
        setTitle(R.string.data_query);

        Date date = new Date();

        txtBeginQueryDate = (TextView) findViewById(R.id.txtBeginQueryDate);
        txtBeginQueryTime = (TextView) findViewById(R.id.txtBeginQueryTime);
        txtEndQueryDate = (TextView) findViewById(R.id.txtEndQueryDate);
        txtEndQueryTime = (TextView) findViewById(R.id.txtEndQueryTime);

        txtBeginQueryDate.setText(DateFormat.format("yyyy-M-d", date));
        txtBeginQueryTime.setText(DateFormat.format("H : m",date));
        txtEndQueryDate.setText(DateFormat.format("yyyy-M-d", date));
        txtEndQueryTime.setText(DateFormat.format("H : m",date));

        Toast.makeText(dataQueryActivity.this, "点击设置时间和日期",
                Toast.LENGTH_LONG).show();
    }

    public void setTxtBeginQueryDate(View v){
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
                        txtBeginQueryDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    public void setTxtBeginQueryTime(View v) {
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
                        txtBeginQueryTime.setText(hourOfDay + " : " + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }
    public void setTxtEndQueryDate(View v) {
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
                        txtEndQueryDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    public void setTxtEndQueryTime(View v) {
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
                        txtEndQueryTime.setText(hourOfDay + " : " + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }
}

