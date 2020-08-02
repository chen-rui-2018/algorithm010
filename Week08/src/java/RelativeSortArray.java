import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/8/2 22:24
 * @version： v1.0
 * @modified By:
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        int [] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int [] arr2 = {2,1,4,3,9,6};
      int [] result =   new RelativeSortArray().relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(result));
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int [] temp = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            temp[arr1[i]]++;
        }
        int j = 0;
        for (int i = 0; i < arr2.length ; i++) {
            while(temp[arr2[i]] > 0){
                arr1[j++] = arr2[i];
                temp[arr2[i]]--;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] >0){
                arr1[j++] = i;
                temp[i]--;
            }
        }
        return arr1;
    }
}
