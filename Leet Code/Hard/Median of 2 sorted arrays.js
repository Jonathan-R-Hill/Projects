const findMedianSortedArrays = (nums1, nums2) => {
    const merged = [];
    let num1Index = 0, num2Index = 0;

    while (num1Index < nums1.length && num2Index < nums2.length) {
        if (nums1[num1Index] < nums2[num2Index]) {
            merged.push(nums1[num1Index]);
            num1Index++;
        } else {
            merged.push(nums2[num2Index]);
            num2Index++;
        }
    }

    // Add remaining elements from nums1
    while (num1Index < nums1.length) {
        merged.push(nums1[num1Index]);
        num1Index++;
    }

    // Add remaining elements from nums2
    while (num2Index < nums2.length) {
        merged.push(nums2[num2Index]);
        num2Index++;
    }

    const length = merged.length;
    const mid = Math.floor(length / 2);

    if (length % 2 === 0) {
        return (merged[mid - 1] + merged[mid]) / 2;
    } else {
        return merged[mid];
    }
};
