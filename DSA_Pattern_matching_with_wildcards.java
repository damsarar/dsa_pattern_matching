public class DSA_Pattern_matching_with_wildcards {

    public static void main(String[] args) {
        String[] t = "cogwrgaccag".split("");
	String p[] = "c_g".split("");
	patternSearch(t, p);
    }
   
    public static void patternSearch(String[] t, String[] p){
	int n = t.length;
	int m = p.length;
	int matched = 0;
	int i;
	
	for(i=0; i<=n-m; i++){
            int j;
            for(j=0; j<m; j++){                
                if(!(t[i+j].equals(p[j]))){
                    if(!(p[j].equals("_"))){
                        break;
                    }
                }
            }
            if(j==m){
                System.out.println("Pattern found at index :" + i);
                matched = 1;                
            }
	}
	
	if(matched == 0){
            System.out.println("Pattern not found");
	}
    }    
}
