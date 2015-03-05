import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class CPRMT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	String a=br.readLine();
	if(a==null || a.equalsIgnoreCase(""))break;
	String b=br.readLine();
	
	int count[]=new int[26];
	int count2[]=new int[26];
	for(int i=0;i<a.length();i++){
		count[a.charAt(i)-97]++;
	}
	for(int i=0;i<b.length();i++){
		count2[b.charAt(i)-97]++;
	}
	for(int i=0;i<count.length;i++){
		if(count[i]>0 && count2[i]>0){
			for(int j=0;j<Math.min(count[i],count2[i]);j++){
				sb.append((char)(i+97));
			}
		}
	}
	sb.append("\n");
}
	System.out.println(sb);
	}

}
