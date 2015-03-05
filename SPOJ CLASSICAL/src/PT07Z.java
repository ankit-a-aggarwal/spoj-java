import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


class PT07Z {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(br.readLine());
Graph g=new Graph();
List<Integer> graph[]=g.createGraph(N);
for(int i=0;i<N-1;i++){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int a=Integer.parseInt(st.nextToken());
	int b=Integer.parseInt(st.nextToken());
	g.addEdge(graph,a-1, b-1);
}
int max=Integer.MIN_VALUE;

	int dis[]=g.BFS(graph,0);
	if(dis[0]>max)max=dis[0];
	 dis=g.BFS(graph,dis[1]);

	System.out.println(dis[0]);
	}

}
class Graph{
	static class Edge{
		int to;
		public Edge() {
			// TODO Auto-generated constructor stub
		}
	public	Edge(int v){
			this.to=v;
		}
	}
	
	static char colour[];
	static int distance[];
	static int parent[];
	
	public List<Integer>[] createGraph(int size){
		colour=new char[size];
		distance = new int[size];
		parent =new int[size];
		List<Integer> graph[]=new List[size];
		for(int i=0;i<size;i++)
			graph[i]=new ArrayList<Integer>();
		return graph;
	}
	public void addEdge(List<Integer> graph[],int s,int t){
		graph[s].add(t);
		graph[t].add(s);
	}
	/*public static Map<Integer,Set<Integer>> edges=new TreeMap<Integer, Set<Integer>>();
	public void addNode(int a){
		if(!edges.containsKey(a)){
			edges.put(a, new TreeSet<Integer>());
		}
	}
	public void removeNode(int a){
		if(!edges.containsKey(a))
			return;
		for(int x:edges.get(a)){
			edges.get(x).remove(a);
		}
		edges.remove(a);
	}
	public void addEdge(int a,int b){
		addNode(a);
		addNode(b);
		edges.get(a).add(b);
		edges.get(b).add(a);
	}
	*/
	public int[] BFS(List<Integer> graph[],int source){
		Arrays.fill(colour, 'W');
		Arrays.fill(parent, -1);
		Arrays.fill(distance, -1);
		
		distance[source]=0;
		colour[source]='G';
		
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(source);
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
		int max=Integer.MIN_VALUE,index=-1;;
		for(int i=0;i<distance.length;i++){
			if(distance[i]>max){
				max=distance[i];
				index=i;
			}
		}
		return new int[]{max,index};
	}
}