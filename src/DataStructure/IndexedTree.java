package DataStructure;

import java.util.Arrays;

import org.junit.Test;

public class IndexedTree {

	public int[] indexedTree;
	public int[] srcArr;
	public int fromTreeIdx;
	
	public void init() {
		int n=0;
		while((1 << n) < srcArr.length) {
			n++;
		}
		indexedTree = new int[1 << (n+1)];
		for(int i=1,j=0;i<indexedTree.length && j<srcArr.length;i++) {
			indexedTree[i] = Integer.MAX_VALUE;
		}
		fromTreeIdx = 1 << n;
		int i = fromTreeIdx;
		int j = 0;
		while(j < srcArr.length) {
			update(i, srcArr[j]);
			i++;
			j++;
		}
	}
	
	public void update(int start, int target) {
		int i = 0;
		while(start > 0) {
			if(target < indexedTree[start]) {
				indexedTree[start] = target;
			}else {
				target = indexedTree[start];
			}
			start = start >> 1;
		}
	}
	
	public int query(int s, int e) {
		int rtn = Integer.MAX_VALUE;
		while(s <= e) {
			if((s & 1) == 1) {
				rtn = rtn > indexedTree[s] ? indexedTree[s] : rtn;
			}
			if((e & 1) == 0) {
				rtn = rtn > indexedTree[e] ? indexedTree[e] : rtn;
			}
			s = (s + 1) >> 1;
			e = (e - 1) >> 1;
		}
		return rtn;
	}
	
	@Test
	public void test() {
		init();
		System.out.println(Arrays.toString(indexedTree));
		System.out.println(query(fromTreeIdx + 3, fromTreeIdx + 4));
	}
}
