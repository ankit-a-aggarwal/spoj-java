import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class BUGLIFE {
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//InputReader1 ir=new InputReader1(System.in);
		Reader ir=new Reader();
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int t=ir.nextInt();
StringBuilder sb=new StringBuilder();

int test=1;
while(t-->0){
	//StringTokenizer st=new StringTokenizer(br.readLine());
	int N=ir.nextInt();
	int M=ir.nextInt();
	Graph1 g1=new Graph1();
	List<Integer> list1[]=g1.createGraph(N);
	for(int i=0;i<M;i++){
		//st=new StringTokenizer(br.readLine());
		int x=ir.nextInt();
		int y=ir.nextInt();
		g1.addEdge(list1,x-1,y-1);
	}
	//boolean isBipartite=g1.BFS(list1);
	boolean isBipartite=g1.DFS(list1);
	sb.append("Scenario #"+test++ +":\n");
	if(!isBipartite)
	sb.append("Suspicious bugs found!\n");
	else sb.append("No suspicious bugs found!\n");
}
	bw.write(sb.toString());
	bw.close();
	}
}
class Graph1{
	//int parent[];
	boolean visited[];
	boolean colour[];
	public List<Integer>[] createGraph(int size){
		@SuppressWarnings("unchecked")
		List<Integer> graph[]=new List[size];
		for(int i=0;i<size;i++){
			graph[i]=new ArrayList<Integer>();
		}
		//parent=new int[size];
		visited=new boolean[size];
		colour=new boolean[size];
		//Arrays.fill(parent, -1);
	//	Arrays.fill(visited, false);
	//	Arrays.fill(colour, true);
		return graph;
	}
	
	public void addEdge(List<Integer> graph[],int s,int d){
		graph[s].add(d);
		graph[d].add(s);
	}
	public boolean BFS(List<Integer> graph[]){
		for(int i=0;i<graph.length;i++){
			if(!visited[i]){
				if(!BFS_visit(graph, i))return false;
			}
		}
		return true;
	}
	public boolean BFS_visit(List<Integer> graph[],int source){
		
		visited[source]=true;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(source);
		while(q.size()>0){
			int u=q.remove();
			for(int i=0;i<graph[u].size();i++){
				int v=graph[u].get(i);
				if(!visited[v]){
				//	parent[v]=u;
					colour[v]=!colour[u];
					visited[v]=true;
					q.add(v);
				}
				else if(colour[v]==colour[u]){
					return false;
				}
			}
		}
		return true;
	}
	public boolean DFS(List<Integer> graph[]){
		for(int i=0;i<graph.length;i++){
			if(!visited[i]){
				//colour[i]=true;
				if(!DFS_Visit(graph, i))return false;
			}
		}
		return true;
	}
	public boolean DFS_Visit(List<Integer> graph[],int source){
		visited[source]=true;
		
		for(int i=0;i<graph[source].size();i++){
			int get=graph[source].get(i);
			if(!visited[get]){
				colour[get]= !colour[source];
				DFS_Visit(graph, get);
			}
			else if(colour[source]==colour[get]){
				return false;
			}
		}
		return true;
	}
}
 
class OutputWriter {
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
 
