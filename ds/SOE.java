import java.util.ArrayList;
import java.util.Arrays;

class SOE {

	private final boolean[] prime;
	private final int size;
	private final int[] data;

	public int[] getData() {
		return data;
	}

	public SOE(int size) {
		this.size = size;
		this.prime = new boolean[size + 1];
		Arrays.fill(this.prime, true);
		this.data = makeData();
	}

	private int[] makeData() {
		int count = this.prime.length;
		for (int p = 2; p * p <= this.size; p++) {
			// If prime[p] is not changed, then it is a prime
			if (prime[p]) {
				// Update all multiples of p
				for (int i = p * p; i <= this.size; i += p) prime[i] = false;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 2, h = this.prime.length; i < h; i++) {
			if (this.prime[i]) {
				list.add(i);
			}
		}
		return list.stream().mapToInt(value -> value).toArray();
	}
}
