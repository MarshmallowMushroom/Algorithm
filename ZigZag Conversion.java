/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

//purily implementation problem, calculate the size of each "zig", then iterate through each row and each zig

public class Solution {
    public String convert(String s, int nRows) {
        //seperate string into zigs, and each zig will have a size of nRows*2 - 2
        int zig = Math.max(1, nRows*2 - 2);
        StringBuilder tmp = new StringBuilder();
        //scan through every zig
        for (int r = 0; r < nRows; r++) {
            for (int i = 0; i < s.length(); i += zig) {
                if (r == 0) { //top row
                    tmp.append(s.charAt(i));
                }
                else if (r == nRows - 1) { //bottom row
                    if (i + r < s.length())
                        tmp.append(s.charAt(i + r));
                }
                else {//intermedian rows
                    if (i + r < s.length()) 
                        tmp.append(s.charAt(i + r));
                    if (i + zig - r < s.length())
                        tmp.append(s.charAt(i + zig - r));
                }
            }
        }
        return new String(tmp);
    }
}
