class Solution {
    public double myPow(double x, int n) {
        // for negative
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }

        return power(x,N,1);
    }

    double power(double x , long N , double ans ){

        if (N==0){
            return ans;
        }

        if(N%2==1){
            ans = ans * x;
        }

        return power(x*x,N/2,ans);
    }
}