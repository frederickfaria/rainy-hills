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
    public void fillWaterTestProblem1() throws Exception {

        long[] test1 = {3,2,4,1,2};

        long volume = core.fillWater(test1);

        assertEquals(2, volume);
    }

    @Test
    public void fillWaterCaseProblem2() throws Exception {
        long[] test1 = {4,1,1,0,2,3};

        long volume = core.fillWater(test1);

        assertEquals(8, volume);
    }

    @Test
    public void fillWaterCaseTestPlainSurface() throws Exception {
        long[] test1 = {1,1,1};

        long volume = core.fillWater(test1);

        assertEquals(0, volume);
    }

    @Test
    public void fillWaterCaseTestLongLimit() throws Exception {
        long[] test1 = {9223372036854775806L,0L,9223372036854775806L};

        long volume = core.fillWater(test1);

        assertEquals(9223372036854775806L, volume);
    }

    @Test (expected = ArithmeticException.class)
    public void fillWaterCaseTestOverFlow() throws Exception {
        long[] test1 = {9223372036854775806L,56L,9223372036854775806L,922337203L,9223372036854775806L};

        core.fillWater(test1);
    }
}