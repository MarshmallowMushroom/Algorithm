Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

public boolean canAttendMeetings(Interval[] meetings) {
  Arrays.sort(meetings, new Comparator<Interval>() {
    @Override
    public int compare(Interval i1 Interval i2) {
      if (i1.start != i2.start) {
        return i1.start.compareTo(i2.start);
      } else {
        return i1.end.compareTo(i2.end);
      }
    }
  ));
  for (int i=1; i<meetings.length; i++) {
    Interval i1 = meetings[i-1];
    Interval i2 = meetings[i];
    if (i1.end >= i2.start) {
      return false;
    }
  }
  return true;
}
