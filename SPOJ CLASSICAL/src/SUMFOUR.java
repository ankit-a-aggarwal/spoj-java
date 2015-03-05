import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;


class SUMFOUR {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//int N=Integer.parseInt(br.readLine());
		InputReader2 ir=new InputReader2(System.in);
int N=ir.readInt();
		int A[]=new int[N];
int B[]=new int[N];
int C[]=new int[N];
int D[]=new int[N];
for(int i=0;i<N;i++){
	//StringTokenizer st=new StringTokenizer(br.readLine());
	A[i]=ir.readInt();
	B[i]=ir.readInt();
	C[i]=ir.readInt();
	D[i]=ir.readInt();
}
//System.out.println(Arrays.toString(A));
int Add1[]=new int[A.length*A.length];
int Add2[]=new int[A.length*A.length];
for(int i=0,k=0;i<A.length;i++){
	for(int j=0;j<A.length;j++){
		Add1[k]=A[i]+B[j];
		Add2[k]=-(C[i]+D[j]);
		k++;
	}
}
Arrays.sort(Add1);
Arrays.sort(Add2);
//System.out.println(Arrays.toString(Add1));
//System.out.println(Arrays.toString(Add2));
int count=0;int index2=0,index;
for(int i=0;i<Add1.length;i++){
	 index=Arrays.binarySearch(Add2,index2,Add2.length,Add1[i]);
	if(index>=0){
		int count1=1;int j;
		for( j=i+1;j<Add1.length;j++){
			if(Add1[j]==Add1[i])count1++;
			else break;
		}
		i=j-1;
		int count2=1;
		for( j=index-1;j>=0;j--){
			if(Add2[j]==Add2[index])count2++;
			else break;
		}
		for(j=index+1;j<Add2.length;j++){
			if(Add2[j]==Add2[index])count2++;
			else break;
		}
		count+=(count1*count2);
		index2=index+1;
	}
}
System.out.println(count);	}

}
class InputReader2 {
	 
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
 
	public InputReader2(InputStream stream) {
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
 
class OutputWriter2 {
	private final PrintWriter writer;
 
	public OutputWriter2(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}
 
	public OutputWriter2(Writer writer) {
		this.writer = new PrintWriter(writer);
	}
 
	public void close() {
		writer.close();
	}
 
	public void printLine(int i) {
		writer.println(i);
	}
}
 
class IOUtils2 {
 
	public static int[] readIntArray(InputReader2 in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.readInt();
		return array;
	}
 
}
 