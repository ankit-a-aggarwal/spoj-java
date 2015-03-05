import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;


class GSS2 {
static int a[];
static int pos[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		pos=new int[200002];
Reader r=new Reader();
//Reader r=new Reader("/media/ankit/Softwares/ECLIPSE/SPOJ/SPOJ CLASSICAL/src/Input.txt");
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out); 
int n=r.nextInt();
a=new int[n+1];
Segment_Tree st=new Segment_Tree(1,n); // Empty Segment Tree
for(int i=1;i<=n;i++)a[i]=r.nextInt();
int q=r.nextInt();
int queries[][]=new int[q][3];
long answers[][]=new long[q][2];
for(int i=0;i<q;i++){
	answers[i][0]=i;
	queries[i][0]=i;
	queries[i][1]=r.nextInt();
	queries[i][2]=r.nextInt();
}
Arrays.sort(queries,new Comparator<int []>() {

	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(o1[2]-o2[2]);
	}
});
//Sorted queries according to least end index
int j=1;
for(int i=0;i<q;i++){
	while(j<=queries[i][2]){
		if(pos[a[j]+100000]==0){
			st.update(j);
			pos[a[j]+100000]=j;
		}
		else{
			st.update(pos[a[j]+100000]);
			pos[a[j]+100000]=j;
			st.update(j);
		}
		System.out.println("j"+j);
		j++;
		Segment_Tree.printPostOrder(st);
	}
	long ans=st.query(queries[i][1],queries[i][2]).bestsum;
	answers[queries[i][0]][1]=ans<0?0:ans;
}
	Arrays.sort(answers,new Comparator<long []>() {

		@Override
		public int compare(long[] o1, long[] o2) {
			// TODO Auto-generated method stub
			return Integer.valueOf((int) (o1[0]-o2[0]));
		}
	});
	for(int i=0;i<q;i++){
		sb.append(answers[i][1]+"\n");
	}
	pr.write(sb.toString());
	pr.flush();
	}
	static class Segment_Tree{
		int start,end;
		Segment_Tree left_child,right_child;
		long bestleftsum,bestrightsum,bestsum,sum;
		int value;
		public Segment_Tree() {}
		public Segment_Tree(int a,int b){
			start=a;end=b;
			if(start!=end){
				int mid=(start+end)>>1;
				left_child=new Segment_Tree(a,mid);
				right_child=new Segment_Tree(mid+1, b);
				join(this,left_child,right_child);
			}
			else{
				bestleftsum=bestrightsum=bestsum=sum=GSS2.a[start];
			}
		}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			parent.sum=left_child.sum+right_child.sum;
			parent.bestleftsum=Math.max(left_child.bestleftsum, left_child.sum+right_child.bestleftsum);
			parent.bestrightsum=Math.max(right_child.bestrightsum,right_child.sum+left_child.bestrightsum);
			parent.bestsum=Math.max(left_child.bestsum,Math.max(right_child.bestsum,left_child.bestrightsum+right_child.bestleftsum));
		}
		public void update(int i){
			if(i>end || i<start)return;
			if(start==i && end==i){
				if(value==0){
					value=1;
					bestleftsum=bestrightsum=bestsum=sum=GSS2.a[i];
					}
				else {
					value=0;
					bestleftsum=bestrightsum=bestsum=sum=0;
				}
				return;
			}
			int mid=(start+end)>>1;
			if(i>mid)right_child.update(i);
			else if(i<=mid)left_child.update(i);
			join(this,left_child,right_child);
		}
		public Segment_Tree query(int a,int b){
			if(a>b || a>end || b<start)return null;
			if(start==a && end==b)return this;
			int mid=(start+end)>>1;
			if(a>mid)return right_child.query(a, b);
			else if(b<=mid)return left_child.query(a, b);
			Segment_Tree ans=new Segment_Tree();
			join(ans,left_child.query(a,mid),right_child.query(mid+1, b));
			return ans;
		}
		public static void printPostOrder(Segment_Tree parent){
			if(parent==null)return;
			else{
				printPostOrder(parent.left_child);
				printPostOrder(parent.right_child);
				System.out.println(parent.start+"-"+parent.end);
				System.out.println(parent.value);
				System.out.println(parent.sum+" "+parent.bestleftsum+" "+parent.bestrightsum+" "+parent.bestsum);
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
9
1 2 1 2 3 -4 3 4 5
5
1 2
1 4
1 6
1 8
1 9
*/