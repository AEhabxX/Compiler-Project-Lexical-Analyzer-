/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.project;

/**
 *
 * @author EGYPTLAPTOP
 */
public class Lex {
    char []vaildinp={'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'h', 'I', 'i', 'k', 'l', 'M' , 'N', 'n', 'O', 'o', 'g', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', '@', ';', '_', '=', '>', '<', '!', '+', '-', '/', '*', '#', '[', ']', '{', '}', '\'', '’', '.', '&', '|', '~'};
    char []digit={'0','1','2','3','4','5','6','7','8','9'};
    char []alpha={'_','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    public boolean isvalidinp(char x){
        boolean f=false;
       for (int i=0;i<vaildinp.length;i++){
           if (x==vaildinp[i]){
               f=true;
               break;}
           else
               f=false;
       }
        return f;  
}
    
    public boolean isdigit(char x){
        boolean f=false;
       for (int i=0;i<digit.length;i++){
           if (x==digit[i]){
               f=true;
               break;}
           else
               f=false;
       }
        return f;
    
}
public boolean isalpha(char x){
        boolean f=false;
       for (int i=0;i<alpha.length;i++){
           if (x==alpha[i]){
               f=true;
               return f;}
           else
               f=false;
       }
        return f;
}
}

