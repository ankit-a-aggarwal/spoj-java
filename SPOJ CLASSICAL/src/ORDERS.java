import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Arrays;



class ORDERS {
//static int s[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
//s=new int[1<<18];
int t=r.nextInt();
//for(int i=0;i<s.length;i++)s[i]=i;

while(t-->0){
	int n=r.nextInt();
	Segment_Tree st=new Segment_Tree(1,n);
	int a[]=new int[n+1];
	//boolean done[]=new boolean[n+1];
	int ans[]=new int[n+1];
	for(int i=1;i<=n;i++)a[i]=r.nextInt();
	for(int i=n;i>0;i--){
		int index=i-a[i];
		ans[i]=st.query(index).start;
		st.update(ans[i]);
	}
	//System.out.println(Arrays.toString(ans));
	for(int i=1;i<=n;i++)sb.append(ans[i]+" ");
	sb.append("\n");
}
	pr.write(sb.toString());
	pr.flush();}
	static class Segment_Tree{
		int start,end;
		Segment_Tree left_child,right_child;
		int sum;
		public Segment_Tree() {}
		public Segment_Tree(int a,int b){
			start=a;end=b;
			if(start!=end){
				int mid=(start+end)>>1;
				left_child=new Segment_Tree(a,mid);
				right_child=new Segment_Tree(mid+1, b);
				join(this, left_child, right_child);
			}
			else sum=1;
		}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			parent.sum=left_child.sum+right_child.sum;
		}
		public void update(int index){
			//if(index>end || index<start)return;
			 if(start==end){
				sum=0;
				return;
				}
			int mid=(start+end)>>1;
			if(index>mid)right_child.update(index);
			else left_child.update(index);
			join(this,left_child,right_child);
		}
		public Segment_Tree query(int index){
			
			 if(start==end){
				return this;
				}
			//int mid=(start+end)>>1;
			if(left_child.sum>=index)return left_child.query(index);
			else return right_child.query(-left_child.sum+index);
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
2
3
0 1 0
5
0 1 2 0 1
*/