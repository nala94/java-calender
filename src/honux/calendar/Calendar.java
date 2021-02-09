package honux.calendar;

public class Calendar {
	// final을 선언하면 변수의 값이 수정될 수 없다
	public static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printCalendar(int year, int month) {
		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TU FR SA");
		System.out.println("---------------------");
		
		int maxDay = getMaxDaysOfMonth(month);
		if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0 && month == 2) {
			maxDay = 29;
		} else if(year % 4 == 0 && year % 100 == 0 && month == 2){
			maxDay = 28;
		} else if(year % 4 == 0 &&  month == 2) {
			maxDay = 29;
		}
		for(int i=1; i<=maxDay; i++) {
			System.out.printf("%3d", i);
			// i룰 7로 나눈 나머지
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

}