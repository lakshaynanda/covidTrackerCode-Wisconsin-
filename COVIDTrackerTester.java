
public class COVIDTrackerTester {
  public static void main(String args[]) {

    testGetIndividualStats();
  }

  public static boolean testAddTest() {
    // two empty arrays -> true; also checking that arrays were updated properly
    String[] pos = new String[2];
    String[] neg = new String[2];
    if (!COVIDTracker.addTest(pos, neg, "AB1234", false) || neg[0] == null)
      return false;
    if (!COVIDTracker.addTest(pos, neg, "CD2345", true) || pos[0] == null)
      return false;
    // two arrays with space -> true
    if (!COVIDTracker.addTest(pos, neg, "CD2345", false) || neg[1] == null)
      return false;
    // one full array but adding to one with space -> true
    if (!COVIDTracker.addTest(pos, neg, "EF3456", true) || pos[1] == null)
      return false;
    // one array with space but adding to full one -> false
    String[] pos2 = new String[2];
    if (COVIDTracker.addTest(pos2, neg, "EF3456", false))
      return false;
    // two full arrays -> false
    if (COVIDTracker.addTest(pos, neg, "EF3456", true))
      return false;
    return true;
  }

  
  public static boolean removeIndividual() {
    // two empty arrays -> true; also checking that arrays were updated properly
    String[] pos = new String[2];
    String[] neg = new String[2];
    if (!COVIDTracker.removeIndividual(pos, neg, "AB1234") || neg[0] == null)
      return false;
    if (!COVIDTracker.removeIndividual(pos, neg, "CD2345") || pos[0] == null)
      return false;
    // two arrays with space -> true
    if (!COVIDTracker.removeIndividual(pos, neg, "CD2345") || neg[1] == null)
      return false;
    // one full array but adding to one with space -> true
    if (!COVIDTracker.removeIndividual(pos, neg, "EF3456") || pos[1] == null)
      return false;
    // one array with space but adding to full one -> false
    String[] pos2 = new String[2];
    if (COVIDTracker.removeIndividual(pos2, neg, "EF3456"))
      return false;
    // two full arrays -> false
    if (COVIDTracker.removeIndividual(pos, neg, "EF3456"))
      return false;
    return true;
  }
  
  public static boolean testGetIndividualStats() {
    // two empty arrays -> true; also checking that arrays were updated properly
    String[] pos = new String[2];
    String[] neg = new String[2];
    if((COVIDTracker.getIndividualStats(pos, neg, "AB1234").equals("Total: 0\nPositive: 0\nNegative: 0"))){
      return (COVIDTracker.getIndividualStats(pos, neg, "AB1234").equals("Total: 0\nPositive: 0\nNegative: 0"));
    }
    if((COVIDTracker.getIndividualStats(pos, neg, "CD2345").equals("Total: 0\nPositive: 0\nNegative: 0"))){
      return (COVIDTracker.getIndividualStats(pos, neg, "CD2345").equals("Total: 0\nPositive: 0\nNegative: 0"));
    }
    if((COVIDTracker.getIndividualStats(pos, neg, "EF3456").equals("Total: 0\nPositive: 0\nNegative: 0"))){
      return (COVIDTracker.getIndividualStats(pos, neg, "EF3456").equals("Total: 0\nPositive: 0\nNegative: 0"));
    }
    return false;
    
      
  }
  
  
 


}
