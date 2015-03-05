import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class EDIST {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	String r=br.readLine();
	String s=br.readLine();
	int ans[][]=new int[r.length()+1][s.length()+1];
	for(int i=0;i<ans.length;i++){
		ans[i][0]=i;
	}
	for(int i=0;i<ans[0].length;i++){
		ans[0][i]=i;
	}
	for(int i=1;i<ans.length;i++){
		for(int j=1;j<ans[i].length;j++){
			int a=ans[i-1][j]+1;
			int b=ans[i][j-1]+1;
			int d=r.charAt(i-1)==s.charAt(j-1)?0:1;
			int c=ans[i-1][j-1]+d;
			ans[i][j]=Math.min(a, Math.min(b, c));
		}
	}
	
	sb.append(ans[ans.length-1][ans[0].length-1]).append("\n");
}

	System.out.println(sb);
	}

}
