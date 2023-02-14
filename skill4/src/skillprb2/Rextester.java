package skillprb2;

class Rextester{
    
    public static boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length && j<=i+k;j++)
            {
                if(nums[j]==nums[i])
                    return true;
            }
        return false;
    }
    public static void main(String args[])
    {
         int[] nums={1,2,3,1};
        int k=3;
        System.out.println(containsNearbyDuplicate(nums,k) );
    }
}
