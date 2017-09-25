package com.univesre.time;

import java.util.Calendar;
import java.util.Date;

import java.sql.Time;


public class Timestamp {

    public static void main(String[] args) {

        //System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
        long unix_timestamp = 1505973629848L;
        String date = new Time(unix_timestamp).toString();
        System.out.println(date);

        int[] intArray = new int[]{0, 101};
        System.out.println(intArray[1]);
        //Calendar cal = Calendar.getInstance();
        //cal.getTimeInMillis()

//		将时间比较的任务转移到数据库中去了;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String dateString = (String) paraMap.get("start_time");
//		Date date = null;
//		if(!dateString.equals("")) {
//			try {
//				date = sdf.parse(dateString);
//				System.out.println("Service_1:" + date.getTime());
//				System.out.println("Service: " + paraMap.get("start_time"));
//				paraMap.put("start_time", date.getTime());
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}

    }

}
