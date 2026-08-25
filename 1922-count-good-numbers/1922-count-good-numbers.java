class Solution {
    long M = 1000000007L;
    public long find_power(int a , long b ){
        // base case 
        if (b==0){
            return 1;
        }
        long half = find_power(a,b/2);
        long result = (half * half) % M;
        if(b%2==1){
            result = (a*result) % M;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        return (int) (find_power(5,(n+1)/2) * find_power(4,(n/2)) % M);
    }
}