import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ACPC10D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = 1;
		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine().trim());
			if (N == 0)
				break;
			long cost[][] = new long[N][3];
			// long cost[][]=new long[N][3];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 3; j++) {
					cost[i][j] = Long.parseLong(st.nextToken());
				}
			}
			// cost[0][0]=cost[0][0];
			// cost[0][1]=cost[0][1];
			cost[0][2] += cost[0][1];
			cost[1][0] += cost[0][1];
			cost[1][1] += Math.min(cost[1][0], Math.min(cost[0][1], cost[0][2]));
			cost[1][2] += Math.min(cost[0][1], Math.min(cost[0][2],cost[1][1]));
			for (int i = 2; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					if (j == 0) {
						cost[i][j] += Math.min(cost[i - 1][j], cost[i - 1][j + 1]);
					} else if (j == 1) {
						cost[i][j] += Math.min(cost[i][j - 1],
								Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i - 1][j + 1])));
					} else {
						cost[i][j] += Math.min(cost[i - 1][j], Math.min(cost[i][j - 1], cost[i - 1][j - 1]));
					}
				}
			}
			/*
			 * for(int i=0;i<N;i++){ for(int j=0;j<3;j++){
			 * System.out.print(cost[i][j]+" "); } System.out.println(); }
			 */
			sb.append(test++ + ". " + cost[N - 1][1] + "\n");
		}

		System.out.println(sb);
	}

}
