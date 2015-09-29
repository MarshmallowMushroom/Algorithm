/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, wherewords are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:

You may assume all letters are in lowercase. 
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
Well, this problem is not that easy. First you may need some clarifications about the problem itself. If you do, you may refer to this post for a nice example which illustrates the purpose of this problem.

Moreover, you need to understand graph representation, graph traversal and specifically, topological sort, which are all needed to solve this problem cleanly.
*/

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Solution {
	public String findOrder(String[] s) {
		Map<Character, Set<Character>> adjMatrix = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> inDegree = new HashMap<Character, Integer>();
		Set<Character> charSet = new HashSet<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length; i++) {
			String t = s[i];
			for(int j=0; j<t.length(); j++) {
				charSet.add(t.charAt(j));
				adjMatrix.put(t.charAt(j), new HashSet<Character>());
			}
		}
		for(int i=0; i<s.length-1; i++) {
			String s1 = s[i];
			String s2 = s[i+1];
			for(int j=0; j<s1.length(); j++) {
				if (j >= s2.length()) {
					return new String();
				} else if (s1.charAt(j) != s2.charAt(j)) {
					char c1 = s1.charAt(j);
					char c2 = s2.charAt(j);
					adjMatrix.get(c1).add(c2);
					if (inDegree.containsKey(c2)) {
						inDegree.put(c2, inDegree.get(c2) +1);
					} else {
						inDegree.put(c2, 1);
					}
					charSet.remove(c2);
					break;
				}
			}
		}
		Iterator<Character> iter = charSet.iterator();
		//topological sort on the
		while(iter.hasNext()) {
			//run topological sort
			char c = iter.next();
			Queue<Character> queue = new LinkedList<Character>();
			queue.add(c);
			while(!queue.isEmpty()) {
				char t = queue.poll();
				Set<Character> next = adjMatrix.get(t);
				for (char n : next) {
					inDegree.put(n, inDegree.get(n)-1);
					if (inDegree.get(n) == 0) {
						queue.add(n);
						next.remove(n);
					}
				}
				sb.append(t);
			}
		}
		return sb.toString();
		 
	}
}

