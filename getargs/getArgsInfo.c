#include "argsInfo.h"
#include <stdlib.h>

/* Parses string argument which contains words
 * separated by whitespace.  It returns an
 * argsInfo data structure which contains an
 * array of the parsed words and the number
 * of words in the array.
 */
argsInfo getArgsInfo(char * string) {
    argsInfo info;
   /* TODO: Implement the function */
char s;
int n[100]={0},w=0,b=0,l,a,i,temp; 

l = strlen(string);               
info.argc=0;                


if(l>0)
{
    for(a=0; a<l; a++)
    {
    s = string[a];
    
    if(s != ' ')    /*counts the number of letters in each word*/
    {
        n[w]++;  
     }    
    if(s == ' ')    /* counts the total number of words*/
    {
       w++;    
     }
    }

    
info.argc = w+1; /* w + 1 is the actual amount of words */
info.argv = (char**)malloc((w+1)*sizeof(char*));  /* allocates memory for (w+1) pointers */

for(a=0; a<(w+1); a++)
{
    info.argv[a] = (char*)malloc((n[a]+1)*sizeof(char*));   /* allocates memory for the amount of letters in the word*/
}                                                  
for(a=0; a<(w+1); a++)
{
    for(i=0; i<n[a]; i++) /* goes through the string again and stores the chars into the allocated memory*/
    {   
        s = string[b+i];
        info.argv[a][i] = s;  
        temp = i;                
                          
    } 
    b = (b+temp+2);
  }
}


    


 return info;
}
	






 
