import java.io.*;
import java.util.*;

class Solution {

	static int A = 123456789, L = 9;
	static boolean isPrime[];
	static HashMap<Integer, Integer> map;

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static int getKey(int[][] arr) {
		int x = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				x = x * 10 + arr[i][j];
			}
		}
		return x;
	}

	static int comp(int[] arr) {
		int i = 0;
		for (int j = 0; j < L; j++) {
			i = i * 10 + arr[j];
		}
		return i;
	}

	static int[] decomp(int x) {
		int[] arr = new int[L];
		for (int i = L - 1; i >= 0; i--) {
			arr[i] = x % 10;
			x /= 10;
		}
		return arr;
	}

	static void graph() {
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		map.put(A, 0);
		while (q.size() > 0) {
			int a = q.remove();
			int s = map.get(a);
			int[] arr = decomp(a);
			for (int i = 0; i < L - 1; i++) {
				int x = arr[i] + arr[i + 1];
				if (isPrime[x] && i != 2 && i != 5) {
					swap(arr, i, i + 1);
					int n = comp(arr);
					if (!map.containsKey(n)) {
						map.put(n, s + 1);
						q.add(n);
					}
					swap(arr, i, i + 1);
				}
				if (i < 6) {
					x = arr[i] + arr[i + 3];
					if (isPrime[x]) {
						swap(arr, i, i + 3);
						int n = comp(arr);
						if (!map.containsKey(n)) {
							map.put(n, s + 1);
							q.add(n);
						}
						swap(arr, i, i + 3);
					}
				}
			}
		}
	}

	static void init() {
		isPrime = new boolean[20];
		for (int i = 2; i < 20; i++) {
			boolean f = true;
			for (int j = 2; j < i; j++) {
				if (isPrime[j] && i % j == 0) {
					f = false;
					break;
				}
			}
			isPrime[i] = f;
		}
		map = new HashMap<>();
		graph();
	}

	public static int solve(List<List<Integer>> d) {
		init();
		int[] arr = new int[9];
		int k = 0;
		for (List<Integer> l : d) {
			for (int e : l) {
				arr[k++] = e;
			}
		}
		int key = comp(arr);
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return -1;
		}
	}

	void solve() throws IOException {
		BufferedReader bf = new BufferedReader(
			new InputStreamReader(System.in)
		);
		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			String[] d = bf.readLine().split(" ");
			List<Integer> s = new ArrayList<>();
			for (String e : d) {
				s.add(Integer.parseInt(e));
			}
			l.add(s);
		}
		System.out.println(solve(l));
	}

	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
