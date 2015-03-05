import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;



class HELPR2D2 {
static int a;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader r=new Reader();
int t=r.nextInt();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
while(t-->0){
	 a=r.nextInt();
	int n=r.nextInt();
	int used=0;
	Segment_Tree st=new Segment_Tree(1,n);
	int ans=Integer.MIN_VALUE;
	for(int i=0;i<n;i++){
		String s[]=r.readLine().split(" ");
		if(s.length==1){
			used+=Integer.parseInt(s[0]);
			ans=Math.max(ans,st.update(Integer.parseInt(s[0])));
		}
		else{
			int len=Integer.parseInt(s[1]);
			for(int j=0;j<len;j++){
				used+=Integer.parseInt(s[2]);
				//Arrays.sort(a, 0, pos);
				ans=Math.max(ans,st.update(Integer.parseInt(s[2])));
			}
			i+=len-1;
		}
		//st.printPostOrder(st);
	}
	//System.out.println(ans);
	sb.append(ans+" "+(a*ans-used)+"\n");
}
	pr.write(sb.toString());
	pr.flush();}
	
	static class Segment_Tree{
		int start,end,max;
		//min;
		Segment_Tree left_child,right_child;
		int index;
		int array[];
		public Segment_Tree(){}
		public Segment_Tree(int a,int b){
			start=a;end=b;
			if(start!=end){
				int mid=(start+end)>>1;
				left_child=new Segment_Tree(a,mid);
				right_child=new Segment_Tree(mid+1,b);
				join(this, left_child, right_child);
			}
			else{
				array=new int[1];
				array[0]=HELPR2D2.a;
				max=array[0];
			}
		}
		public static void join(Segment_Tree parent,Segment_Tree left_child,Segment_Tree right_child){
			parent.max=Math.max(left_child.max, right_child.max);
			//parent.min=Math.min(left_child.min, right_child.min);
		}
		public int update(int value){
			if(start==end){
				max-=value;
				//min-=value;
				index=start;
				return start;
			}
			int ret=0;
			if(left_child.max>=value){ret= left_child.update(value);}
			else {ret=right_child.update(value);}
			join(this, left_child, right_child);
			return ret;
		}
		public void printPostOrder(Segment_Tree parent){
			if(parent==null)return;
			else{
				printPostOrder(parent.left_child);
				printPostOrder(parent.right_child);
				System.out.println(parent.start+"-"+parent.end);
				System.out.println(parent.max);
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
