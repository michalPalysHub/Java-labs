package com.company.Substring;

public class Substring {

    public boolean[] checkLettersUsedInString(String string){
        // checkes which letters were used in the string
        int counter = 0, index = 0;
        boolean[] lettersUsed = new boolean[26];

        for (int i = 0; i < string.length(); i++){
            if ('a' <= string.charAt(i) && string.charAt(i) <= 'z') {
                index = string.charAt(i) - 'a';
            } else if ('A' <= string.charAt(i) && string.charAt(i) <= 'Z') {
                index = string.charAt(i) - 'A';
            }
            lettersUsed[index] = true;
        }
       return lettersUsed;
    }

    public boolean compareTwoStrings(String a, String b){
        // compares two strings in terms of letters usage
        boolean sameLettersUsed = true;
        boolean[] lettersUsedInStringA = checkLettersUsedInString(a);
        boolean[] lettersUsedInStringB = checkLettersUsedInString(b);
        for (int i = 0; i < 26; i++){
            if (lettersUsedInStringA[i] != lettersUsedInStringB[i]){
                sameLettersUsed = false;
                break;
            }
        }
        return sameLettersUsed;
    }

    public int substring(String a, String b) throws DifferentLettersException {
        if (a.isEmpty() || b.isEmpty()){
            throw new IllegalArgumentException("The arguments cannot be empty Strings!");
        }
        if (!compareTwoStrings(a,b)){
            throw new DifferentLettersException("The two strings must consist of the same letters!");
        }

        int counter = 1;
        String tmp = a;
        do{
            if(a.contains(b)){
               return counter;
            }
            a = a.concat(tmp);
            counter++;
        }
        while (a.length() * b.length() > counter);
        return -1;
    }
}
