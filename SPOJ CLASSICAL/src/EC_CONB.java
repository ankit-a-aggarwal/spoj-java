import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class EC_CONB {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(N-->0){
	int a=Integer.parseInt(br.readLine());
	if((a&1)==1)sb.append(a+"\n");
	else {
		char x[]=Integer.toBinaryString(a).toCharArray();
		//System.out.println(Integer.toBinaryString(a));
		for(int i=0;i<x.length;i++){
			if(x[i]=='1')x[i]='0';
			else x[i]='1';
		}
		a=0;
		//System.out.println(Arrays.toString(x));
		for(int i=x.length-1,j=0;i>=0;j++,i--){
			//System.out.println(x[i]);
			if(x[i]=='1')
			a+=Math.pow(2, j);
		}
		sb.append(a+"\n");
	}
	
}
	System.out.println(sb);
	}

}
