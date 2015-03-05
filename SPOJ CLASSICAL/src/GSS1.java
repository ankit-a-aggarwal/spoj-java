import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

//import java.io.PrintWriter;

class GSS1 {

	static int array[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Reader ir = new Reader();
		OutputStream out = new BufferedOutputStream(System.out);
		
		int N = ir.nextInt();
		array = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			array[i] = ir.nextInt();
		}
		
		Segment_Tree root = new Segment_Tree(1, N);
		int M = ir.nextInt();
	
		for (int i = 0; i < M; i++) {
			
			int x = ir.nextInt();
			int y = ir.nextInt();
			int nas = root.query(x, y).max_sum;
			out.write((nas + "\n").getBytes());
		}
		out.flush();
	}

	static class Segment_Tree {
		Segment_Tree left_child, right_child;
		int best_left_sum, best_right_sum, sum, max_sum, start, end;

		public Segment_Tree() {
		}

		public Segment_Tree(int a, int b) {
			start = a;
			end = b;
			if (start != end) {
				int mid = (start + end) >> 1;
				left_child = new Segment_Tree(start, mid);
				right_child = new Segment_Tree(mid + 1, end);
				join(this, left_child, right_child);
			} else {
				best_left_sum = best_right_sum = sum = max_sum = GSS1.array[start];
			}

		}

		public void join(Segment_Tree parent, Segment_Tree left_child, Segment_Tree right_child) {
			parent.sum = left_child.sum + right_child.sum;
			parent.best_left_sum = Math.max(left_child.best_left_sum, left_child.sum + right_child.best_left_sum);
			parent.best_right_sum = Math.max(right_child.best_right_sum, right_child.sum + left_child.best_right_sum);
			parent.max_sum = Math.max(left_child.max_sum,
					Math.max(right_child.max_sum, left_child.best_right_sum + right_child.best_left_sum));
		}

		public Segment_Tree query(int a, int b) {
			if (a == start && b == end)
				return this;
			int mid = (start + end) >> 1;
			if (a > mid)
				return right_child.query(a, b);
			if (b <= mid)
				return left_child.query(a, b);
			Segment_Tree ans = new Segment_Tree();
			join(ans, left_child.query(a, mid), right_child.query(mid + 1, b));
			return ans;
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
 * 10 -200 3 4 -200 6 2 4 -200 5 6 4 1 1 10 0 1 -100 1 1 5 1 1 10
 */