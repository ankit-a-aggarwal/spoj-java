import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


class MRECAMAN {
static long calculate[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		solve();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	int K=Integer.parseInt(br.readLine());
	if(K==-1)break;
	sb.append(calculate[K]+"\n");
}
	System.out.println(sb);
	}
public static void solve(){
	calculate=new long[500001];
	calculate[0]=0;
	HashSet<Long> hs=new HashSet<Long>();
	hs.add(0L);
	for(int i=1;i<calculate.length;i++){
		calculate[i]=calculate[i-1]-i;
		if(calculate[i]>0 && !hs.contains(calculate[i])){
			hs.add(calculate[i]);
		}
		else {calculate[i]+=2*i;hs.add(calculate[i]);}
	}
}
}
