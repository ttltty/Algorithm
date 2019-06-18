package POJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class POJ2236 {
	
	public static int N, D;
	public static int[][] nodes;
	public static int[] set, visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		D = Integer.valueOf(st.nextToken());
		nodes = new int[N+1][2];
		set = new int[N+1];
		visited = new int[N+1];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			nodes[i][0] = Integer.valueOf(st.nextToken());
			nodes[i][1] = Integer.valueOf(st.nextToken());
			set[i] = i;
		}
		int tmp = 0;
		int cnt = 1;
		while(br.ready()) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("O")) {
				tmp = Integer.valueOf(st.nextToken());
				visited[cnt] = tmp; 
				cnt++;
				for(int j=1;j<cnt;j++) {
					if(tmp != visited[j] && withinDist(nodes[tmp], nodes[visited[j]])) {
						union(tmp, visited[j]);
					}
				}
			}else {
				if(connect(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()))) {
					System.out.println("SUCCESS");
				}else {
					System.out.println("FAIL");
				}
			}
		}
		
	}
	
	public static boolean withinDist(int[] node1, int[] node2) {
		int x = node1[0] - node2[0];
		int y = node1[1] - node2[1];
		if(x * x + y * y <= D * D) return true;
		else return false;
	}
	
	public static int find(int n) {
		if(n == set[n]) return set[n];
		else return set[n] = find(set[n]);
	}
	
	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A != B) set[A] = B;
	}
	
	public static boolean connect(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A == B) return true;
		else return false;
	}

}
