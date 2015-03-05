//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;
//import java.util.StringTokenizer;
import java.util.TreeMap;

class ARRAYSUB {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	int n = Integer.parseInt(br.readLine());
		int n=sc.nextInt();
		// br.readLine();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		long a[] = new long[n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			a[i] =sc.nextLong();
		TreeMap<Long, Long> tm = new TreeMap<Long, Long>();
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			Long x = tm.get(a[i]);
			tm.put(a[i], x == null ? 1 : x + 1);
		}

		sb.append(tm.lastKey() + " ");
		for (int i = k, j = 0; i < n; i++, j++) {
			Long x = tm.get(a[j]);
			x = x - 1;
			if (x == 0)
				tm.remove(a[j]);
			else
				tm.put(a[j], x);
			x = tm.get(a[i]);
			tm.put(a[i], x == null ? 1 : x + 1);

			sb.append(tm.lastKey() + " ");
		}
		System.out.println(sb);
		sc.close();
	}

}
