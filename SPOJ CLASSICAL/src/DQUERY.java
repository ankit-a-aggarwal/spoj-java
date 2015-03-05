import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;


class DQUERY {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
int n=r.nextInt();
Segment_Tree st=new Segment_Tree(1, n);
int pos[]=new int[1000001];
int a[]=new int[n+1];
for(int i=1;i<=n;i++)a[i]=r.nextInt();
int q=r.nextInt();
int queries[][]=new int[q][3];
int answers[][]=new int[q][2];
for(int i=0;i<q;i++){
	queries[i][0]=i;
	answers[i][0]=i;
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
for(int i=0;i<q;i++){
	System.out.println(queries[i][0]+" "+queries[i][1]+" "+queries[i][2]);
}
int j=1;
for(int i=0;i<q;i++){
	while(j<=queries[i][2]){
		if(pos[a[j]]==0){
			st.update(j);
			pos[a[j]]=j;
		}
		else{
			st.update(pos[a[j]]);
			pos[a[j]]=j;
			st.update(j);
		}
		//System.out.println(j);
		//Segment_Tree.printPostOrder(st);
		j++;
	}
	answers[queries[i][0]][1]=st.query(queries[i][1],queries[i][2]).value;
//	System.out.println(answers[queries[i][0]][1]);
}
Arrays.sort(answers, new Comparator<int []>() {

	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(o1[0]-o2[0]);
	}
});
//for(int i=0;i<q;i++)System.out.println(answers[i][0]+" "+answers[i][1]);
for(int i=0;i<q;i++){
	sb.append(answers[i][1]+"\n");
}
pr.write(sb.toString());
pr.flush();
}
static class Segment_Tree{
	int start,end,value;
	Segment_Tree left_child, right_child;
	public Segment_Tree(){}
	public Segment_Tree(int a,int b){
		start=a;end=b;
		if(start!=end){
			int mid=(start+end)>>1;
			left_child=new Segment_Tree(a, mid);
			right_child=new Segment_Tree(mid+1, b);
			join(this, left_child, right_child);
		}
		
	}
	public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
		parent.value=left_child.value+right_child.value;
	}
	public void update(int i){
		if(i>end || i<start)return;
		if(start==end){
			value=value==0?1:0;
			return;
		}
		int mid=(start+end)>>1;
		if(i>mid)right_child.update(i);
		else if(i<=mid)left_child.update(i);
		join(this,left_child,right_child);
	}
	public Segment_Tree query(int a,int b){
		if(a>b || a>end || b<start) return null;
		if(start==a && end==b)return this;
		int mid=(start+end)>>1;
		if(a>mid)return right_child.query(a, b);
		else if(b<=mid)return left_child.query(a, b);
		Segment_Tree ans=new Segment_Tree();
		join(ans,left_child.query(a, mid),right_child.query(mid+1, b));
		return ans;
	}
	public static void printPostOrder(Segment_Tree parent){
		if(parent==null)return;
		else{
			printPostOrder(parent.left_child);
			printPostOrder(parent.right_child);
			System.out.println(parent.start+"-"+parent.end+" "+parent.value);
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
