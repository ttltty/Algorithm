package KOITP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RestArea {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.valueOf(input[0]);
		int M = Integer.valueOf(input[1]);
		int L = Integer.valueOf(input[2]);
		int[] patrol = new int[N+1];
		for(int i=0;i<patrol.length - 1;i++) {
			patrol[i] = Integer.valueOf(br.readLine());
		}
		patrol[N] = L;
		int[] result = new int[N+1];
		int count = 0;
		int tmp = M;
		for(int i=0;i<result.length;i++) {
			if(tmp < patrol[i]) {
				tmp = patrol[i-1] + M;
				count++;
			}
			result[i] = count;
		}
		System.out.println(result[N]);
	}
}
