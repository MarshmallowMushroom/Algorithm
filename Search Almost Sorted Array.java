    public int searchAlmostSortedArray(int [] A, int target, int start, int end) {
        if (start > end) // notice this must be test first in case start and end is out of boundary 
            return -1;
        int mid = (start + end)/2;
        if (A[mid] == target)
            return mid;
        if (mid + 1 < A.length && A[mid + 1] == target)
            return mid + 1;
        if (mid - 1 >= 0 && A[mid - 1] == target)
            return mid - 1;
        if (A[mid] < target) // because already compared with mid - 1, we only need to start from mid - 2
            return searchAlmostSortedArray(A, target, start, mid - 2);
        return searchAlmostSortedArray(A, target, mid + 2, end);
    }
    
    /* the key here is to make sure that mid + 1 and mid - 1 must be within the range, otherwise could throw out of boundary exception*/
