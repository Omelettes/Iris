package org.npc.daily2;

public class Text {
	public static void main(String[]args) {
		String s = "Boy ♂ Next ♂ Door" ;
		char   b = '♂' ;
		byte size= (byte)s.lastIndexOf("") ;
		byte po  = (byte)s.indexOf(b) ;
		System.out.println("空字符在字符串s中的索引位置是："+size);
		System.out.println("第一个♂字符在字符串s中索引位置是："+po);
	}
}
