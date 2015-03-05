import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class MC {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
String s=br.readLine();	
if(s.equals("#"))
	break;
String r=br.readLine();
int lcs[][]=new int[s.length()+1][r.length()+1];
for(int i=0;i<lcs.length;i++){
	lcs[i][0]=0;
}
for(int i=0;i<lcs[0].length;i++){
	lcs[0][i]=0;
}
for(int i=1;i<lcs.length;i++){
	for(int j=1;j<lcs[i].length;j++){
		if(s.charAt(i-1)==r.charAt(j-1)){
			lcs[i][j]=1+lcs[i-1][j-1];
		}
		else lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
	}
}
//sb.append(lcs[s.length()][r.length()]).append("\n");
int ans=15*(s.length()-lcs[s.length()][r.length()])+30*(r.length()-lcs[s.length()][r.length()]);
sb.append(ans).append("\n");
}
	System.out.println(sb);

	}

}
