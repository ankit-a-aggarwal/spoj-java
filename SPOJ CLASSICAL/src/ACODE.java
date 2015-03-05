import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ACODE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = br.readLine();
			 if (s.trim().equals("0"))
				break;
			 else if(s.length()==1){sb.append("1\n");continue;}
			long ans[] = new long[s.length()];
			ans[0] = 1;
			int in=Integer.parseInt(s.substring(0, 2));
			if(in<=26 && s.charAt(1)!='0')
				ans[1] = 2;
			else
				ans[1] = 1;
			char x,y;
			for (int i = 2; i < s.length(); i++) {
				 x=s.charAt(i-1);
				 in=Integer.parseInt(s.substring(i-1,i+1));
				if(i<s.length()-1)
				  y=s.charAt(i+1);
				ans[i] = ans[i - 1] +  ( in<=26 && x!='0' && s.charAt(i)!='0'? ans[i-2] : 0);
			}
			sb.append(ans[s.length() - 1] + "\n");
		}
		System.out.println(sb);
	}

}
/*
17221
172210
1722101
17221012
34
23
1017
0
20 
1190 
11101 
01 
30
*/