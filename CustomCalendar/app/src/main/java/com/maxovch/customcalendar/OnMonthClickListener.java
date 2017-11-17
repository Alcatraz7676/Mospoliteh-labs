package com.maxovch.customcalendar;

import java.util.ArrayList;
import java.util.Date;

public interface OnMonthClickListener {
    void onItemClick(int month, int headerColor, ArrayList<Date> days);
}
