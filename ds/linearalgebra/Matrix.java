import java.util.Arrays;

public class Matrix {

	public static long mod = 1_000_000_007;

	public static long[][] matrixAdd(long[][] a, long[][] b) {
		int n = a.length;
		int m = a[0].length;
		long[][] res = new long[n][m];
		for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) res[i][j] =
			(a[i][j] + b[i][j]) % mod;
		return res;
	}

	public static long[][] matrixMul(long[][] a, long[][] b) {
		int n = a.length;
		int m = a[0].length;
		int k = b[0].length;
		long[][] res = new long[n][k];
		for (int i = 0; i < n; i++) for (int j = 0; j < k; j++) for (
			int p = 0;
			p < m;
			p++
		) res[i][j] = (res[i][j] + (a[i][p] * b[p][j]) % mod) % mod;
		return res;
	}

	public static long[][] matrixPow(long[][] a, long p) {
		if (p == 0) return matrixUnit(a.length); else if (
			p % 2 == 0
		) return matrixPow(matrixMul(a, a), p / 2); else return matrixMul(
			a,
			matrixPow(a, p - 1)
		);
	}

	public static long[][] matrixSumPow(long[][] a, long p) {
		int n = a.length;
		if (p == 0) {
			return new long[n][n];
		}
		if (p % 2 == 0) {
			return matrixMul(
				matrixSumPow(a, p / 2),
				matrixAdd(matrixUnit(n), matrixPow(a, p / 2))
			);
		} else {
			return matrixAdd(a, matrixMul(matrixSumPow(a, p - 1), a));
		}
	}

	public static long[][] matrixUnit(int n) {
		long[][] res = new long[n][n];
		for (int i = 0; i < n; ++i) {
			res[i][i] = 1;
		}
		return res;
	}
}
