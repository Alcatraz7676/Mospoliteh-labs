package com.maxovch.customcalendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class FullCalendarActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_calendar);

        TextView monthTextView = findViewById(R.id.calendar_date_display);
        LinearLayout header = findViewById(R.id.calendar_header);
        GridView gridView = findViewById(R.id.calendar_grid);

        int month = getIntent().getIntExtra("MONTH_NAME", 0);
        int headerColor = getIntent().getIntExtra("HEADER_COLOR", 0);
        ArrayList<Date> days =
                (ArrayList<Date>)getIntent().getSerializableExtra("DAYS_GRID");

        switch (month) {
            case 0:
                monthTextView.setText("January");
                break;
            case 1:
                monthTextView.setText("February");
                break;
            case 2:
                monthTextView.setText("March");
                break;
            case 3:
                monthTextView.setText("April");
                break;
            case 4:
                monthTextView.setText("May");
                break;
            case 5:
                monthTextView.setText("June");
                break;
            case 6:
                monthTextView.setText("July");
                break;
            case 7:
                monthTextView.setText("August");
                break;
            case 8:
                monthTextView.setText("September");
                break;
            case 9:
                monthTextView.setText("October");
                break;
            case 10:
                monthTextView.setText("November");
                break;
            case 11:
                monthTextView.setText("December");
                break;
        }
        header.setBackgroundColor(getResources().getColor(headerColor));
        gridView.setAdapter(new CalendarDayAdapter(this, days, month, R.layout.full_calendar_day));
    }

}
