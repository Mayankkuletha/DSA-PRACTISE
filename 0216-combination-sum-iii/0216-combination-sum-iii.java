class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<Integer> ans = new ArrayList<>();

         int  start = 1 ;
          solve(k,n,ans,start);
          

        return result;
    }

    public void solve(int k , int n , List<Integer> ans, int start){
        
        //base case
        if(k==0){
            if(n==0){
                result.add(new ArrayList <>(ans));
            }
            return ;
        }
       for(int i = start ; i<= 9 ; i++){

        ans.add(i);
        solve(k-1,n-i,ans,i+1 );

        ans.remove(ans.size()-1);
       }

    }
}