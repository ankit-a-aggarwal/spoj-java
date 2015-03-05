import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class COMPARE_OUTPUTS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb1=new StringBuilder();
BufferedReader br=new BufferedReader(new FileReader("/media/ankit/Softwares/ECLIPSE/SPOJ/SPOJ CLASSICAL/src/OutputTemple.txt"));
String s;
while((s=br.readLine())!=null){
	sb1.append(s+"\n");
}
br=new BufferedReader(new FileReader("/home/ankit/Desktop/OutputFile.txt"));
StringBuilder sb2=new StringBuilder();
while((s=br.readLine())!=null){
	sb2.append(s+"\n");
}
if(sb1.equals(sb2))System.out.println("Files are same");
else{
	System.out.println("Not same");
}
	}

}
