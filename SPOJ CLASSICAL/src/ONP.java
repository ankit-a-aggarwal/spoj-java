import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


class ONP {
static char array[]={'(','^','/','*','+','-'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
while(t-->0){
	String s=br.readLine();
	Stack<Character> stack=new Stack<Character>();
	for(int i=0;i<s.length();i++){
		char x=s.charAt(i);
		switch(x){
		case '(':
		case '^':
		case '/':
		case '*':
		case '+':
		case '-':
			
	
		boolean flag=false;
				 
			while(stack.size()>0){
			char y=stack.peek();
			if(precedence(x,y) || y=='('){
				stack.push(x);
				flag=true;
				break;
			}
			if(y!='(')
			sb.append(stack.pop());
			
		}
			if(!flag)stack.push(x);
			
			break;
		case ')':
			while(stack.size()>0){
				char q=stack.pop();
				if(q=='(')break;
				sb.append(q);
			}
			break;
		default:sb.append(x);
		}
	}
	sb.append("\n");
}
	System.out.println(sb);
	}
public static boolean precedence(char a,char b){
	int index1=-1,index2=-1;
	for(int i=0;i<array.length;i++){
		if(array[i]==a)index1=i;
		else if(array[i]==b)index2=i;
	}
	if(index1<index2)return true;
	return false;
}
}
