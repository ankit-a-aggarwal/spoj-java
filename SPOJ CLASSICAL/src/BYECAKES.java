import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//import java.util.StringTokenizer;


class BYECAKES {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Reader r=new Reader();
StringBuilder sb=new StringBuilder();
while(true){
	//StringTokenizer st=new StringTokenizer(br.readLine());
	int a[]=new int[8];
	boolean flag=false;
	for(int i=0;i<8;i++){
		a[i]=r.nextInt();
		if(a[i]!=-1)flag=true;
	}
	if(!flag)break;
	if(a[0]==0 && a[1]==0 && 0==a[3] && a[2]==0){
		sb.append("0 0 0 0\n");continue;
	}
	if(a[0]<a[4] && a[1]<a[5] && a[2]<a[6] && a[3]<a[7]){
		sb.append((a[4]-a[0])+" "+(a[5]-a[1])+" "+(a[6]-a[2])+" "+(a[7]-a[3])+"\n");
		continue;
	}
	
	int b[]=new int[4];
	b[0]=(int)Math.ceil(1.0*a[0]/a[4]);
	b[1]=(int)Math.ceil(1.0*a[1]/a[5]);
	b[2]=(int)Math.ceil(1.0*a[2]/a[6]);
	b[3]=(int)Math.ceil(1.0*a[3]/a[7]);
	
	int max=Math.max(b[0],Math.max(b[1], Math.max(b[2],b[3])));
	/*b[0]+=max-b[0];
	b[1]+=max-b[1];
	b[2]+=max-b[2];
	b[3]+=max-b[3];
	*/
	int ans[]=new int[4];
	ans[0]=max*a[4]-a[0];
	ans[1]=max*a[5]-a[1];
	ans[2]=max*a[6]-a[2];
	ans[3]=max*a[7]-a[3];
	sb.append((ans[0])+" "+(ans[1])+" "+(ans[2])+" "+(ans[3])+"\n");
}
	System.out.println(sb);
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
//-1 -1 -1 -1 -1 -1 -1 -1 -1