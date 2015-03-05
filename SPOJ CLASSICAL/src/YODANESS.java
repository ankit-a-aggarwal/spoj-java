import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.Arrays;
import java.util.HashMap;
//import java.util.Map;


class YODANESS {
static int tree[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	Reader r=new Reader();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
while(t-->0){
	int n=Integer.parseInt(br.readLine());
	tree=new int[n+1];
//	int a[]=new int[n+1];
	//for(int i=1;i<=n;i++)a[i]=i;
	int b[]=new int[n+1];
	String sorted=br.readLine();
	String jumbled=br.readLine();
	String h[]=sorted.split(" ");
	String l[]=jumbled.split(" ");
	HashMap<String, Integer> hm=new HashMap<String, Integer>();
	for(int i=0;i<n;i++)hm.put(h[i], i);
	for(int i=1;i<=n;i++){
		b[i]=hm.get(l[i-1])+1;
	}
	//System.out.println(Arrays.toString(b));
/*	long count=0;
	for(int i=n;i>0;i--){
		count+=read(b[i]);
		update(b[i],1);
	}
	sb.append(count+"\n");
	*/
	sb.append(mergeSort(b, 0, b.length-1)+"\n");
	//System.out.println(Arrays.toString(b));
}
	pr.write(sb.toString());
	pr.flush();
	}
	public static long read(int idx){
		long sum=0;
		while(idx>0){
			sum+=tree[idx];
			idx -= idx& -idx;
		}
		return sum;
	}
	public static void update(int idx,int value){
		while(idx<tree.length){
			tree[idx]+=value;
			idx += idx & -idx;
		}
	}
	public static int mergeSort(int a[],int low,int high){
		int c=0,d=0,e=0;
		if(low<high){
			int mid=(low+high)>>1;
		 c=mergeSort(a, low, mid);
		 d=mergeSort(a, mid+1, high);
		 e=merge(a, low, mid, high);
		}
		else return 0;
		return c+d+e;
	}
	public static int merge(int a[],int low,int mid,int high){
		//System.out.println(low+" "+mid+" "+high+" "+Arrays.toString(a));
		int b[]=new int[mid-low+1];
		int c[]=new int[high-mid];
		int i=low,j=0;
				int k=low;
		for(;j<b.length && i<a.length;j++,i++)b[j]=a[i];
		for(j=0;j<c.length && i<a.length;j++,i++)c[j]=a[i];
		
		int count=0;
		for(i=0,j=0;i<b.length && j<c.length && k<a.length;){
			if(b[i]>c[j]){
				count+=(b.length-(i));
				a[k]=c[j++];
			}
			else{
				a[k]=b[i++];
			}
			
			k++;
		}
		for(;i<b.length && k<a.length;i++){
			a[k++]=b[i];
			}
		for(;j<c.length && k<a.length;j++)a[k++]=c[j];
		return count;
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
