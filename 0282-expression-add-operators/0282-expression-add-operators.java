class Solution {

    List<String> ans = new ArrayList<>();
    void solve(String num, int target, int index,String curr, List<String> ans,long value, long res) {

        // Base case
        if (index == num.length()) {
            if (value == target) {
                ans.add(curr);
            }
            return;
        }

        String st = "";
        long curres = 0;

        for (int i = index; i < num.length(); i++) {

            // Leading zero avoid
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            st += num.charAt(i);
            curres = curres * 10 + (num.charAt(i) - '0');//string ke digits ko number mein convert

            // First number
            if (index == 0) {

                solve(num, target, i + 1,st, ans,curres, curres);

            } else {
                // +
                solve(num, target, i + 1,curr + "+" + st, ans,value + curres,curres);
                // -
                solve(num, target, i + 1,curr + "-" + st, ans, value - curres,-curres);
                // *
                solve(num, target, i + 1,curr + "*" + st, ans,value - res + (res * curres),res*curres);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        solve(num, target, 0, "", ans, 0, 0);
        return ans;
    }
}