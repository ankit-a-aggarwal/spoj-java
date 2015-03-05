import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.StringTokenizer;


class PIGBANK {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int empty=Integer.parseInt(st.nextToken());
	int full=Integer.parseInt(st.nextToken());
	int N=Integer.parseInt(br.readLine());
	int w[][]=new int[N+1][2];
//	int array[]=new int[full-empty+1];
	
	for(int i=1;i<=N;i++){
		st=new StringTokenizer(br.readLine());
		w[i][0]=Integer.parseInt(st.nextToken());
		w[i][1]=Integer.parseInt(st.nextToken());
	}
	/*Arrays.sort(w, new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1[1]-o2[1];
		}
	});
	*/
	//for(int i=0;i<=N;i++)System.out.println(Arrays.toString(w[i]));
	//long min=Integer.MAX_VALUE;
	long min_money[][]=new long[N+1][full-empty+1];
	//boolean keep[][]=new boolean[N+1][full-empty+1];
	for(int i=1;i<min_money.length;i++){
		for(int j=1;j<min_money[i].length;j++){
			if(i==1 && j<w[i][1]){
				min_money[i][j]=Integer.MAX_VALUE;
			}
			else if(i==1){
				min_money[i][j]=w[i][0]+min_money[i][j-w[i][1]];
			}
			else if(j<w[i][1]){
				min_money[i][j]=min_money[i-1][j];
			}
			else{
				min_money[i][j]=Math.min(min_money[i-1][j], w[i][0]+min_money[i][j-w[i][1]]);
			}
		}
	}
	
/*for(int i=1;i<=N;i++){
		for(int j=0;j<min_money[i].length;j++){
			System.out.print(min_money[i][j]+" ");
		}
		System.out.println();
	}
	*/
	
	if(min_money[N][full-empty]>=Integer.MAX_VALUE)
		sb.append("This is impossible.\n");
	else{
		sb.append("The minimum amount of money in the piggy-bank is "+min_money[N][full-empty]+".\n");
	}
}

	System.out.println(sb);}

}
/*
0 0 0 0 0 0 0 0 0 0 0
1 0 0 0 0 0 10 10 10 10 10 10
2 0 0 0 0 40 40 40 40 40 50 50
3 0 0 0 0 40 40 40 40 40 50 70
4 0 0 0 50 50 50 50 90 90 90 90
*/
/*
1
1 11
4
10 5
40 4
30 6
50 3
*/