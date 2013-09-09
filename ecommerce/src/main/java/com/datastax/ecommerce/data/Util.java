package com.datastax.ecommerce.data;

import java.util.Random;

/**
 *
 * @author Mark Kerzner
 */
public class Util {
    // constants
    public static String ROOT_DIR = "generated";
    public static String USERS = "user.txt";
    public static String INTERESTS = "interest.txt";
    public static String USER_INTERESTS = "user_interest.txt";
    // generators
    private Random ran = new Random();
    private static char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "msn.com", "comcast.net"};

    public String generateUserName() {
        StringBuilder userName = new StringBuilder();
        int len = generateInt(5, 10);
        for (int l = 0; l < len; ++l) {
            int pos = generateInt(0, letters.length);
            userName.append(letters[pos]);
        }
        return userName.toString();
    }

    public String generateDomain() {
        int domain = generateInt(0, domains.length);
        return domains[domain];
    }
    public int generateInt(int min, int range) {
        int i = ran.nextInt(range) + min;
        return i;
    }
}