package com.arya.string;

public class DeleteSubSeqCharInString {

    public static void main(String[] args) {
        // String str = "abcccddbcaab";
        // String str = "aabcccdee";
        // String str = "abcdeedcbfgf";
        String str = "abbabba";
        System.out.println(delSubSeqChars(str));

    }

    private static String delSubSeqChars(String str) {
        int pos = -1;
        int j = 0;

        StringBuilder sb = new StringBuilder(str + " ");

        for (j = 0; j < sb.length() - 1; ) {
            if (sb.charAt(j) == sb.charAt(j + 1)) {
                pos = j;
            } else {
                j++;
            }

            while (pos > -1) {
                if ((sb.charAt(j) == sb.charAt(j + 1))) {
                    sb.deleteCharAt(j);
                } else {
                    sb.deleteCharAt(j);
                    pos = -1;
                    j = 0;
                }

            }
        }
        return sb.toString();
    }

}
