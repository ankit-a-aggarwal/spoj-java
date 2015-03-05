import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;
//import java.util.Vector;


class RPLB {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
int x=1;
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int N=Integer.parseInt(st.nextToken());
	int limit=Integer.parseInt(st.nextToken());
	int a[]=new int[N+1];
	st=new StringTokenizer(br.readLine());
	for(int i=1;i<=N;i++){
		a[i]=Integer.parseInt(st.nextToken());
	}
	//System.out.println(Arrays.toString(a));
	int ans[][]=new int[N+1][limit+1];
	//Vector<Integer> v=new Vector<Integer>();
	//boolean flag=false;
	for(int i=1;i<=1;i++){
		for(int j=1;j<ans[i].length;j++){
			if(a[i]>j)
				ans[i][j]=ans[i-1][j];
			else{
				ans[i][j]=Math.max(ans[i-1][j],ans[i-1][j-a[i]]+a[i]);
			}
		}
	}
	for(int i=2;i<ans.length;i++){
		
		for(int j=1;j<ans[i].length;j++){
	//		flag=false;
			if(a[i]>j){
				ans[i][j]=ans[i-1][j];
			}
			
			else if(ans[i-1][j]>(ans[i-2][j-a[i]]+a[i]))
					ans[i][j]=ans[i-1][j];
		
			
			else{
				/*(for(int k=v.size()-1;k<v.size() && k>0;k++){
					if(i==v.get(k)+1){
					ans[i][j]=ans[i-1][j];
						continue one;
					}
					ans[i][j]=ans[i-1][j-a[i]]+a[i];
					flag=true;
					//ans[i][j]=ans[i-1][j-a[i]]+a[i];
					//v.add(i);
				*/
				
					ans[i][j]=ans[i-2][j-a[i]]+a[i];
				// ans[i][j]=ans[i-1][j-a[i]]+a[i];
				}
			}
		//System.out.println(Arrays.toString(ans[i]));
		
	}
	sb.append("Scenario #"+ x++ +": "+ans[N][limit]).append("\n");
}
	System.out.println(sb);
	}

}
