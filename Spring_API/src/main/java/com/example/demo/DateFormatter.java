package com.example.demo;

import java.util.Calendar;
import java.util.Date;

public class DateFormatter {

    public String dateString(Date d){                   // this method will return the java date in a yyyy-mm-dd string format
        Calendar cal = Calendar.getInstance();          //basically it formats in a date only nicer way..
        cal.setTime(d);
        String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
        return formatedDate;
    }
}
