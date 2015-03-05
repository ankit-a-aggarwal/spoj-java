import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class PARTY {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Budget = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (Budget == 0 && n == 0)
				break;
			int price[] = new int[n + 1];
			int fun[] = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				price[i] = Integer.parseInt(st.nextToken());
				fun[i] = Integer.parseInt(st.nextToken());
			}
			int ans[][] = new int[n + 1][Budget + 1];
			boolean keep[][] = new boolean[n + 1][Budget + 1];
			for (int i = 1; i < ans.length; i++) {
				for (int j = 1; j < ans[i].length; j++) {
					if (price[i] > j) {
						ans[i][j] = ans[i - 1][j];
					} else {
						ans[i][j] = Math.max(ans[i - 1][j], fun[i] + ans[i - 1][j - price[i]]);
						if (fun[i] + ans[i - 1][j - price[i]] >= ans[i - 1][j])
							keep[i][j] = true;
					}
				}
			}
			int answer = ans[n][Budget];
			// System.out.println(answer+" a");
			/*
			 * for(int i=1;i<ans.length;i++){ for(int j=1;j<ans[i].length;j++){
			 * System.out.print(keep[i][j]+" "); } System.out.println(); }
			 */

			int cost, min_cost = Integer.MAX_VALUE;
			 for (int i = n; i >= 1; i--) {
				
				int K = Budget, j = Budget;
				for (; j >= 1; j--) {
					if (ans[i][j] == answer) {
						K=j;cost=0;
						//System.out.println(i+" "+j);
						for (int x = i; x >= 1; x--) {
							if (keep[x][K]) {
								//System.out.println(x+" "+K);
								K -= price[x];
								cost += price[x];
							}
						}
						min_cost = Math.min(cost, min_cost);
						
					}
				}
				// System.out.println(cost);
				
			}
			//System.out.println(count);
			sb.append(min_cost + " " + ans[n][Budget] + "\n");
			br.readLine();
		}
		System.out.println(sb);
	}

}
