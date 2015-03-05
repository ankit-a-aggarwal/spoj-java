import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class ABCDEF {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(br.readLine());
long a[]=new long[N];
long b[]=new long[N*N*N];
long c[]=new long[N*N*N];
for(int i=0;i<N;i++){
	a[i]=Long.parseLong(br.readLine());
	}
//Arrays.sort(a);

//Arrays.sort(b);
long count=0;
for(int i=0,y=0,z=0;i<a.length;i++){
	for(int j=0;j<a.length;j++){
		for(int k=0;k<a.length;k++){
			b[y++]=a[i]*a[j]+a[k];
			if(a[i]==0)continue;
			c[z++]=a[i]*(a[j]+a[k]);
		}
	}
}
Arrays.sort(b);
Arrays.sort(c);
//System.out.println(Arrays.toString(b));
//System.out.println(Arrays.toString(c));
int k;
for(int i=0;i<b.length;i++){
	int index=Arrays.binarySearch(c, b[i]);
	if(index>=0){
		int d=1;
		for( k=i+1;k<a.length;k++){
			if(b[k]==b[i])d++;
			else break;
		}
		int count1=1;
		for(int j=index-1;j>=0;j--)
			if(c[j]==b[i])count1++;
			else break;
		for(int j=index+1;j<c.length;j++){
			if(c[j]==b[i])count1++;
			else break;
		}
		count+=(count1*d);
		i=k-1;
	}
}
System.out.println(count);
	}

}
