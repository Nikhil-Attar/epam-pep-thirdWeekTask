import java.util.*;

public class StatisticsOfString {
	static int power(int a, int b, int mod) {
		if (b == 0)
			return 1;
		int p = power(a, b / 2, mod);
		p = (int) ((long) p * p % mod);
		if (b % 2 == 1)
			p = (int) ((long) p * a % mod);
		return p;
	}

	static int[] arr;

	static int find(int i) {
		return arr[i] < 0 ? i : (arr[i] = find(arr[i]));
	}

	static boolean join(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return false;
		if (arr[i] > arr[j])
			arr[i] = j;
		else {
			if (arr[i] == arr[j])
				arr[i]--;
			arr[j] = i;
		}
		return true;
	}

	static int simplify(int k, int v, int n, int a, int mod) {
		Arrays.fill(arr, -1);
		int bcnt = 0, count = n;
		for (int i = 1; i < n; i++)
			if ((v & 1 << i) > 0) {
				for (int j = i; j < i + k; j++)
					if (join(j, j - i))
						count--;
				bcnt++;
			}
		int sum = power(a, count, mod);
		return bcnt % 2 == 1 ? sum : (mod - sum) % mod;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int mod = sc.nextInt();
		arr = new int[n];
		int sum = 0;
		for (int k = 1; k < n; k++)
			for (int v = 2; v < 1 << n - k + 1; v += 2)
				sum = (sum + simplify(k, v, n, a, mod)) % mod;
		System.out.println(sum);
	}
}