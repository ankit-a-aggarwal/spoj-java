import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class GLJIVE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int a[]=new int[10];
for(int i=0;i<10;i++){
	a[i]=Integer.parseInt(br.readLine().trim());
}
int ans=0;int i=0;
for(;i<a.length;i++){
	ans+=a[i];
	if(ans==100){System.out.println(100);System.exit(0);}
	else if(ans>100)break;
	//System.out.println(ans);
}
if(i>=a.length)i--;
int ix=ans-100;
int j=100-(ans-a[i]);
//System.out.println(ans+" "+ix+" "+j+" "+a[i]);
if(j<ix)System.out.println(ans-a[i]);
else {
	System.out.println(ans);
}
}

}
