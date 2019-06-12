import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DSA_Pattern_matching_with_wildcards {
    static String tcontent, pcontent, outputString;

    public static void main(String[] args) {        
        System.out.println("1 - Matching pattern\n2 - Not matching pattern\n3 - Empty pattern and a text");
        System.out.println("4 - Empty pattern and non-empty text\n5 - Empty text and non-empty pattern");
        System.out.println("6 - Pattern with spaces\n7 - Pattern havin an underscore only");
        System.out.println("Enter an option :");
        
        Scanner s1 = new Scanner(System.in);
        String opt = s1.next();
        
        switch(opt){
            case "1":
                // Matching pattern
                readFile("q1/pattern1.txt", "q1/text1.txt");
                patternSearch();
                writeFile("q1/output1.output", outputString);                
                
                break;
                
            case "2":
                // Not matching pattern
                readFile("q1/pattern2.txt", "q1/text2.txt");
                patternSearch();
                writeFile("q1/output2.output", outputString);                
                
                break;
                
            case "3":
                // Empty pattern and a text
                readFile("q1/pattern3.txt", "q1/text3.txt");
                patternSearch();
                writeFile("q1/output3.output", outputString);               
                
                break;
                
            case "4":
                // Empty pattern and non-empty text
                readFile("q1/pattern4.txt", "q1/text4.txt");
                patternSearch();
                writeFile("q1/output4.output", outputString);                
                
                break;
                
            case "5":
                // Empty text and non-empty pattern"
                readFile("q1/pattern5.txt", "q1/text5.txt");
                patternSearch();
                writeFile("q1/output5.output", outputString);                
                
                break;
                
            case "6":
                // Pattern with spaces
                readFile("q1/pattern6.txt", "q1/text6.txt");
                patternSearch();
                writeFile("q1/output6.output", outputString);        
                
                break;
                
            case "7":
                // Pattern havin an underscore only
                readFile("q1/pattern7.txt", "q1/text7.txt");
                patternSearch();
                writeFile("q1/output7.output", outputString);               
                
                break;
                
            default:
                System.out.println("Enter a correct option");
                break;
                    
        } 
    }
   
    // matching function - naive string matching
    public static void patternSearch(){
	outputString = "";                
        // checking if text or pattern is empty
        if(tcontent.isEmpty() && pcontent.isEmpty()){
            System.out.println("Empty text and empty pattern inserted");
            outputString+= "Empty text and empty pattern inserted";
        }else if(tcontent.isEmpty()){
            System.out.println("Empty text inserted");
            outputString+= "Empty text inserted";
        }else if(pcontent.isEmpty()){
            System.out.println("Empty pattern inserted");
            outputString+= "Empty pattern inserted";
        }else{
            String t[] = tcontent.split("");         // converting inputted string to a string array
            String p[] = pcontent.split("");      // converting inputted string to a string array
            
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
                    
                    outputString += ("Pattern found at index :" + i + "\r\n");
                   
                }
            }

            if(matched == 0){
                System.out.println("Pattern not found");    // when pattern not found
                outputString = "Pattern not found";
            }
        }       
    }
    
    
    // Function to read a file
    public static void readFile(String pname, String tname){
        try
        {
            tcontent = new String ( Files.readAllBytes( Paths.get(tname) ) );        // getting the text file
            pcontent = new String ( Files.readAllBytes( Paths.get(pname) ) );     // getting the pattern file
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }               
    }
    
    
    //Function to write to a file
    public static void writeFile(String fname, String content){        
        OutputStream os1 = null;
        
        File file = new File(fname);   // deleting the existing file
        file.delete();
        
        try {
            os1 = new FileOutputStream(new File(fname));
            os1.write(content.getBytes(), 0, content.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
   
}
