import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;


class MAXLN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
StringBuilder sb=new StringBuilder();
int i=1;
while(t-->0){
	long r=Integer.parseInt(br.readLine());
	double alpha=Math.asin(1.0/(4*r));
	//System.out.println(alpha);
	BigDecimal bd=new BigDecimal((4.0*r*r)*(Math.cos(alpha)*Math.cos(alpha))+2*r*Math.sin(alpha));
	bd=bd.setScale(2,BigDecimal.ROUND_UP);
	//ans=roundTwoDecimals(ans);
	//ans=Math.round(ans*100.0/100);
	sb.append("Case "+i+": "+bd.toString()+"\n");
	i++;
}
	System.out.println(sb);
	}
	public static double roundTwoDecimals(double d) {
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
	    return Double.valueOf(twoDForm.format(d));
	}
}
