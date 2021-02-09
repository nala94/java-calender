package honux.calendar;

import java.util.Scanner;

public class Calendar {

	public void printSampleCalendar() {
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("-----------------------");
		System.out.println(" 1  2   3   4   5  6  7");
		System.out.println(" 8  9  10  11  12 13 14");
		System.out.println("15 16  17  18  19 20 21");
		System.out.println("22 23  24  25  26 27 28");
	}

	// final을 선언하면 변수의 값이 수정될 수 없다
	public static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public static void main(String[] args) {

		// 수를 입력받아 달의 최대일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();		
		
						
		//반복 횟수를 모르니 while?
		// -1을 입력받기 전까지 계속 반복?
		int i = 1;
		while(i > 0) {
			System.out.println("월을 입력하세요 \n>");
			int month = scanner.nextInt();
			if(month > 0 &&  month < 13 ) {
				System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
				i++;
			} else {
				System.out.println("Have a nice day!");
				i = i*0;
			}
		}			
		scanner.close();
	}

}
