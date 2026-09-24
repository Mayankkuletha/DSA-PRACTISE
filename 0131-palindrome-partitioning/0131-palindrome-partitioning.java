class Solution {
    List<List<String>>result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> ans = new ArrayList<>();
        solve(s , 0 , ans);
        return result;
    }
    public void solve(String s , int index , List<String> ans){
        //base case
        if(index == s.length()){
            result.add(new ArrayList<>(ans));
            return ;
        }
        for (int i = index ; i< s.length() ; i++){
            if(isPalindrome(s,index,i)){

                ans.add(s.substring(index , i+1));

                solve(s,i+1,ans);

                ans.remove(ans.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s , int start , int end){

        while(start <=end){

            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start ++;
            end--;
        }
        return true;
    }
}