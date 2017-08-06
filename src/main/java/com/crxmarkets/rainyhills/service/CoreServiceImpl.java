package com.crxmarkets.rainyhills.service;

import javax.ejb.Stateless;

/**
 * Core service implementation
 *
 * Created by ffaria on 5/8/17.
 */
public class CoreImpl {

    /**
     * Calculates the volume of water which remained after the rain, in units.
     *
     * @param arr
     *          describes profile of a surface
     *
     * @return
     *      the volume of water in units which remained after the rain
     *
     * Time Complexity: O(n)
     * Space Complexity : O(1)
     */
    public int fillWater(int[] arr) {

        int volume = 0;
        int left = 0;
        int right = 0;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left) {
                    left = arr[lo];
                } else {
                    volume += left - arr[lo];
                }
                lo++;
            } else {
                if (arr[hi] > right) {
                    right = arr[hi];
                } else {
                    volume += right - arr[hi];
                }
                hi--;
            }
        }

        return volume;
    }
}
