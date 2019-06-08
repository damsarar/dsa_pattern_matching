#include<bits/stdc++.h> 
using namespace std; 

void patternSearch(char* t, char* p){
	int n = strlen(t);
	int m = strlen(p);
	int matched = 0;
	int i;
	
	for(i=0; i<=n-m; i++){
		int j;
		for(j=0; j<m; j++){
			if(t[i+j] != p[j]){
				if(p[j] != '_'){
					break;
				}	
			}
		}
		if(j==m){
			cout<<"Pattern matched at index : "<<i<<endl;
			matched = 1;
		}
	}
	
	if(matched == 0){
		cout<<"Pattern not found "<<endl;
	}
}

int main(){
	char t[] = "cogwrgaccag";
	char p[] = "c_g";
	patternSearch(t, p);
	
	return 0;
}



