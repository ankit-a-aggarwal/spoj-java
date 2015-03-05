import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class PT07Y {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st=new StringTokenizer(br.readLine());
int N=Integer.parseInt(st.nextToken());
int M=Integer.parseInt(st.nextToken());
Graph g=new Graph();
List<Integer> graph[]=g.createGraph(N);
int s=0,d=0;
for(int i=0;i<M;i++){
	st=new StringTokenizer(br.readLine());
	 s=Integer.parseInt(st.nextToken());s--;
	 d=Integer.parseInt(st.nextToken());d--;
	g.addEdge(graph, s, d);
}
boolean b=g.DFS(graph);
if(b)System.out.println("YES");
else System.out.println("NO");
	}
static class Graph{
	int parent[];
	int distance[];
	char colour[];
	public List<Integer>[] createGraph(int N){
		parent=new int[N];
		distance=new int[N];
		colour=new char[N];
		List<Integer> graph[]=new List[N];
		for(int i=0;i<N;i++){
			graph[i]=new ArrayList<Integer>();
		}
		return graph;
	}
	public void addEdge(List<Integer> graph[],int s,int d){
		graph[s].add(d);
		graph[d].add(s);
	}
	public boolean BFS(List<Integer> graph[],int s){
		Arrays.fill(parent, -1);
		Arrays.fill(distance, -1);
		Arrays.fill(colour, 'W');
		distance[s]=0;
		colour[s]='G';
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(s);
		while(q.size()>0){
			int remove=q.remove();
			for(int i=0;i<graph[remove].size();i++){
				int x=graph[remove].get(i);
				if(colour[x]=='W'){
					colour[x]='G';
					distance[x]=distance[remove]+1;
					parent[x]=remove;
					q.add(x);
				}
			}
			colour[remove]='B';
		}
		for(int i=0;i<distance.length;i++){
			if(distance[i]<0)return false;
		}
		return true;
	}
	public boolean DFS(List<Integer> graph[]){
		Arrays.fill(colour, 'W');
		Arrays.fill(parent, -1);
		int count=0;
		for(int i=0;i<graph.length;i++){
			if(colour[i]=='W'){
				boolean cycle=DFS_Visit(graph, i);
				if(cycle)return false;
				count++;
			}
			if(count>1)return false;
		}
		return true;
	}
	public boolean DFS_Visit(List<Integer> graph[],int s){
		colour[s]='G';
		for(int i=0;i<graph[s].size();i++){
			int x=graph[s].get(i);
			if(colour[x]=='W'){
				parent[x]=s;
				DFS_Visit(graph, x);
			}
			else if(colour[x]=='G' && (parent[x]!=s && parent[s]!=x))
				return true;
		}
		colour[s]='B';
		return false;
	}
}
}
