import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;



class MSE06H {
static long tree[];
static int n,m,k;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
int t=r.nextInt();
for(int i=1;i<=t;i++){
	n=r.nextInt();
	 m=r.nextInt();
	k=r.nextInt();
	int edges[][]=new int[k+1][2];
	tree=new long[Math.max(m, Math.max(n, k))+1];
	
	for(int j=1;j<=k;j++){
		edges[j][0]=r.nextInt();
		edges[j][1]=r.nextInt();
		}
	Arrays.sort(edges,new Comparator<int []>() {
		
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if(o1[0]==o2[0])return Integer.valueOf(o1[1]-o2[1]);
			return Integer.valueOf(o1[0]-o2[0]);
			}
	});
	//for(int j=0;j<edges.length;j++)System.out.println(edges[j][0]+" "+edges[j][1]);
	long sum=0;
	for(int j=k,l;j>0;j=l){
		for(l=j;l>0 && edges[l][0]==edges[j][0];l--)sum+=read(edges[l][1]-1);
		for(l=j;l>0 && edges[l][0]==edges[j][0];l--)update(edges[l][1],1);
			//System.out.println(Arrays.toString(tree));
			}
	sb.append("Test case "+i+": "+sum+"\n");
}
	pr.write(sb.toString());
	pr.flush();}
	public static void update(int idx,long val){
		while(idx<=m){
			tree[idx]+=val;
			idx += idx & -idx;
		}
	}
	public static long read(int idx){
		long sum=0;
		while(idx>0){
			sum+=tree[idx];
			idx -= idx & -idx;
		}
		return sum;
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