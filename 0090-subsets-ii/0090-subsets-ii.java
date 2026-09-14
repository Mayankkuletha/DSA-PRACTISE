class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List <Integer> ans = new ArrayList<>(); 
        Arrays.sort(nums);
        solve(nums,0,ans,n);
        return result;
    }

    public void solve(int[] nums,int index , List<Integer> ans , int n){

        //base case 
        result.add(new ArrayList<>(ans));
        for(int i = index ; i<n;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            ans.add(nums[i]);
            solve(nums,i+1,ans,n);
            ans.remove(ans.size()-1);

        }
    }
}