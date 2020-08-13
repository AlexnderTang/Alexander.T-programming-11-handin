package sample;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class CreateFriend {
    private static String firstName;
    private static String lastName;
    private static int age;
    private static String gender;
    private static String friendGroup;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList createAllFriends(String friendGroup) throws IOException {
        fr = new FileReader(friendGroup);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                friendString += line;
            } else {
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }

    public static void parseFriend(String string) {
        int posDot = 0;
        int posComma = 0;
        int posColon = 0;
        int posNeg = 0;
        int posStar = 0;
        String firstName = "";
        String lastName = "";
        int age = 0;
        String gender = "";
        String friendGroup = "";
        for ( int i = 0; i < string.length(); i++ ) {
            if (string.substring(i, i + 1).equals(".")) {
                posDot = i;
                firstName = string.substring(0, posDot);
                for ( int x = 0; x < string.length(); x++ ) {
                    if (string.substring(x, x + 1).equals(",")) {
                        posComma = x;
                        lastName = string.substring(posDot + 1, posComma);
                        for ( int z = 0; z < string.length(); z++ ) {
                            if (string.substring(z, z + 1).equals(":")) {
                                posColon = z;
                                age = Integer.parseInt(string.substring(posComma + 1, posColon));
                                for ( int y = 0; y < string.length(); y++ ) {
                                    if (string.substring(y, y + 1).equals("-")) {
                                        posNeg = y;
                                        gender = string.substring(posColon + 1, posNeg);
                                        for ( int t = 0; t < string.length(); t++ ) {
                                            if (string.substring(t, t + 1).equals("*")) {
                                                posStar = t;
                                                friendGroup = string.substring(posNeg + 1, posStar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        Friend f = new Friend(firstName, lastName, age, gender, friendGroup);
        Boolean friendExists=false;
        for ( int i = 0; i < friends.size(); i++ ) {
            if (f.compareFriend(friends.get(i))) {
                friendExists = true;
            }
        }
        if (!friendExists) {
            friends.add(f);
        }
    }
}
