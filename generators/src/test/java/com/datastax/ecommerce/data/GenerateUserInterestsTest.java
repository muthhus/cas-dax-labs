package com.datastax.ecommerce.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author c07408
 */
public class GenerateUserInterestsTest {
    
    public GenerateUserInterestsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class GenerateUserInterests.
     */
    //@Test
    public void testMain() {
        System.out.println("main");
        String[] argv = new String[3];
        argv[0] = "10";
        argv[1] = "5";
        argv[2] = "3";
        GenerateUserInterests.main(argv);

    }
}