import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class NSTEPS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int x=Integer.parseInt(st.nextToken());
	int y=Integer.parseInt(st.nextToken());
	if(x==y && x==1)sb.append(1+"\n");
	else if(x==y && x==0)sb.append(0+"\n");
	else if(y!=x-2 && y!=x)sb.append("No Number"+ "\n");
	else if((x&1)==1)sb.append((x+y-1)+"\n");
	else sb.append(x+y+"\n");
	
}
	System.out.println(sb);
	}

}
