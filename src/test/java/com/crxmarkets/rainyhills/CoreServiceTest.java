package com.crxmarkets.rainyhills;

import com.crxmarkets.rainyhills.service.CoreServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CoreServiceTest {

    CoreServiceImpl core;

    @Before
    public void setUp() throws Exception {
        core = new CoreServiceImpl();
    }

    @Test
    public void fillWaterCase1() throws Exception {

        int[] test1 = {3,2,4,1,2};

        int volume = core.fillWater(test1);

        assertEquals(2, volume);
    }

    @Test
    public void fillWaterCase2() throws Exception {
        int[] test1 = {4,1,1,0,2,3};

        int volume = core.fillWater(test1);

        assertEquals(8, volume);
    }

    @Test
    public void fillWaterCase3() throws Exception {
        int[] test1 = {1,1,1};

        int volume = core.fillWater(test1);

        assertEquals(0, volume);
    }
}