import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class ETF {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//int euler_phi[]=euler_phi_function(1000000);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	int n=Integer.parseInt(br.readLine());
	sb.append(phi(n)+"\n");
}
	System.out.println(sb);
	}
public static int[] euler_phi_function(int n){
	int euler_phi[]=new int[n+1];
	for(int i=1;i<=n;i++)euler_phi[i]=i;
	for(int i=1;i<=n;i++){
		for(int j=i+i;j<=n;j+=i){
			euler_phi[j]=euler_phi[j]-euler_phi[i];
		}
	}
	return euler_phi;
}
public static int phi(int n){
	int result=n;
	for(int i=2;i*i<=n;i++){
		if(n%i==0){
		result=result-result/i;
		while(n%i==0)n/=i;
		}
		}
	if(n>1){
		result=result-result/n;
	}
	return result;
}
}
