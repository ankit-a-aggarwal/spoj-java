import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;



class RATING {
static int tree[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
int n=r.nextInt();
Pair p[]=new Pair[n+1];
//Pair p2[]=new Pair[n+1];
tree=new int[100001];
p[0]=new Pair(0, 0, 0);
//p2[0]=new Pair(0, 0, 0);
for(int i=1;i<=n;i++){
	p[i]=new Pair(i,r.nextInt(),r.nextInt());
	//p2[i]=new Pair(i,p[i].rating2,p[i].rating1);
	//update(p[i].rating2,1);
}
Arrays.sort(p);
/*Arrays.sort(p2,new Comparator<Pair>() {
	@Override
	public int compare(Pair o1, Pair o2) {
		// TODO Auto-generated method stub
		if(o1.rating1==o2.rating1)return o1.rating2-o2.rating2;
		return o1.rating1-o2.rating1;
	}
});
*/
//System.out.println(Arrays.toString(p));
//System.out.println(Arrays.toString(p2));
int answers[]=new int[n+1];
int i=1;
while(i<=n){
	Pair x=p[i];
	int idx=i;
	while(i<=n && x.rating1==p[i].rating1 && x.rating2==p[i].rating2){
		answers[p[i].index]=read(x.rating2);
		i++;
	}
	i=idx;
	while(i<=n && x.rating1==p[i].rating1 && x.rating2==p[i].rating2){
		update(x.rating2,1);
		i++;
	}
}
for( i=1;i<=n;i++)sb.append(answers[i]+"\n");
pr.write(sb.toString());
pr.flush();

	}
	/*public static int binarySearch(Pair p2[],int val,int index){
		int low=1,high=p2.length-1,mid=(low+((high-low+1)>>1));
		while(low<high){
			mid=(low+((high-low+1)>>1));
			if(p2[mid].rating1<val)low=mid+1;
			else if(p2[mid].rating1==val){
				low=mid;
				}
			else high=mid-1;
		}
		if(p2[low].index==index){
			int count=0;
			for(int j=low-1;j>0 && p2[j].rating1==val;j--)
				count++;
			return count;
		}
		else{
			int j=low-1,count=0;
			for(;j>0 && p2[j].index!=index;j--);
			for(int k=j-1;k>0 && p2[k].rating1==val;k--)
				count++;
			return count;
			
		}
	//	return 0;
	}
	*/
	public static void update(int idx,int value){
		while(idx<tree.length){
			tree[idx]+=value;
			idx += idx & -idx;
		}
	}
	public static int read(int idx){
		int sum=0;
		while(idx>0){
			sum+=tree[idx];
			idx -=idx & -idx;
		}
		return sum;
	}
	static class Pair implements Comparable<Pair>{
		int index,rating1,rating2;

		@Override
		public String toString() {
			return "Pair [index=" + index + ", rating1=" + rating1 + ", rating2=" + rating2 + "]\n";
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getRating1() {
			return rating1;
		}

		public void setRating1(int rating1) {
			this.rating1 = rating1;
		}

		public int getRating2() {
			return rating2;
		}

		public void setRating2(int rating2) {
			this.rating2 = rating2;
		}

		public Pair() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Pair(int index, int rating1, int rating2) {
			super();
			this.index = index;
			this.rating1 = rating1;
			this.rating2 = rating2;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if(this.rating1==o.rating1)return this.rating2-o.rating2;
			return this.rating1-o.rating1;
		}
	}
static class Reader {
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;
	
	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}
	
	public Reader(String file_name) throws IOException {
		din = new DataInputStream(new FileInputStream(file_name));
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}
	
	public String readLine() throws IOException {
		byte[] buf = new byte[64];
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}
	
	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	
	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	
	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (c == '.')
			while ((c = read()) >= '0' && c <= '9')
				ret += (c - '0') / (div *= 10);
		if (neg)
			return -ret;
		return ret;
	}
	
	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}
	
	private byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
	
	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}
}

}
/*
[Pair [index=0, rating1=0, rating2=0]
, Pair [index=2, rating1=862, rating2=700]
, Pair [index=8, rating1=1014, rating2=1473]
, Pair [index=6, rating1=1033, rating2=950]
, Pair [index=3, rating1=1075, rating2=1089]
, Pair [index=4, rating1=1568, rating2=1557]
, Pair [index=7, rating1=1656, rating2=1649]
, Pair [index=1, rating1=1798, rating2=1832]
, Pair [index=5, rating1=2575, rating2=1984]
]
*/
/*
8
862 700
1014 1473
1033 600
1075 1475
1568 650
1656 1474
1798 1473
2575 1475
*/
/*
9
862 100
1014 100
1033 100
1075 200
1568 300
1656 200
1798 300
2575 300
2600 200
*/