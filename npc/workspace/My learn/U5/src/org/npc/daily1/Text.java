package org.npc.daily2;

public class Text {
	public static void main(String[]args) {
		String s = "Boy �� Next �� Door" ;
		char   b = '��' ;
		byte size= (byte)s.lastIndexOf("") ;
		byte po  = (byte)s.indexOf(b) ;
		System.out.println("���ַ����ַ���s�е�����λ���ǣ�"+size);
		System.out.println("��һ�����ַ����ַ���s������λ���ǣ�"+po);
	}
}
