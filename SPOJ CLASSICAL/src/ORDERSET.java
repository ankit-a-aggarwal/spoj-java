import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Set;
//import java.util.Collections;
import java.util.StringTokenizer;
//import java.util.TreeMap;
import java.util.TreeSet;






class ORDERSET {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();

StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
int n=r.nextInt();
//int countI=0,countD=0,countK=0,countC=0;

//TreeMap<Integer, Integer> tmap=new TreeMap<Integer, Integer>();
TreeSet<Integer> tmap=new TreeSet<Integer>();
int count=0;
for(int i=1;i<=n;i++){
	String s=r.readLine();
	StringTokenizer st=new StringTokenizer(s);
	while(st.hasMoreTokens()){
		String q=st.nextToken();
		if(q.equals("I")){
			
			int value=Integer.parseInt(st.nextToken());
			
				
				//countI++;
			tmap.add(value);
			
			count=tmap.size();
			
			
			
		}
			
		else if(q.equals("D")){
			
			int value=Integer.parseInt(st.nextToken());
			
				//countD++;
			tmap.remove((Integer)value);
			
			count=tmap.size();
			
			
		}
			
		else if(q.equals("K")){
			//countK++;
			
			int k=Integer.parseInt(st.nextToken());
		
			if(k>count)sb.append("invalid\n");
			else{
			
			//	Set<Integer> tss=tmap.keySet();
				Object a[]=tmap.toArray();
				Object value= binarySearch(a, k, count);
				sb.append(value+"\n");
			
			}
			
		}
		else{
			//countC++;
			
			int k=Integer.parseInt(st.nextToken());
			k--;
			
			//Set<Integer> tss=tmap.keySet();
			Object[] c=tmap.toArray();
			Object value=binarySearchCount(c, k, count);
			sb.append(value+"\n");
			
		}
	}
	
	//System.out.println(countI+" "+countD+" "+countK+" "+countC);
}
pr.write(sb.toString());
pr.flush();
	}
	public static Object binarySearch(Object a[],int k,int count){
		k--;
		int low=0,high=count-1,mid=(low+((high-low+1)>>1)),prev_mid=mid;
		while(low<high){
			mid=(low+((high-low+1)>>1));
			if(prev_mid==mid)mid--;
			if(mid>k)high=mid;
			else if(mid<k)low=mid+1;
			else return a[mid];
			prev_mid=mid;
		}
		return a[low];
	}
	public static Object binarySearchCount(Object a[],Object number,int count){
		int low=0,high=count-1,mid=(low+((high-low+1)>>1));
		while(low<high){
			mid=(low+((high-low+1)>>1));
			if((Integer)a[mid]>(Integer)number)high=mid-1;
			else if((Integer)a[mid]<(Integer)number)low=mid;
			else return mid==0?1:mid+1;
		}
		if(low==0 && (Integer)a[low]<=(Integer)number)return 1;
		else if(low==0 && (Integer)a[low]>(Integer)number)return 0;
		return low+1;
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
