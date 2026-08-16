class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int n = s.length();
        int right = n-1;

        while(left<right){

        //remove spaces from left
        while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }
        //removing spaces from right
          while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

        if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
            return false;
        }
        left++;
        right--;
        }
        return true;
    }
}