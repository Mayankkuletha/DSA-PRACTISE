class Solution {
    public int[] singleNumber(int[] nums) {
        long XOR = 0 ;
        for(int i = 0 ; i< nums.length ; i++){
            XOR = XOR ^ nums[i];
        }
        int b1 = 0 ; 
        int b2 = 0 ;
        long rightmost = ((XOR & (XOR-1)) ^ XOR);
        //checking if bit is 1 or not
        for(int i = 0 ; i< nums.length ; i++){
            if((nums[i] & rightmost)!=0){
                b1= b1^nums[i];
            }else{
                b2 = b2^nums[i];
            }
        }
        return new int[]{b1,b2};
    }
}