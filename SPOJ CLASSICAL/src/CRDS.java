import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class CRDS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	long N=Long.parseLong(br.readLine());
	N=((3*(N+1)*N/2)-N)%1000007;
	sb.append(N+"\n");
}
	System.out.println(sb);}

}
