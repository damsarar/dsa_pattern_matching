public class DSA_Pattern_matching_with_wildcards {
    static String tcontent, pcontent;

    public static void main(String[] args) {        
        
        try
        {
            tcontent = new String ( Files.readAllBytes( Paths.get("text1.txt") ) );        // getting the text file
            pcontent = new String ( Files.readAllBytes( Paths.get("pattern1.txt") ) );     // getting the pattern file
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        // checking if text or pattern is empty
        if(tcontent.isEmpty() && pcontent.isEmpty()){
            System.out.println("Empty text and empty pattern inserted");
        }else if(tcontent.isEmpty()){
            System.out.println("Empty text inserted");
        }else if(pcontent.isEmpty()){
            System.out.println("Empty pattern inserted");
        }else{
            String text[] = tcontent.split("");         // converting inputted string to a string array
            String pattern[] = pcontent.split("");      // converting inputted string to a string array
       
            patternSearch(text, pattern);     // calling the matching function
        }            
    }
   
    // matching function - naive string matching
    public static void patternSearch(String[] t, String[] p){
	int n = t.length;
	int m = p.length;
	int matched = 0;
	int i;
        
        // looping through the text
	for(i=0; i<=n-m; i++){
            int j;
            
            //looping through the pattern
            for(j=0; j<m; j++){                
                if(!(t[i+j].equals(p[j]))){       
                    if(!(p[j].equals("_"))){
                        break;                  // in here loop will break if there is a mismatch or the current character is not the '_'
                    }
                }
            }
            if(j == m){     // if the j goes to the last index of the pattern, then the pattern is matched
                System.out.println("Pattern found at index :" + i);
                matched = 1;                
            }
	}
	
	if(matched == 0){
            System.out.println("Pattern not found");
	}
    }
    
}