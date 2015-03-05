import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Iterator;
import java.util.Map;
//import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


class ANARC05B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int n=Integer.parseInt(st.nextToken());
	if(n==0)break;
	long a[]=new long[n];
	long sum_a=0;
	TreeMap<Long, Integer> hm=new TreeMap<Long, Integer>();
	for(int i=0;i<n;i++){
		a[i]=Long.parseLong(st.nextToken());
		sum_a+=a[i];
		Integer value=hm.get(a[i]);
		hm.put(a[i], value==null?1:value+1);
	}
	st=new StringTokenizer(br.readLine());
	n=Integer.parseInt(st.nextToken());
	long b[]=new long[n];
	long sum_b=0;
	boolean flag=false;
	for(int i=0;i<n;i++){
		b[i]=Long.parseLong(st.nextToken());
		sum_b+=b[i];
		Integer value=hm.get(b[i]);
		hm.put(b[i], value==null?1:value+1);
		if(value!=null && value==1)flag=true;
	}
	ArrayList<Long> al=new ArrayList<Long>();
	for(Map.Entry<Long, Integer> entry:hm.entrySet()){
		if(entry.getValue()>1){
			flag=true;
			al.add(entry.getKey());
		}
	}
	if(!flag){
		sb.append(Math.max(sum_a, sum_b)+"\n");
		continue;
	}
	//Iterator<Long> iter=hs.iterator();
	long max_sum=0;
	int prev_index1=0;
	int prev_index2=0;
	int j=0;
	while(j<al.size()){
		long val=al.get(j);
		//System.out.println(val);
		int index1=Arrays.binarySearch(a,prev_index1,a.length, val);
		int index2=Arrays.binarySearch(b,prev_index2,b.length, val);
		long max_1=0;
		long max_2=0;
				for(int i=prev_index1;i<=index1;i++)max_1+=a[i];
				for(int i=prev_index2;i<=index2;i++)max_2+=b[i];
				max_sum+=Math.max(max_2, max_1);
		prev_index1=index1+1;
		prev_index2=index2+1;
		j++;
	}
	long max_1=0;long max_2=0;
	for(int i=prev_index1;i<a.length;i++)max_1+=a[i];
	for(int i=prev_index2;i<b.length;i++)max_2+=b[i];
	max_sum+=Math.max(max_1, max_2);
	sb.append(max_sum+"\n");
}
	System.out.println(sb);
	}

}
/*
13 3 5 7 9 20 25 30 40 55 56 57 60 62
11 1 4 7 11 14 25 44 47 55 57 100
4 -5 100 1000 1005
3 -12 1000 1001
0
*/