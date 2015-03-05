import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class ACPC10A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
StringTokenizer st=new StringTokenizer(br.readLine());
long a=Long.parseLong(st.nextToken());
long b=Long.parseLong(st.nextToken());
long c=Long.parseLong(st.nextToken());
if(a==b && a==c && a==0)break;
if(b==(a+c)*1.0/2){
	sb.append("AP "+(c+c-b)+"\n");
}
else sb.append("GP "+(c*(c/b))+"\n");
	}
System.out.println(sb);	}
}
