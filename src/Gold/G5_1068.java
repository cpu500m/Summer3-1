/* 2022-12-26 에 푼문제 */
// 처음에는 일반적인 트리 자료구조처럼 해볼까 생각했는데
// 그렇게 하면 노드 갯수가 최대 50개이므로
// 편향 트리를 생각했을때 2^49 만큼의 size의 배열을 잡아야하므로 이는 안하기로.
// 그래서 생각난게 누적합의 형태로 해당 노드 아래에 자식이 몇개 매달렸나 기록. 추가로 부모 노드를 기록하여
// 찾아가는 방식.
// 즉 , 최종적으로 검사할때
// 노드 아래에 매달린 자식 수로 리프노드인지를 판정. ( 자식 수가 0 일때 리프노드)
// 리프노드일 경우, 해당 노드가 삭제된 노드인지를 검사. ( is_deleted() 함수를 통해 자신부터 시작해
// 부모노드를 추적해가며 부모가 삭제되었는지를 확인.)

// 시간초과 떠서 수정필요!!

// 시간초과 이유를 생각해봤는데
// 자식 노드 개수를 증가시키는 과정에서의 연산량이 너무많음.
// 그래서 그냥 직접적으로 연결된 자식의 수만 카운트하는 방식으로 바꿔서 해결함.

package Gold;

import java.io.*;
import java.util.StringTokenizer;

class Node_info{
    private int num_of_child;
    private int parent;

    Node_info(){
        num_of_child = 0;
    }
    public void inc_num_of_child() {
        num_of_child++;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getParent() {
        return parent;
    }

    public void sub_Num_of_child() {
        this.num_of_child--;
    }

    public int getNum_of_child() {
        return num_of_child;
    }
}
public class G5_1068 {
    static Node_info[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int arr[]= new int[n];
        node =  new Node_info[n];
        int i, del_node_cnt, result = 0;
        // node 선언
        for(i = 0 ; i < n ; i++)
            node[i] = new Node_info();
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(i = 0; i < n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int del_idx = Integer.parseInt(br.readLine());
        for(i = 0 ; i < n ; i++){
            if(arr[i] == -1){
                node[i].setParent(-1);
                continue;
            }
            node[i].setParent(arr[i]);
            node[node[i].getParent()].inc_num_of_child();
        }
        del_node_cnt = node[del_idx].getNum_of_child();
        if(node[del_idx].getParent() != -1)
            node[node[del_idx].getParent()].sub_Num_of_child();
        for(i = 0 ; i < n ; i++){
            if(node[i].getNum_of_child() == 0){
                if(!is_deleted(i, del_idx))
                    result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static boolean is_deleted(int cur_idx,int del_idx){
        int cur = cur_idx;
        while(cur != -1){
            if(cur == del_idx)
                return true;
            cur = node[cur].getParent();
        }
        return false;
    }
//    static void increase_child(int cur_idx){
//        int cur = node[cur_idx].getParent();
//        while(cur != -1){
//            node[cur].inc_num_of_child();
//            cur = node[cur].getParent();
//        }
//    }
}
