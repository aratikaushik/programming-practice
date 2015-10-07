package leetCode;

import java.util.Arrays;
public class Solution {
	
	public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
			if(nums[i] == nums[i-1])
				return true;
		}
		return false;
    }
    
    public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())
			return false;
		
		char tArray[] = t.toCharArray();
		for(int i=0;i<s.length();i++){
			String t2 = new String(tArray);
			int thisIndex = t2.indexOf((int)s.charAt(i));
			if(thisIndex == -1)
				return false;
			tArray[thisIndex] = ' ';
		}
		return true;
    }
	    
    public static void main(String[] args){
		Solution s = new Solution();
		int[] nums1 = new int[]{1,3,5,1,4,3};
		int[] nums2 = new int[]{1,10,3,5};
		System.out.println("nums1 contains duplicates - "+Boolean.toString(s.containsDuplicate(nums1)));
		System.out.println("nums2 contains duplicates - "+Boolean.toString(s.containsDuplicate(nums2)));
		System.out.println("are abb and baa anagrams? - "+Boolean.toString(s.isAnagram("abb","baa")));
		System.out.println("are abc and cab anagrams? - "+Boolean.toString(s.isAnagram("abc","cab")));
	}
    
}
