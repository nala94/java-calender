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

		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
										// 입력받은 반복횟수 n만큼 월을 입력
		System.out.println("반복횟수를 입력하세요.");
		int n = scanner.nextInt();

										// 입력받은 월만큼의 개수의 배열을 만듬
		int[] numbers = new int[n];

										// 입력받은 정수(월)들을 numbers 배열에 저장
		System.out.println("월을 입력하세요.");
		for (int j = 0; j < n; j++) {
			numbers[j] = scanner.nextInt();
		}
			
										// 반복문을 통해 각 달의 최대일수를 출력
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%d월은 %d일까지 있습니다.\n", numbers[i], cal.getMaxDaysOfMonth(numbers[i]));

		}
		scanner.close();

	}

}
