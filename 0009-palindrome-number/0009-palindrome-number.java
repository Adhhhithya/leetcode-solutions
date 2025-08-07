class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false; 

        int original = x;
        int rev = 0;

        while (x != 0) {
            int last = x % 10;
            if (rev > (Integer.MAX_VALUE - last) / 10) {
                return false;
            }

            rev = rev * 10 + last;
            x = x / 10;
        }

        return original == rev;
    }
}
