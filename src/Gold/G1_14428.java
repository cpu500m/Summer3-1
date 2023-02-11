package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G1_14428 {
    static class Node{
        int idx;
        int val;
        Node(int idx ,int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Node[] seg_tree = new Node[2*N];
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        make_segment_tree(arr,seg_tree,N);
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            if(act == 1){
                update_value(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), seg_tree, N);
            }
            else if(act == 2){
                long val = query(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),seg_tree,N);
                sb.append(val+"\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
    static void make_segment_tree(int[] arr, Node[] seg_tree,int N){
        for(int i = 0 ; i < N ; i++){
            seg_tree[i+N] = new Node(i+1,arr[i]);
        }

        for(int i = N-1 ; i > 0 ; i--) {
            if(seg_tree[i<<1].val > seg_tree[i<<1|1].val)
                seg_tree[i] = seg_tree[i<<1|1];
            else if(seg_tree[i<<1].val == seg_tree[i<<1|1].val){
                if(seg_tree[i<<1].idx > seg_tree[i<<1|1].idx)
                    seg_tree[i] = seg_tree[i<<1|1];
                else seg_tree[i] = seg_tree[i<<1];
            }
            else seg_tree[i] = seg_tree[i << 1];
        }
    }
    static void update_value(int idx, int value,Node[] seg_tree ,int N){

        int i = idx-1;
        seg_tree[i+=N].val = value;

        while ( (i>>=1) > 0){
            if(seg_tree[i<<1].val > seg_tree[i<<1|1].val)
                seg_tree[i] = seg_tree[i<<1|1];
            else if(seg_tree[i<<1].val == seg_tree[i<<1|1].val){
                if(seg_tree[i<<1].idx > seg_tree[i<<1|1].idx)
                    seg_tree[i] = seg_tree[i<<1|1];
                else seg_tree[i] = seg_tree[i<<1];
            }
            else seg_tree[i] = seg_tree[i << 1];
        }
    }
    static int query(int left ,int right , Node[] seg_tree, int N){

        int l = left-1 , r = right;
        Node result = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for(l+=N , r+=N ; l != r ; l>>=1 , r>>=1){

            if(l % 2 == 1) {
                if(result.val > seg_tree[l++].val)
                    result = seg_tree[l-1];

                else if(result.val == seg_tree[l-1].val)
                    if(result.idx > seg_tree[l-1].idx)
                        result = seg_tree[l-1];
            }
            if(r % 2 == 1) {
                if (result.val > seg_tree[--r].val)
                    result = seg_tree[r];
                else if(result.val == seg_tree[r].val)
                    if(result.idx > seg_tree[r].idx)
                        result = seg_tree[r];
            }
        }
        return result.idx;
    }
}
