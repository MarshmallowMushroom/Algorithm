// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    int buff;
    boolean hasNext;
    Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
	    this.hasNext = this.iter.hasNext();
	    if (this.hasNext) {
	        buff = iterator.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.buff;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int rtn = this.buff;
	    this.hasNext = this.iter.hasNext();
	    if (this.hasNext) {
	        this.buff = this.iter.next();
	    }
	   
	    return rtn;
	}

	@Override
	public boolean hasNext() {
	    return this.hasNext;
	}
}
