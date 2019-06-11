public class DSA_DNA_Pattern_matching {
    static List<String> datalines = new ArrayList<>();             // list to store read lines of DNA database
    static List<String> querylines = new ArrayList<>();            // list to store read lines of query base
    static Map<String, String> data = new LinkedHashMap<>();       // map to store DNA database (description, string) pairs
    static Map<String, String> queries = new LinkedHashMap<>();    // map to store query base (description, string) pairs
    public final static int nalph = 4;                             // no of characters in the alphabet
    static String tempkey;                                         // variable to store the description temporary
    static int foundAt;                                            // variable to store the value returned by the matching algorithm
    static int status;                                             // variable to store the matched status temporary
    static int primeno = 101;                                      // variable to store the prime number
    
    public static void main(String[] args) {
        try {            
            // reading the DNA database and the query base
            datalines = Files.readAllLines(Paths.get("DNA Database.txt"));
            querylines = Files.readAllLines(Paths.get("Querybase.txt"));
        } catch (IOException ex) {
            Logger.getLogger(DSA_DNA_Pattern_matching.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        // looping through the list of read lines of DNA database
        for(int i = 0; i < datalines.size(); i++) {
            if(datalines.get(i).contains(">")){                   // checking if the current line has '>' as a string
                tempkey = datalines.get(i).replace(">", "");      // remove the '>' in the line
                data.put(tempkey, "");                            // adding the description as a key in the map
                
            }else{
                data.put(tempkey, data.get(tempkey)+datalines.get(i));   // adding values to the particular keys
            }
           
        }        
        
        // looping through the list of read lines of query base
        for(int i = 0; i < querylines.size(); i++) {
            if(querylines.get(i).contains(">")){                  // checking if the current line has '>' as a string
                tempkey = querylines.get(i).replace(">", "");     // remove the '>' in the line
                queries.put(tempkey, "");                         // adding the description as a key in the map
                
            }else{
                queries.put(tempkey, queries.get(tempkey)+querylines.get(i));   // adding values to the particular keys
            }
           
        }
        
        // removing the EOF keys from the 2 maps
        queries.remove("EOF");
        data.remove("EOF");
        
        // looping through the queries map
        queries.forEach((pdescription, pattern) -> {
            status = 0;
            System.out.println(pdescription);
            
            // looping through the DNA database map
            data.forEach((tdescription, text) ->{
                  foundAt = rabinKarp(pattern, text, primeno);          // getting the matched offset by calling the rabinKarp mrthod
                  if(foundAt != -1){
                      status = 1;
                      System.out.println("[" +tdescription + "]" + " at offset " + foundAt);
                  }              
            });
            
            if(status == 0){
                    System.out.println("NOT FOUND");
            }  
        });        
    }
    
    
    static int rabinKarp(String p, String t, int prime){ 
        int m = p.length();         // length of the pattern
        int n = t.length();         // length of the text
        int i, j;
        int h = 1;              
        int ph = 0;                 // hash value of the pattern
        int th = 0;                 // hash value of the text 
         
     
        i=0;
        while(i < m-1){
            h = (h*nalph)%prime;
            i++;
        }
      
        // calculating the hash value of the pattern and th eparticular text portion
        i=0;
        while(i < m){
            ph = (p.charAt(i) + nalph*ph)%prime; 
            th = (t.charAt(i) + nalph*th)%prime;
            i++;
        }
      
      // looping through a particular portion of text and checking for a match
        i=0;
        while(i <= n - m){
            if(ph == th){                  // checing if the to hash values are same
                j = 0;
                while(j < m){
                    if (t.charAt(i+j) != p.charAt(j)){          // checking for a match
                        break;
                    }
                    j++;
                }
                
                if(j == m){                  // match found
                    return i;
                }
            }
            
            // finding tha hash value of the next text portin
            if (i < n-m){
                th = (nalph*(th - t.charAt(i)*h) + t.charAt(i+m))%prime;
                if (th < 0){
                    th = (th + prime);
                }
            }
            
            i++;
        }
    
        return -1;
        
    }
}