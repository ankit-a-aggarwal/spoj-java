import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class MMAXPER {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(br.readLine());
int a[][]=new int[N][2];
boolean chose[][]=new boolean[N][2];
int max=0;
for(int i=0;i<N;i++){
	StringTokenizer st=new StringTokenizer(br.readLine());
	a[i][0]=Integer.parseInt(st.nextToken());
	a[i][1]=Integer.parseInt(st.nextToken());
}
int j=-1,k=-1;
if(a[0][0]>a[0][1]){
	max+=a[0][0];
	chose[0][0]=true;
	j=0;k=1;
}
else{
	max+=a[0][1];
	chose[0][1]=true;
	j=k=0;
}

for(int i=1;i<N;i++){
	int choice1=Math.abs(a[i][0]-a[j][k]);
	int choice2=Math.abs(a[i][1]-a[j][k]);
	boolean flag=false;
	if(choice1>choice2){
		max+=choice1;
		j=i;k=1;
	}
	else{
		max+=choice2;
		j=i;k=0;
		flag=true;
	}
	max+=a[j][k];
	if(flag)
		k=1;
		else k=0; 
}
	System.out.println(max);
	}

}
