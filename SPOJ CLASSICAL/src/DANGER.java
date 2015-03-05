import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class DANGER {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
while(true){
	String s=br.readLine();
	if(s.equalsIgnoreCase("00e0"))break;
	StringBuilder num=new StringBuilder();
	num.append(s.charAt(0)+""+s.charAt(1));
	int z=Integer.parseInt(s.charAt(3)+"");
	for(int i=0;i<z;i++)num.append(0);
	long x=Long.parseLong(num.toString());
	long nearest_lower_power_two=(long)Math.pow(2, Math.floor(Math.log(x)/Math.log(2.0)));
	long answer=(2*(x-nearest_lower_power_two))+1;
	sb.append(answer+"\n");
}
	System.out.println(sb);
	}

}
