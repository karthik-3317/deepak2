	package Question3;
	import java.util.*;
	import java.lang.*;
	import java.io.*;
	public class pairing{
	int nan;
	int distance;
	pairing(int nan,int distance){
	this.nan=nan;
	this.distance=distance;
	}
	}
	class Magic{
	static int nan;
	static ArrayList<pairing> adj[]=new ArrayList[100005];
	public static void main (String[] args) throws java.lang.Exception{
	Scanner sc=new Scanner(System.in);
	nan=sc.nextInt();
	int mam=sc.nextInt();
	for(int i=1;i<=nan;i++){
	adj[i]=new ArrayList<>();
	}
	for(int i=0;i<mam;i++){
	int u=sc.nextInt();
	int v=sc.nextInt();
	adj[u].add(new pairing(v,0) );
	adj[v].add(new pairing(u,1) );
	}
	min(1);
	}
	public static void min(int src){
	int[] dist=new int[nan+1];
	for(int i=1;i<=nan;i++){
	dist[i]=Integer.MAX_VALUE;
	}
	dist[src]=0;
	Deque<pairing> dq=new ArrayDeque<>();
	dq.addFirst(new pairing(src,0) );
	while(!dq.isEmpty() ){
	pairing fr=dq.removeFirst();
	int nan=fr.nan;
	int distance=fr.distance;
	for(pairing x: adj[nan]){
	int nd=x.nan;
	int ds=x.distance;
	if(ds+distance<dist[nd] ){
	dist[nd]=ds+distance;
	if(ds==0){
	dq.addFirst(new pairing(nd,dist[nd] ) );
	}else{
	dq.addLast(new pairing(nd,dist[nd] ) );
	}
	}
	}
	}
	if(dist[nan]==Integer.MAX_VALUE ){
	System.out.println(-1);
	return;
	}
	System.out.println(dist[nan] );
	}
	}