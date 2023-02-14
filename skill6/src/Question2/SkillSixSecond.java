	package Question2;
	
	import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.Arrays;
	import java.util.InputMismatchException;
	
	public class SkillSixSecond {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	void solve()
	{
	int n = ni();
	int m = ni(), f = ni();
	int[] from = new int[m];
	int[] to = new int[m];
	for (int i = 0; i < m; i++) {
	from[i] = ni() - 1;
	to[i] = ni() - 1;
	}
	int[][] g = packU(n, from, to);
	int[][] cc = decomposeToCC(g);
	int[][][] cgs = split(g, cc[0], cc[1], cc[2]);
	long ans = 0;
	for(int[][] cg : cgs){
	ans = Math.max(ans, solve(f, cg));
	}
	out.println(ans);
	}
	long solve(int f, int[][] cg)
	{
	if(cg.length == 1)return 1;
	int[] dia = diameter(cg);
	if(f > dia[0])return 1;
	return dia[0]/f+1;
	}
	public static int[] diameter(int[][] g)
	{
	int n = g.length;
	int f0 = -1, f1 = -1, d01 = -1;
	int[] q = new int[n];
	boolean[] ved = new boolean[n];
	{
	int qp = 0;
	q[qp++] = 0; ved[0] = true;
	for(int i = 0;i < qp;i++){
	int cur = q[i];
	for(int e : g[cur]){
	if(!ved[e]){
	ved[e] = true;
	q[qp++] = e;
	continue;
	}
	}
	}
	f0 = q[n-1];
	}
	{
	int[] d = new int[n];
	int qp = 0;
	Arrays.fill(ved, false);
	q[qp++] = f0; ved[f0] = true;
	for(int i = 0;i < qp;i++){
	int cur = q[i];
	for(int e : g[cur]){
	if(!ved[e]){
	ved[e] = true;
	q[qp++] = e;
	d[e] = d[cur] + 1;
	continue;
	}
	}
	}
	f1 = q[n-1];
	d01 = d[f1];
	}
	return new int[]{d01, f0, f1};
	}
	public static int[][] decomposeToCC(int[][] g)
	{
	int n = g.length;
	DJSet ds = new DJSet(n);
	for(int i = 0;i < n;i++){
	for(int e : g[i])ds.union(i, e);
	}
	int[] clus = new int[n];
	int[] inds = new int[n];
	Arrays.fill(clus, -1);
	int p = 0;
	for(int i = 0;i < n;i++){
	if(ds.upper[i] < 0)clus[i] = p++;
	}
	int[] counts = new int[p];
	for(int i = 0;i < n;i++){
	if(ds.upper[i] >= 0)clus[i] = clus[ds.root(i)];
	inds[i] = counts[clus[ds.root(i)]]++;
	}
	return new int[][]{clus, inds, counts};
	}
	public static int[][][] split(int[][] g, int[] clus, int[]
	inds, int[] counts)
	{
	int m = counts.length;
	int[][][] xg = new int[m][][];
	for(int i = 0;i < m;i++){
	xg[i] = new int[counts[i]][];
	}
	for(int i = 0;i < g.length;i++){
	int ci = clus[i];
	int ii = inds[i];
	xg[ci][ii] = new int[g[i].length];
	for(int j = 0;j < g[i].length;j++){
	xg[ci][ii][j] = inds[g[i][j]];
	}
	}
	return xg;
	}
	public static class DJSet {
	public int[] upper;
	public DJSet(int n) {
	upper = new int[n];
	Arrays.fill(upper, -1);
	}
	public int root(int x) {
	return upper[x] < 0 ? x : (upper[x] =
	root(upper[x]));
	}
	public boolean equiv(int x, int y) {
	return root(x) == root(y);
	}
	public boolean union(int x, int y) {
	x = root(x);
	y = root(y);
	if (x != y) {
	if (upper[y] < upper[x]) {
	int d = x;
	x = y;
	y = d;
	}
	upper[x] += upper[y];
	upper[y] = x;
	}
	return x == y;
	}
	public int count() {
	int ct = 0;
	for (int u : upper)
	if (u < 0)
	ct++;
	return ct;
	}
	}
	public static int[][] parents3(int[][] g, int root) {
	int n = g.length;
	int[] par = new int[n];
	Arrays.fill(par, -1);
	int[] depth = new int[n];
	depth[0] = 0;
	int[] q = new int[n];
	q[0] = root;
	for (int p = 0, r = 1; p < r; p++) {
	int cur = q[p];
	for (int nex : g[cur]) {
	if (par[cur] != nex) {
	q[r++] = nex;
	par[nex] = cur;
	depth[nex] = depth[cur] + 1;
	}
	}
	}
	return new int[][] { par, q, depth };
	}
	static int[][] packU(int n, int[] from, int[] to) {
	int[][] g = new int[n][];
	int[] p = new int[n];
	for (int f : from)
	p[f]++;
	for (int t : to)
	p[t]++;
	for (int i = 0; i < n; i++)
	g[i] = new int[p[i]];
	for (int i = 0; i < from.length; i++) {
	g[from[i]][--p[from[i]]] = to[i];
	g[to[i]][--p[to[i]]] = from[i];
	}
	return g;
	}
	void run() throws Exception
	{
	is = INPUT.isEmpty() ? System.in : new
	ByteArrayInputStream(INPUT.getBytes());
	out = new PrintWriter(System.out);
	long s = System.currentTimeMillis();
	solve();
	out.flush();
	if(!INPUT.isEmpty())tr(System.currentTimeMillis()-
	s+"ms");
	}
	public static void main(String[] args) throws Exception {
	new SkillSixSecond().run();
	}
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	private int readByte()
	{
	if(lenbuf == -1)throw new InputMismatchException();
	if(ptrbuf >= lenbuf){
	ptrbuf = 0;
	try { lenbuf = is.read(inbuf); } catch (IOException
	e) { throw new InputMismatchException(); }
	if(lenbuf <= 0)return -1;
	}
	return inbuf[ptrbuf++];
	}
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <=
	126); }
	private int skip() {
		int b; while((b = readByte()) != -1 &&
		isSpaceChar(b));
		return b; 
		}
	private double nd() 
	{ 
		return Double.parseDouble(ns()); 
	}
	private char nc() { return (char)skip(); }
	private String ns()
	{
	int b = skip();
	StringBuilder sb = new StringBuilder();
	while(!(isSpaceChar(b))){ // when nextLine,
	sb.appendCodePoint(b);
	b = readByte();
	}
	return sb.toString();
	}
	private char[] ns(int n)
	{
	char[] buf = new char[n];
	int b = skip(), p = 0;
	while(p < n && !(isSpaceChar(b))){
	buf[p++] = (char)b;
	b = readByte();
	}
	return n == p ? buf : Arrays.copyOf(buf, p);
	}
	private char[][] nm(int n, int m)
	{
	char[][] map = new char[n][];
	for(int i = 0;i < n;i++)map[i] = ns(m);
	return map;
	}
	private int[] na(int n)
	{
	int[] a = new int[n];
	for(int i = 0;i < n;i++)a[i] = ni();
	return a;
	}
	private int ni()
	{
	int num = 0, b;
	boolean minus = false;
	while((b = readByte()) != -1 && !((b >= '0' && b <= '9')
	|| b == '-'));
	if(b == '-'){
	minus = true;
	b = readByte();
	}
	while(true){
	if(b >= '0' && b <= '9')
	num = num * 10 + (b - '0');
	else
	return minus ? -num : num;
	b = readByte();
	}
	}
	private long nl()
	{
	long num = 0;
	int b;
	boolean minus = false;
	while((b = readByte()) != -1 && !((b >= '0' && b <= '9')
	|| b == '-'));
	if(b == '-'){
	minus = true;
	b = readByte();
	}
	while(true){
	if(b >= '0' && b <= '9'){
	num = num * 10 + (b - '0');
	}else{
	return minus ? -num : num;
	}
	b = readByte();
	}
	}
	private static void tr(Object... o)
	{
	System.out.println(Arrays.deepToString(o));
	}
	}