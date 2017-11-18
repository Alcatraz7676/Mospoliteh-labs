package com.maxovch.customcalendar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class CalendarDayAdapter extends ArrayAdapter<Date> {

    private LayoutInflater inflater;
    private int month;
    private Context context;
    private int calendarDayLayoutResource;

    public CalendarDayAdapter(Context context, ArrayList<Date> days, int month,
                              int calendarDayLayoutResource) {
        super(context, calendarDayLayoutResource, days);
        inflater = LayoutInflater.from(context);
        this.month = month;
        this.context = context;
        this.calendarDayLayoutResource = calendarDayLayoutResource;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // day in question
        Date date = getItem(position);
        int day = date.getDate();
        final int month = date.getMonth();
        int year = date.getYear();

        // date for this month
        Date date2 = new Date();
        date2.setMonth(this.month);

        // today
        Date today = new Date();

        // inflate item if it does not exist yet
        if (view == null)
            view = inflater.inflate(calendarDayLayoutResource, parent, false);

        // clear styling
        ((TextView)view).setTypeface(null, Typeface.NORMAL);
        ((TextView)view).setTextColor(Color.BLACK);

        if (month != date2.getMonth() || year != date2.getYear()) {
            // if this day is outside current month, grey it out
            ((TextView)view).setTextColor(context.getResources().getColor(R.color.greyed_out));
        } else if (day == today.getDate() && month == today.getMonth()) {
            // if it is today, set it to blue/bold
            ((TextView)view).setTypeface(null, Typeface.BOLD);
            ((TextView)view).setTextColor(context.getResources().getColor(R.color.today));
        }

        // set text
        ((TextView)view).setText(String.valueOf(date.getDate()));

        return view;
    }
}
