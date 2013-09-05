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
    private static String[] domains = { "google.com", "yahoo.com", "hotmail.com", "msn.com", "comcast.net" };

    public String generateUserName() {
        StringBuilder userName = new StringBuilder();
        int len = generateInt(5, 10);
        for (int l = 0; l < len; ++l) {
            int pos = generateInt(0, letters.length);
            userName.append(letters[pos]);
        }
        return userName.toString();
    }

    public int generateInt(int min, int range) {
        int i = ran.nextInt(range) + min;
        return i;
    }
}
