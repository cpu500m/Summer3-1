package Platinum;

import java.io.*;
import java.util.StringTokenizer;

public class P3_12895 {
    // 내부 값으로 비트 마스킹한 ( 최대 30Bit까지만 유효비트로 사용하는) 값을 가질 예정
    static int[] seg_tree;
    static int[] lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int Q= Integer.parseInt(st.nextToken());

        seg_tree = new int[N<<2];
        lazy = new int[N<<2];

        // 처음에 모든집을 1번 색으로 칠해놓고 시작한다.
        for(int i = 1 ; i<= N ; i++)
            update(1,1,N,i,i,1);

        for(int i = 0 ; i < Q ; i++){
            st = new StringTokenizer(br.readLine());
            char act = st.nextToken().charAt(0);
            if(act == 'C'){
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if( l > r){
                    int temp =l;
                    l = r;
                    r = temp;
                }
                int c = Integer.parseInt(st.nextToken());
                update(1,1,N,l,r,1<<(c-1));
            }
            else{
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if( l > r){
                    int temp =l;
                    l = r;
                    r = temp;
                }
                int val = query(1,1,N,l,r);
                int res = 0;
                for(int j = 0 ; j < T ; j++){
                    if( ((val>>j) & 1) != 0)
                        res++;
                }
                sb.append(res+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void update(int n, int s, int e ,int i , int j , int d){
        if(lazy[n] != 0){
            if( s!=e){
                lazy[n*2] = lazy[n];
                lazy[n*2|1] = lazy[n];
            }
            seg_tree[n] = lazy[n];
            lazy[n] = 0;
        }
        if(j < s || e < i) return ;
        if( i<= s && e <=j){
            lazy[n] = d;
            if( s!=e){
                lazy[n*2] = lazy[n];
                lazy[n*2|1] = lazy[n];
            }
            seg_tree[n] = lazy[n];
            lazy[n] = 0;
            return ;
        }

        int mid = (s+e)>>1;
        update(n*2,s,mid,i,j,d);
        update(n*2|1,mid+1,e,i,j,d);
        seg_tree[n] = seg_tree[n*2] | seg_tree[n*2|1];
    }

    public static int query(int n , int s,int e ,int i ,int j ){
        if(lazy[n] != 0){
            if( s!=e){
                lazy[n*2] = lazy[n];
                lazy[n*2|1] = lazy[n];
            }
            seg_tree[n] = lazy[n];
            lazy[n] = 0;
        }
        if(j < s || e < i) return 0;
        if( i<= s && e <=j){
            return seg_tree[n];
        }

        int mid = (s+e)>>1;
        int l = query(n*2,s,mid,i,j);
        int r = query(n*2|1,mid+1,e,i,j);
        return l | r;
    }
}
