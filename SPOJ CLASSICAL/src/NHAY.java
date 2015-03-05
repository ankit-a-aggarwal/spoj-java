import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class NHAY {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	String s=br.readLine();
	if(s==null || s.equalsIgnoreCase(""))break;
	String find=br.readLine();
	String target=br.readLine();
	int j=0;
	for(int i=0;i<target.length();i++){
		int index=target.indexOf(find, j);
		if(index>=0){
			sb.append(index+"\n");
		}
		else break;
		j=index+1;
	}
	sb.append("\n");
}
	System.out.println(sb);
	}

}
