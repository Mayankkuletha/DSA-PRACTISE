class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> ans = new ArrayList<>();
        int n = candidates.length;

        solve(candidates, target, 0, n, ans);

        return result;
    }

    public void solve(int candidates[], int target, int index,
                      int n, List<Integer> ans) {

        if (index == n) {
            if (target == 0) {
                result.add(new ArrayList<>(ans));
            }
            return;
        }

        // Take
        if (candidates[index] <= target) {

            ans.add(candidates[index]);

            solve(candidates,target - candidates[index],index,n,ans);
            // Backtracking
            ans.remove(ans.size() - 1);
        }

        // Not Take
        solve(candidates,target,index + 1,n,ans);
    }
}