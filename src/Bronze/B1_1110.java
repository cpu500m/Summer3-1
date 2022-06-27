/* 2022-06-27 워밍업 */
package Bronze;
import java.util.Scanner;

public class B1_1110 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cycle = 0;
        int new_value=100;
        char first;
        char second;
        String input = scanner.next();
        String n_input;
        if(Integer.valueOf(input) < 10)
            n_input = "0"+input;
        else
            n_input = input;
        int pre_value = Integer.valueOf(n_input);
        while(new_value != Integer.valueOf(input)){
            if(pre_value>9) {
                first = String.valueOf(pre_value).charAt(1);
                if( (new_value= Character.getNumericValue(String.valueOf(pre_value).charAt(0))+Character.getNumericValue(String.valueOf(pre_value).charAt(1))) < 10) {
                    second = String.valueOf(new_value).charAt(0);
                }
                else {
                    second = String.valueOf(new_value).charAt(1);
                }
            }
            else {
                first = String.valueOf(pre_value).charAt(0);
                second = String.valueOf(pre_value).charAt(0);
            }
            new_value = Integer.valueOf(Character.toString(first)+Character.toString(second));
            pre_value = new_value;
            cycle++;
        }
        System.out.print(cycle);
    }
}
