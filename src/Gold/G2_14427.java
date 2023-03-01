// 세그먼트 트리 상위호환 냄새가 솔솔나는 펜윅트리 ㄱㄱㄱ

// 아근데 직접 해보니깐 그냥 이거 구간합 구하기 원툴이다
// 예를들어서 3~16 구간에 대해 가장 작은 값을 가지는 엔덱스를 찾겠다 라고 쿼리를 던지면
// 이거는 만약에 4번 인덱스가 최소값을 가지는데 1,2번 인덱스가 더 작아서 묻힌경우
// 뭐 이런 경우에 아예 대처가안됨. 뭐 복잡하게 풀면은 (다른 거 몇개 더쓰고 그러면은) 풀어 낼 수 는 있겠지만
// 그럴바에 그냥 차라리 세그먼트트리 쓰지;
// 걍 앞으로는 세그먼트 트리를 쓰자..,
package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G2_14427 {
    static class Node{
        int idx;
        int val;
        Node(){
            val = Integer.MAX_VALUE;
        }
    }
    static Node[] seg_tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        seg_tree = new Node[N<<2];

        // 세그먼트 트리 생성
        make_seg_tree();

        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++)
            update(1,1,N,i,Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int act= Integer.parseInt(st.nextToken());
            if(act ==1){
                int idx = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                update(1,1,N,idx,v);
            }
            else{
                int res = seg_tree[1].idx;
                sb.append(res+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void make_seg_tree(){
        for(int i = 0 ; i < seg_tree.length ; i++)
            seg_tree[i] = new Node();
    }

    static void update(int n ,int s ,int e ,int i , int v){
        if( i < s || e < i) return;
        if( s == e){
            seg_tree[n].val = v;
            seg_tree[n].idx = i;
            return ;
        }

        int mid = (s+e)>>1;
        if( i <= mid)
            update(n*2,s,mid,i,v);
        else update(n*2|1,mid+1,e,i,v);
        seg_tree[n] = merge(seg_tree[n*2], seg_tree[n*2|1]);
    }
    static Node merge(Node l ,Node r){
        if( l.val < r.val)
            return l;
        else if( l.val == r.val){
            if(l.idx < r.idx)
                return l;
        }
        return r;
    }
//    static Node query(int n ,int s , int e ,int i ,int j){
//        if(j < s || e < i) return seg_tree[0];
//        if( i<= s && e<= j){
//            return seg_tree[n];
//        }
//
//        int mid = (s+e)>>1;
//        Node l = query(n*2, s,mid,i,j);
//        Node r = query(n*2|1,mid+1,e,i,j);
//        return merge(l,r);
//    }
}

// 아래는 펜윅트리 직접 구현해보다가 단점을 체감한 코드
    /*
    static class Node{
        int idx;
        int val;
        Node(){
            idx = -1;
            val = Integer.MAX_VALUE;
        }
    }

    static Node[] fenwick_tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        fenwick_tree = new Node[N+1];
        for(int i = 0 ; i < N+1 ; i++)
            fenwick_tree[i] = new Node();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            update(i+1,Integer.parseInt(st.nextToken()));
    }

    // 펜윅트리 업데이트
    static void update(int i, int v){
        int start_idx = i;
        // 상위 구간으로 계속해서 올라가면서 갱신해준다.
        while ( i < fenwick_tree.length){
            if(fenwick_tree[i].val > v){
                fenwick_tree[i].idx = start_idx;
                fenwick_tree[i].val = v;
            }
            else if( fenwick_tree[i].val == v)
                fenwick_tree[i].idx = Math.min(fenwick_tree[i].idx , start_idx);
            i += ( i & -i);
        }
    }
    // s~e 구간에 대한 쿼리를 던진다..
    // 이는 ,.,,, 흠
    // 3~ 14 구간에 퀴리를 던졌다고 치면...
    // 일단 14를 이진수로 변환해서 1110 -> 1100 -> 1000 에 대해서 가장 작은 값을 가진 인덱스를 찾겠지?
    //
    static int query(int s ,int e){
        int res = 0;
        while ()
    }
    */
