import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


class RRSCHED {
static long tree[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Reader r=new Reader();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int n=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
Pair a[]=new Pair[n+1];
tree=new long[n+1];
a[0]=new Pair(0,0);
for(int i=1;i<=n;i++){
	
	a[i]=new Pair(i,Integer.parseInt(br.readLine()));
//	a[i].time=r.nextInt();
	//a[i].index=i;
	update(i, 1);
}
Arrays.sort(a);
//System.out.println(Arrays.toString(a));
long current_time=0;
long answers[]=new long[n+1];
for(int i=1;i<=n;i++){
	current_time+=(a[i].time-a[i-1].time-1)*(n-i+1); // (n-i+1) is number of tasks which are incomplete
	current_time+=read(a[i].index);
	answers[a[i].index]=current_time;
	update(a[i].index,-1);//a[i].index task is complete
	current_time+=(n-i)-read(a[i].index);//number of tasks after a[i].index which are incomplete
}
for(int i=1;i<=n;i++)sb.append(answers[i]+"\n");
pr.write(sb.toString());
pr.flush();
	}
	public static void update(int index,long value){
		while(index<tree.length){
			tree[index]+=value;
			index += index & -index;
		}
	}
	public static long read(int index){
		long sum=0;
		while(index>0){
			sum+=tree[index];
			index -= index & -index;
		}
		return sum;
	}
	static class Pair implements Comparable<Pair>{
		int index,time;

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public Pair() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Pair(int index, int time) {
			super();
			this.index = index;
			this.time = time;
		}

		@Override
		public int compareTo(Pair arg0) {
			// TODO Auto-generated method stub
			if(this.time==arg0.time)return this.index-arg0.index;
			return this.time-arg0.time;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return index+"-"+time+"\n";
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
