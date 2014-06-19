/*
Reverse Words in a String
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

*/
//solution using a stack
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();//remove heading or trailing string
        Stack<Character> word = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                    word.push(s.charAt(i));
            }
            else {
                if (word.isEmpty()) // skip continuous spaces
                    continue;
                while(!word.isEmpty())
                    result.append(word.pop());
                result.append(" ");
            }
        }
        //last word push
        while(!word.isEmpty())
            result.append(word.pop());
        return new String(result);
    }
}

//solution without using a stack, find the index and length and each separate word
public class Solution {
    public String reverseWords(String s) {
       s=s.trim();
       if (s.length() == 0)
           return "";
       StringBuilder tmp = new StringBuilder();
       for (int i = s.length()-1; i >= 0; i--) {
           if (s.charAt(i) != ' ') {
               int j = i;
               while(j >= 0 && s.charAt(j) != ' ') {
                   j--;
               }
               if (j >= 0)
                tmp.append(s.substring(j+1, i+1) + " ");
               else
                tmp.append(s.substring(0, i+1)); //last word
               i = j;
           }
       }
       return new String(tmp);
    }
}
