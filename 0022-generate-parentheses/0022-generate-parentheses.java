class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        StringBuilder str = new StringBuilder();
        int open = 0;
        int close = 0;

        solve(str , n ,open ,close);
        return result;
    }

    public void solve(StringBuilder curr , int n , int open ,int close){

        if(curr.length()==2*n){
            result.add(curr.toString());
            return;
        }

        if(open<n){
        curr.append('(');
        solve(curr,n , open+1,close);
        curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
        curr.append(')');
        solve(curr,n ,open , close+1);
        curr.deleteCharAt(curr.length()-1);
        }

    }

}