import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BYTESM2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//DataInputStream dts=new DataInputStream(System.in);
		Reader r=new Reader();
		int t = r.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
		//	StringTokenizer st = new StringTokenizer(dts.readLine());
			int h = r.nextInt();
			int w = r.nextInt();
			int array[][] = new int[h][w];
			//int answer[][] = new int[h][w];
			for (int i = 0; i < h; i++) {
			//	st = new StringTokenizer(dts.readLine());
				for (int j = 0; j < w; j++) {
					array[i][j] =r.nextInt();
				}
			}
			//for (int i = 0; i < w; i++) {
				//answer[0][i] = array[0][i];
			//}
			//br.readLine();
			for (int i = 1; i < h; i++) {

				for (int j = 0; j < w; j++) {
					int a = 0, b = 0, c = 0;
					if (j >= 1)
						a = array[i - 1][j - 1];
					if (j + 1 < w)
						c = array[i - 1][j + 1];
					b = array[i - 1][j];
					array[i][j] += Math.max(a, Math.max(b, c));
				}
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < w; i++) {
				if (max < array[array.length - 1][i])
					max = array[array.length - 1][i];
			}
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
	static	class Reader {
	    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
	    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
	    }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
	    }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
	    }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
	    }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
	    }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
	    }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
	    }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
	    }public void close() throws IOException{if(din==null) return;din.close();}
	}
}

