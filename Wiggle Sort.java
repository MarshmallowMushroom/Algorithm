public void wiggleSort(int[] arr) {
  boolean less = false;
  for (int i=0; i<arr.length-1; i++) {
    if (less) {
      if (arr[i] > array[i+1]) {
        swap(i, i+1, arr);
      }
    } else {
      if (arr[i] < arr[i+1]) {
        swap(i, i+1, arr);
      }
    }
    less = !less;
  }
}

private swap(int i, int j, int[] arr) {
  int tmp = arr[i];
  arr[i] = arr[j];
  arr[j] = tmp;
}
