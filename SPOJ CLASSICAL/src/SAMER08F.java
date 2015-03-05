import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class SAMER08F {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	int n=Integer.parseInt(br.readLine());
	if(n==0)break;
	long ans=(long)n*((2*n)+1)*(n+1)/6;
	sb.append(ans+"\n");
}
	System.out.println(sb);
	}

}
