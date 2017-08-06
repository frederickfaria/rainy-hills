package com.crxmarkets.rainyhills.service;

import javax.ejb.Stateless;

/**
 * Core service implementation
 *
 * Created by ffaria on 5/8/17.
 */
@Stateless
public class CoreServiceImpl implements CoreService {

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
     * Space Complexity: O(1)
     */
    @Override
    public long fillWater(long[] arr) {

        long volume = 0;
        long left = 0;
        long right = 0;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left) {
                    left = arr[lo];
                } else {
                    volume = checkSumLimit(volume, left - arr[lo]);
                }
                lo++;
            } else {
                if (arr[hi] > right) {
                    right = arr[hi];
                } else {
                    volume = checkSumLimit(volume, right - arr[hi]);
                }
                hi--;
            }
        }

        return volume;
    }

    /**
     * Verifies that the sum of two longs do not exceeds Long.MAX_VALUE
     *
     * @param a
     *          First number to sum
     * @param b
     *          Second number to sum
     *
     * @return
     *          the sum of a + b if not exceeds the limit, otherwise throws ArithmeticException
     */
    public long checkSumLimit(long a, long b) {
        long result = a + b;
        if(!((a ^ b) < 0L | (a ^ result) >= 0L)) {
            throw new ArithmeticException("The sum of " + a + " + " + b + " exceeds Long.MAX_VALUE");
        }
        return result;
    }
}
