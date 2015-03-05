import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class DOTAA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine().trim());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine().trim());
	int n=Integer.parseInt(st.nextToken());
	int m=Integer.parseInt(st.nextToken());
	int D=Integer.parseInt(st.nextToken());
	int count=0;
	for(int i=0;i<n;i++){
		int H=Integer.parseInt(br.readLine().trim());
		if(H>D){count+=H/D;if(H%D==0)count--;}
	}
	if(count>=m)sb.append("YES\n");
	else sb.append("NO\n");
}
	System.out.println(sb);
	}

}
