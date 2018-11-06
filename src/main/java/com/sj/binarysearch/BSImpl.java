package com.sj.binarysearch;

import com.sj.exception.ElementNotFoundException;

public class BSImpl<E> {

    public int search(E arr[], E searchElement){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = (low + high) >>> 1;
            Comparable midVal = (Comparable)arr[mid];
            int cmp = midVal.compareTo(searchElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        throw new ElementNotFoundException();
    }
}
