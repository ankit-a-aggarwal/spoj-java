import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


class MKTHNUM_Input_File {
	static Random rand = new Random();
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter("/media/ankit/Softwares/ECLIPSE/SPOJ/SPOJ CLASSICAL/src/Input.txt");
sb.append("10\n");
for(int i=0;i<10;i++)
	if(i%2==0)
	sb.append((-5+i)+" ");
	else sb.append((-5)+" ");
sb.append("\n");
sb.append("10\n");
for(int i=0;i<10;i++){
	int l=randInt(1, 10);
	int r=randInt(1, 10);
	if(l>r){
		l=l^r;r=l^r;l=l^r;
	}
//	int range=r-l+1;
	//int k=randInt(1, 1000000000);
	sb.append(l+" "+r+"\n");
}
	pr.write(sb.toString());
	pr.flush();
	pr.close();}
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
