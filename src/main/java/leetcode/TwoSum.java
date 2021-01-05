package leetcode;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
target. You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Constraints:
2 <= nums.length <= 10^3
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.
 */

public class TwoSum
{
    // Brute Force Method
    public int[] bruteForceMethod(int[] nums, int target)
    {
        int[] answer = new int[2];
        int find;
        for (int i = 0; i < nums.length - 1; i++)
        {
            answer[0] = i;
            find = target - nums[i];
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] == find)
                {
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }

    public int[] hashTableMethod(int[] nums, int target)
    {
        int [] answer = new int[2];
        return answer;
    }

    /*
    Fastest Way - No Space Constraints

    If there is no space constraints we can create an array bigArr of size
    (2 * 10^9) + 1 = 2,000,000,001 because this is the range of
    possible values in nums array.

    For each value i in nums[i] array
        bigArr[nums[i]] = nums[i];

    For each value i in nums array
        int find = target - nums[i];
    */
}
