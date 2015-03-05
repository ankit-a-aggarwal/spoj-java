import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


class TEMPLQ_Input_file {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter("/media/ankit/Softwares/ECLIPSE/SPOJ/SPOJ CLASSICAL/src/InputTemple.txt");
PrintWriter prw=new PrintWriter("/home/ankit/Desktop/InputFile.txt");
sb.append("100000 500000\n");
for(int i=0;i<100000;i++){
	sb.append(randInt(0, 100000000)+" ");
}
sb.append("\n");
for(int i=0;i<500000-1;i++){
	int choice=randInt(1,3);
	choice=3;
	int val;
	sb.append(choice+" ");
	if(choice==1){
		 val=randInt(1, 100000);
		sb.append(val+"\n");continue;
	}
	
	else if(choice==2)
	 val=randInt(0, 100);
	else  val=randInt(1,100);
	sb.append(val+"\n");
}
sb.append("2 0\n");
	pr.write(sb.toString());
	pr.flush();
//	pr=new PrintWriter("/home/ankit/Desktop/InputFile.txt");
	prw.write(sb.toString());
	prw.flush();
	pr.close();
	prw.close();
	}
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
