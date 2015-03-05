import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class TWOSQRS {
static boolean b[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		long time=System.currentTimeMillis();
		b=new boolean[1000001];
		b[0]=b[1]=true;
		b[2]=false;
		ArrayList<Integer> al=new ArrayList<Integer>();al.add(2);
		for(int i=4;i<b.length;i+=2)b[i]=true;
		for(int p=3;p*p<b.length;p+=2){
			if(!b[p]){
				
				int m=p;
				int mp=m*p;
				for(;mp<b.length && mp>=0;){
					b[mp]=true;
					m+=2;
					mp=m*p;
				}
			}
		}
		for(int i=3;i<b.length;i++)if(!b[i])al.add(i);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
//int t=100;
//StringBuilder tcase=new StringBuilder();
//long L=1234567809L;

StringBuilder sb=new StringBuilder();
one:while(t-->0){
	long n=Long.parseLong(br.readLine());
	//long n=L--;
	int count=0;
	for(int i=0;i<al.size();i++){
		int get=al.get(i);
		while(n%get==0){
			n/=get;
			count++;
		}
		//System.out.println(n);
	
		if((get-3)%4==0 && (count&1)!=0){
			sb.append("No\n");
			continue one;
		}
		count=0;
		if(n==1)break;
	}
	if(n>1){
		boolean isP=isPrime(n);
	if(isP && (n-1)%4==0){
		sb.append("Yes\n");
	continue;}
	else if(isP && (n-3)%4==0){
		sb.append("No\n");continue;
	}
	}
	sb.append("Yes\n");
}
	System.out.println(sb);
	System.out.println((System.currentTimeMillis()-time)/1000.0);
	}
public static boolean isPrime(long n){
	if(n<2)return false;
	else if(n==2)return true;
	if(n%2==0)return false;
	
	for(int i=3;i*i<=n;i+=2)
		if(n%i==0)return false;
	return true;
}
}
