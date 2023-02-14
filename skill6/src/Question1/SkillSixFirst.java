	package Question1;
	import java.io.OutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.io.FilterInputStream;
	import java.io.BufferedInputStream;
	import java.math.BigInteger;
	import java.io.InputStream;
	public class SkillSixFirst {
	public static void main(String[] ARGS) {
	new Thread(null, new Runnable() {
	public void run() {
	new SkillSixFirst().solve();
	}
	}, "1", 1 << 26).start();
	}
	void solve() {
	InputStream IS = System.in;
	OutputStream OS = System.out;
	ScanReader in = new ScanReader(IS);
	PrintWriter out = new PrintWriter(OS);
	CountingBipartiteGraphs countingbipartitegraphs = new CountingBipartiteGraphs();
	countingbipartitegraphs.solve(1, in, out);
	out.close();
	}
	static class CountingBipartiteGraphs {
	long mod = 998244353;
	long[] Cr;
	int n;
	int m;
	public void solve(int testNumber, ScanReader in, PrintWriter out) {
	n = in.scanInt();
	m = in.scanInt();
	Cr = new long[n + 1];
	// pre();
	Cr[0] = 1;
	Cr[1] = n;
	long ans = 0;
	long power = CodeX.power(2, n, mod);
	long modin = CodeX.modinverse(2, mod) % mod;
	for (int i = 0; i <= n; i++) {
	if (i >= 2) {
	Cr[i] = ((Cr[i - 1] % mod) * ((n - i + 1) % mod)) % mod;
	Cr[i] = (Cr[i] * modInverse(i, mod)) % mod;
	}
	long temp = (power - 1);
	temp = mod(temp);
	temp = CodeX.power(temp, m, mod);
	temp = mod(temp);
	temp = ((temp % mod) * Cr[i]) % mod;
	if (i % 2 == 0) ans = (ans + temp);
	else ans = (ans - temp);
	ans = mod(ans);
	power = ((power % mod) * modin);
	power = mod(power);
	}
	System.out.println(ans);
	}
	long mod(long n) {
	if (n < 0) {
	return (n + mod);
	} else {
	return (n % mod);
	}
	}
	static long modInverse(long a, long m) {
	long m0 = m;
	long y = 0, x = 1;
	if (m == 1)
	return 0;
	while (a > 1) {
	long q = a / m;
	long t = m;
	m = a % m;
	a = t;
	t = y;
	y = x - q * y;
	x = t;
	}
	if (x < 0)
	x += m0;
	return x;
	}
	}
	static class ScanReader {
	private byte[] buf = new byte[4 * 1024];
	private int index;
	private BufferedInputStream in;
	private int Total_Char;
	public ScanReader(InputStream inputStream) {
	in = new BufferedInputStream(inputStream);
	}
	private int scan() {
	if (index >= Total_Char) {
	index = 0;
	try {
	Total_Char = in.read(buf);
	} catch (Exception e) {
	e.printStackTrace();
	}
	if (Total_Char <= 0) return -1;
	}
	return buf[index++];
	}
	public int scanInt() {
	int integer = 0;
	int n = scan();
	while (isWhiteSpace(n)) n = scan();
	int neg = 1;
	if (n == '-') {
	neg = -1;
	n = scan();
	}
	while (!isWhiteSpace(n)) {
	if (n >= '0' && n <= '9') {
	integer *= 10;
	integer += n - '0';
	n = scan();
	}
	}
	return neg * integer;
	}
	private boolean isWhiteSpace(int n) {
	if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
	else return false;
	}
	}
	static class CodeX {
	public static long modinverse(long a, long b) {
	BigInteger temp = BigInteger.valueOf(a);
	temp = temp.modInverse(BigInteger.valueOf(b));
	return temp.longValue();
	}
	public static long power(long x, long y, long p) {
	long res = 1;
	x = x % p;
	while (y > 0) {
	if ((y & 1) != 0)
	res = (res * x) % p;
	y = y >> 1;
	x = (x * x) % p;
	}
	return res;
	}
	}
	}