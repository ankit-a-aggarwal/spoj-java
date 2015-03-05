import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class PERMUTE1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int N=Integer.parseInt(st.nextToken());
	int K=Integer.parseInt(st.nextToken());
	int a[][]=new int[K+1][N+1];
	for(int i=1;i<a[0].length;i++){
		a[0][i]=1;
	}
	for(int i=1;i<a.length;i++){
		for(int j=1;j<a[i].length;j++){
			int m=i,l=0;
			while(m>=0 && l<j){
				a[i][j]+=a[m][j-1];
				m--;
				l++;
			}
		}
	}
	sb.append(a[K][N]+"\n");
}
	System.out.println(sb);
	}

}
