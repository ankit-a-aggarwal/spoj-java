import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Arrays;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


class LINES {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
int N=Integer.parseInt(br.readLine());
if(N==0)break;
int co[][]=new int[N][2];
for(int i=0;i<N;i++){
	StringTokenizer st=new StringTokenizer(br.readLine());
	co[i][0]=Integer.parseInt(st.nextToken());
	co[i][1]=Integer.parseInt(st.nextToken());
}

//int k=0;
HashSet<Long> hs=new HashSet<Long>();
for(int i=0;i<N;i++){
	for(int j=i+1;j<N;j++){
		int diff=co[j][0]-co[i][0];
		if(diff==0){
			hs.add((long) (5000.0*1000000000));
			continue;
		}
		double ax=(co[j][1]-co[i][1])*1.0/(diff);
		//System.out.println(ax);
		hs.add((long)(ax*1000000000));
	}
}
sb.append(hs.size()+"\n");
	}
	System.out.println(sb);
	}
	
}
