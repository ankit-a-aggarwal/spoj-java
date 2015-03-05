import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class DIVSUM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	int n=Integer.parseInt(br.readLine());
	if(n==1){sb.append(0+"\n");continue;}
	sb.append(sum_of_divisors(n)+1+"\n");
}
	System.out.println(sb);
	}
public static long sum_of_divisors(int n){
	long sum=0;
	int div=(int) Math.sqrt(n);
	for(int i=2;i<=div;i++){
		if(n%i==0){
			sum+=i;
			if(i*i!=n){
				sum+=(n/i);
			}
		}
	}
	return sum;
}
}
