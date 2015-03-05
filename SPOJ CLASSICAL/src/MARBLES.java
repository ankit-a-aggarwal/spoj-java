import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class MARBLES {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine() );
	int N=Integer.parseInt(st.nextToken());
	int K=Integer.parseInt(st.nextToken());
	long ans=1;
	long ans2=ans;
	N-=K;
	for(int i=1;i<=K;i++){
		ans=ans*(N+1-i)/i;
		ans2+=ans;
		
		//System.out.println(ans);
	}
	sb.append(ans2+"\n");
}
	System.out.println(sb);
	}

}
