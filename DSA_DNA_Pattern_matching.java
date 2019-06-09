
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSA_DNA_Pattern_matching {
    static List<String> datalines = new ArrayList<>();
    static List<String> querylines = new ArrayList<>();
    static Map<String, String> data = new HashMap<>();
    static Map<String, String> queries = new HashMap<>();
    public final static int d = 256;     
    static String tempkey;
    static int foundAt;
    static int status;
    
    public static void main(String[] args) {
        try {
            datalines = Files.readAllLines(Paths.get("C:\\Users\\Damsara\\Desktop\\UCSC Downloads\\Second Year\\Semester 1\\SCS 2201 - DSA 3\\Assignment 1\\DSA_Pattern_matching_assignment\\DNA Database.txt"));
            querylines = Files.readAllLines(Paths.get("C:\\Users\\Damsara\\Desktop\\UCSC Downloads\\Second Year\\Semester 1\\SCS 2201 - DSA 3\\Assignment 1\\DSA_Pattern_matching_assignment\\Querybase.txt"));
        } catch (IOException ex) {
            Logger.getLogger(DSA_DNA_Pattern_matching.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        for(int i = 0; i < datalines.size(); i++) {
            if(datalines.get(i).contains(">")){
                tempkey = datalines.get(i).replace(">", "");
                data.put(tempkey, "");
                
            }else{
                data.put(tempkey, data.get(tempkey)+datalines.get(i));
            }
           
        }        
        
        for(int i = 0; i < querylines.size(); i++) {
            if(querylines.get(i).contains(">")){
                tempkey = querylines.get(i).replace(">", "");
                queries.put(tempkey, "");
                
            }else{
                queries.put(tempkey, queries.get(tempkey)+querylines.get(i));
            }
           
        }
        
        queries.remove("EOF");
        data.remove("EOF");
        
//        System.out.println(" "+ data);
//        System.out.println(" "+ queries);//        
       
        queries.forEach((pdescription, pattern) -> {
            status = 0;
            System.out.println(pdescription);
            data.forEach((tdescription, text) ->{
                  foundAt = rabinKarp(pattern, text, d);
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
    
    
    static int rabinKarp(String p, String t, int q){ 
        int m = p.length(); 
        int n = t.length(); 
        int i, j;
        int h = 1;               
        int ph = 0;              // pattern hash value
        int th = 0;              // text hash value 
         
      
        // The value of h would be "pow(d, M-1)%q"
        i=0;
        while(i < m-1){
            h = (h*d)%q;
            i++;
        }
      
        // Calculate the hash value of pattern and first 
        // window of text 
        
        i=0;
        while(i < m){
            ph = (p.charAt(i) + d*ph)%q; 
            th = (t.charAt(i) + d*th)%q;
            i++;
        }
      
        // Slide the pattern over text one by one 
    
        i=0;
        while(i <= n - m){
            if(ph == th){
                j = 0;
                while(j < m){
                    if (t.charAt(i+j) != p.charAt(j)){
                        break;
                    }
                    j++;
                }
                
                if(j == m){
//                    System.out.println("Pattern found at index " + i);
                    return i;
                }
            }
            
            if (i < n-m){
                th = (d*(th - t.charAt(i)*h) + t.charAt(i+m))%q;
                if (th < 0){
                    th = (th + q);
                }
            }
            
            i++;
        }
    
        return -1;
        
    }
}
