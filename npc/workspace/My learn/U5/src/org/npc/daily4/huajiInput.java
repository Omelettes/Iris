package org.npc.learnxx;
import java.util.Scanner ;
public class mrInput {
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Now!�����ս�Ļ���������");
		int  watevr= input.nextInt();
		System.out.printf("Ŀǰ����������%dֻ����",watevr);
		byte i ;
		String arr[] = new String[watevr];
		for(i=1;i<=watevr;i++) {
			
			System.out.printf("\n�����%dֻ����������",i);
			arr[i-1] = input.next();
		}
		System.out.println("���л�����׼��������");
		for(String x : arr) {
			System.out.print(x+"\t");
		}
		input.close();
	}
}
