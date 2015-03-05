import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


class GSS4 {
static int array[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//long t=System.currentTimeMillis();
Reader r=new Reader();
PrintWriter pr=new PrintWriter(System.out);
StringBuilder sb=new StringBuilder();
int test=1;
while(true){
	String s=r.readLine();
	if(s==null || s.equalsIgnoreCase("") || s.equals("\n"))break;
	int N=Integer.parseInt(s);
	sb.append("Case #"+test++ +":\n");
	array=new int[N+1];
	for(int i=1;i<=N;i++){
		array[i]=r.nextInt();
	}
	Segment_Tree root=new Segment_Tree(1, N);
	int M=r.nextInt();
	for(int i=0;i<M;i++){
		int choice=r.nextInt();
		int low=r.nextInt();
		int high=r.nextInt();
		if(choice==0){
			root.update(Math.min(low, high),Math.max(low, high));
		}
		else{
			sb.append(root.query(Math.min(low, high),Math.max(low, high)).sum+"\n");
		}
	}
	sb.append("\n");
}
	pr.write(sb.toString());
	//pr.write(((System.currentTimeMillis()-t)/1000.0)+"");
	pr.flush();
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
	static class Segment_Tree{
		Segment_Tree left_child,right_child;
		int start,end;long sum;
		long lazy;
		public Segment_Tree(){}
		public Segment_Tree(int a,int b){
			start=a;
			end=b;
			if(start!=end){
				int mid=(start+end)>>1;
				left_child=new Segment_Tree(start, mid);
				right_child=new Segment_Tree(mid+1, end);
				join(this,left_child,right_child);
			}
			else{
				sum=GSS4.array[start];
			}
		}
		public void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			parent.sum=left_child.sum+right_child.sum;
		}
		public Segment_Tree query(int a,int b){
			if(a>b || a<start || b>end)return new Segment_Tree();
			if(start==a && end==b)return this;
			int mid=(start+end)>>1;
			if(a>mid)return right_child.query(a, b);
			else if(b<=mid) return left_child.query(a, b);
			Segment_Tree ans=new Segment_Tree();
			join(ans,left_child.query(a, mid),right_child.query(mid+1, b));
			return ans;
		}
		public void update(int a,int b){
			
			if(a>b || a<start || b>end)return;
		if(start!=end){
			int mid=(start+end)>>1;
			left_child.update(a, mid);
			right_child.update(mid+1, b);
			join(this, left_child, right_child);
		}
		else{
			this.sum=GSS4.squareRot(this.sum);
		}
		}
		}
	public static long squareRoot(double x){
		if(x==0)return 0;
		 if(x<0) x=-x;
		
			double sqrt=x/2;
		
		double g1;
		do{
			g1=sqrt;
			sqrt = (g1+ (x/g1))/2;
		}while(g1-sqrt!=0);
	return (long)sqrt;
	}
	public static long squareRot(long x){
		if(x==0)return 0;
		long op,one,res;
		op=x;res=0;
		one=1<<30;
		while(one>op)one>>=2;
		while(one!=0){
			 if (op >= res + one) {
		            op -= res + one;
		            res += one << 1;  
		        }
		        res >>= 1;
		        one >>= 2;
		}
		return res;
	}
	}
