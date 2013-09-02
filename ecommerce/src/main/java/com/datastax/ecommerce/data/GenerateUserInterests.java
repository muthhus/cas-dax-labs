package com.datastax.ecommerce.data;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 *
 * @author Mark Kerzner
 */
public class GenerateUserInterests {

    private static String USERS = "users.txt";
    private static String INTERESTS = "interests.txt";
    private static String USER_INTERESTS = "user_interests.txt";

    public static void main(String argv[]) {
        if (argv.length != 3) {
            System.out.println("Arguments: number-users, number-interests, interest-density-percent");
            System.exit(0);
        }
        GenerateUserInterests generator = new GenerateUserInterests();
        int nUsers = Integer.parseInt(argv[0]);
        int nInterests = Integer.parseInt(argv[1]);
        int percentDensity = Integer.parseInt(argv[2]);
        try {
            generator.generate(nUsers, nInterests, percentDensity);
        } catch (Exception e) {
            System.out.println("Problem writig files: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void generate(int nUsers, int nInterests, int percentDensity) throws IOException {
        System.out.println("Generating users and interests tables with the following parameters:");
        System.out.println("number-users: " + nUsers);
        System.out.println("number-interests: " + nInterests);
        System.out.println("interest-density-percent: " + percentDensity);
        Charset charset = Charset.forName("US-ASCII");
        new File(USERS).delete();
        for (int u = 1; u <= nUsers; ++u) {
            String toWrite = u + "|" + "abc" + "|" + "abc@gmail.com" + "\n";
            Files.append(toWrite, new File(USERS), charset);
        }
        for (int u = 1; u <= nUsers; ++u) {
            String toWrite = u + "|" + "abc" + "|" + "abc@gmail.com" + "\n";
            Files.append(toWrite, new File(INTERESTS), charset);
        }
        for (int u = 1; u <= nUsers; ++u) {
            String toWrite = u + "|" + "abc" + "|" + "abc@gmail.com" + "\n";
            Files.append(toWrite, new File(USER_INTERESTS), charset);
        }
    }
}
