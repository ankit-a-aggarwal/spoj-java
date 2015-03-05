import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class EDIT {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
try{
while(true){
String s=br.readLine();
if(s.equals("\n") || s==null || s.length()==0)
	break;
/*;
a[1]=0;
for(int i=2;i<a.length;i++){
	if((Character.isUpperCase(s.charAt(i-1)) && Character.isUpperCase(s.charAt(i-2)) )|| (Character.isLowerCase(s.charAt(i-1))&& Character.isLowerCase(s.charAt(i-2))))
	a[i]=Math.min(a[i-2],a[i-1])+1;
	else a[i]=a[i-1];
}
sb.append(a[s.length()]).append("\n");
*/
//int a[]=new int[s.length()];
int x=0,y=0;
for(int i=0;i<s.length();i++){
	if(Character.isLowerCase(s.charAt(0))){
		if(i%2==0 && Character.isUpperCase(s.charAt(i)))
			x++;
		else if(i%2==1 && Character.isLowerCase(s.charAt(i)))
			x++;
	}
	else{
		
	}
}
}
System.out.println(sb);
}catch(Exception e){	}
	}

}
