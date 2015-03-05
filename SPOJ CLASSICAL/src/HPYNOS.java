import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


class HPYNOS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
long N=Long.parseLong(br.readLine());
int count=0;
HashSet<Long> hs=new HashSet<Long>();
while(true){
	hs.add(N);
	long M=0;
	while(N>0){
		long Y=N%10;
		M+=(Y*Y);
		N/=10;
	}
	count++;
	if(M==1){
		System.out.println(count);
		System.exit(0);
	}
	else if(hs.contains(M)){
		System.out.println(-1);
		System.exit(0);
	}
	//hs.add(M);
	N=M;
}
	}

}
