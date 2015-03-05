import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


class BRIDGE {

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
while(t-->0){
	int N=Integer.parseInt(br.readLine());
	int a[][]=new int[N][2];
	//int b[]=new int[N];
	StringTokenizer st=new StringTokenizer(br.readLine());
	for(int i=0;i<a.length;i++){
		a[i][0]=Integer.parseInt(st.nextToken());
	}
	st=new StringTokenizer(br.readLine());
	for(int i=0;i<a.length;i++){
		a[i][1]=Integer.parseInt(st.nextToken());
	}
	Arrays.sort(a, new Comparator<int []>() {

		@Override
		public int compare(int o1[], int o2[]) {
			// TODO Auto-generated method stub
			return Integer.valueOf(o1[1]-o2[1]);
		}
	});
	for(int i=0;i<N;i++)System.out.println(Arrays.toString(a[i]));
	int lis1=LIS_NlogN(a);
	//int lis2=LIS(b);
	//int ans=Math.max(lis1-lis2, lis2);
	sb.append(lis1).append("\n");
}
	System.out.println(sb);
	}
public static int LIS(int a[][]){
	int LIS[]=new int[a.length];
	Arrays.fill(LIS,1);
	for(int i=0;i<LIS.length;i++){
		for(int j=0;j<i;j++){
			if(a[i][0]>=a[j][0] && LIS[i]<LIS[j]+1){
				LIS[i]=LIS[j]+1;
			}
		}
	}
	int max=Integer.MIN_VALUE;
	for(int i=0;i<LIS.length;i++){
		max=Math.max(LIS[i], max);
	}
	return max;
}
public static int LIS_NlogN(int a[][]){
	int LIS[]=new int[a.length];
	LIS[0]=a[0][0];
	int len=1;
	for(int i=1;i<a.length;i++){
		if(a[i][0]<LIS[0]){
			LIS[0]=a[i][0];
			//len++;
		}
		else if(a[i][0]>LIS[len-1]){
			LIS[len++]=a[i][0];
		}
		//else if(a[i][0]==LIS[0] || LIS[len-1]==a[i][0]){
			//len++;
		//}
		else{
			LIS[CielIndex(LIS, -1, len-1,a[i][0])]=a[i][0];
		}
	}
	return len;
}
public static int CielIndex(int a[],int l,int r,int key){
	int m;
	while(r-l>1){
		m=l+(r-l)/2;
		if(a[m]>=key)
			r=m;
		else l=m;
	}
	return r;
}
}
