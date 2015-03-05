import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class AGGRCOW {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int a[] = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(a);
			sb.append(binarySearch(a, K)+"\n");
		}
		System.out.println(sb);
	}

	public static int binarySearch(int a[], int K) {
		int low = 0, high = a[a.length - 1], mid = low + (high - low) / 2;
		while (low < high) {
			mid=low+(high-low+1)/2;
			if(find(a, mid, K)){
				low=mid;
			}
			else{
				high=mid-1;
			}
		}
		return low;
	}

	public static boolean find(int a[], int x, int K) {
		int last_pos = 0;
		int cows_placed = 1;
		for (int i = 1; i < a.length; i++) {

			if (a[i] - a[last_pos] >= x) {
				cows_placed++;
				last_pos=i;
			}
			if (cows_placed == K)
				return true;
			}
		return false;
	}
}
