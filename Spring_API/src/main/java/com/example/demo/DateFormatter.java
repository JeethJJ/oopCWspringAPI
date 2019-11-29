package com.example.demo;

import java.util.Calendar;
import java.util.Date;

public class DateFormatter {

    public String dateString(Date d){
//            String dateStr = cb.getEday().toString();
//            DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
//            Date date =cb.getEday();
//            System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
        return formatedDate;
    }
}
