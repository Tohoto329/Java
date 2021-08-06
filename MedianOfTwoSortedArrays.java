class MedianOfTwoSortedArrays{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){

        double result = 0.0;
        if(nums1.length == 0 && nums2.length == 0)
            return result;
        int p1 = 0, p2 = 0;
        int[] sorted = new int[nums1.length + nums2.length];
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] <= nums2[p2]){
                sorted[p1+p2] = nums1[p1];
                p1 += 1;
            }else{
                sorted[p1+p2] = nums2[p2];
                p2 += 1;
            }
        }
        while(p1 < nums1.length){
            //Copy the remaining from nums1
            sorted[p1+p2] = nums1[p1];
            p1 += 1;
        }
        while(p2 < nums2.length){
            //Copy the remaining from nums1
            sorted[p1+p2] = nums2[p2];
            p2 += 1;
        }
        int mid = sorted.length/2;
        if(sorted.length % 2 == 0){
            result = (sorted[mid] + sorted[mid-1])/2.0;
        }else{
            result = sorted[mid];
        }
        return result;
    }
}

// // Check if num1 is smaller than num2
//         // If not, then we will swap num1 with num2
//         if(nums1.length > nums2.length){
//             return findMedianSortedArrays(nums2, nums1);
//         }
//         //length of two arrays
//         int m = nums1.length;
//         int n = nums2.length;
//         // pointer for binary search
//         int start = 0;
//         int end = m;
        
//         while(start <= end){
//             //partition the two array
//             int partitionNums1 = (start + end ) / 2;
//             int partitionNums2 = (m + n + 1) / 2 - partitionNums1;
//             // edge cases
//             //if there are no elements on the left side after partition
//             int maxLeftNums1 = partitionNums1 = 0 ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
//              //if there are no elements on the left side after partition
//             int minRightNums1 = partitionNums1 = m ? Integer.MAX_VALUE : nums1[partitionNums1];
//             //Similarly for nums2
//             int maxLeftNums2 = partitionNums2 = 0 ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
//             int minRightNums2 = partitionNums2 = n ? Integer.MAX_VALUE : nums2[partitionNums2];
//             //Check if we found the match 
//             if(maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1){
//                 //check if the combined is odd/even length
//                 if((m + n) / 2 == 0) {
//                     return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2;
//                 }else{
//                     return Math.max(maxLeftNums1, maxLeftNums2);                
//                 }
//             }
//             //if we are too far on the right, we need to go to the left side 
//             else if(maxLeftNums1 > minRightNums2){
//                 end = partitionNums1 - 1;
//             }
//             else {
//                 start = partitionNums1 + 1;
//             }
//         }
//         //if we reach here that means the array are not sorted
//         throw new IllegalArgumentException();