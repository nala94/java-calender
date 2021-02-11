package honux.calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int year;
		int month = 1;
		String weekday;

		while (true) {
			System.out.println("연도를 입력하세요");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			System.out.println("달을 입력하세요");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			System.out.println("첫번째 요일을 입력하세요 ");
			System.out.print("WEEKDAY> ");
			weekday = scanner.next();
			cal.printCalendar(year, month, weekday);
		}

		System.out.println("Bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		//
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
