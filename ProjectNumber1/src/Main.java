public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;
        //your code here
        //used for loop to loop through the characters of String s. If encountering 'a' 'e' 'i' 'o' 'u', int answer will increase by 1.
        for (int i = 0; i<s.length();i++){

            if((s.charAt(i) == 'a')||
                    (s.charAt(i)=='e')||
                    (s.charAt(i)=='i')||
                    (s.charAt(i)=='o')||
                    (s.charAt(i)=='u')){

                answer++;
            }
        }
        return answer;
    }
    //Code you problem number two here
    static int problemTwo(String s){
        int answer = 0;
        //your code here
        /*
        used for loop to loop through the characters of String s and stop at the second last character. If the characters of three consecutive indexes of
        String s is "bob" then answer will increase by 1.
        */
        for (int i=0;i<s.length()-2;i++){

            if (s.substring(i, i + 3).contains("bob")){
                answer++;
            }
        }
        return answer;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s) {
        //your code here
        /*
        Initialize longestSubString as a blank String and currentSubString as blank String + the first char of String s.
        Then use for loop to loop through the chars of String s.
        If a char of String s is greater or equal to the final char of currentSubString, then add the char of String s to the end of currentSubString.
        Then check the next if statement. If the char is the last of String s, and the currentSubString is longer than longestSubString, make the longestSubString equal to currentSubString.
        When both if conditions are false, move onto the else if statement. If the length of currentSubString is longer than longestSubString, make the longestSubString equal to currentSubString and make the currentSubString blank + the current String s char that's being looped.
        When all of the above are false, make the currentSubString blank + current String s char that's being looped.
         */
        String longestSubString = "";
        String currentSubString = "" + s.charAt(0);
        for ( int i = 1; i < s.length(); i++ ) {
            if (s.charAt(i) >= currentSubString.charAt(currentSubString.length() - 1)) {
                currentSubString += s.charAt(i);

                if ((i == s.length() - 1) && (currentSubString.length() > longestSubString.length())) {
                    longestSubString = currentSubString; }
            }
            else if (currentSubString.length() > longestSubString.length()){
                    longestSubString = currentSubString;
                    currentSubString = "" + s.charAt(i);}

            else {currentSubString = "" + s.charAt(i);}
            }

        s = longestSubString;

            return s;


    }

    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;
        System.out.println(problemOne("aeiouaeiouqwrthgfd"));
        System.out.println(problemTwo("ooboobob"));
        System.out.println(problemThree("abcdefgh"));
    }
}
