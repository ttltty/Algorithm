package POJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class POJ3061 {

	public static int N, S, answer;
	public static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.valueOf(st.nextToken());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.valueOf(st.nextToken());
			S = Integer.valueOf(st.nextToken());
			
			input = new int[N];
			answer = Integer.MAX_VALUE;
			int a = 0, b = 0;
			
			st = new StringTokenizer(br.readLine());
			int tmp = 0;
			int cnt = 0;
			
			for(int i=0;i<N;i++) {
				input[i] = Integer.valueOf(st.nextToken());
				tmp += input[i];
				b++;
				while(tmp >= S) {
					cnt = b - a;
					if(cnt < answer) {
						answer = cnt;
					}
					tmp -= input[a];
					a++;
				}
			}
			answer = answer == Integer.MAX_VALUE ? 0 : answer;
			System.out.println(answer);
		}
	}
}
