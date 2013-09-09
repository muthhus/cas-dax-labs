/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datastax.ecommerce.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mark Kerzner
 */
public class GenerateCustomIndicesTest {
    
    public GenerateCustomIndicesTest() {
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
     * Test of main method, of class GenerateCustomIndices.
     */
    @Test
    public void testMain() {
        System.out.println("GenerateCustomIndices.main");
        String[] argv = new String[3];
        argv[0] = "10";
        argv[1] = "5";
        argv[2] = "3";
        GenerateCustomIndices.main(argv);
    }
}