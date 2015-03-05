import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class PRIME1 {
static boolean primes[];
static boolean p[];
static int prime[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		sieve();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int m=Integer.parseInt(st.nextToken());
	int n=Integer.parseInt(st.nextToken());
	if(m==1)m++;
	if(n<p.length){
		for(int i=m;i<=n;i++)
			if(!p[i])
				sb.append(i+"\n");
		sb.append("\n");
		continue;
			}
	boolean b[]=primes(m, n);
	for(int i=0;i<b.length;i++){
		if(!b[i])
		sb.append(i+m+"\n");
	}
	sb.append("\n");
}
	System.out.println(sb);
	}
public static boolean[] primes(int m,int n){
	primes=new boolean[ (n-m+1)];
	
	for(int i=0;i<prime.length;i++){
		if(prime[i]*prime[i]>n)break;
		if(prime[i]<=0)continue;
		//System.out.println(prime[i]);
		int start=(m-m%prime[i]);
		while(start<m){
			start+=prime[i];
		}
		if(start==prime[i])start+=prime[i];
		 start=start-m;
		for(;start<primes.length;){
			primes[start]=true;
			start+=prime[i];
		}
	}
	return primes;
}
public static int[] sieve(){
	p=new boolean[(int) Math.sqrt(1000000000)];
	prime=new int[p.length];
	
	p[0]=p[1]=true;
	for(int i=4;i<p.length;i+=2)p[i]=true;
	for(int i=3;i*i<p.length;i+=2){
		if(!p[i]){
			int m=i;
			int mp=m*i;
			for(;mp<p.length;){
				p[mp]=true;
				m+=2;
				mp=m*i;
			}
		}
	}
	int i=2,j=0;
	for(;i<p.length;i++){
		if(!p[i])
		prime[j++]=i;
	}
	//for( i=0;i<100;i++)System.out.print(prime[i]+" ");
	return Arrays.copyOf(prime, j);
}
}
