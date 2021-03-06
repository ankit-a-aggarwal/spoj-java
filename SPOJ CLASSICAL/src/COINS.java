//import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
//import java.io.InputStreamReader;
//import java.util.Scanner;


class COINS {
static Hashtable<Long, Long> ht;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		ht=new Hashtable<Long, Long>();long N;
while(true){
	String s=br.readLine();
	if(s.equalsIgnoreCase("") || s==null)break;
	N=Long.parseLong(s);
	
	sb.append(maximize_dollars(N)+"\n");
	
	}
	System.out.println(sb);
	//sc.close();
	}
public static long maximize_dollars(long n){
	if(n<=11)return n;
	Long val=ht.get(n);
	if(val==null){
		val= Math.max(n,maximize_dollars(n/2)+maximize_dollars(n/3)+maximize_dollars(n/4));
		ht.put(n, val);
	}
	return val;
	// maximize_dollars(n/2)+maximize_dollars(n/3)+maximize_dollars(n/4)
}
}
