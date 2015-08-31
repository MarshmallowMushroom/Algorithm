/*Shortest Word Distance
Problem Description:

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public int shortestDistance(String word1, String word2, String[] words) {
  String preWord = null;
  int index1 = -1;
  int index2 = -1;
  int minDist = words.length - 1;
  for(int i=0; i<words.length; i++) {
    String currWord = words[i];
    if (currWord.equals(word1)) {
      if (index2 != -1) {
        minDist = Math.min(minDist, i - index2);
      }
      index1 = i;
    } else if (currWord.equals(word2)) {
      if (index1 != -1) {
        minDist = Math.min(minDist, i - index1);
      }
      index2 = i;
    }
  }
  return minDist;
}
  
