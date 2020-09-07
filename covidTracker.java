class covidTracker{

    public static boolean addTest(String pos[],String neg[],String id,boolean isPos){
        if(isPos == true){
            for(int i=0;i<pos.length;i++){
                if(pos[i] == null || (pos[i].trim().length() == 0)){
                    pos[i]=id;
                    return true;
                }
            }
        }else{
            for(int i=0;i<neg.length;i++){
                if(neg[i] == null || (neg[i].trim().length() == 0)){
                    neg[i]=id;
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean removeIndividual(String[] pos, String[] neg,String id){
        int i; 
        int n = pos.length;
        int m = neg.length;
        for (i=0; i<pos.length; i++) 
            if (pos[i] == id) 
                break; 
        // If id is found in array pos
        if (i < n) 
        { 
            // reduce size of array and move all elements one space ahead 
            n = n - 1; 
         
            for (int j=i; j < n; j++){
                pos[j] = pos[j+1];
            }
            pos[pos.length-1]="";
            return true;
        }
        int k; 
        for (k=0; k < m; k++) 
            if (neg[k] == id) 
                break; 
        // If id is found in array neg
        if (k < m) 
        { 
            // reduce size of array and move all elements one space ahead 
            m = m - 1; 
            for (int l=k; l < m; l++){
                neg[l] = neg[l+1];
            }
            neg[neg.length-1]="";
            return true;
        }
        return false;
    }
    public static String getPopStats(String[] pos,String[] neg){
        int posCount = 0;
        for(String stats : pos) {
            if(stats != null) {
                posCount++;
            }
        }
        int negCount = 0;
        for(String stats : neg) {
            if(stats != null) {
                negCount++;
            }
        }
        int unPos = countDistinct(pos);
        int unNeg = countDistinct(neg);
        float propPos= (float)posCount/((float)posCount+(float)negCount);
        float propIndPos = (float)unPos/((float)unNeg+(float)unPos);
        
        String ans = "Total covid positive cases: " + posCount +"\n"+
                      "Total covid negative cases: "+ negCount +"\n"+
                      "Unique individual positive cases: "+ unPos +"\n"+
                      "Unique individual negative cases: "+ unNeg +"\n"+
                      "Proportion of positive cases:" + propPos +"\n"+
                      "Proportion of individuals tested positive: " +propIndPos;
                      
        return ans;
    }
    static int countDistinct(String arr[]) 
    { 
        int res = 1; 
    
        // Pick all elements one by one 
        for (int i = 1; i < arr.length; i++)  
        { 
            int j = 0; 
            for (j = 0; j < i; j++) 
                if (arr[i] == arr[j] || arr[i]== null || arr[j] == null) 
                    break;  
            if (i == j) 
                res++; 
        } 
        return res; 
    } 
    public static String getIndividualStats(String[] pos, String[] neg,String id){
        int totalPos=0;
        for(int i=0;i<pos.length;i++){
            if(pos[i]==id){
                totalPos++;
            }
        }
        int totalNeg=0;
        for(int i=0;i<neg.length;i++){
            if(neg[i]==id){
                totalNeg++;
            }
        }
        int totalCases=totalPos+totalNeg;
        String res = "Total Positive Tests: "+totalPos +"\n"+
                     "Total Negative Tests: "+totalNeg +"\n"+
                     "Total Cases for Individual with Id- "+id+ " are: "+totalCases;
        return res;
    }
    public static void main(String args[]){
        String[] pos= new String[3];
        String[] neg = new String[4];
        // neg[0] = "id1"; //Added a mock value to check if the array is full
        // neg[1] = "id2"; //Added a mock value to check if the array is full
        // neg[2] = "id3"; //Added a mock value to check if the array is full
        // neg[3] = "id4"; //Added a mock value to check if the array is full
        System.out.println(addTest(pos,neg,"WIS001",false));
        System.out.println(addTest(pos,neg,"WIS002",false));
        System.out.println(addTest(pos,neg,"WIS003",false));
        System.out.println(addTest(pos,neg,"WIS004",false));
        
        System.out.println(addTest(pos,neg,"WIS004",true));

        for(int i=0;i<neg.length;i++){
            System.out.print(neg[i]+" ");
        }
        System.out.println();
        removeIndividual(pos,neg,"WIS002");
        
        for(int i=0;i<neg.length;i++){
            System.out.print(neg[i]+" ");
        }System.out.println();
        
        for(int i=0;i<pos.length;i++){
            System.out.print(pos[i]+" ");
        }
        System.out.println(getPopStats(pos,neg));
        System.out.println();
        System.out.println();
        System.out.println(getIndividualStats(pos,neg,"WIS004"));
    }
}