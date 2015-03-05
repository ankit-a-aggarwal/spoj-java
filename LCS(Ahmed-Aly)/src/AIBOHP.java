import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;


class AIBOHP {
static int ans[][];
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sbu=new StringBuilder();
while(t-->0){
	//StringBuilder xx=new StringBuilder();
	//for(int i=0;i<6100;i++)xx.append("a");
	StringBuilder sb=new StringBuilder(br.readLine());
	//StringBuilder sb=new StringBuilder(xx);
	String rev=sb.reverse().toString();
	//System.out.println(sb+" "+rev);
	sbu.append(sb.length()-LCS(sb.reverse().toString(), rev)).append("\n");
}
	System.out.println(sbu);
	}
public static int LCS(String a,String b){
	ans=new int[a.length()+1][b.length()+1];
	for(int i=1;i<ans.length;i++){
		for(int j=1;j<ans[i].length;j++){
			if(a.charAt(i-1)==b.charAt(j-1)){
				ans[i][j]=ans[i-1][j-1]+1;
			}
			else ans[i][j]=Math.max(ans[i-1][j],ans[i][j-1]);
		}
	}
	//for(int i=0;i<ans.length;i++)System.out.println(Arrays.toString(ans[i]));
	return ans[a.length()][b.length()];
}
}
