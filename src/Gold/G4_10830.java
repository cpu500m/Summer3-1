/* 2022-06-22 세번째로 푼 문제 */
// A 의 n 제곱일 때
// n이 짝수면 반 반 쪼개서 처리가 가능하고,
// n이 홀수이면 반 반 쪼개서 각각 곱하고 A를 곱해주면 되니까
// 계속 쪼개 나가다가 n=1일 때부터 처리하는 방식의 divide and conquer 방식으로 생각 함.
package Gold;

import java.util.Scanner;

public class G4_10830 {
    public static void main(String[] args) {
        int size;
        long mul;
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        mul = scanner.nextLong();
        int[][] mat= new int[size][size];
        // 행렬 내부 값 입력 받고
        for(int i = 0 ; i < size; i ++) {
            for (int j = 0; j < size; j++)
                mat[i][j] = scanner.nextInt();
        }
        mat = matPower(mat , mul);

        for(int i = 0 ; i < size; i ++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j]);
                if( j != size-1)
                    System.out.print(" ");
            }
            if( i != size-1)
            System.out.println();
        }
    }
    public static int[][] matrixMultiply(int[][] mat1, int[][] mat2){
        int[][] result = new int[mat1.length][mat1.length];

        for(int i = 0 ; i < mat1.length; i ++) {
            for (int j = 0; j < mat1.length; j++)
                result[i][j]=0;
        }
        for(int i = 0 ; i < mat1.length; i ++) {
            for (int j = 0; j < mat1.length; j++){
                for (int k = 0; k < mat1.length; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            if (result[i][j] >= 1000)
                result[i][j] %= 1000;
            }
        }
        return result;
    }
    public static int[][] matPower(int[][] mat , long po){
        if ( po == 1) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if (mat[i][j] >= 1000)
                        mat[i][j] %= 1000;
                }
            }
            return mat;
        }
        int [][] temp = matPower(mat,po/2);
        int[][] result = matrixMultiply(temp,temp);
        if( po % 2 == 0 ) {
            return result;
        }
        else {
            result = matrixMultiply(result, mat);
        }
        return result;
    }
}
