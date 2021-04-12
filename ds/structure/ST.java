/* 
    Tickertape Scraper
    Copyright (C) 2020 Tarang Parikh
    
    Email : tp0265@gmail.com
    Project Home : https://github.com/tarangparikh/TickertapeScraper
    
    Original Author : @author Tarang Parikh <tp0265@gmail.com>
    
*/

public class ST {

	int size;
	public int[] data;

	public ST(int size) {
		this.size = size;
		this.data = new int[size << 1];
	}

	void build() {
		for (int i = size; i > 0; i--) {
			this.data[i] = this.data[i << 1] + this.data[i << 1 | 1];
		}
	}

	public void build(int[] data) {
		int size = data.length >> 1;
		for (int i = size - 1; i > 0; i--) {
			data[i] = data[i << 1] + data[i << 1 | 1];
		}
	}

	public void modify(int index, int value) {
		for (this.data[index += size] = value; index > 1; index >>= 1) {
			this.data[index >> 1] = this.data[index] + this.data[index ^ 1];
		}
	}

	public int query(int l, int r) {
		int res = 0;
		for (l += size, r += size; l < r; l >>= 1, r >>= 1) {
			if ((l & 1) == 1) res += this.data[l++];
			if ((r & 1) == 1) res += this.data[--r];
		}
		return res;
	}

	public int[] min(int[] a, int[] b) {
		return a[0] <= b[0] ? a : b;
	}
}
