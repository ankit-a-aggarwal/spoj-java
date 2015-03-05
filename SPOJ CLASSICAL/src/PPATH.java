import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class PPATH {
static int primes_list[];
static boolean primes[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int count=sieve_primes();
		/*PrintWriter pr=new PrintWriter("/home/ankit/Desktop/primes2.txt");
		StringBuilder prime=new StringBuilder();
		for(int i=0;i<primes_list.length;i++){
			if(primes_list[i]==0)break;
			prime.append(primes_list[i]+"\n");
		}
		pr.write(prime.toString());
		pr.flush();
		System.out.println(Arrays.toString(primes_list));
		*/
		Graph2 g=new Graph2();
		List<Integer> list1[]=g.createGraph(primes.length);
		for(int i=0;i<primes_list.length;i++){
			if(primes_list[i]==0)break;
			
			for(int j=i+1;j<primes_list.length;j++){
				if(primes_list[j]==0)break;
				String jj=primes_list[j]+"";
				String ii=primes_list[i]+"";
				int count_similar=0;
				for(int xx=0;xx<ii.length();xx++){
					if(ii.charAt(xx)==jj.charAt(xx))count_similar++;
				}
				if(count_similar==3){
				//System.out.println(primes_list[i]+" "+primes_list[j]);
					g.addEdge(list1, primes_list[i]-1000,primes_list[j]-1000);
				}
			}
		}
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
/*for(int i=0;i<100;i++){
	System.out.println(primes_list[i]);
}*/

int t=Integer.parseInt(br.readLine() );
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int s=Integer.parseInt(st.nextToken());
	int d=Integer.parseInt(st.nextToken());
	int dis=g.BFS(list1, s-1000, d-1000);
	if(dis==-1)
		sb.append("Impossible\n");
	else sb.append(dis+"\n");
}
	System.out.println(sb);
	}
public static int sieve_primes(){
	primes_list=new int[9001];
	primes=new boolean[9001];
	for(int i=0;i<primes.length;i+=2)primes[i]=true;
	int j=3;
	while(j*j<(primes.length+1000)){
	int i=1000-1000%j;
	if(i<1000){
		i+=j;
	}
	int quo=i/j;
	if((quo&1)==0)quo++;
	
		
		int mp=quo*j;
		//System.out.println(mp+" "+quo+" "+j);
		for(;(mp-1000)<primes.length;){
			primes[mp-1000]=true;
			quo+=2;
			mp=quo*j;
		}
	j+=2;
	}
	int count=0;
	for(int i=0;i<primes.length;i++){
		if(!primes[i]){
			primes_list[count++]=i+1000;
		}
	}
	Arrays.copyOf(primes_list, count);
	return count;
}
}
class Graph2{
	boolean visited[];
	int parent[];
	char colour[];
	int distance[];
	public List<Integer> [] createGraph(int size){
		List<Integer> graph[]=new List[size];
		for(int i=0;i<graph.length;i++){
			if(!PPATH.primes[i]){
				//System.out.println(i+1000);
				graph[i]=new ArrayList<Integer>();
			}
		}
		visited=new boolean[size];
		parent=new int[size];
		colour=new char[size];
		distance=new int[size];
		
		return graph;
	}
	public void addEdge(List<Integer> graph[],int s,int d){
		graph[s].add(d);
		graph[d].add(s);
	}
	public int BFS(List<Integer> graph[],int source,int destination){
		Arrays.fill(parent, -1);
		Arrays.fill(colour, 'W');
		Arrays.fill(distance, -1);
		if(source==destination)return 0;
		visited[source]=true;
		Arrays.fill(visited, false);
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(source);
		colour[source]='G';
		distance[source]=0;
		while(q.size()>0){
			int u=q.remove();
			//for(int i=0;i<graph[u].size();i++)System.out.println(graph[u].get(i));
			for(int i=0;i<graph[u].size();i++){
				int v=graph[u].get(i);
				if(!visited[v]){
					visited[v]=true;
					parent[v]=u;
					distance[v]=distance[u]+1;
					colour[v]='G';
					q.add(v);
				}
			}
			colour[u]='B';
		}
		return distance[destination];
	}
}