package com.datastax.ecommerce.data;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 *
 * @author Mark Kerzner
 */
public class GenerateCustomIndices {
    
    public static void main(String argv[]) {
        if (argv.length != 3) {
            System.out.println("Arguments: number-users, number-interests, interest-density-percent");
            System.exit(0);
        }
        GenerateCustomIndices generator = new GenerateCustomIndices();
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

    public void generate(int nUsers, int nInterests, int percentDensity) throws IOException {
        System.out.println("Generating users and interests tables with the following parameters:");
        System.out.println("number-users: " + nUsers);
        System.out.println("number-interests: " + nInterests);
        System.out.println("interest-density-percent: " + percentDensity);
        new File(Util.ROOT_DIR).mkdirs();
        Charset charset = Charset.forName("US-ASCII");
        // users
        String userFile = Util.ROOT_DIR + "/" + Util.USERS;
        Util util = new Util();
        new File(userFile).delete();
        for (int u = 1; u <= nUsers; ++u) {
            String userName = util.generateUserName();
            String domain = util.generateDomain();
            String toWrite = u + "|" + userName + "|" + userName + "@" + domain + "\n";
            Files.append(toWrite, new File(userFile), charset);
        }
        // interests
        String interestFile = Util.ROOT_DIR + "/" + Util.INTERESTS;
        new File(interestFile).delete();
        for (int i = 1; i <= nInterests; ++i) {
            String toWrite = i + "|" + "abc" + "|" + "abc@gmail.com" + "\n";
            Files.append(toWrite, new File(interestFile), charset);
        }
        // user interests
        String uiFile = Util.ROOT_DIR + "/" + Util.USER_INTERESTS;
        new File(uiFile).delete();
        for (int ui = 1; ui <= nUsers; ++ui) {
            String toWrite = ui + "|" + "abc" + "|" + "abc@gmail.com" + "\n";
            Files.append(toWrite, new File(uiFile), charset);
        }
    }
}
