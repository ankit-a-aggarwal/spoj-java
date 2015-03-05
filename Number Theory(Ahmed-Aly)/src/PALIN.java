import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;


class PALIN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	String s=br.readLine();
	
	int z=0;
	for( ;z<s.length();z++){
		if(s.charAt(z)!='9')break;
	}
	if(z==s.length()){
		StringBuilder sb1=new StringBuilder();
		sb1.append(1);
		for(z=0;z<s.length()-1;z++)sb1.append(0);
		sb1.append(1);
		sb.append(sb1.toString()+"\n");
		continue;
	}
	char ans[]=new char[s.length()];
	boolean flag3=false;
	int i,j,pos1=-1,pos2=-1;
	if((s.length()&1)==1){
		i=s.length()/2-1;
		j=s.length()/2+1;
		ans[i+1]=s.charAt(i+1);
	}
	else {
		i=s.length()/2-1;
		j=s.length()/2;
	}
	for(;i>=0 && j<s.length();i--,j++ ){
		char x=s.charAt(i);
		char y=s.charAt(j);
		ans[i]=ans[j]=x;
		if(x==y)continue;
		if(!flag3)
		if(y>x ){pos1=j;}
		else {pos2=j;}
		flag3=true;
		//System.out.println(Arrays.toString(ans));
	}
	if(!flag3 || pos1>pos2){
		if((s.length()&1)==1){
			if(ans[s.length()/2]<'9'){
				ans[s.length()/2]++;
			}
			else{
				ans[s.length()/2]='0';
				i=s.length()/2-1;
				j=i+2;
				while(i>=0){
					if(ans[i]<'9'){ans[i]++;ans[j]++;break;}
					else{
						ans[i]=ans[j]='0';i--;j++;
					}
				}
			}
		}
		else{
			if(ans[s.length()/2]<'9'){
				ans[s.length()/2]++;
				ans[s.length()/2-1]++;
			}
			else{
				ans[s.length()/2]='0';
				ans[s.length()/2-1]='0';
				i=s.length()/2-2;
				j=s.length()/2+1;
				while(i>=0){
					if(ans[i]<'9'){ans[i]++;ans[j]++;break;}
					else{
						ans[i]=ans[j]='0';i--;j++;
					}
				}
			}
		}
	}
	
	
	sb.append(new String(ans)+"\n");
}
	System.out.println(sb);
	}

}
//9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2
//9 4 1 8 8 0 8 8 1 4 9
