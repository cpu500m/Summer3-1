/* 2022-06-28 12번째로 푼 문제 */
// 가장 먼저 생각나는 방법은 그냥 for문 2번 돌려서
// 열 인덱스 작은거부터 비어있는지 보고 비어있으면 거기다가 연결하고 그런식으로
// 하면 안되나? 임. ( 현재 row 인덱스를 기준으로 +-1 위치의 인덱스를 보면서 진행)
// 시간복잡도를 조금 생각해봤는데 외부 loop는 row갯수만큼 돌아야하고
// 내부 루프는 column 개수만큼 돌아야하니까
// 10,000*500 = 5,000,000
// 그렇게 나쁘진 않아보임. 일단 한번 이렇게 해봄
// 하면 느낀건데 row 인덱스 0번을 추가할 필요가 있음. ( +-1 로 봐야하니까 코드 일관성을 위해)
// 그니까 이제 예제를 예로들면
// X X X X X
// . X X . .
// 이런식으로 되는거임 맨위는 건물에 둘러쌓여있다고 생각
// 일단 먼저 temp라는 배열에 기록해 놨다가 만약 연결이 된다면 temp라는 배열내용을
// check 배열에 써주는 식의 방식을 생각.
// 시간 초과가 발생 여지가 있다고 생각 했음. 그래도 일단 해봄

// 역시나 예상대로 시간초과.
// 그래서 temp를 대체할 방식을 생각함.
// 가장 먼저 생각난 방식은
// connectPipe 함수를 재귀호출하면서
// 그다음 경로 가
// 그 함수가 true를 리턴할 때만 check배열에 내용을 저장.
// 한번 이대로 해봄.

// 근데 이대로 해도 시간 초과나서
// 다시한번 더 생각해봄.
// 다시한번 더 생각해본 바로는
// 예를들어 3행 4열에서 길이 없었는데
// 나중에 또 여길 방문할경우 또 헛고생을하는거니까
// visit 배열을 만들어서 한번 앞에 길이있는지 없는지를 저장해 주는식으로 구현해봄.
// visit 배열을 만들어서 해결 완료.
package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G2_3109 {
    static boolean[][] check;
    static boolean[][] visit;
    static int col;
    static int row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        String nextStr;
        int count = 0;
        check = new boolean[row + 1][col];
        visit = new boolean[row+1][col];
        // check 배열에 건물 위치 표시.
        for (int i = 1; i < row + 1; i++) {
            nextStr = br.readLine();
            for (int j = 0; j < col; j++) {
                if (nextStr.charAt(j) == 'x') check[i][j] = true;
                else check[i][j] = false;
            }
        }
        // 0번째 행은 싹다 건물로 처리
        for (int i = 0; i < col; i++)
            check[0][i] = true;

        for (int i = 1; i < row + 1; i++) {
            if (connectPipe(i,0))
                count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }

    public static boolean connectPipe(int row_n, int col_n) {
        int row_num = row_n;
        if(col_n > col-1)
            return true;
        if(visit[row_n][col_n])
            return false;
        for (int i = row_num - 1; i < row_num + 2; i++) {
            if (i > row || i == 0)
                continue;
            if (check[i][col_n] == true)
                continue;
            else {
                if (connectPipe(i, col_n+1)) {
                    check[i][col_n] = true;
                    return true;
                }
            }
        }
            visit[row_n][col_n] = true;
            return false;
    }
}
/* 아래는 첫번째로 생각한 내용 */
//    static boolean[][] check;
//    static boolean[][] temp;
//    static int col;
//    static int row;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        row = Integer.parseInt(st.nextToken());
//        col = Integer.parseInt(st.nextToken());
//        String nextStr;
//        int count = 0;
//        check = new boolean[row + 1][col];
//        temp = new boolean[row+1][col];
//        // check 배열에 건물 위치 표시.
//        for (int i = 1; i < row + 1; i++) {
//            nextStr = br.readLine();
//            for (int j = 0; j < col; j++) {
//                if (nextStr.charAt(j)=='x') check[i][j] = true;
//                else check[i][j] = false;
//            }
//        }
//        // 0번째 행은 싹다 건물로 처리
//        for(int i = 0 ; i < col; i++)
//            check[0][i] = true;
//
//        for(int i = 1 ; i < row+1; i++){
//            if(connectPipe(i)) {
//                count++;
//                for(int a = 1 ; a <row+1; a++)
//                    for(int b = 0; b< col; b++){
//                        if(temp[a][b])
//                            check[a][b]=true;
//                    }
//            }
//            for(int a = 1 ; a < row+1; a++)
//                for(int b = 0;b<col; b++)
//                    temp[a][b]= false;
//        }
//        bw.write(String.valueOf(count));
//        bw.flush();
//    }
//    public static boolean connectPipe(int row_n){
//        boolean ok;
//        boolean next;
//        int row_num= row_n;
//        for(int i = 0 ; i< col; i++){
//            ok = false;
//            next = false;
//            for(int j= row_num-1; j<row_num+2; j++) {
//                if (!next) {
//                    if (j > row)
//                        return false;
//                    if (check[j][i] == true)
//                        continue;
//                    else {
//                        temp[j][i] = true;
//                        row_num = j;
//                        ok = true;
//                        next= true;
//                    }
//                }
//            }
//            if(!ok)
//                return false;
//        }
//        return true;
//    }
