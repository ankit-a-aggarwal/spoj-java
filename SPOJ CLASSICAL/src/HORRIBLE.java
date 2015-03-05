import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;




class HORRIBLE {
static long a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
int t=r.nextInt();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out,true);
while(t-->0){
	int n=r.nextInt();
	Segment_Tree st=new Segment_Tree(1,n);
	int c=r.nextInt();
	for(int i=0;i<c;i++){
		switch(r.nextInt()){
		case 1:sb.append(st.query(r.nextInt(),r.nextInt()).sum+"\n");break;
		case 0:st.update(r.nextInt(), r.nextInt(), r.nextLong());
		}
		//st.printPostOrder(st);
	}
}
	pr.write(sb.toString());
	pr.flush();
	}
	static class Segment_Tree{
		int start,end;
		Segment_Tree left_child,right_child;
		long sum,lazy;
		public Segment_Tree(){}
		public Segment_Tree(int a,int b){
			start=a;end=b;
			if(start!=end){
				int mid=(start+end)>>1;
				left_child=new Segment_Tree(a,mid);
				right_child=new Segment_Tree(mid+1,b);
				join(this, left_child, right_child);
			}
		}
		public int range(){return end-start+1;}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			if(parent.start==0 && parent.end==0){
				parent.start=left_child.start;
				parent.end=right_child.end;
			}
			parent.sum=left_child.sum+right_child.sum;
		}
		public Segment_Tree query(int a,int b){
			if(a>b || a>end || b<start)return null;
			if(start==a && end==b)return this;
			push();
			int mid=(start+end)>>1;
			if(a>mid)return right_child.query(a, b);
			else if(b<=mid)return left_child.query(a, b);
			Segment_Tree ans=new Segment_Tree();
			Segment_Tree left=left_child.query(a, mid);
			Segment_Tree right=right_child.query(mid+1, b);
			join(ans,left,right);
			return ans;
		}
		public void update(int a,int b,long value){
			if(a>end || b<start || a>b)return;
			if(start==a && end==b){
				sum+=range()*value;
				lazy+=value;
				return;
			}
			push();
			int mid=(start+end)>>1;
			if(a>mid)right_child.update(a, b, value);
			else if(b<=mid)left_child.update(a, b, value);
			else{
				left_child.update(a,mid, value);
				right_child.update(mid+1,b,value);
			}
			sum=left_child.sum+right_child.sum;
		}
		public void push(){
			if(left_child!=null){
				left_child.sum+=left_child.range()*lazy;
				left_child.lazy+=lazy;
				right_child.sum+=right_child.range()*lazy;
				right_child.lazy+=lazy;
				sum=left_child.sum+right_child.sum;
			}
			lazy=0;
		}
		public void printPostOrder(Segment_Tree parent){
			if(parent==null)return;
			else{
				printPostOrder(parent.left_child);
				printPostOrder(parent.right_child);
				System.out.println(parent.start+"-"+parent.end);
				System.out.println(parent.sum+" "+parent.lazy);
			}
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
1
8 6
0 2 4 26
0 4 8 80
0 4 5 20
1 8 8 
0 5 7 14
1 4 8
*/