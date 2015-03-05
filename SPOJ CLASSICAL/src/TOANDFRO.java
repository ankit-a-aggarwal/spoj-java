import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class TOANDFRO {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	int n=Integer.parseInt(br.readLine());
	if(n==0)break;
char  s[]=br.readLine().toCharArray();
	for(int i=n,k=2;i<s.length;i+=(k*n)){
		for(int j=i,x=j+(n-1);j<=x && x<s.length;j++,x--){
			char a=s[j];
			s[j]=s[x];
			s[x]=a;
		}
		
	}
	for(int j=n,k=0;k<n;k++)
	for(int i=k;i<s.length;i+=j)
		sb.append(s[i]);
	sb.append("\n");
	}
	System.out.println(sb);
	}
}
