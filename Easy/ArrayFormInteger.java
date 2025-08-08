package Easy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayFormInteger {
    public static List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> ans = new ArrayList<>();
        int p = num.length -1;
        int carry = 0;
        while (p >= 0 || k > 0) {
            int numVal = 0;
            // numval = 0 due to handle case when k value is greater then whole array value
            if (p >= 0) {
                numVal = num[p];
            }

            int d = k % 10; // to get the last element of k
            int sum = d + numVal + carry; // adding last element of k with last element of arr with carry
            int digit = sum % 10; // to get the last element of sum in order to check if there is carry
            carry = sum / 10; // carry will be the remaining digit
            ans.add(digit);
            p--;
            k = k / 10;

        }
        if (carry > 0) {
            ans.add(carry);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(addToArrayForm(nums, 12345));
    }
}
