import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


class KGSS {
static int a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
int n=r.nextInt();
//System.out.println(n);
 a=new int[n+1];
for(int i=1;i<=n;i++)a[i]=r.nextInt();
Segment_Tree st=new Segment_Tree(1, n);
//st.printPostOrder(st);
int q=r.nextInt();
for(int i=0;i<q;i++){
	int c=r.nextInt();
	int low=r.nextInt();
	int high=r.nextInt();
	if(c==33){
		Segment_Tree query=st.query(low, high);
		sb.append((query.highest_value+query.second_highest)+"\n");
	}
	else st.update(low, high);
}
pr.write(sb.toString());
	pr.flush();}
	static class Segment_Tree{
		int start,end;int highest_value,second_highest;
		
		Segment_Tree left_child;Segment_Tree right_child;
		public Segment_Tree(){}
		public Segment_Tree(int a,int b){
			start=a;end=b;
			if(start!=end){
				int mid=(start+end)>>1;
				left_child=new Segment_Tree(a, mid);
				right_child=new Segment_Tree(mid+1, b);
				join(this, left_child, right_child);
			}
			else {
				highest_value=second_highest=KGSS.a[start];
			}
		}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			int left_h=left_child.highest_value;
			int left_sh=left_child.second_highest;
			int right_h=right_child.highest_value;
			int right_sh=right_child.second_highest;
			if(parent.start==0 && parent.end==0){
				parent.start=left_child.start;
				parent.end=right_child.end;
			}
			 if(left_h>=right_h){
				 parent.highest_value=left_h;
				 if(left_h==left_sh && left_child.start==left_child.end)
					 parent.second_highest=Math.max(right_h, right_sh);
				 else parent.second_highest=Math.max(right_h, Math.max(left_sh, right_sh));
			 }
			 else {
				 parent.highest_value=right_h;
				 if(right_h==right_sh && right_child.start==right_child.end)
					 parent.second_highest=Math.max(left_sh, left_h);
				 else
				 parent.second_highest=Math.max(left_h, Math.max(left_sh, right_sh));
			 }
		}
		public void update(int index,int value){
			if(index<start || index>end)return;
			if(start==index && end==index){
				second_highest=highest_value=value;
				return;
			}
			int mid=(start+end)>>1;
			if(index>mid)right_child.update(index, value);
			else if(index<=mid)left_child.update(index, value);
			join(this, left_child, right_child);
		}
		public Segment_Tree query(int a,int b){
			if(a>b || a>end || b<start)return null;
			if(start==a && end==b)return this;
			int mid=(start+end)>>1;
			if(a>mid)return right_child.query(a, b);
			else if(b<=mid)return left_child.query(a, b);
			Segment_Tree ans=new Segment_Tree();
			Segment_Tree left=left_child.query(a, mid);
			Segment_Tree right=right_child.query(mid+1, b);
			join(ans,left,right);
		//	printPostOrder(ans);
			return ans;
		}
		public void printPostOrder(Segment_Tree parent){
			if(parent==null)return;
			else{
				printPostOrder(parent.left_child);
				printPostOrder(parent.right_child);
				System.out.println(parent.start+"-"+parent.end);
				System.out.println(parent.highest_value+" "+parent.second_highest);
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
