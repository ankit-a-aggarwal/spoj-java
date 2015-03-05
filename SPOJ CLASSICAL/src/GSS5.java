import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.PrintWriter;


class GSS5 {
static int a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
Reader r=new Reader();
int t=r.nextInt();
PrintWriter pr=new PrintWriter(System.out);
StringBuilder sb=new StringBuilder();
while(t-->0){
	int N=r.nextInt();
	a=new int[N+1];
	for(int i=1;i<=N;i++)a[i]=r.nextInt();
	SegmentTree root=new SegmentTree(1, N);
	int M=r.nextInt();
	for(int i=0;i<M;i++){
		int x1=r.nextInt();
		int y1=r.nextInt();
		int x2=r.nextInt();
		int y2=r.nextInt();
		if(y1<x2){
			int ans=root.query(x1,y1).bestrightsum+root.query(y1+1,x2-1).sum+root.query(x2,y2).bestleftsum;
			sb.append(ans+"\n");
			
		}
		else{
			int ans1=root.query(x1,x2-1).bestrightsum+root.query(x2,y2).bestleftsum;
			int ans2=root.query(y1+1,y2).bestleftsum+root.query(x1, y1).bestrightsum;
			//int ans3=root.query(x1,x2-1).bestrightsum+root.query(x2,y1).sum+root.query(y1+1,y2).bestleftsum;
			int ans3=root.query(x2, y1).bestsum;
			int ans=Math.max(ans1, Math.max(ans2, ans3));
			sb.append(ans+"\n");
		}
	}
	
}
	pr.write(sb.toString());
	pr.flush();
	}
static class SegmentTree{
	SegmentTree left_child,right_child;
	int bestleftsum,bestrightsum,bestsum,sum,start,end;
	public SegmentTree(){}
	public SegmentTree(int a,int b){
		start=a;end=b;
		if(start!=end){
			int mid=(start+end)>>1;
			left_child=new SegmentTree(start,mid);
			right_child=new SegmentTree(mid+1,end);
			join(this,left_child,right_child);
		}
		else{
			bestleftsum=bestrightsum=bestsum=sum=GSS5.a[start];
		}
	}
	public void join(SegmentTree parent,SegmentTree left_child,SegmentTree right_child){
		parent.sum=left_child.sum+right_child.sum;
		parent.bestleftsum=Math.max(left_child.bestleftsum,left_child.sum+right_child.bestleftsum);
		parent.bestrightsum=Math.max(right_child.bestrightsum,right_child.sum+left_child.bestrightsum);
		parent.bestsum=Math.max(left_child.bestsum,Math.max(right_child.bestsum,left_child.bestrightsum+right_child.bestleftsum));
	}
	public SegmentTree query(int a,int b){
		if(a<start || b>end || a>b)return new SegmentTree();
		if(start==a && end==b)return this;
		int mid=(start+end)>>1;
		if(a>mid)return right_child.query(a, b);
		if(b<=mid)return left_child.query(a, b);
		SegmentTree ans=new SegmentTree();
		join(ans,left_child.query(a, mid),right_child.query(mid+1, b));
		return ans;
	}
}
static class Reader {
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
