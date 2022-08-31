// 행렬제곱을 응용하는 문제라고 써져있어서 좀 생각 해봄.
// 한참 생각해 봤는데
// f(n+1) = f(n-1) + f(n) ( n >= 1) 인 점을 이용해서
// [ f(n)   f(n+1) ]     *      [ 0  1 ]
// [ f(n+1) f(n+2) ]            [ 1  1 ]
// 의 결과는
// [ f(n+1) f(n+2) ]
// [ f(n+2) f(n+3) ]
// 가 나왔음.
// 근데 이제 초항 역시 [ 0   1 ]
//                  [ 1   1 ]  이므로 이 행렬의 거듭 제곱 형태로 값을 구할 수 있을 것 같음.
// 이를 이용해보면
// n이 주어졌을 때 f(n)을 구해야 하니깐
// 이 행렬을 (n+1) 번 거듭 곱한 형태의 0행 0열 값을 취하면 f(n)값이 나옴.

package Gold;

import java.io.*;

public class G2_11444 {
    private static final int DIV_VALUE = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long[][] mat = new long[2][2];
        long[][] result = new long[2][2];
        mat[0][0] = 0; mat[0][1] = 1; mat[1][0] = 1; mat[1][1] = 1;
        result = matPower(mat , n+1);
        bw.write(String.valueOf(result[0][0]));
        bw.flush();
    }
    public static long[][] matrixMultiply(long[][] mat1, long[][] mat2){
        long[][] result = new long[2][2];

        for(int i = 0 ; i < 2; i ++) {
            for (int j = 0; j < 2; j++)
                result[i][j]=0;
        }
        for(int i = 0 ; i < 2; i ++) {
            for (int j = 0; j < 2; j++){
                for (int k = 0; k < 2; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
                if (result[i][j] >= DIV_VALUE)
                    result[i][j] %= DIV_VALUE;
            }
        }
        return result;
    }
    public static long[][] matPower(long[][] mat , long po){
        if ( po == 1)
            return mat;
        long [][] temp = matPower(mat,po/2);
        long[][] result = matrixMultiply(temp,temp);
        if( po % 2 == 0 ) {
            return result;
        }
        else {
            result = matrixMultiply(result, mat);
        }
        return result;
    }
}
