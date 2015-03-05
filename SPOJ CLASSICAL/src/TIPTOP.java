import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class TIPTOP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
int c=1;
while(t-->0){
	sb.append("Case "+c+": ");
	long N=Long.parseLong(br.readLine() );
	long sqrt=(long) Math.sqrt(N);
	if(sqrt*sqrt==N)
	sb.append("Yes\n");
	else sb.append("No\n");
	c++;
}
	System.out.println(sb);
	}

}
