/**
 * @author by wuYang
 * @date 2019/1/18
 * @describe
 */

import sun.rmi.runtime.Log;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
class Three {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(isPalindrome1(121) + "");
    }

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        if (x == reverse1(x)) {
            return true;
        }
        return false;
    }


    public static int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    /**
     * 牛皮解答
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        String reverseNumber = new StringBuilder(String.valueOf(x)).reverse().toString();
        return reverseNumber.equals(String.valueOf(x));

    }

}
