class Solution {

    public List<String> addOperators(String num, int target) {

        List<String> ans = new ArrayList<>();

        dfs(num, target, 0, "", 0, 0, ans);

        return ans;
    }

    public void dfs(String num, int target, int index,
                    String path, long value, long prev,
                    List<String> ans) {

        // All digits have been used
        if (index == num.length()) {

            if (value == target) {
                ans.add(path);
            }

            return;
        }

        // Try every possible number starting at index
        for (int i = index; i < num.length(); i++) {

            // Leading zero is not allowed
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);

            // First number: no operator before it
            if (index == 0) {

                dfs(num, target, i + 1, part,
                    curr, curr, ans);

            } else {

                // Addition
                dfs(num, target, i + 1,
                    path + "+" + part,
                    value + curr, curr, ans);

                // Subtraction
                dfs(num, target, i + 1,
                    path + "-" + part,
                    value - curr, -curr, ans);

                // Multiplication
                dfs(num, target, i + 1,
                    path + "*" + part,
                    value - prev + prev * curr,
                    prev * curr, ans);
            }
        }
    }
}