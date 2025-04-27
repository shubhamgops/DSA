class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCounter = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCounter++;
            } else {
                if (zeroCounter > 0) {
                    nums[i-zeroCounter] = nums[i];
                    nums[i] = 0;    
                }
            }
        }
    }
}