import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/7/5 15:06
 * @version： v1.0
 * @modified By:
 *  柠檬水找零
 */
public class LemonadeChange {
    public static void main(String[] args) {
       int [] bulls = {20,5,5,10,20};
        System.out.println(new LemonadeChange().lemonadeChange(bulls));
    }
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int five = 0;
        int ten =  0;
        for (int i = 0; i < bills.length ; i++) {
            if (bills[i] == 5){
                five ++;
            }else if (bills[i] == 10) {
                if (five ==0) {
                    return false;
                }
                ten++;
                five--;
            }else {
                if (five > 0 && ten >0 ) {
                    five--;
                    ten--;
                }else if (five > 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }

}
