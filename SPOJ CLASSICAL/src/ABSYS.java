import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;


class ABSYS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	br.readLine();
	String s=br.readLine();
	int index_of_mac=s.indexOf("machula");
	int index_of_plus=s.indexOf("+");
	int index_of_equal=s.indexOf("=");
	if(index_of_mac<index_of_plus){
		String sub=s.substring(index_of_plus+1);
		String x[]=sub.split("=");
		int nas=Integer.parseInt(x[1].trim())-Integer.parseInt(x[0].trim());
		//machula13 + 75425 = 77038
		sb.append(nas+" +"+x[0]+"="+x[1]+"\n");
		continue;
	}
	else if(index_of_mac>index_of_plus && index_of_mac<index_of_equal){
		String sub=s.substring(0,index_of_plus).trim();
		String eq=s.substring(index_of_equal+1).trim();
		int nas=Integer.parseInt(eq)-Integer.parseInt(sub);
		//3247 + 5machula2 = 3749
		sb.append(sub+" + "+nas+" = "+eq+"\n");
		continue;
	}
	else{
		String sub=s.substring(0,index_of_equal);
		//System.out.println(sub);
		//String x[]=sub.split("+");
		int nas=Integer.parseInt(sub.substring(0,index_of_plus).trim())+Integer.parseInt(sub.substring(index_of_plus+1,index_of_equal).trim());
		//23 + 47 = machula
		sb.append(sub+"= "+nas+"\n");
		continue;
	}
	
}
	System.out.println(sb);
	}

}
