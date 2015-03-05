import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


class RPLN {
static int a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out,true);
int t=r.nextInt();
for(int te=1;te<=t;te++){
	sb.append("Scenario #"+te+":\n");
	sb.append("\n");
	int n=r.nextInt();
	int q=r.nextInt();
	 a=new int[n+1];
	for(int i=1;i<=n;i++)a[i]=r.nextInt();
	Segment_Tree st=new Segment_Tree(1,n);
	for(int i=0;i<q;i++){
		int s=r.nextInt();
		int e=r.nextInt();
		sb.append(st.query(s, e).min_value+"\n");
		sb.append("\n");
	}
}
	pr.write(sb.toString());
	pr.flush();
	}
	static class Segment_Tree{
		int start,end,min_value;
		Segment_Tree left_child,right_child;
		public Segment_Tree(){}
		public Segment_Tree(int a,int b){
			start=a;end=b;
			if(start!=end){
				int mid=(start+end)>>1;
	left_child=new Segment_Tree(a,mid);
	right_child=new Segment_Tree(mid+1,b);
	join(this, left_child, right_child);
			}
			else this.min_value=RPLN.a[start];
		}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			parent.min_value=Math.min(left_child.min_value, right_child.min_value);
		}
		public Segment_Tree query(int a,int b){
			if(a>b || a>end || b<start)return null;
			if(start==a && end==b)return this;
			int mid=(start+end)>>1;
			if(a>mid)return right_child.query(a, b);
			else if(b<=mid)return left_child.query(a, b);
			Segment_Tree ans=new Segment_Tree();
			join(ans,left_child.query(a, mid),right_child.query(mid+1, b));
			return ans;
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
