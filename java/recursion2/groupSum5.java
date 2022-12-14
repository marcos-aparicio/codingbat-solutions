/*
 *
Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with these additional constraints: all multiples of 5 in the array must be included in the group. If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)


groupSum5(0, [2, 5, 10, 4], 19) → true
groupSum5(0, [2, 5, 10, 4], 17) → true
groupSum5(0, [2, 5, 10, 4], 12) → false
 *
 */
public boolean groupSum5(int start, int[] nums, int target) {
  
  if(start >= nums.length) return target == 0; 
  
  boolean follow =  groupSum5(start+1,nums,target-nums[start]);
  boolean dontFollow =  groupSum5(start+1,nums,target);
  
  if(start > 0 && nums[start-1] == 5 && nums[start] == 1) follow = false;
  
  if(nums[start] % 5 == 0) dontFollow = false;

  return follow || dontFollow;
  
}
