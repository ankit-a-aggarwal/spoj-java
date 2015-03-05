import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


class FACEFRND {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(br.readLine());
int a[][]=new int[N][];
int count=0;
HashSet<Integer> hs=new HashSet<Integer>();
for(int i=0;i<N;i++){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int X=Integer.parseInt(st.nextToken());
	int M=Integer.parseInt(st.nextToken());
	a[i]=new int[M+1];
	a[i][0]=X;
	for(int j=1;j<=M;j++){
		a[i][j]=Integer.parseInt(st.nextToken());
		hs.add(a[i][j]);
	}
	Arrays.sort(a[i],1,a[i].length);
}

for(int i=0;i<N;i++){
	
	int X=a[i][0];
	if(hs.contains(X))count++;
}
//System.out.println(hs.size()+" "+count);
System.out.println(hs.size()-count);	}

}
/*
3

2334 5 1256 4323 7687 3244 5678

1256 2 2334 7687

4323 5 2334 5678 6547 9766 9543
*/