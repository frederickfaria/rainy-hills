package com.crxmarkets.rainyhills.service;

import javax.ejb.Stateless;

/**
 * Core service implementation
 *
 * Created by ffaria on 5/8/17.
 */
public class CoreImpl {

    public int fillWater(int[] arr) {

        int volume = 0;
        int leftMax = 0;
        int rightMax = 0;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > leftMax) {
                    leftMax = arr[lo];
                } else {
                    volume += leftMax - arr[lo];
                }
                lo++;
            } else {
                if (arr[hi] > rightMax) {
                    rightMax = arr[hi];
                } else {
                    volume += rightMax - arr[hi];
                }
                hi--;
            }
        }

        return volume;
    }
}
