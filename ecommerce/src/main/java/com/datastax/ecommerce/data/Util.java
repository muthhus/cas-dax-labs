/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datastax.ecommerce.data;

import java.util.Random;

/**
 *
 * @author Mark Kerzner
 */
public class Util {
        private Random ran = new Random();
    private static char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String generateUserName() {
        StringBuilder userName = new StringBuilder();
        int len = generateInt(1, 5);
        return userName.toString();
    }

    public int generateInt(int min, int range) {
        int i = ran.nextInt(range) + min;
        return i;
    }
}
