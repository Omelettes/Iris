package org.npc.learnxx;
import java.util.Scanner ;
public class mrInput {
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Now!输入参战的滑稽数量：");
		int  watevr= input.nextInt();
		System.out.printf("目前竞技场里有%d只滑稽",watevr);
		byte i ;
		String arr[] = new String[watevr];
		for(i=1;i<=watevr;i++) {
			
			System.out.printf("\n请给第%d只滑稽命名：",i);
			arr[i-1] = input.next();
		}
		System.out.println("所有滑稽已准备就绪：");
		for(String x : arr) {
			System.out.print(x+"\t");
		}
		input.close();
	}
}
