//import java.io.BufferedReader;
import java.util.Collections;
//import java.io.InputStreamReader;
import java.util.Vector;


class LongestIncreasingSubsequence_NlogN {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int a[]={2,5,3,2};
Vector<Vector<Integer>> ans=new Vector<Vector<Integer>>();
one:for(int i=0;i<a.length;i++){
	if(ans.size()>0){
	Vector<Integer> x=ans.get(0);
	if(a[i]<=x.get(x.size()-1)){
		Vector<Integer> new_Vector=new Vector<Integer>();
		new_Vector.add(a[i]);
		ans.insertElementAt(new_Vector, 0);
		for(int i1=0;i1<ans.size();i1++)System.out.println(i+" "+ans.get(i1).toString());
		continue;
	}
	x=ans.get(ans.size()-1);
	if(a[i]>=x.get(x.size()-1)){
		Vector<Integer> clone=(Vector<Integer>) x.clone();
		clone.add(a[i]);
		//System.out.println(clone.toString());
		ans.add(clone);
		for(int i1=0;i1<ans.size();i1++)System.out.println(i+" "+ans.get(i1).toString());
		continue;
	}
	}
	for(int j=ans.size()-1;j>=0;j--){
		Vector<Integer> c=ans.get(j);
		if(a[i]>c.get(c.size()-1)){
			Vector<Integer> clone=(Vector<Integer>) c.clone(); 
			clone.add(a[i]);
			Vector<Integer> x=new Vector<Integer>();
			
			//ans.insertElementAt(clone, j+1);
			for(int k=j-1;k>=0;k--){
				Vector<Integer> v=ans.get(k);
				if(v.size()==clone.size())
					x.add(k);
				else if(v.size()<clone.size())
					break;
			}
			for(int k=j+1;k<ans.size();k++){
				Vector<Integer> v=ans.get(k);
				if(clone.size()==v.size())
					x.add(k);
				else if(v.size()>clone.size())
					break;
			}
			ans.insertElementAt(clone,x.get(x.size()-1)+1);
			for(int k=0,l=0;k<x.size();k++,l--){
				int get=x.get(k);
				ans.remove(get-l);
			}
			break;
		}
	}
	if(i==0){
		Vector<Integer> v=new Vector<Integer>();
		v.add(a[i]);
		ans.add(v);
	}
	for(int x=0;x<ans.size();x++)System.out.println(i+" "+ans.get(x).toString());
}
System.out.println(ans.size());
StringBuilder sb=new StringBuilder();
	for(int i=0;i<ans.size();i++){
	Vector<Integer> v=ans.get(i);
	for(int j=0;j<v.size();j++){
	sb.append(v.get(j)).append(" ");	
	}
	sb.append("\n");
	}
System.out.println(sb);
}

}
