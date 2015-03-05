//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.io.Writer;
import java.util.InputMismatchException;
//import java.util.Map;
//import java.util.StringTokenizer;
//import java.util.TreeMap;


class MAJOR {
static int count[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
InputReader ir=new InputReader(System.in);
//OutputWriter ow=new OutputWriter(System.out);
int t=ir.readInt();
StringBuilder sb=new StringBuilder();
one:while(t-->0){
	int n=ir.readInt();
	count=new int[2001];
	//StringTokenizer st=new StringTokenizer(br.readLine());
	//TreeMap<Integer, Integer> tm=new TreeMap<Integer, Integer>();
	for(int i=0;i<n;i++){
		int x=ir.readInt();
		count[x+1000]++;
		//Integer value=tm.get(x);
		//tm.put(x, value==null?1:value+1);
		}
	for(int i=0;i<count.length;i++){
		if(count[i]>n/2)
		{
			sb.append("YES "+(i-1000)+"\n");
			continue one;
		}
	}
	sb.append("NO\n");
}
	System.out.println(sb);
	}

}
class InputReader {
	 
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
 
	public InputReader(InputStream stream) {
		this.stream = stream;
	}
 
	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}
 
	public static boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public char readCharacter() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		return (char) c;
	}
 
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
 
/*class OutputWriter {
	private final PrintWriter writer;
 
	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}
 
	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}
 
	public void close() {
		writer.close();
	}
 
	public void printLine(int i) {
		writer.println(i);
	}
}
 */
class IOUtils {
 
	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.readInt();
		return array;
	}
 
}