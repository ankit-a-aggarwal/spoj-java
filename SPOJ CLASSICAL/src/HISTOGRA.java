import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

class HISTOGRA {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader r = new Reader();
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = r.readLine();
			if (s == null || s.equals("\n") || s.equalsIgnoreCase(""))
				break;
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			long a[] = new long[n];
			long max_area = Long.MIN_VALUE, area = 0, min_value = Long.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				a[i] = Long.parseLong(st.nextToken());
			}

			long max_value = a[0];
			int index = 0,max_index=0;
		//	long area2 = 0;
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (a[i] != 0 && !flag) {
					index = i;
					flag = true;
				} else if(a[i]==0)
					flag = false;
				if (a[i] < min_value && a[i]!=0)
					min_value = a[i];
				else if(a[i]==0)min_value=Long.MAX_VALUE;
				if(flag)
				area = (i - index + 1) * min_value;
				if(a[i]>max_value){
					System.out.println(i);
					if(i-max_index==1)
					max_value=Math.max(a[i],(i-max_index+1)*max_value);
					else max_value=a[i];
					max_index=i;
				}
				max_area=Math.max(area,Math.max( max_value,max_area));
			}
			sb.append(max_area+"\n");
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
/*
6 40 0 40 30 59 302
0
*/