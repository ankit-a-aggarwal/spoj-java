import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class SAMER08D {
static int K;
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	 K=Integer.parseInt(br.readLine());
	 if(K==0)break;
	String r=br.readLine();
	String s=br.readLine();
	sb.append(solve(r, s)).append("\n");
}
	//System.out.println(sb);
	}
public static int solve(String r,String s){
	int dp[][]=new int[r.length()+1][s.length()+1];
	int longest_segment_length[][]=new int[r.length()+1][s.length()+1];
	for(int i=1;i<dp.length;i++){
		for(int j=1;j<dp[i].length;j++){
			dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			longest_segment_length[i][j]=r.charAt(i-1)==s.charAt(j-1)?longest_segment_length[i-1][j-1]+1:0;
			if(longest_segment_length[i][j]>=K){
				for(int z=K;z<=longest_segment_length[i][j];z++){
					dp[i][j]=Math.max(dp[i][j],dp[i-z][j-z]+z);
				}
			}
		}
	}
	for(int i=0;i<dp.length;i++)System.out.println(Arrays.toString(dp[i]));
	System.out.println();
	for(int i=0;i<dp.length;i++)System.out.println(Arrays.toString(longest_segment_length[i]));
	return dp[r.length()][s.length()];
}
}
