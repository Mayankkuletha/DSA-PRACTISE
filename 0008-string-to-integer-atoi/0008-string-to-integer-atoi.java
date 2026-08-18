class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // 1. skip spaces
        while(i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. check sign
        int sign = 1;

        if(i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if(i < n && s.charAt(i) == '+') {
            i++;
        }

        // 3. make number
        long num = 0;

        while(i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            // 4. overflow check
            if(sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if(sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(sign * num);
    }
}