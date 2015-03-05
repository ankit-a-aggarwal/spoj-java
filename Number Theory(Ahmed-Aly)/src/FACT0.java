import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class FACT0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
long n=Long.parseLong(br.readLine());
if(n==0)break;
int c=0;
while(n%2==0){
	n/=2;
	c++;
}
if(c>0)
sb.append(2+"^"+c+" ");
for(long i=3;i*i<=n;i+=2){
	 c=0;
	
	while(n%i==0){
		n/=i;
		c++;
	}
	if(c>0)
	sb.append(i+"^"+c+" ");
	
	
}
if(n>1){
	sb.append(n+"^"+1);
}
sb.append("\n");
}
System.out.println(sb);
}

}
