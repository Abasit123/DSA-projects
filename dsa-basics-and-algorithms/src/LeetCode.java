class Solution {
    public int addDigits(int num) {
        String nums= ""+num;
        int sum=0;
        int[] sumArr= new int[nums.length()];
        int i=0, j=0;
        while(i<nums.length())
        {
           sumArr[i]= Integer.parseInt(nums.substring(i, i+1));
           i++; 
        }
        while(j<sumArr.length)
        {
            sum+=sumArr[j];
            j++;
        }
        nums=""+sum;
        if(nums.length()==1)
        return sum;
        else
        return addDigits(sum);
    }
}
public class LeetCode{
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.addDigits(38));
    }
}