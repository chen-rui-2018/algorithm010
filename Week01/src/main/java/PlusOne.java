/**
 * @author： chenr
 * @date： Created on 2020/6/14 20:24
 * @version： v1.0
 * @modified By:
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 9, 9};
        int[] array2 = {9, 9, 9, 9, 9};
        int[] aimArray = plusOne(array);
        int[] aimArray2 = plusOne2(array2);

        for (int i = 0; i < aimArray.length; i++) {
            System.out.print(aimArray[i] + ",");
        }
        System.out.println();

        for (int i = 0; i < aimArray2.length; i++) {
            System.out.print(aimArray2[i] + ",");
        }

    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        int i = digits.length - 1;
        while (digits[i] > 9) {

            if (i == 0) {
                int[] newArray = new int[digits.length + 1];
                System.arraycopy(digits, 0, newArray, 1, digits.length);
                newArray[0] = 1;
                newArray[1] = newArray[1] % 10;
                return newArray;
            }
            if (i > 0) {
                digits[i - 1]++;
                digits[i] = digits[i] % 10;
                i--;
            }
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }
}
