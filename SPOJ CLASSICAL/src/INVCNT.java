import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;


class INVCNT {
static long count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	count=0;
	br.readLine();
	int N=Integer.parseInt(br.readLine());
	int a[]=new int[N];
	for(int i=0;i<N;i++){
		a[i]=Integer.parseInt(br.readLine());
	}
	count=merge_Sort(a, 0, a.length-1);
	//long count=0;
	//System.out.println(Arrays.toString(a));
	sb.append(count+"\n");
}
	System.out.println(sb);
	}
public static long merge_Sort(int a[],int left,int right){
	if(right>left){
		int mid=(left+(right-left)/2);
		count=merge_Sort(a, left, mid);
		count+=merge_Sort(a, mid+1, right);
		count+=merge(a,left,mid,right);
	}
	else return 0;
	//System.out.println(count);
	return count;
}
public static long merge(int a[],int left,int mid,int right){
	int helper[]=new int[a.length];
	for(int i=left;i<=right;i++)helper[i]=a[i];
	int i=left,k=left,j=mid+1;long count=0;
	while(i<=mid && j<=right){
		if(helper[i]<=helper[j]){
			a[k]=helper[i];i++;
		}
		else {
			a[k]=helper[j];j++;
			count+=mid-i+1;
		}
		k++;
	}
	while(i<=mid){
		a[k++]=helper[i++];
	}
	while(j<=right){
		a[k++]=helper[j++];
	}
	//System.out.println(left+" "+right+" "+count);
	return count;
}
}
