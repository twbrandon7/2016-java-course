package frame.libs;

import java.io.Console;
import java.util.Scanner;

public class Myfun{

	public static class ABVar{
			public int a;
			public int b;
	}

	public static String inverse(String s){
		int k=s.length(); int i; String z="";
		for(i=0; i<=k-1; i=i+1) { z=s.substring(i,i+1)+z; }
		return( z );
	}
	
	@SuppressWarnings("resource")
	public static String ideKeyin(String msg){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print(msg);
		String s = scanner.nextLine();
		
		return s;
	}
	
	public static String keyin(String msg){
		Console in = System.console();
		String s = in.readLine(msg);
		
		return s;
	}
	
	public static int random(int n){
		return (int) (Math.random() * n);
	}
	
	public static int random(int min, int max){
		int k = 0;
		if(min > max){
			k = max;
			max = min;
			min = k;
		}
		return (min + Myfun.random(max - min + 1));
	}
	
	public static void randNumbers(int[] a, int min, int max, int cnt){
		int k = 0;
		a[0] = Myfun.random(min, max);
		for(int i = 1; i < cnt ; i++){
			do{
				k = 0;
				a[i] = Myfun.random(min, max);
				for(int j = 0; j < i; j++){
					if(a[i] == a[j]){
						k = 1;
						break;
					}
				}
			}while(k == 1);
		}
	}
	
	public static boolean checkSame(String s){
		boolean flag = false;
		int length = s.length();
		for(int i = 0; i < length - 1; i++){
			String z = s.substring(i, i + 1);
			String p = s.substring(i+1, length);
			if(p.indexOf(z) >= 0){
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	public static String answer1(){
		int ans = 0;
		int[] m = new int[4];
		
		do{
			Myfun.randNumbers(m, 0, 9, 4);
		}while(m[0] == 0);
		
		ans = m[0] * 1000 + m[1] * 100 + m[2] * 10 + m[3];
	
		return String.valueOf(ans);
	}
	
	public static String answer2(){
		String ans, z, p;
		int k = 0;
		
		do{
			ans = String.valueOf(Myfun.random(1000, 9999));
			k = 0;
			for(int i = 0; i < 3; i++){
				z = ans.substring(i, i + 1);
				p = ans.substring(i+1, 4);
				if(p.indexOf(z) >= 0){
					k = 1;
					break;
				}
			}
		}while(k == 1);
		
		return ans;
	}
	
	public static int countAB(String ans, String gus){
		int a = 0;
		int b = 0;
		if(gus.length() == 4){
			for(int i = 0; i < 4; i++){
				String z = gus.substring(i, i+1);
				int k = ans.indexOf(z);
				if(k >= 0){
					if(k == i){
						a = a + 1;
					}else{
						b = b + 1;
					}
				}
			}
		}
		return a * 10 + b;
	}
	
	public static ABVar countAB2(String ans, String gus){
		ABVar abVar = new ABVar();
		if(gus.length() == 4){
			for(int i = 0; i < 4; i++){
				String z = gus.substring(i, i+1);
				int k = ans.indexOf(z);
				if(k >= 0){
					if(k == i){
						abVar.a = abVar.a + 1;
					}else{
						abVar.b = abVar.b + 1;
					}
				}
			}
		}
		return abVar;
	}
}