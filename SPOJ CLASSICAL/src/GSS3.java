import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

class GSS3 {
	static int array[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GSS3.Reader r = new GSS3.Reader();
		int N = r.nextInt();
		array = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			array[i] = r.nextInt();
		}
		SegmentTree st = new SegmentTree(1, N);
		int Q = r.nextInt();
		StringBuilder sb = new StringBuilder();
		PrintWriter pr = new PrintWriter(System.out);
		for (int i = 0; i < Q; i++) {
			int choice = r.nextInt();
			int left = r.nextInt();
			int right = r.nextInt();
			if (choice == 1) {
				sb.append(st.query(left, right).bestsum + "\n");
			} else {
				st.update(left, right);
			}
		}
		pr.write(sb.toString());
		pr.flush();
	}

	static class SegmentTree {
		SegmentTree left_child, right_child;
		int bestleftsum, bestrightsum, bestsum, sum, start, end;

		public SegmentTree() {
		}

		public SegmentTree(int a, int b) {
			start = a;
			end = b;
			if (start != end) {
				int mid = (start+end) >> 1;
				left_child = new SegmentTree(start, mid);
				right_child = new SegmentTree(mid + 1, end);
				join(this, left_child, right_child);
			} else {
				bestleftsum = bestrightsum = bestsum = sum = GSS3.array[start];
			}
		}

		public void join(SegmentTree parent, SegmentTree left_child, SegmentTree right_child) {
			parent.sum = left_child.sum + right_child.sum;
			parent.bestleftsum = Math.max(left_child.bestleftsum, left_child.sum + right_child.bestleftsum);
			parent.bestrightsum = Math.max(right_child.bestrightsum, right_child.sum + left_child.bestrightsum);
			/*parent.bestsum = Math.max(
					left_child.bestleftsum,
					Math.max(
							right_child.bestrightsum,
							Math.max(left_child.bestrightsum, Math.max(right_child.bestleftsum, left_child.bestrightsum
									+ right_child.bestleftsum))));
		*/
		parent.bestsum=Math.max(left_child.bestsum, Math.max(right_child.bestsum,left_child.bestrightsum+right_child.bestleftsum));
		}

		public SegmentTree query(int a, int b) {
			if (a == start && b == end)
				return this;
			int mid = (start + end) >> 1;
			if (a > mid)
				return right_child.query(a, b);
			else if (b <= mid)
				return left_child.query(a, b);
			SegmentTree st = new SegmentTree();
			join(st, left_child.query(a, mid), right_child.query(mid + 1, b));
			return st;
		}

		public void update(int index, int value) {
			if (index == start && index == end) {
				bestleftsum = bestrightsum = bestsum = sum = value;
				return;
			}
			int mid = (start + end) >> 1;
			if (index <= mid)
				left_child.update(index, value);
			else
				right_child.update(index, value);
			join(this, left_child, right_child);
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
 * 4 1 2 3 4 4 1 1 3 0 3 -3 1 2 4 1 3 3
 */
/*
 * 10 -200 3 4 -200 6 2 4 -200 5 6 4 1 1 10 0 1 -100 1 1 5 1 1 10
 */