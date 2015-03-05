import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


class BRCKTS {
static int a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Reader r=new Reader();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
int i=1;
while(true){
	
	String sr=br.readLine();
	if(sr==null || sr.equalsIgnoreCase(""))break;
	sb.append("Test "+(i++)+":\n");
int n=Integer.parseInt(sr);
//boolean odd=false;
//if((n&1)==1)odd=true;
 a=new int[n+1];
String s=br.readLine();
for(int j=1;j<=n;j++){
	a[j]=s.charAt(j-1)=='('?1:-1;
}
Segment_Tree st=new Segment_Tree(1, n);
//Segment_Tree.print_postOrder(st);
int m=Integer.parseInt(br.readLine());

for(int j=0;j<m;j++){
	int q=Integer.parseInt(br.readLine());
	
	if(q==0){
		
	//	else if(st.sum==0 && st.min_sum==0)sb.append("YES\n");
		 if(st.number_of_closed_unbalanced==0 && st.number_of_open_unbalanced==0 )sb.append("YES\n");
		else sb.append("NO\n");
	}
	else st.update(q);
	//System.out.println(st.sum+" "+st.min_sum);
	//System.out.println("H");
}
}
pr.write(sb.toString());
pr.flush();
}
	static class Segment_Tree{
		int start,end,number_of_open_unbalanced,number_of_closed_unbalanced;
		Segment_Tree left_child,right_child;
		//int sum,min_sum;
		public Segment_Tree(){};
		public Segment_Tree(int a,int b){
			start=a;end=b;
			if(start!=end){
				int mid=(start+end)>>1;
				left_child=new Segment_Tree(a,mid);
				right_child=new Segment_Tree(mid+1,b);
				join(this,left_child,right_child);
			}
			else {
				//sum=min_sum=BRCKTS.a[start]==1?1:-1;
				if(BRCKTS.a[start]==1)
					number_of_open_unbalanced=1;
				else number_of_closed_unbalanced=1;
			}
		}
		public void join(Segment_Tree parent,Segment_Tree leftchild,Segment_Tree rightchild){
			//parent.sum=leftchild.sum+rightchild.sum;
			//parent.min_sum=Math.min(leftchild.min_sum,rightchild.min_sum+leftchild.sum);
			parent.number_of_closed_unbalanced=leftchild.number_of_closed_unbalanced;
			parent.number_of_open_unbalanced=rightchild.number_of_open_unbalanced;
			int unbala=rightchild.number_of_closed_unbalanced-leftchild.number_of_open_unbalanced;
			if(unbala>0){
			parent.number_of_closed_unbalanced+=unbala;
			}
			else parent.number_of_open_unbalanced+=Math.abs(unbala);
		}
		public void update(int index){
			if(start==index && end==index){
				
				if(number_of_open_unbalanced==1){
					number_of_closed_unbalanced=1;
					number_of_open_unbalanced=0;
				}
				else {
					number_of_closed_unbalanced=0;
					number_of_open_unbalanced=1;
				}
				//sum=min_sum=min_sum==1?-1:1;
				return ;
			}
			int mid=(start+end)>>1;
			if(index<=mid)left_child.update(index);
			else if(index>mid)right_child.update(index);
			join(this, left_child, right_child);
		}
		public static void print_inOrder(Segment_Tree parent){
			if(parent==null)return;
			else{
			print_inOrder(parent.left_child);
			System.out.println(parent.number_of_open_unbalanced+" "+parent.number_of_closed_unbalanced);
			print_inOrder(parent.right_child);
			}
		}
		public static void print_postOrder(Segment_Tree parent){
			if(parent==null)return;
			else{
				print_postOrder(parent.left_child);
				print_postOrder(parent.right_child);
				System.out.println(parent.number_of_open_unbalanced+" "+parent.number_of_closed_unbalanced);
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
/*
12
(()(()(())))
16
0
1
3
0
4
5
6
0
10
0
2
0
1
3
4
0
*/