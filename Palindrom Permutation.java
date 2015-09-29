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
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Solution {
    public List<String> palindromPermutation(String s) {
        Map<Character, Integer> set = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if (set.containsKey(c)) {
        		set.put(c, set.get(c)+1);
        	} else {
        		set.put(c, 1);
        	}
        }
        Iterator<Entry<Character, Integer>> iter = set.entrySet().iterator();
        List<String> res = new ArrayList<String>();
        int odd = 0;
        char oddChar = 'n';
        StringBuilder perm = new StringBuilder();
        while(iter.hasNext()) {
        	Entry<Character, Integer> e = iter.next();
        	if (e.getValue()%2 != 0) {
        		if (odd == 1) {
        			return res;
        		} else {
        			odd =1;
        			oddChar = e.getKey();
        			e.setValue(e.getValue()-1);
        		}
        	}
        	for(int j=0; j<e.getValue()/2; j++) {
        		perm.append(e.getKey());
        	}
        }
        List<String> list = generatePerm(perm);
        if (odd == 1) {
        	for(String p : list) {
        		res.add(p + oddChar + new StringBuilder(p).reverse().toString());
        	}
        } else {
        	for(String p : list) {
        		res.add(p + new StringBuilder(p).reverse().toString());
        	}
        }
        return res;
    }
    
    private List<String> generatePerm(StringBuilder sb) {
    	List<String> res = new ArrayList<String>();
    	if (sb.length() == 0) {
    		res.add("");
    		return res;
    	}
    	Set<Character> visited = new HashSet<Character>();
    	for(int i=0; i<sb.length(); i++) {
    		char c = sb.charAt(i);
    		if (!visited.contains(c)) {
    			visited.add(c);
    			StringBuilder n = new StringBuilder(sb);
    			List<String> next = generatePerm(n.deleteCharAt(i));
    			for(String s : next) {
    				res.add(c + s);
    			}
    		}
    	}
    	return res;
    }
}
