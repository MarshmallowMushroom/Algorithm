/*
Read N Characters Given Read4 II - Call multiple times

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it 
returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) 
that reads n characters from the file.

Note:
The read function may be called multiple times.
*/

class BufferReader {
  ArrayList<Character> buffer = new ArrayList<Character>();
  int position;
  
  public BufferReader() {
    this.buffer = new ArrayList<Character>();
    this.position = 0;
  }
  
  public  ArrayList<Character> readN(int n) {
    ArrayList<Character> result = new ArrayList<Character>();
    while(n > 0) {
      //first read from buffer
      if (buffer != null && this.position < buffer.size()) {
        result.add(buffer.get(this.position));
        this.position++;
      } else {
        //read from the file
        int size = read4(this.buffer);
        if (size == 0) {
          this.buffer = null;
          break;
        } else {
          this.position = 0;
        }
    }
    return result;
  }

}
