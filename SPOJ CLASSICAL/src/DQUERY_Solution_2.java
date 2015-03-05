import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;


class DQUERY_Solution_2 {
static int index[];
static int n;
static int a[];
static long tree[];
static long read[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
n=r.nextInt();
a=new int[n+1];
index=new int[100001];
tree=new long[n+1];
read=new long[n+1];
Arrays.fill(read, -1);
for(int i=1;i<=n;i++)a[i]=r.nextInt();
int q=r.nextInt();
int queries[][]=new int[q][3];
long answers[][]=new long[q][2];
for(int i=0;i<q;i++){
	queries[i][0]=i;
	answers[i][0]=i;
	queries[i][1]=r.nextInt();
	queries[i][2]=r.nextInt();
}

Arrays.sort(queries, new Comparator<int []>() {

	@Override
	public int compare(int[] arg0, int[] arg1) {
		// TODO Auto-generated method stub
		return Integer.valueOf(arg0[2]-arg1[2]);
	}
});
int j=1;
//for(int i=1;i<=q;i++)System.out.println(queries[i][0]+" "+queries[i][1]+" "+queries[i][2]);
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
int prev_num=-1;
long readnum=-1;
for(int i=0;i<q;i++){
	int num=queries[i][2];
	while(j<=queries[i][2]){
		if(index[a[j]]==0){
			update(j, 1);
		}
		else{
			update(index[a[j]], -1);
			update(j,1);
		}
		index[a[j]]=j;
		j++;
		//System.out.println(Arrays.toString(tree));
	}
	if(prev_num!=num)
	 readnum=read(num);
	answers[queries[i][0]][1]=readnum-read(queries[i][1]-1);
	prev_num=num;
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
	public static long read(int idx){
		long sum=0;
		while(idx>0){
			sum+=tree[idx];
			idx -= idx & -idx;
		}
		return sum;
	}
	public static void update(int idx,int val){
		while(idx<tree.length){
			tree[idx]+=val;
			idx += idx & -idx;
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
