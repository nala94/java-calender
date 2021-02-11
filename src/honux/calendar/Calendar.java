package honux.calendar;

public class Calendar {
	// final을 선언하면 변수의 값이 수정될 수 없다
	public static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

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
		
	public int firstDay(String weekday) {
		if(weekday.equals("SU")) return 0;	
		else if(weekday.equals("MO")) return 1;
		else if(weekday.equals("TU")) return 2;
		else if(weekday.equals("WE")) return 3;
		else if(weekday.equals("TH")) return 4;
		else if(weekday.equals("FR")) return 5;
		else if(weekday.equals("SA")) return 6;
		else return 0;
	}	
		
	public void printCalendar(int year, int month, String weekday) {
		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		int week = firstDay(weekday);
		for(int j=0; j<week; j++) {
			System.out.print("   ");			
		}
		
		int remain = (7-week);
		for(int f=1; f<=remain; f++) {
			System.out.printf("%3d", f);
		}
		System.out.println();

		int maxDay = getMaxDaysOfMonth(year, month);
		for (int i = remain+1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			// i룰 7로 나눈 나머지
			if (i % 7 == remain) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

}