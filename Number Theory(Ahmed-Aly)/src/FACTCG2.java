import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class FACTCG2 {
static boolean primes[];
static int primes_list[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
int count=sieve_primes();
while(true){
	String s=br.readLine();
	if(s==null || s.equalsIgnoreCase(""))break;
	int X=Integer.parseInt(s);
	sb.append("1");
	while(X>1){
		for(int i=0;i<count;i++){
			if(primes_list[i]==0)break;
			while(X%primes_list[i]==0){
				X/=primes_list[i];
				sb.append(" x "+primes_list[i]);
				}
			if(X==1)break;
		}
	}
	sb.append("\n");
}
	System.out.println(sb);
	}
public static int sieve_primes(){
	primes=new boolean[3163];
	primes_list=new int[3163];
	primes[0]=primes[1]=true;
	for(int i=4;i<primes.length;i+=2)primes[i]=true;
	
	for(int i=3;i*i<primes.length;i+=2){
		int m=i;
		int mp=m*i;
		for(;mp<primes.length;){
			primes[mp]=true;
			m+=2;
			mp=m*i;
		}
	}
	int count=0;
	for(int i=2;i<primes.length;i++){
		if(!primes[i]){
			primes_list[count++]=i;
		}
	}
	Arrays.copyOf(primes_list, count);
	return count;
}
}
