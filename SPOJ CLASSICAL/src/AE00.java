import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class AE00 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(br.readLine() );
long sum=N;

for(int i=2;i*i<=N;i++){
	for(int j=i;j*i<=N;j++)
		sum++;
}
	System.out.println(sum);}

}
