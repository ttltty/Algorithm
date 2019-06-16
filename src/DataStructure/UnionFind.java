package DataStructure;
import org.junit.Test;

public class UnionFind {

	
	public int[] set = new int[101];
	
	public void init() {
		for(int i=0;i<set.length;i++) {
			set[i] = i;
		}
	}
	
	public void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A != B) set[A] = B;
	}
	
	public int find(int n) {
		if(set[n] == n) return set[n];
		else return set[n] = find(set[n]);
	}
	
	public boolean connect(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A == B) return true;
		else return false;
	}
	
	@Test
	public void test() {
		init();
		int[][] input = new int[][] {{1, 2}, {2, 3}, {2, 4}, {5, 6}, {8, 6}};
		for(int i=0;i<input.length;i++) {
			union(input[i][0], input[i][1]);
		}
		
		System.out.println(connect(1, 4));
		System.out.println(find(2));
		System.out.println(find(3));
		System.out.println(find(8));
		System.out.println(connect(1, 8));
		union(1, 5);
		System.out.println(connect(1, 8));
		System.out.println(find(8));
	}
	
}
