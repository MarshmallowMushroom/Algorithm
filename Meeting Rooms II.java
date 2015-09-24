//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

public int numMeetingRooms(Interval[] meetings) {
  Arrays.sort(meetings, new Comparator<Interval>() {
    @Override
    public int compare (Interval i1, Interval i2) {
      if (i1.start != i2.start) {
        return i1.start.compareTo(i2.start);
      }
      return i1.end.compareTo(i2.end);
    }
    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(10, new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        return i1.end.compareTo(i2.end);
      }
    }
    int max = 0;
    for(int i=0; i<meetings.length(); i++){
      Interval m = meetings[i];
      if (heap.isEmpty() || heap.element().end >= m.start) {
        max++;
      } else {
        heap.remove();
      }
      heap.add(m);
    }
    return max;
}
