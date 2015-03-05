import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import java.util.PriorityQueue;


class PRATA {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
int t=r.nextInt();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
while(t-->0){
	int P=r.nextInt();
	int n=r.nextInt();
	//int ranks[]=new int[n];
	Pair p[]=new Pair[n];
	for(int i=0;i<p.length;i++){
		int rank=r.nextInt();
		p[i]=new Pair(rank*1,i,1,rank);
	}
	//int time[]=new int[n];
	PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
	
	//int multiplier[]=new int[n];
	//Arrays.fill(multiplier, 1);
	Arrays.sort(p);
	for(int i=0;i<n;i++){
		pq.add(p[i]);
	}
	/*Iterator<Pair> iter=pq.iterator();
	while(iter.hasNext()){
		System.out.println(iter.next());
	}
	*/
	int count=Integer.MIN_VALUE;
	for(int i=0;i<P;i++){
	/*		Iterator<Pair> iter=pq.iterator();
	while(iter.hasNext()){
		System.out.println(iter.next());
	}
	*/
	Pair pair=pq.remove();
	pair.total_time+=pair.time;
	pair.multiplier++;
	pair.time=pair.rank*pair.multiplier;
	pq.add(pair);
	
//	System.out.println();
	}
	/*Iterator<Pair> iter=pq.iterator();
	while(iter.hasNext()){
		System.out.println(iter.next());
	}
	*/
	for(int i=0;i<n;i++)
		count=Math.max(count, p[i].total_time);
	sb.append(count+"\n");
}
	pr.write(sb.toString());
	pr.flush();}
	static class Pair implements Comparable<Pair>{
		int time,index,multiplier,rank,total_time;
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		
		
		public Pair(int time, int index, int multiplier, int rank) {
			super();
			this.time=time;
			this.index = index;
			this.multiplier = multiplier;
			this.rank = rank;
			this.total_time=0;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if(this.time+this.total_time==o.time+o.total_time)return this.rank-o.rank;
			return this.time+this.total_time-(o.time+o.total_time);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return time+" "+rank+" "+multiplier+" "+total_time;
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
