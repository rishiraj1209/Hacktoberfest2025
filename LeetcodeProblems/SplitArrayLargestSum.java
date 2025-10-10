class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return -1;
        int s = Integer.MIN_VALUE;
        int e = 0;
        for(int i=0; i<n; i++){
            s = Math.max(s, nums[i]);
            e += nums[i];
        }

        while(s <= e){
            int mid = s + (e-s)/2;
            int countSub = countSplit(nums, mid);
            if(countSub > k){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return s;
    }

    private int countSplit(int nums[], int num){
        int n = nums.length;
        int count = 1;
        int currSum = 0;
        for(int i=0; i<n; i++){
            if(currSum + nums[i] <= num){
                currSum += nums[i];
            }else{
                count++;
                currSum = nums[i];
            }
        }
        return count;
    }
}
