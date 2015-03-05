import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;





class MKTHNUM {
static int a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long time=System.currentTimeMillis();
Reader r=new Reader("/media/ankit/Softwares/ECLIPSE/SPOJ/SPOJ CLASSICAL/src/Input.txt");
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter("/media/ankit/Softwares/ECLIPSE/SPOJ/SPOJ CLASSICAL/src/Output.txt");
int n=r.nextInt();
int m=r.nextInt();
 a=new int[n+1];
for(int i=1;i<=n;i++)a[i]=r.nextInt();
Segment_Tree st=new Segment_Tree(1, n);

for(int i=0;i<m;i++){
	int start=r.nextInt();
	int end=r.nextInt();
	int k=r.nextInt();
	//System.out.println(m);
	int ans=st.binarySearch(start, end, k);
	sb.append(ans+"\n");
	}

	pr.write(sb.toString());
	System.out.println((System.currentTimeMillis()-time)/1000.0);
	pr.flush();
	pr.close();}
	static class Segment_Tree{
		int start,end;
		Segment_Tree left_child,right_child;
		int array[];
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
				array=new int[1];
				array[0]=MKTHNUM.a[start];
			}
		}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			parent.array=new int[left_child.array.length+right_child.array.length];
			if(parent.start==0 && parent.end==0){
				parent.start=left_child.start;
				parent.end=right_child.end;
			}
		int i=0,j=0,k=0,left_len=left_child.array.length,right_len=right_child.array.length;
		for(;i<left_len && j<right_len;)
			parent.array[k++]=left_child.array[i]<right_child.array[j]?left_child.array[i++]:right_child.array[j++];
			for(;i<left_len;i++)
				parent.array[k++]=left_child.array[i];
			for(;j<right_len;j++)
				parent.array[k++]=right_child.array[j];
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
			//printPostOrder(ans);
			return ans;
		}
		public int binarySearch(int start,int end,int k){
			Segment_Tree ans=this.query(start, end);
			k--;
			//System.out.println(Arrays.toString(ans.array));
			int low=0,high=ans.array.length-1,mid=low+((high-low+1)>>1);
			while(low<high){
				mid=low+((high-low+1)>>1);
				if(mid>k)
					high=mid-1;
				else if(mid==k)return ans.array[mid];
				else low=mid+1;
			}
			mid=(low+((high-low+1)>>1));
			return ans.array[mid];
		}
		/*public void printPostOrder(Segment_Tree parent){
			if(parent==null)return;
			else{
				printPostOrder(parent.left_child);
				printPostOrder(parent.right_child);
				System.out.println(parent.start+"-"+parent.end);
				System.out.println(Arrays.toString(parent.array));
			}
		}*/
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
