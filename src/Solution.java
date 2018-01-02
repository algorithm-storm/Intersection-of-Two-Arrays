import java.util.Arrays;

public class Solution {

    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null){
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pos1 = 0;
        int pos2 = 0;
        int [] temp = new int[nums1.length + nums2.length];
        int posTemp = 0;

        while(pos1 < nums1.length && pos2 < nums2.length){

            if(nums1[pos1] < nums2[pos2]){
                pos1++;
            }
            else if(nums1[pos1] > nums2[pos2]){
                pos2++;
            }
            else if(nums1[pos1] == nums2[pos2]) {
                if(posTemp == 0 || temp[posTemp-1] != nums2[pos2])
                temp[posTemp++] = nums2[pos2];
                pos1++;
                pos2++;
            }

        }

        int [] result = new int [posTemp];
        for(int i = 0 ; i < result.length; i++){
            result[i] = temp[i];
        }

        return result;

    }
};