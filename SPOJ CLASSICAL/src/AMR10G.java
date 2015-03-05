import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class AMR10G {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine().trim());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine().trim());
	int N=Integer.parseInt(st.nextToken());
	int K=Integer.parseInt(st.nextToken());
	int a[]=new int[N];
	st=new StringTokenizer(br.readLine().trim());
	for(int i=0;i<N;i++){
		a[i]=Integer.parseInt(st.nextToken());
	}
	Arrays.sort(a);
	int diff=0,min_diff=Integer.MAX_VALUE;
	for(int i=0,j=i+(K-1);j<a.length;i++,j++){
		diff=a[j]-a[i];
		min_diff=Math.min(diff, min_diff);
	}
	sb.append(min_diff+"\n");
}
	System.out.println(sb);
	}

}
