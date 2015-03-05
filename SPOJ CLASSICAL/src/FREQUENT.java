import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


class FREQUENT {
static int a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
while(true){
int n=r.nextInt();
if(n==0)break;
int q=r.nextInt();
 a=new int[n+1];
for(int i=1;i<=n;i++)a[i]=r.nextInt();
Segment_Tree st=new Segment_Tree(1,n);
//Segment_Tree.printPostOrder(st);
for(int i=0;i<q;i++){
	int s=r.nextInt();
	int e=r.nextInt();
	int ans=st.query(s, e).freq;
	sb.append(ans+"\n");
}
}
	pr.write(sb.toString());
	pr.flush();
	}
	static class Segment_Tree{
		int start,end;
		int leftmost,freq1,rightmost,freq2,best,freq;
		Segment_Tree left_child,right_child;
		public Segment_Tree(){}
		public Segment_Tree(int freq){this.freq=freq;}
		public Segment_Tree(int a,int b){
			start=a;end=b;
			if(start!=end){
				int mid=(start+end)>>1;
				left_child=new Segment_Tree(a,mid);
				right_child=new Segment_Tree(mid+1, b);
				join(this, left_child, right_child);
			}
			else{
				leftmost=rightmost=best=FREQUENT.a[start];
				freq1=freq2=freq=1;
			}
		}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			int combine=0;
			if(parent.start==0 && parent.end==0){
				parent.start=left_child.start;parent.end=right_child.end;
			}
			int mid=(parent.start+parent.end)>>1;
			if(FREQUENT.a[mid]==FREQUENT.a[mid+1]){
				parent.freq1=left_child.freq1+right_child.freq1*(FREQUENT.a[mid+1]==FREQUENT.a[parent.start]?1:0);
				parent.freq2=right_child.freq2+left_child.freq2*(FREQUENT.a[mid]==FREQUENT.a[parent.end]?1:0);
				
				combine=left_child.freq2+right_child.freq1;
				parent.freq=Math.max(combine, Math.max(left_child.freq,right_child.freq));
			}
			else{
				parent.freq1=left_child.freq1;
				parent.freq2=right_child.freq2;
				parent.freq=Math.max(left_child.freq, right_child.freq);
			}
		}
		public Segment_Tree query(int a,int b){
			if(a>b || a>end || b<start)return null;
			if(start==a && end==b)return this;
			int mid=(start+end)>>1;
			if(a>mid)return right_child.query(a, b);
			else if(b<=mid)return left_child.query(a, b);
			//Segment_Tree ans=new Segment_Tree();
			Segment_Tree left=left_child.query(a,mid);
			Segment_Tree right=right_child.query(mid+1, b);
			if(FREQUENT.a[mid]==FREQUENT.a[mid+1]){
				int combine=Math.min(left_child.freq2,mid-a+1)+Math.min(right_child.freq1,b-mid);
				return new Segment_Tree(Math.max(combine, Math.max(left.freq, right.freq)));
			}
			else{
				return new Segment_Tree(Math.max(left.freq, right.freq));
			}
			//join(ans,left,right);
			//printDetails(ans, left, right);
			//return ans;
		}
		public static void printPostOrder(Segment_Tree parent){
			if(parent==null)return;
			else{
				printPostOrder(parent.left_child);
				printPostOrder(parent.right_child);
				System.out.println(parent.start+"-"+parent.end);
				System.out.println(parent.best+" "+parent.freq);
				System.out.println(parent.leftmost+" "+parent.freq1);
				System.out.println(parent.rightmost+" "+parent.freq2);
			}
		}
		public static void printDetails(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			System.out.println(left_child.start+"-"+left_child.end);
			System.out.println(right_child.start+"-"+right_child.end);
			System.out.println(left_child.leftmost+" "+left_child.freq1);
			System.out.println(left_child.rightmost+" "+left_child.freq2);
			System.out.println(right_child.leftmost+" "+right_child.freq1);
			System.out.println(right_child.rightmost+" "+right_child.freq2);
			System.out.println(parent.best+" "+parent.freq);
			System.out.println(parent.leftmost+" "+parent.freq1);
			System.out.println(parent.rightmost+" "+parent.freq2);
		}
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
10 5
-1 -1 -1 -1 1 1 1 1 2 2
2 7
6 10
3 7
2 5
1 10
0
*/