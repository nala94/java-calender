package honux.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {	
	Scanner scanner = new Scanner(System.in);
	Calendar cal = new Calendar();
	int year = 2021;
	int month = 1;
	
	public void runPrompt() throws ParseException {	
				
		printmenu();
		
		boolean isLoop = true;
		while (isLoop) {						
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print("> ");			
			String cmd = scanner.next();
			switch(cmd) {
			case "1":
				cmdRegister();
				break;
			case "2":
				cmdSearch();
				break;
			case "3":
				cmdCal();
				break;
			case "h":
				printmenu();
				break;
			case "q":
				isLoop = false;
				break;
				
			}
			
			System.out.println();			
		}
		
		System.out.println("Bye~");
		scanner.close();
	}
	
	
	// cmd = 1
	public void cmdRegister() throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		String text = "";
		System.out.println("일정을 입력해주세요.(문장의 끝에 ;을 입력해 주세요.)");	
		while(true) {
			String word = scanner.next();
			text += word + " ";
			if (word.endsWith(";")) {
				break;
			}
		}
		cal.registerPlan(date, text);
;
		}
	
	
	// cmd = 2
	public void cmdSearch() {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		String plan="";
		try {
			plan = cal.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);

	}
		
	public void cmdCal() {		
		System.out.println("연도를 입력하세요.");
		System.out.print("YEAR> ");
		year = scanner.nextInt();
		System.out.println("달을 입력하세요");
		System.out.print("MONTH> ");
		month = scanner.nextInt();
					
		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		} else {
			cal.printCalendar(year, month);			
		}
		
	}
	
	public void printmenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}
	
	public int parseDay(String week) {
		
		switch(week) {
		case "su" :
			return 0;
		case "mo" :
			return 1;
		case "tu" :
			return 2;
		case "we" :
			return 3;
		case "th" :
			return 4;
		case "fr" :
			return 5;
		case "sa" :
			return 6;
		default : 
			return 0;
		
		}
		
//		if(week.equals("su")) return 0;	
//		else if(week.equals("mo")) return 1;
//		else if(week.equals("tu")) return 2;
//		else if(week.equals("we")) return 3;
//		else if(week.equals("th")) return 4;
//		else if(week.equals("fr")) return 5;
//		else if(week.equals("sa")) return 6;
//		else return 0;
	}
	
	public static void main(String[] args) throws ParseException {
		//
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
