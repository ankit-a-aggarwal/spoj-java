import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


class NY10A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	int t=Integer.parseInt(br.readLine());
	StringBuilder sb=new StringBuilder();
	while(t-->0){
		HashMap<String, Integer> hm=new LinkedHashMap<String, Integer>();
		hm.put("TTT",0);
		hm.put("TTH",0);
		hm.put("THT",0);
		hm.put("THH",0);
		hm.put("HTT",0);
		hm.put("HTH",0);
		hm.put("HHT",0);
		hm.put("HHH",0);
		int x=Integer.parseInt(br.readLine());
		sb.append(x+" ");
		String s=br.readLine();
		for(int i=0;i<=s.length()-3;i++){
			String sub=s.substring(i, i+3);
			//if(i==37)System.out.println(sub);
			Integer l=hm.get(sub);
			hm.put(sub, l==null?0:l+1);
		}
		for(Map.Entry<String,Integer> entry:hm.entrySet()){
			//System.out.println(entry.getKey());
			sb.append(entry.getValue()+" ");
		}
		sb.append("\n");
	}
	
	System.out.println(sb);
	}

}
