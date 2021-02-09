package honux.calendar;

import java.util.Scanner;

public class Calendar {
	// final을 선언하면 변수의 값이 수정될 수 없다
	public static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printCalendar1() {
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("-----------------------");
		System.out.println(" 1  2   3   4   5  6  7");
		System.out.println(" 8  9  10  11  12 13 14");
		System.out.println("15 16  17  18  19 20 21");
		System.out.println("22 23  24  25  26 27 28");
		System.out.println("29 30  31");
	}
	
	public void printCalendar2() {
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("-----------------------");
		System.out.println(" 1  2   3   4   5  6  7");
		System.out.println(" 8  9  10  11  12 13 14");
		System.out.println("15 16  17  18  19 20 21");
		System.out.println("22 23  24  25  26 27 28");
		System.out.println("29 30");
	}
	
	public void printalendar3() {
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("-----------------------");
		System.out.println(" 1  2   3   4   5  6  7");
		System.out.println(" 8  9  10  11  12 13 14");
		System.out.println("15 16  17  18  19 20 21");
		System.out.println("22 23  24  25  26 27 28");
	}
	
	public static int[][] Month = {
			{1, 3, 5, 7, 8, 10, 12},
			{4, 6, 9, 11},
			{2}
	};
	
	

	public static void main(String[] args) {	
		

		// 수를 입력받아 달의 최대일수를 출력하는 프로그램

		String PROMPT = "cal> ";
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();			
		
		
		int month = 1;
		
		while(true) {
			System.out.println("월을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if(month == -1) {
				break;
			}
			if(month > 12) {
				continue;
			}
			
			for(int a=0; a<Month[0].length; a++) {
				if(month == Month[0][a]) {
					cal.printCalendar1();
				}
			}
			for(int a=0; a<Month[1].length; a++) {
				if(month == Month[1][a]) {
					cal.printCalendar2();
				}
			}
			for(int a=0; a<Month[2].length; a++) {
				if(month == Month[2][a]) {
					cal.printalendar3();
				}
			}
		
			
		}

		System.out.println("Bye~");
		scanner.close();
	}

}