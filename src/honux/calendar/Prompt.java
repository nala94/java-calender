package honux.calendar;

import java.util.Scanner;

public class Prompt {	
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int year = 2021;
		int month = 1;

		while (true) {
			System.out.println("연도를 입력하세요. (exit : -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if(year == -1) {
				break;
			}
			System.out.println("달을 입력하세요");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
						
			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			cal.printCalendar(year, month);
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
