package com.datastax.ecommerce.data;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mark Kerzner
 */
public class GenerateCustomIndices {

    public static void main(String argv[]) {
        if (argv.length != 3) {
            System.out.println("Arguments: number-users, number-interests, number-user-interests");
            System.exit(0);
        }
        GenerateCustomIndices generator = new GenerateCustomIndices();
        int nUsers = Integer.parseInt(argv[0]);
        int nInterests = Integer.parseInt(argv[1]);
        int nUserInterests = Integer.parseInt(argv[2]);
        try {
            generator.generate(nUsers, nInterests, nUserInterests);
        } catch (Exception e) {
            System.out.println("Problem writig files: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void generate(int nUsers, int nInterests, int nUserInterests) throws IOException {
        System.out.println("Generating users and interests tables with the following parameters:");
        System.out.println("number-users: " + nUsers);
        System.out.println("number-interests: " + nInterests);
        System.out.println("number-user-interests: " + nUserInterests);
        new File(Util.ROOT_DIR_B).mkdirs();
        Charset charset = Charset.forName("US-ASCII");
        // users
        String userFile = Util.ROOT_DIR_B + "/" + Util.USERS;
        Util util = new Util();
        new File(userFile).delete();
        for (int u = 1; u <= nUsers; ++u) {
            String userName = util.generateUserName();
            String domain = util.generateDomain();
            String toWrite = Util.userFormat.format(u) + "|" + userName + "|" + userName + "@" + domain + "\n";
            Files.append(toWrite, new File(userFile), charset);
        }
        // interests
        String interestFile = Util.ROOT_DIR_B + "/" + Util.INTERESTS;
        new File(interestFile).delete();
        for (int i = 1; i <= nInterests; ++i) {
            String interest = util.generateInterest();
            String toWrite = Util.interestFormat.format(i) + "|" + interest + "|" + interest + " is a ..." + "\n";
            Files.append(toWrite, new File(interestFile), charset);
        }
        // user interests
        String uiFile = Util.ROOT_DIR_B + "/" + Util.USER_INTERESTS;
        new File(uiFile).delete();
        Map<String, String> userInterests = new HashMap<String, String>();
        Map <String, String> interestUsers = new HashMap<String, String>();
        for (int ui = 1; ui <= nUserInterests; ++ui) {
            String user = Util.userFormat.format(util.generateInt(1, nUsers));
            String interest = Util.interestFormat.format(util.generateInt(1, nInterests));
            userInterests.put(user, interest);
            interestUsers.put(interest, user);
        }
    }
}
