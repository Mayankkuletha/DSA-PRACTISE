class Solution {

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return result;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(digits, 0, "", map);

        return result;
    }

    public void solve(String digits, int index, String ans, String[] map) {

        // base case
        if (index == digits.length()) {
            result.add(ans);
            return;
        }

        // current digit
        int digit = digits.charAt(index) - '0';

        String letters = map[digit];

        // try every letter of current digit
        for (int i = 0; i < letters.length(); i++) {

            char ch = letters.charAt(i);

            solve(digits, index + 1, ans + ch, map);
        }
    }
}