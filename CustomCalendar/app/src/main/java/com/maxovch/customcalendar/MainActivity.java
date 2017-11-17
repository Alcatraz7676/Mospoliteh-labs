package com.maxovch.customcalendar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity implements OnMonthClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarAdapter adapter = new CalendarAdapter(this, this);

        Calendar currentDate = Calendar.getInstance();
        TextView year = findViewById(R.id.year);
        year.setText(String.valueOf(currentDate.get(Calendar.YEAR)));
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        CustomGridLayoutManager layoutManager = new CustomGridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int month, int headerColor, ArrayList<Date> days) {
        Intent intent = new Intent(this, FullCalendarActivity.class);
        intent.putExtra("MONTH_NAME", month);
        intent.putExtra("HEADER_COLOR", headerColor);
        intent.putExtra("DAYS_GRID", days);
        startActivity(intent);
    }
}
