import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class OIL_DEPOSITS {
static boolean visited[][];
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	StringTokenizer st=new StringTokenizer(br.readLine());
	int N=Integer.parseInt(st.nextToken());
	int M=Integer.parseInt(st.nextToken());
	if(N==0 && M==0)
		break;
	char c[][]=new char[N][M];
	visited=new boolean[N][M];
	for(int i=0;i<N;i++){
			String xx=br.readLine();
			for(int j=0;j<M;j++){
				c[i][j]=xx.charAt(j);
			}
		}
	int count=0;
	for(int i=0;i<c.length;i++){
		
		for(int j=0;j<c[i].length;j++){
			char x=c[i][j];
			if(x=='@' && !visited[i][j]){
				DFS_visit(c, i, j);
				count++;
			}
		}
	}
	sb.append(count).append("\n");
	}
	System.out.println(sb);
	}
	public static void DFS_visit(char c[][],int i,int j){
		visited[i][j]=true;
		if(i-1>0 && j-1>0 && c[i-1][j-1]=='@' && !visited[i-1][j-1]){
			DFS_visit(c, i-1, j-1);
		}
		if(i-1>0 && c[i-1][j]=='@' && !visited[i-1][j]){
			DFS_visit(c, i-1, j);
		}
		if(i-1>0 && j+1<c[i-1].length && c[i-1][j+1]=='@' && !visited[i-1][j+1]){
			DFS_visit(c, i-1,1+ j);
		}
		if(  j+1<c[i].length && c[i][j+1]=='@' && !visited[i][j+1]){
			DFS_visit(c,i,1+j);
		}
		if(i+1<c.length && j+1<c[i+1].length && c[i+1][j+1]=='@' && !visited[i+1][j+1]){
			DFS_visit(c, i+1,1+j);
		}
		if(i+1<c.length  && c[i+1][j]=='@' && !visited[i+1][j]){
			DFS_visit(c, i+1,j);
		}
		if(i+1<c.length && j-1>0 && c[i+1][j-1]=='@' && !visited[i+1][j-1]){
			DFS_visit(c, i+1,j-1);
		}
		if(j-1>0 && c[i][j-1]=='@' && !visited[i][j-1]){
			DFS_visit(c, i, j-1);
		}
		
	}
	}
