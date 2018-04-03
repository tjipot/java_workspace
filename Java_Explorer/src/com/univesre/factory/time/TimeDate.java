package factory.time;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @Project: java_demo
 * @PackageName: factory.time
 * @CreationDate: 2018-03-27 10:52
 * @Description: TODO
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class TimeDate {


	public static void main(String[] args) {

		/** 时间 */
		System.out.println(new Date().getTime());           // 1522116024098
		System.out.println(System.currentTimeMillis());     // 1522116024099
		// unixTimestampe -> HH:mm:ss
		long unixTimestamp = 1505973629848L;
		String timeStr = new Time(unixTimestamp).toString();   // 14:00:29
		System.out.println(timeStr);
		//
		//Calendar cal = Calendar.getInstance();
		//cal.getTimeInMillis()

		/** 时间格式 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 1.创建一种具体格式;
		String dateStr = "2018-03-27";                              // 2.给一个时间的字符串;
		Date dateFor = null;
		try {                                                       // 3.有ParseException, 要try/catch;
			dateFor = sdf.parse(dateStr);
			System.out.println("Service_1:" + dateFor.getTime());   // 1522080000000;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/** 1.时间戳 -> 2.sqlTimeStamp("2018-03-27 10:29:44.555") -> 3.SimpleDateFormat("yyyy-MM-dd HH:mm:ss") */
		DateFormat sdf02 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long tsLong = System.currentTimeMillis();                       // 时间戳;
		java.sql.Timestamp tsStamp = new java.sql.Timestamp(tsLong);    // Timestamp类型;
		String tsStr = sdf02.format(tsStamp);
		System.out.println("tsLong: "  + tsLong);                       // 1522117784555;
		System.out.println("tsStamp: " + tsStamp.toString());           // 2018-03-27 10:29:44.555;
		System.out.println("tsStr: "   + tsStr);                        // 2018-03-27 10:29:44;


		// new int[] 语法;
		int[] intArray = new int[]{0, 101};
		System.out.println(intArray[1]);

		// 生成UUID, @20171018;
		for (int i = 0; i < 1; i++) {
			System.out.println(UUID.randomUUID().toString());
		}

		/**
		 * Calendar和Date相互转换, @0324;
		 * Ref: https://zhidao.baidu.com/question/274721544.html;
		 */
		// (1) Calendar转化为Date
		Calendar cal0324A = Calendar.getInstance();
		Date date0324A = cal0324A.getTime();
		// (2) Date转化为Calendar
		Date date0324B = new Date();
		Calendar cal0324B = Calendar.getInstance();
		cal0324B.setTime(date0324B);

	}

}
