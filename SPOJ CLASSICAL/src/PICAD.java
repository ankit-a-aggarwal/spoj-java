import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;




class PICAD {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb=new StringBuilder();
PrintWriter pr=new PrintWriter(System.out);
for(int j=0;j<10;j++){
//while(true){
String s=br.readLine().trim();
if(s.equals("") || s==null )break;
StringTokenizer stk=new StringTokenizer(s);
int start=Integer.parseInt(stk.nextToken());
int end=Integer.parseInt(stk.nextToken());
int n=Integer.parseInt(br.readLine().trim());
Time times[]=new Time[2*n];
for(int i=0;i<times.length;){
	stk=new StringTokenizer(br.readLine().trim());
	times[i++]=new Time(Integer.parseInt(stk.nextToken()),i,'a');
	times[i++]=new Time(Integer.parseInt(stk.nextToken()),i,'d');
}
Arrays.sort(times);
//System.out.println(Arrays.toString(times));
int min_count=Integer.MAX_VALUE,max_count=Integer.MIN_VALUE,count=0,prev_time=-1;char prev_state='d';
for(int i=0;i<times.length;i++){
	if(times[i].time>=start && times[i].time<=end){
		if(i!=0){
		max_count=Math.max(max_count, count);
		if((prev_time==times[i].time && prev_state!=times[i].state) || prev_time!=times[i].time)
			
		min_count=Math.min(min_count, count);
		}
		}
	if( times[i].state=='a')
		count++;
	else if( times[i].state=='d')
		count--;
	prev_time=times[i].time;
	prev_state=times[i].state;
	//System.out.println(min_count+" "+max_count);
}
if(max_count==Integer.MIN_VALUE)max_count=0;
if(min_count==Integer.MAX_VALUE)min_count=0;
sb.append(min_count+" "+max_count+"\n");	
}
	pr.write(sb.toString());
	pr.flush();}
	static class Time implements Comparable<Time>{
		public Time(int nextInt, int i,char state) {
			time=nextInt;
			index=i;
			this.state=state;
			// TODO Auto-generated constructor stub
		}
		public Time(){}
		int time,index;
		char state;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return index+"-"+time+"-"+state;
		}
		@Override
		public int compareTo(Time o) {
			// TODO Auto-generated method stub
			if(this.time==o.time){
				return this.state-o.state;
			}
			return this.time-o.time;
		}
	}
}
/*
5 20 
3 
5 20 
5 10 
11 20
*/