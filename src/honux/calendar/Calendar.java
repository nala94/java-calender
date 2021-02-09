package honux.calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("-----------------------");
		System.out.println(" 1  2   3   4   5  6  7");
		System.out.println(" 8  9  10  11  12 13 14");
		System.out.println("15 16  17  18  19 20 21");
		System.out.println("22 23  24  25  26 27 28");
		
		// 수를 입력받아 최대일수를 구하는 프로그램
		int a;
		Scanner scanner = new Scanner(System.in);	
		System.out.println("월을 입력하세요 : ");
		String s1 = scanner.next();
		a = Integer.parseInt(s1);
		
		// 1,3,5,7,8,10,12월은 31일
		// 2월은 28일
		// 4,6,9,11월은 30일
		int[] Day31 = new int[7];
		Day31[0] = 1;
		Day31[1] = 3;
		Day31[2] = 5;
		Day31[3] = 7;
		Day31[4] = 8;
		Day31[5] = 10;
		Day31[6] = 12;
		
		int[] Day30 = new int[4];
		Day30[0] = 4;
		Day30[1] = 6;
		Day30[2] = 9;
		Day30[3] = 11;
		
		int[] Day28 = new int[1];
		Day28[0] = 2;
		
		for(int i=0; i<Day31.length; i++) {
			if(Day31[i] == a) {
				System.out.printf("%d월은 31일까지 있습니다",a);
				break;			
			}
		}
		
		for(int i=0; i<Day30.length; i++) {
			if(Day30[i] == a) {
				System.out.printf("%d월은 30일까지 있습니다",a);
				break;			
			}
		}
		
		for(int i=0; i<Day28.length; i++) {
			if(Day28[i] == a) {
				System.out.printf("%d월은 28일까지 있습니다",a);
				break;			
			}
		}
		scanner.close();	

	}

}
