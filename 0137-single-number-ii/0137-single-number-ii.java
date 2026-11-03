class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twoes = 0 ;
        for(int i = 0 ; i<nums.length ; i++){
            ones = (ones^nums[i]) & (~twoes);
            twoes = (twoes ^ nums[i]) & (~ones);
        }
        return ones;
    }
}