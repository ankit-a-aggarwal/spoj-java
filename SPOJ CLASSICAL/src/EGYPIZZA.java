import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;


class EGYPIZZA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(br.readLine().trim());
//double array[]=new double[N];
int count[]=new int[3];
for(int i=0;i<N;i++){
	String s=br.readLine();
	if(s.trim().equalsIgnoreCase("1/4"))count[0]++;
	else if(s.trim().equalsIgnoreCase("1/2"))count[1]++;
	else count[2]++;
}
//System.out.println(count[0]+" "+count[1]+" "+count[2]);

//Arrays.sort(array);
int count_ans=1;
count_ans+=count[2]+count[1]/2.0 +0.5;
int extra=count[2]+(count[1]%2)*2;
if(count[0]>=extra){
	count[0]-=extra;
	count_ans+=count[0]/4.0+0.75;
}
System.out.println(count_ans);
	}

}
/*
6 
3/4 
3/4 
1/4 
1/4 
1/2 
1/2*/
