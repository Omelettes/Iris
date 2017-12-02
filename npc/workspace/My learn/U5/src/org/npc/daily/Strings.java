package org.npc.daily1;

public class Strings {
	public static void main(String[]args) {
		char a[] = {'d','o','i','n','g'};
		char b[] = {'w','a','i','t'};
		char c[] = {'h','o','l','y'};
		char d[] = {'u','s'};
		char e[] = {'f','a','t','e'};
		char f[] = {'r','i','s','k'};
		String r = new String(a),             
		       s = new String(b,0,2),         
		       t = new String(b,3,1),         
		       u = new String(c,0,1);         
		String v = new String(e,1,1),         
		       w = new String(f,0,1),         
		       x = new String(e,3,1);         
		String y = new String(c,3,1),         
		       z = new String(a,1,1),         
		       z2= new String(d,0,1);         
		String z3= new String(c,2,1);         
		System.out.print(s+t);
		System.out.print(" ");
		System.out.print(t+u+x);
		System.out.print(" ");
		System.out.print(u+x+z3+z3);
		System.out.print(" ");
		System.out.print(v+w+x);
		System.out.print(" ");
		System.out.print(y+z+z2);
		System.out.print(" ");
		System.out.print(r);
	}
}
