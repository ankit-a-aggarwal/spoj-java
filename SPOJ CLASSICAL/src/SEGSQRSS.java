import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


class SEGSQRSS {
static long a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
int t=r.nextInt();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
for(int i=1;i<=t;i++){
	int n=r.nextInt();
	int q=r.nextInt();
	a=new long[n+1];
	for(int j=1;j<=n;j++)a[j]=r.nextLong();
	for(int j=0;j<q;j++){
		int c=r.nextInt();
		int st=r.nextInt();
		int en=r.nextInt();
		long x=0;
		if(c!=2)
			x=r.nextLong();
	}
}
	}
	static class Segment_Tree{
		int start,end;
		long value,sum,lazy1,lazy2;
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
			else{
				value=SEGSQRSS.a[start];
				sum=value*value;
			}
		}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			if(parent.start==0 && parent.end==0){
				parent.start=left_child.start;
				parent.end=right_child.end;
			}
			parent.sum=left_child.sum+right_child.sum;
		}
		public int range(){return end-start+1;}
		public void update(int a,int b,long value){
			if(a>b || a>end || b<start)return;
			if(start==a && end==b){
				lazy1+=value;
				return;
			}
			int mid=(start+end)>>1;
			if(a>mid)right_child.update(a, b, value);
			else if(b<=mid)left_child.update(a, b, value);
			else{
				left_child.update(a,mid, value);
				right_child.update(mid+1, b, value);
			}
			sum=left_child.sum+right_child.sum;
		}
		public void push(){
			
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
