import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
//import java.util.Iterator;
//import java.util.TreeSet;
import java.util.Vector;





class POSTERS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Reader r=new Reader();
int t=r.nextInt();
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
while(t-->0){
	int n=r.nextInt();
	Vector<Pair> v=new Vector<POSTERS.Pair>();
	//TreeSet<Pair> ts=new TreeSet<POSTERS.Pair>();
	//TreeSet<Pair> ts1=null;
//	Vector<Vector<Integer>> v=new Vector<Vector<Integer>>();
	Pair p=null;
	int a[][]=new int[n][3];
	for(int i=0;i<n;i++){
	//	System.out.println("Input");
		a[i][0]=i;
		a[i][1]=r.nextInt();
		a[i][2]=r.nextInt();
		 p=new Pair(a[i][0], a[i][1], a[i][2]);
	
	if(v.size()==0)v.add(p);
	else{
	//	ts1=new TreeSet<POSTERS.Pair>(ts);
	//Iterator<Pair> iter=ts.iterator();
		int j=0;
		boolean flag=false;
		boolean flag2=false;
	while(j<v.size()){
		Pair x=v.get(j);
		//System.out.println(x);
		if(a[i][1]==x.left && a[i][2]==x.left){
			v.remove(j);
			v.insertElementAt(p, j);
			flag2=true;
			break;
		}
		if(a[i][1]<x.left && a[i][2]<x.left){
			v.add(p);
			flag2=true;
			break;
		}
		else if(a[i][1]<=x.left && a[i][2]>=x.left && a[i][2]<x.right){
			x.left=a[i][2]+1;
			Pair z=new Pair(x.index,x.left,x.right);
			v.remove(x);
			//((TreeSet<Pair>) iter).add(z);
			//((TreeSet<Pair>) iter).add(p);
			v.add(p);
			v.add(z);
			flag2=true;
			break;
		}
		else if(a[i][1]<=x.left && a[i][2]>=x.right){
			v.remove(x);
			//v.add(p);
			//((TreeSet<Pair>) iter).add(p);
			flag=true;
		}
	/*	else if(a[i][1]==x.left && a[i][2]<x.right){
			x.left=a[i][2]+1;
			Pair z=new Pair(x.index,x.left,x.right);
			ts.remove(x);
			ts.add(z);
		}
		*/
		else if(a[i][1]>x.left && a[i][2]<x.right){
			Pair twopair=new Pair();
			twopair.setLeft(a[i][2]+1);
			twopair.setRight(x.right);
			twopair.setIndex(x.index);
			x.right=a[i][1]-1;
			Pair three=new Pair(x.index, x.left, x.right);
			v.remove(x);
			v.add(twopair);
			v.add(three);
			v.add(p);
			flag2=true;
			break;
		}
		else if(a[i][1]>x.right){
			//System.out.println("right");
			j++;
			continue;
		}
		else if(a[i][1]>x.left && a[i][2]>=x.right){
			Pair twopair=new Pair();
			twopair.setRight(a[i][1]-1);
			twopair.setIndex(x.index);
			twopair.setLeft(x.left);
			v.remove(x);
			v.insertElementAt(twopair, j);
			//v.add(p);
			//flag2=true;
			
		}
		else if(a[i][2]>=x.left){
			Pair z=new Pair(x.index,a[i][2]+1,x.right);
			v.remove(x);
			v.add(z);
			v.add(p);
			flag2=true;
		}
		if(!flag)
		j++;
	}
	if(!flag2)v.add(p);
	}
	Collections.sort(v);
	//for(int j=0;j<v.size();j++)System.out.println(v.get(j));
}
	int j=0;
	HashSet<Integer> hs=new HashSet<Integer>();
	while(j<v.size()){
		hs.add(v.get(j).index);
		j++;
	}
	sb.append(hs.size()+"\n");
}
	pr.write(sb.toString());
	pr.flush();
	}
	static class Pair implements Comparable<Pair>{
		 int index,left,right;
		 public Pair(){}
		public Pair(int index, int left, int right) {
			super();
			this.index = index;
			this.left = left;
			this.right = right;
		}

		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getLeft() {
			return left;
		}
		public void setLeft(int left) {
			this.left = left;
		}
		public int getRight() {
			return right;
		}
		public void setRight(int right) {
			this.right = right;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.right-o.left;
		}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return index+" "+left+" "+right;
	}
		
		public boolean equals(Pair obj) {
			// TODO Auto-generated method stub
			if(this.index==obj.index && this.left==obj.left && this.right==obj.right)return true;
			return false;
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
1
10
1 4
2 5
2 3
6 9
5 6
9 10
7 9
10 15
10 12
14 15
*/