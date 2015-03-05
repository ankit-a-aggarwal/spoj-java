import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class GIRLSNBS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int A=Integer.parseInt(st.nextToken());
	int B=Integer.parseInt(st.nextToken());
	if(A==-1 && B==-1)break;
	else if(A==0 && B==0){
		sb.append("0\n");continue;
	}
	else if(A==B){
		sb.append("1\n");continue;
	}
	else if(A==0){
		sb.append(B+"\n");continue;
	}
	else if(B==0){
		sb.append(A+"\n");continue;
	}
	int min=Math.min(A, B);
	int max=Math.max(A, B);
	A=max;
	B=min;
	int ans=(int) (Math.ceil((A-(B+1))*1.0/(B+1))+1);
	sb.append(ans+"\n");
	
}
	System.out.println(sb);
	}

}
