package honux.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
	// final을 선언하면 변수의 값이 수정될 수 없다
	public static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private HashMap <Date, String> planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, String>();
	}
	
	/**
	 * 
	 * @param date
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan) throws ParseException {
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
//		System.out.println(date);
		planMap.put(date, plan);
	}
	
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}

	/*
	 * String startDateString = "06/27/2007"; DateFormat df = new
	 * SimpleDateFormat("MM/dd/yyyy"); Date startDate; try { startDate =
	 * df.parse(startDateString); String newDateString = df.format(startDate);
	 * System.out.println(newDateString); } catch (ParseException e) {
	 * e.printStackTrace(); }
	 */
	
	public boolean IsLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (IsLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}	
		
	public void printCalendar(int year, int month) {
		System.out.printf("     <<%d년 %3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		// get weekday automatically
		int weekday = getweekDay(year, month, 1);
		
		
		//print blank space
		for(int j=0; j<weekday; j++) {
			System.out.print("   ");			
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = (7-weekday);
		int delim = (count < 7) ? count : 0;
		/*
		int delim;
		if(count < 7) {
			delim = count;
		} else {
			delim = 0;
		}*/
		
		// print first line
		for(int f=1; f<=count; f++) {
			System.out.printf("%3d", f);
		}
		System.out.println();
		
		//print 2nd line to last line
		
		for (int i = count+1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			// i룰 7로 나눈 나머지
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

	private int getweekDay(int year, int month, int day) {
		// 기준날짜 요일 , 1970년 1월 1일 목요일
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970/jan/1st = thursday
		
		int count = 0;
		
		for (int i = syear; i<year; i++) {
			int delta = IsLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		for (int i=1; i<month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;			
		}
		count += day -1;
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
	
	//simple test code
	public static void main(String[] args) throws ParseException {
		Calendar cal = new Calendar();
//		System.out.println(cal.getweekDay(1970, 1, 1) == 3);
//		System.out.println(cal.getweekDay(1971, 1, 1) == 4);
		cal.registerPlan("2021-03-07", "Let's go theater!");
		cal.registerPlan("2017-06-23", "Let's eat beef!");
		System.out.println(cal.searchPlan("2017-06-23").equals("Let's eat beef!"));
		System.out.println(cal.searchPlan("2021-03-07").equals("Let's go theater!"));
	}

}