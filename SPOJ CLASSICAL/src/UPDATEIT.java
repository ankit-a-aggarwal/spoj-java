import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


class UPDATEIT {
static int a[];
static int tree[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader r=new Reader();
int t=r.nextInt();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
while(t-->0){
	int n=r.nextInt();
	tree=new int[n+2];
	int u=r.nextInt();
	for(int i=0;i<u;i++){
		int left=r.nextInt();
		int right=r.nextInt();
		int val=r.nextInt();
		update(left+1,val);
		System.out.println(Arrays.toString(tree));
		
		update(right+2,-val);
		System.out.println(Arrays.toString(tree));
		//System.out.println("Done");
	}
	int q=r.nextInt();
	for(int i=0;i<q;i++){
		int idx=r.nextInt();
		sb.append(read(idx+1)+"\n");
	}
}
	pr.write(sb.toString());
	pr.flush();}
	public static void update(int idx,int val){
		while(idx<tree.length){
			tree[idx]+=val;
			idx += idx & -idx;
		}
	}
	public static int read(int idx){
		int sum=0;
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
/*
1
5 3
0 1 7
2 4 6
1 3 2
3
0
3
4
*/