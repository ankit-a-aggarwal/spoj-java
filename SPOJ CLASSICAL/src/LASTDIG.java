import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class LASTDIG {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	StringTokenizer st=new StringTokenizer(br.readLine());
	//int a=Integer.parseInt(st.nextToken());
	String a=st.nextToken();
	long b=Long.parseLong(st.nextToken());
	if(b==0){sb.append("1\n");continue;}
	if(a.equals("0")){sb.append("0\n");continue;}
	
	
	switch(a.charAt(a.length()-1)){
	case '1':
	sb.append("1\n");break;
	case '5':
	sb.append("5\n");break;
	case '6':
	sb.append("6\n");break;
	case '0':
	sb.append("0\n");break;
	case '9':if((b&1)==0)sb.append("1\n");
		else sb.append("9\n");break;
	case '2':
	int mod=(int) (b%4);
	if(mod==1)sb.append("2\n");
	else if(mod==2)sb.append("4\n");
	else if(mod==3)sb.append("8\n");
	else sb.append("6\n");
	break;
	case '3':
	mod=(int) (b%4);
	if(mod==1)sb.append("3\n");
	else if(mod==2)sb.append("9\n");
	else if(mod==3)sb.append("7\n");
	else sb.append("1\n");break;
	case '4':
	
		if((b&1)==1)sb.append("4\n");
		else sb.append("6\n");
		break;
	case '7':
	mod=(int) (b%4);
	if(mod==1)sb.append("7\n");
	else if(mod==2)sb.append("9\n");
	else if(mod==3)sb.append("3\n");
	else sb.append("1\n");
		break;
	case '8':
	mod=(int) (b%4);
	if(mod==1)sb.append("8\n");
	else if(mod==2)sb.append("4\n");
	else if(mod==3)sb.append("2\n");
	else sb.append("6\n");
	
	}
}
	System.out.println(sb);
	}

}
