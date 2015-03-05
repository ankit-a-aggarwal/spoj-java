import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Arrays;


class TSHOW1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
int t=r.nextInt();
while(t-->0){
	long l=r.nextLong();
	long pow=(long) Math.floor(Math.log(l)/Math.log(2));
	long nextpow=pow+1;
	if(l>=Math.pow(2, pow)-1  && l<Math.pow(2, nextpow)-1);
	else pow=nextpow;
//	long number[]=new long[(int) pow];
	long start=(long) Math.pow(2, pow);
	
	//int k,prev_k;
	long x=(long) (l-(start-1));
	//x--;
		boolean number[]=new boolean[(int) pow];
		int k=0;
		while(x>0){
			long rem=(x&1)==1?1:0;
			if(rem==1)number[k]=true;
			k++;
			x>>=1;
		}
		int len=number.length;
	//	for(int i=0;i<pow-len;i++)sb.append(5);
		for(int i=len-1;i>=0;i--){
			if(!number[i])sb.append(5);
			else sb.append(6);
		}
		sb.append("\n");
	//556565655555565666665565555555556
		//66566655665656655656555555556
		//665655566565655656556565556555555555556
}
pr.write(sb.toString());
	pr.flush();}
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
