package com.crxmarkets.rainyhills.service;

import javax.ejb.Local;

/**
 * Core service local interface
 *
 * Created by ffaria on 5/8/17.
 */
@Local
public interface CoreService {
    int fillWater(int arr[]);
}
