package com.maxovch.customcalendar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    // how many days to show, defaults to six weeks, 42 days
    private static final int DAYS_COUNT = 42;

    private Context context;

    private final int[] monthSeason = new int[] {2, 2, 3, 3, 3, 0, 0, 0, 1, 1, 1, 2};
    private final int[] rainbow = new int[] {
            R.color.summer,
            R.color.fall,
            R.color.winter,
            R.color.spring
    };

    private Calendar currentDate = Calendar.getInstance();

    private OnMonthClickListener clickListener;

    public CalendarAdapter(Context context, OnMonthClickListener clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int season = monthSeason[position];
        int color = rainbow[season];
        holder.header.setBackgroundColor(context.getResources().getColor(color));

        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar) currentDate.clone();
        calendar.set(Calendar.MONTH, position);

        // determine the cell for current month's beginning
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        if (monthBeginningCell < 0)
            monthBeginningCell = 6;

        // move calendar backwards to the beginning of the week
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        // fill cells
        while (cells.size() < DAYS_COUNT)
        {
            cells.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        // update grid
        holder.grid.setAdapter(new CalendarDayAdapter(context, cells, position, R.layout.calendar_day));
        holder.setOnClickListener(position, color, cells, clickListener);

        switch (position) {
            case 0:
                holder.month.setText("Jan");
                break;
            case 1:
                holder.month.setText("Feb");
                break;
            case 2:
                holder.month.setText("Mar");
                break;
            case 3:
                holder.month.setText("Apr");
                break;
            case 4:
                holder.month.setText("May");
                break;
            case 5:
                holder.month.setText("Jun");
                break;
            case 6:
                holder.month.setText("Jul");
                break;
            case 7:
                holder.month.setText("Aug");
                break;
            case 8:
                holder.month.setText("Sep");
                break;
            case 9:
                holder.month.setText("Oct");
                break;
            case 10:
                holder.month.setText("Nov");
                break;
            case 11:
                holder.month.setText("Dec");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout header;
        TextView month;
        GridView grid;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.calendar_header);
            month = itemView.findViewById(R.id.calendar_date_display);
            grid = itemView.findViewById(R.id.calendar_grid);
            this.view = itemView;
        }

        public void setOnClickListener(final int month, final int headerColor, final ArrayList<Date> days,
                                       final OnMonthClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(month, headerColor, days);
                }
            });
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    listener.onItemClick(month, headerColor, days);
                }
            });
        }
    }

}