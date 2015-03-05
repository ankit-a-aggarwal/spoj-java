//import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


class POUR1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader r=new Reader();
int t=r.nextInt();
StringBuilder sb=new StringBuilder();
one:while(t-->0){
	int a=r.nextInt();
	int b=r.nextInt();
	int c=r.nextInt();
	if(c%GCD(a,b)!=0 || c>Math.max(a, b)){
		sb.append("-1\n");
		continue;
	}
	int count=0;
	int min=Math.min(a, b);
	int max=Math.max(a, b);
	int x=0,y=0;
	
	while(y!=c && x!=c){
		x+=(min-x);
		count++;
		if(x==c){
			sb.append(count+"\n");
			continue one;
		}
		if(y+x<=max){y+=x;x=x-x;}
		else {int sub=(y+x)-max;y+=sub;x-=sub;}
		
		count++;
		if(y==c || x==c){
			sb.append(count+"\n");
			continue one;
		}
		
		
		if(y==max){
			y=x;count+=2;
			x=0;
		}
		
	}
}
System.out.println(sb);

	}
	public static int GCD(int a,int b){
		if(a==0)return b;
		return GCD(b%a,a);
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
