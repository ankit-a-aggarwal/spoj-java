import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;


class APCP11B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int n=Integer.parseInt(st.nextToken());
	int a[]=new int[n];
	for(int i=0;i<n;i++){
		a[i]=Integer.parseInt(st.nextToken());
	}
	 st=new StringTokenizer(br.readLine());
	 n=Integer.parseInt(st.nextToken());
	int b[]=new int[n];
	for(int i=0;i<n;i++){
		b[i]=Integer.parseInt(st.nextToken());
	}
	int min_diff=Integer.MAX_VALUE;
	for(int i=0;i<a.length;i++){
		for(int j=0;j<b.length;j++){
			min_diff=Math.min(min_diff, Math.abs(a[i]-b[j]));
		}
	}
	sb.append(min_diff+"\n");
}
	System.out.println(sb);
	}

}
