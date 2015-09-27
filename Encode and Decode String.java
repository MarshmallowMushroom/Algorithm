

public String encode(String[] s) {
  StringBuilder sb = new StringBuilder();
  for(int i=0; i<s.length; i++) {
    String curr = s[i];
    sb.append(String.valueOf(curr.length()));
    sb.append("#");
  }
  return sb.toString();
}

public String[] decode(String s) {
  idx = 0;
  List<String> res = new ArrayList<String>();
  while(idx < s.length) {
    int len = Integer.parseInt(s.charAt(idx));
    String curr = s.substring(idx+2, idx+2+len);
    res.add(curr);
    idx += 1+len+1;
  }
  String[] rtn = new String(res.size());
  int i = 0;
  for (String t : res) {
    rtn[i] = t;
    i++;
  }
  return rtn
}
