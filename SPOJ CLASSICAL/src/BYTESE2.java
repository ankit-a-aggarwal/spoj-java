import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


class BYTESE2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
int t=r.nextInt();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
while(t-->0){
	int n=r.nextInt();
	 Time[] arrival=new Time[n];
	 Time[] depart=new Time[n];
	 Time [] times=new Time[n*2]; 
	for(int i=0,j=0;i<arrival.length;i++){
		arrival[i]=new Time(r.nextInt(),i,true);
		depart[i]=new Time(r.nextInt(),i,false);
		times[j++]=arrival[i];
		times[j++]=depart[i];
	}
	Arrays.sort(times);
	int count=0,max_count=-1;
	for(int i=0;i<times.length;i++){
		Time ti=times[i];
		if(ti.state==true){
			count++;
		}
		else count--;
		max_count=Math.max(count, max_count);
	}
	sb.append(max_count+"\n");
	//Arrays.sort(depart);
	//System.out.println(Arrays.toString(arrival));
	//System.out.println(Arrays.toString(depart));
}
	pr.write(sb.toString());
	pr.flush();}
	static class Time implements Comparable<Time>{
		public Time(int nextInt, int i,boolean state) {
			time=nextInt;
			index=i;
			this.state=state;
			// TODO Auto-generated constructor stub
		}
		public Time(){}
		int time,index;
		boolean state;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return index+"-"+time;
		}
		@Override
		public int compareTo(Time o) {
			// TODO Auto-generated method stub
			return this.time-o.time;
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
