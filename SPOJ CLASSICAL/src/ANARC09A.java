import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ANARC09A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (true) {
			String s = br.readLine();
			if (s.contains("-"))
				break;
			int changed = 0;
			int closed = 0, open = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				char x = s.charAt(i);
				if (x == '}') {
					closed++;
				} else {
					if (closed > 0)
						closed--;
					else if (open == 0) {
						open++;
						changed += open;
					} else {
						open = 0;
					}
				}
			}
			if (closed > 0)
				changed += Math.ceil(closed/2.0);
			sb.append(t++ + ". " + changed + "\n");
		}
		System.out.println(sb);
	}

}
