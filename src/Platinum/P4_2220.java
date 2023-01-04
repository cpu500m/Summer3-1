// 최대 힙 관련 문제인데
// 처음에는 그냥 n을 점점 늘려나가며 swap 횟수가 최대인 힙이 어떤 형태를 띄고 있는지 봤음.
// 근데 아무리 생각해도 해결 방법을 찾을 수 가 없어서 다른 방법을 생각.
// sawp횟수가 최대인 n = 6 일때의 힙을 가지고 힙정렬을 수행해 보았는데
// 매번 마지막 노드 값이 1이고 하나를 빼고
// swap과정을 수행하고 나면 n-1일때의 swap횟수 최대인 최대 힙이었음.
// 그래서 n = 1부터 늘려나가는데
// n+1인 애를 넣고 , 1과 위치를 바꾸고 , 그리고 최대힙을 구성하면 swap 횟수가 최대인 힙이 나올거 같음. 그대로 해봄.
// 근데 안돼서 왜 안되지 하고 한참생각했는데
// 부모노드 인덱스 잡을때 cur_node 값이 아닌 heap_size 값을 가지고 잡아서 그랬음 ; 디버거 돌려 꺠달음

package Platinum;

import java.io.*;

public class P4_2220 {
    static int[] heap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // index
        int i;
        int n = Integer.parseInt(br.readLine());
        // 힙
        heap = new int[n+1];
        int cur_size = 1;
        heap[1] = 1;
        for(i = 1 ; i < n; i++) {
            heap[i] = i+1;
            heap[i+1] = 1;
            cur_size++;
            build_heap(cur_size);
        }
        for(i = 1; i <= n ; i++)
            bw.write(heap[i]+" ");
        bw.flush();
    }
    static void build_heap(int heap_size){
        int cur_node = heap_size-1;
        int parent = cur_node/2;
        int temp;
        // 루트 노드부터 바꿔치기 수행.
        while( parent > 0){
            temp = heap[cur_node];
            heap[cur_node] = heap[parent];
            heap[parent] = temp;
            cur_node = parent;
            parent = cur_node/2;
        }
    }
}
