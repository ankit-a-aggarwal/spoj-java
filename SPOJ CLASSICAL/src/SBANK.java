import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


class SBANK {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	int N=Integer.parseInt(br.readLine() );
	TreeMap<String,Integer> tm=new TreeMap<String, Integer>();
	for(int i=0;i<N;i++){
		String s=br.readLine();
		Integer value=tm.get(s);
		tm.put(s, value==null?1:value+1);
	}
	for(Map.Entry<String, Integer> entry:tm.entrySet()){
		sb.append(entry.getKey()+" "+entry.getValue()+"\n");
	}
	sb.append("\n");
	br.readLine();
}
	System.out.println(sb);
	}

}
