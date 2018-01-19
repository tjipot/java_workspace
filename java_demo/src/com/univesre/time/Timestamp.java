package com.univesre.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.sql.Time;

import java.util.UUID;


public class Timestamp {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //System.out.println(new Date().getTime());

//        System.out.println(System.currentTimeMillis());
//        long unix_timestamp = 1505973629848L;
//        String date = new Time(unix_timestamp).toString();
//        System.out.println(date);

//        int[] intArray = new int[]{0, 101};
//        System.out.println(intArray[1]);
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


		// 生成UUID, @20171018;
//        for (int i = 0; i < 1; i++) {
//            System.out.println(UUID.randomUUID().toString());
//        }
//
//        System.out.println(System.currentTimeMillis());
//        System.out.println(System.currentTimeMillis());
//
//        java.sql.Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
//
//        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateTimeStr = sdf.format(ts);
//        System.out.println(dateTimeStr);
//        System.out.println(ts.toString());

		// 添加收尾单引号;
		String exclPtf = "fa894a20-23c1-4056-9306-55c64b0a9008";
	    exclPtf = "'"+exclPtf+"'";
		System.out.println(exclPtf);




    }

}
