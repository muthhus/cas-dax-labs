/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datastax.ecommerce.data;

import junit.framework.TestCase;

/**
 *
 * @author Mark Kerzner
 */
public class UtilTest extends TestCase {
    
    public UtilTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of generateUserName method, of class Util.
     */
    public void testGenerateUserName() {
        System.out.println("generateUserName");
        Util instance = new Util();
        for (int i = 0; i < 10; ++i) {
            System.out.println(instance.generateUserName());
        }
    }

    /**
     * Test of generateInt method, of class Util.
     */
    public void testGenerateInt() {
        System.out.println("generateInt");
        int min = 1;
        int range = 5;
        // Just to get a feel that it works
        // We could test the statistical properties of generated data
        Util instance = new Util();
        for (int i = 0; i < 10; ++i) {
            System.out.println(instance.generateInt(min, range));
        }
    }
}
