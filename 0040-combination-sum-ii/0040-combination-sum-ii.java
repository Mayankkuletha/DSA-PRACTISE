class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<Integer> curr = new ArrayList<>();

        solve(candidates, target, curr, 0);

        return result;
    }

    public void solve(int[] candidates, int target,
                      List<Integer> curr, int index) {

        // target mil gaya
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // same level par duplicate skip
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // array sorted hai
            if (candidates[i] > target) {
                break;
            }

            // choose
            curr.add(candidates[i]);

            // i + 1 -> same element dobara use nahi hoga
            solve(candidates, target - candidates[i],
                  curr, i + 1);

            // backtrack
            curr.remove(curr.size() - 1);
        }
    }
}