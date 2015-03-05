import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;


class LIS2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(br.readLine());
int a[][]=new int[N][2];
for(int i=0;i<N;i++){
	StringTokenizer st=new StringTokenizer(br.readLine());
	a[i][0]=Integer.parseInt(st.nextToken());
	a[i][1]=Integer.parseInt(st.nextToken());
}
int ans[][]=new int[N][2];
//Arrays.fill(ans, 1);
ans[0][0]=a[0][0];ans[0][1]=a[0][1];
int len=1;
for(int i=1;i<ans.length;i++){
	if(a[i][0]<=ans[0][0] && a[i][1]<=ans[0][1]){
		ans[0][0]=a[i][0];ans[0][1]=a[i][1];
	}
	else if((a[i][0]>ans[len-1][0] && a[i][1]>ans[len-1][1]))
			//||(a[i][0]==ans[len-1][0] && a[i][1]>ans[len-1][1])
			//|| (a[i][0]>ans[len-1][0] && a[i][1]==ans[len-1][1]))
		{
		ans[len][0]=a[i][0];ans[len++][1]=a[i][1];
	}
	else{
		int pos=Ciel_Binary_Search(ans, -1, len-1, a[i][0],a[i][1]);
		//if(i==ans.length-1)
			System.out.println(i+" "+pos+" ");
			if((a[i][0]==ans[pos][0] && a[i][1]>ans[pos][1]) ||(a[i][0]>ans[pos][0] && a[i][1]==ans[pos][1]) )
				continue;
		{ans[pos][0]=a[i][0];ans[pos][1]=a[i][1];}
	}
}

System.out.println(len);
	}
public static int Ciel_Binary_Search(int a[][],int l,int r,int key1,int key2){
	int middle;
	while(r-l>1){
		middle=l+(r-l)/2;
		if(a[middle][0]>=key1 && a[middle][1]>=key2){
			r=middle;
		}
		else l=middle;
	}
	return r;
}
}
/*
8
1 3
3 2
1 1
4 5
6 3
9 9
8 7
7 6
*/
/*
4
1 1
2 4
4 2
5 3
*/