public class COVIDTracker {

  public static boolean addTest(String pos[], String neg[], String id, boolean isPos) {
    if (isPos == true) {
      for (int i = 0; i < pos.length; i++) {
        if (pos[i] == null || (pos[i].trim().length() == 0)) {
          pos[i] = id;
          return true;
        }
      }
    } else {
      for (int i = 0; i < neg.length; i++) {
        if (neg[i] == null || (neg[i].trim().length() == 0)) {
          neg[i] = id;
          return true;
        }
      }
    }
    return false;
  }

  public static boolean removeIndividual(String[] pos, String[] neg, String id) {
    int i;
    int n = pos.length;
    int m = neg.length;
    for (i = 0; i < pos.length; i++)
      if (pos[i] == id)
        break;
    // If id is found in array pos
    if (i < n) {
      // reduce size of array and move all elements one space ahead
      n = n - 1;

      for (int j = i; j < n; j++) {
        pos[j] = pos[j + 1];
      }
      pos[pos.length - 1] = null;
      return true;
    }
    int k;
    for (k = 0; k < m; k++)
      if (neg[k] == id)
        break;
    // If id is found in array neg
    if (k < m) {
      // reduce size of array and move all elements one space ahead
      m = m - 1;
      for (int l = k; l < m; l++) {
        neg[l] = neg[l + 1];
      }
      neg[neg.length - 1] = null;
      return true;
    }
    return false;
  }

  public static String getPopStats(String[] pos, String[] neg) {
    int posCount = 0;
    for (String stats : pos) {
      if (stats != null) {
        posCount++;
      }
    }
    int negCount = 0;
    for (String stats : neg) {
      if (stats != null) {
        negCount++;
      }
    }
    String result[]=mergeArrays(pos, neg);
    
    
    int uniqueTotal=countDisInd(result);
    int totaltests= posCount+negCount;
    
    int unPos = countDisInd(pos);

    double propPos = ((double) posCount / ((double) posCount + (double) negCount))*100;
    double propIndPos = ((double) unPos / ((double) uniqueTotal))*100;

    String ans = "Total tests: " + totaltests + "\n" + "Total individuals tested: "
        + uniqueTotal + "\n" + "Percent positive tests: "+ propPos + "%\n" + "Percent positive individuals: " + propIndPos+"%";

    return ans;
  }

  static int countDisInd(String arr[]){
    int res = 0;
    if(arr.length==0){
      res=0;
    }
    for (int i = 0; i < arr.length; i++) {
      int j;
      for (j = 0; j < i; j++)
        if (arr[i] == arr[j])
          break;
      if (i == j)
        res++;
    }
    if(isNull(arr)){
      res--;
    }
    return res;
  }
  
  static boolean isNull(String[] pos){
    for(int i=0;i<pos.length;i++){
      if(pos[i]==null){
        return true;
      }
    }
    return false;
  }

  static String[] mergeArrays(String arr1[], String arr2[]){
    String[] result = new String[arr1.length + arr2.length];
    for(int i=0;i<arr2.length;i++){
      result[i]=arr2[i];
    }
    for(int i=0;i<arr1.length; i++){
      result[arr2.length+i]=arr1[i];
    }
    return result;
  }

  public static String getIndividualStats(String[] pos, String[] neg, String id) {
    int totalPos = 0;
    for (int i = 0; i < pos.length; i++){
      if(pos[i]== null)
        break;
      if (pos[i].equals(id)) {
        totalPos++;
      }
   }
    int totalNeg = 0;
    for (int i = 0; i < neg.length; i++) {
      if(neg[i]== null)
        break;
      if (neg[i].equals(id)) {
        totalNeg++;
      }
    }
    
    int totalCases = totalPos + totalNeg;
    String res = "Total: "+totalCases+"\n"+"Positive: " + totalPos + "\n" + "Negative: " + totalNeg;
    return res;
  }
  public static void main(String args[]){
    String[] pos= new String[3];
    String[] neg = new String[6];
        // neg[0] = "id1"; //Added a mock value to check if the array is full
        // neg[1] = "id2"; //Added a mock value to check if the array is full
        // neg[2] = "id3"; //Added a mock value to check if the array is full
        // neg[3] = "id4"; //Added a mock value to check if the array is full
        System.out.println(addTest(pos,neg,"WIS001",false));
        System.out.println(addTest(pos,neg,"WIS002",false));
        System.out.println(addTest(pos,neg,"WIS003",false));
        System.out.println(addTest(pos,neg,"WIS004",false));
        System.out.println(addTest(pos,neg,"WIS003",false));
        System.out.println(addTest(pos,neg,"WIS002",false));

        
        System.out.println(addTest(pos,neg,"WIS004",true));
        System.out.println(addTest(pos,neg,"WIS003",true));
        System.out.println(addTest(pos,neg,"WIS003",true));

        // for(int i=0;i<neg.length;i++){
        //     System.out.print(neg[i]+" ");
        // }
        // System.out.println();
        // removeIndividual(pos,neg,"WIS002");
        
        // for(int i=0;i<neg.length;i++){
        //     System.out.print(neg[i]+" ");
        // }System.out.println();
        
        // for(int i=0;i<pos.length;i++){
        //     System.out.print(pos[i]+" ");
        // }
        System.out.println(getPopStats(pos,neg));
        
        // String res[] = new String[]
        // System.out.println();
        // System.out.println();
        // System.out.println(getIndividualStats(pos,neg,"WIS004"));
  }
}
