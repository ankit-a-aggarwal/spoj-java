import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
//import java.util.Map;




class TEMPLEQ {
static int a[];
static BitSet bs;
static int count=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long time=System.currentTimeMillis();
		Reader r=new Reader();
		//Reader r=new Reader("/media/ankit/Softwares/ECLIPSE/SPOJ/SPOJ CLASSICAL/src/InputTemple.txt");
int n=r.nextInt();
int q=r.nextInt();
StringBuilder sb=new StringBuilder();
PrintWriter prfile=new PrintWriter(System.out);
//PrintWriter prfile=new PrintWriter("/media/ankit/Softwares/ECLIPSE/SPOJ/SPOJ CLASSICAL/src/OutputTemple.txt");
 a=new int[n+1];
int b[]=new int[n+1];
//segtree=new int[4*n];
bs=new BitSet(n+1);
HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
for(int i=1;i<=n;i++){a[i]=r.nextInt();
b[i]=a[i];}
Arrays.sort(a,1,a.length);
for(int i=1;i<=n;i++){
int pos=binarySearch(a, b[i]);
hm.put(i, pos);
}

/*for(Map.Entry<Integer, Integer> entry:hm.entrySet()){
System.out.println(entry.getKey()+" "+entry.getValue());
}
*/


for(int i=0;i<q;i++){
	int choice=r.nextInt();
	int number=r.nextInt();
	if(choice==1){
		
		number=hm.get(number);
	int	bval=a[number];
		
		int j=binsearch_rightmost(a, bval, number, a.length-1);
		
		a[j]++;
		
		
	}
	else if(choice==2){
		int ans=binsearch_leftmost(a,number,1,n);
	
		if(a[ans]>=number)
		sb.append((n-ans+1)+"\n");
		else sb.append((n-ans)+"\n");
		
	}
	else
		{
		int ans=binsearch_leftmost(a,number,1,n);
		if(a[ans]>=number)
		for(int j=ans;j<a.length;++j)a[j]--;
		}
	
	//System.out.println(i);
}
	prfile.write(sb.toString());
	System.out.println((System.currentTimeMillis()-time)/1000.0);
	prfile.flush();
	prfile.close();
	}
	public static int binarySearch(int a[],int val){
		int low=0,high=a.length-1,mid=(low+((high-low+1)>>1));
		while(low<high){
			mid=(low+((high-low+1)>>1));
			if(a[mid]>=val)high=mid-1;
			else low=mid;
		}
		mid=(low+((high-low+1)>>1));
		if(a[mid]<val){
			int j;
			for( j=mid+1;a[j]!=val;j++);
			mid=j;
		}
		if(!bs.get(mid)){
			bs.set(mid);
			return mid;
		}
		else{
			int j;
			for( j=mid;j>0 && a[j]==val && !bs.get(j);j--);
			if(j!=mid)return j;
			else{
				j++;
				for(;j<a.length && a[j]==val;j++){
					if(!bs.get(j)){
						bs.set(j);
						break;
					}
				}
				return j;
			}
			
		}
	}
	public static int binsearch_rightmost(int a[],int val,int left,int right){
		if(left==right)return left;
		int mid=(left+right+1)>>1;
			if(a[mid]>val)return binsearch_rightmost(	a, val, left, mid-1);
			return binsearch_rightmost(a, val, mid, right);
	}
	public static int binsearch_leftmost(int a[],int val,int left,int right){
	    if(left==right) return left;
	   int mid = (left+right)>>1;
	    if(a[mid] < val)
	        return binsearch_leftmost(a,val,mid+1,right);
	    else
	        return binsearch_leftmost(a,val,left,mid);
	}

static class Reader {
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;
	
	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}
	
	public Reader(String file_name) throws IOException {
		din = new DataInputStream(new FileInputStream(file_name));
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}
	
	public String readLine() throws IOException {
		byte[] buf = new byte[64];
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}
	
	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	
	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	
	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (c == '.')
			while ((c = read()) >= '0' && c <= '9')
				ret += (c - '0') / (div *= 10);
		if (neg)
			return -ret;
		return ret;
	}
	
	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}
	
	private byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
	
	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}
}

}
/*
5 6
20 30 10 50 40
2 31
1 2
2 31
3 11
2 20
2 50
*/
/*
5 6
10 10 10 10 10
1 3
1 5
1 3
3 11
1 4
2 11
*/