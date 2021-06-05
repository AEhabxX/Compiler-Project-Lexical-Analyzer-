/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.project;

import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author EGYPTLAPTOP
 */
public class Scanner {
    
    Lex lex =new Lex();

    public Scanner() {
        
        
    }
    
    //ArrayList<Character> bufferWord = new ArrayList<Character>();
    LexemesDictionary table = new LexemesDictionary();
    String[][] t = table.Lexemes;
    boolean inSingleLineComment=false;
    boolean inMultiLineComment=false;
    boolean isFirstState=true;
    int Line_no = 0;
    
    //bufferWord is the input we get from the file
    String bufferWord = new String();
    
    //next char in file
    String fchar= new String();
    
    //nextState is the state we are going to look for next
    String nextState = new String();
    
    //passedrow is a string that has a specific row in the table so we can compare it
    String []passedRow = new String [62];
    
    //passedrow is a string that has a specific column in the table so we can compare it
    String []passedColumn = new String [157];
    
    //size of the bufferWord
    public int bufferSize;
    
    //the number of the row we look in for the next state
    int NoOfRow;
    
    int identifier=0;
    int error =0;
    
    
    
    String save="";
        public String[] getrow2(String nextState){
    for (int i = 0; i < 157; i++) {
            //we get the number of the row that the state is at
            if(nextState.equals(passedColumn[i])){
                //System.out.println("state"+"    "+passedColumn[i]);
                NoOfRow = i;
                 
     }}
    String[] Row = new String[62];
    for (int i = 0; i < 62; i++) {
            Row[i] = t[NoOfRow][i];
        }
    return Row;
    }

     // function that finds first state
    public void findFirstState() {
        switch (identifier){
            case 0:
        save=save+bufferWord.charAt(bufferSize-1);
        System.out.println("first"+"  "+save);
        String lexeme = Character.toString(bufferWord.charAt(bufferSize-1));
        /*if(Character.isDigit((bufferWord.charAt(bufferSize-1)))){
        nextState="334'";
        break;
        }*/
        //62 is the number of columns
        int y=0;
        for (int i = 0; i < 62; i++) {
            //y string has the top row of the table
            //so we compare the first letter in the input to see if it matches
            //any of the character or nums in the top of the transtion table
            
            if (lexeme.equals(passedRow[i])) {
                y=1;
                nextState = table.Lexemes[1][i];
                System.out.println(nextState);
                if (nextState.equals("0")){
 
                    y=0;
                    break;
                    }
                System.out.println("First State"+"      "+nextState);
                String [] f=getrow2(nextState);
            if(f[60].equals("yes")){
            System.out.println(save + "    " +"return"+"    "+f[61]);
            isFirstState=true;
            
            save="";
                break;
            }
            else{isFirstState=false;}}
        }
        if(y==0){
            isFirstState=false;
            
            identifier=1;
            
            if(Character.isDigit((bufferWord.charAt(bufferSize-1)))){
                
                error=1;
                                   
                    }}
        break;
            case 1:
                save=save+bufferWord.charAt(bufferSize-1);
                isFirstState=false;
                break;
        }
        }
    //method that finds the next state
    public void getNextState(String buffer, String[][] t) {

        //get the first column in the string called passedColumn
        //so we can compare that column to other strings
        
 switch(identifier){
            
    case 0:
        
        getColumn(0,t);
        
        //find the number of the row that has the state
        for (int i = 0; i < 157; i++) {
            //we get the number of the row that the state is at
            if(nextState.equals(passedColumn[i])){
                //System.out.println("state"+"    "+passedColumn[i]);
                NoOfRow = i;
                System.out.println("NoOfRow"+"   " +NoOfRow);
                break;
            }
        }
        //getRow(NoOfRow,t);
        //System.out.println(Arrays.toString(passedRow));
        //get the row that corresponds to the state 
        getRow(0,t);
        

        String  State= Character.toString(bufferWord.charAt(bufferSize-1));
        
        String accState = "yes";
        
        int fin=0;
        int y=0;
        String [] f=getrow2(nextState);
        if(f[60].equals(accState)){
            System.out.println(save + "    " +"return"+"    "+f[61]);
            isFirstState=true;
            y=1;
            fin=1;
            save="";
           
        }
        
        if(fin==0){
        for (int i = 0; i < 62; i++) {
            //get the column that the next state is at
            
            if(State.equals(passedRow[i])){
                
                  save=save+State;  
                  nextState=t[NoOfRow][i];  
                  if (nextState.equals("0")){
                    identifier=1;
                    break;
                    }
                     String [] g=getrow2(nextState);
        if(g[60].equals(accState)){
            System.out.println(save + "    " +"return"+"    "+g[61]);
            isFirstState=true;
            
            save="";
                  
                  
                    }}
        }}
            
                    
        
        break;
    case 1:
             
                char e = (bufferWord.charAt(bufferSize-1));
                //System.out.println(e);
                //System.out.println();
               // System.out.println(Character.isAlphabetic(e));
                if(Character.isAlphabetic(e) || Character.isDigit(e)){
                    //System.out.println("123456");
                save =save+bufferWord.charAt(bufferSize-1);
                    //System.out.println(save);
                    //System.out.println(save);
     }               else if (e ==','){
                    if(error==1){
                        System.out.println(save+"   "+"not matched");
                        save="";
                        error=0;
                    }
                    else{
                        
                        System.out.println(save+"   "+"matched");
                        save="";
                        }}
                    else if(e ==';') {
                       if(error==1){
                       System.out.println(save+"    "+"not matched");
                       identifier=0;
                       nextState="373'";
                       String [] p=getrow2(nextState);
           if(p[60].equals("yes")){
            System.out.println(";" + "    " +"return"+"    "+p[61]);
            isFirstState=true;
            
            save="";
                    
                       } }
                       if(error==0){ 
                       System.out.println(save+"    "+"matched");
                       identifier=0;
                       nextState="373'";
                       
                     String [] r=getrow2(nextState);
           if(r[60].equals("yes")){
            System.out.println(";" + "    " +"return"+"    "+r[61]);
            isFirstState=true;
            
            save="";
  
                    }}}}}
       
    //stores a row from the table in the string called passedrow
    public void getRow(int rowNum, String[][] matrix){
        for (int i = 0; i < 62; i++) {
            passedRow[i] = matrix[rowNum][i];
        }
    }
       
    //stores a column from the table in the string called column
    public void getColumn(int colNum, String[][] matrix){
        for (int i = 0; i < 157; i++) {
            passedColumn[i] = matrix[i][colNum];
        }
    }

    public void scanning(File file) {

        //bufferWord is empty now
        bufferWord = "";

        //call readChar method
        readChar(file);
    }
    

    //read a character and put it in bufferWord arraylist
    public void readChar(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedReader br2 = new BufferedReader(new FileReader(file));
            BufferedReader br3 = new BufferedReader(new FileReader(file));
            int st;
            //new
            int st2;
            int st3;
            Line_no = 1;
             String grt = ">";
                String smt = "<";
                String eq = "=";
            //new 
            
            bufferSize = 0;
            //new 
            if((st2 = br2.read()) == -1)System.out.println("end of file");
           
            while ((st = br.read()) != -1 && (st2 = br2.read()) != -1 &&(st3 = br3.read()) != -1) {
             //while ((st2 = br2.read()) != -1) {
                char c = (char) st;
                //System.out.println(st);
                char c2 = (char) st2;
                //System.out.println("\"");
                char c3 =(char) st3;
                //add the char to the end of the string bufferWord
                bufferWord = bufferWord + c;
                fchar = fchar +c2;
                //increment the bufferSize
                bufferSize++;
                
                 //check for multi-line comment 
                if(bufferWord.charAt(bufferSize-1)=='/'&& fchar.charAt(bufferSize-1)=='#'){
                    inMultiLineComment=true;
                    
                    save+="/#";
                    
                    System.out.println(save + " " +Line_no);
                    
                    save="";
                     
                }
                //check for single-line comment
                else if(bufferWord.charAt(bufferSize-1)=='/'&& fchar.charAt(bufferSize-1)=='-'){
                    inSingleLineComment=true;
                    Line_no++;
                    save="/-";
                    
                    System.out.println(save + " " +Line_no);
                    save="";
                     
                }
                //check if we are inside a comment
                else if(inMultiLineComment==true){
                    if(bufferWord.charAt(bufferSize-1)=='#'&& fchar.charAt(bufferSize-1)=='/'){
                        save+="#/";
                        
                        System.out.println(save + " " +Line_no);
                        save="";
                        inMultiLineComment=false;
                         
                    }else if(bufferWord.charAt(bufferSize-1)=='\n'){
                        Line_no++;
                         
                    }
                }else if(inSingleLineComment==true){
                    if(bufferWord.charAt(bufferSize-1)=='\n'){
                        Line_no++;
                        inSingleLineComment=false;
                         
                    }                   
                }if(bufferWord.charAt(bufferSize-1)=='\n'){
                        Line_no++;
                    }
              
                
                
                
               
                else if((Character.toString(bufferWord.charAt(bufferSize-1))).equals(grt)){
                    save = "";
                    if ((Character.toString(fchar.charAt(bufferSize-1))).equals(eq)){
                        save = grt + eq;
                        getRow(129,t);
                        System.out.println(save);
                        System.out.println("Return Token:" + passedRow[61]);
                         
                        
                    }
                    else{
                        save = grt;
                        getRow(128,t);
                        System.out.println("Return Token:" + passedRow[61]);
                        System.out.println(save);
                         
                        
                    }
                }
                else if((Character.toString(bufferWord.charAt(bufferSize-1))).equals(smt)){
                    save = "";
                    if ((Character.toString(fchar.charAt(bufferSize-1))).equals(eq)){
                        save = smt + eq;
                        getRow(131,t);
                        System.out.println("Return Token:" + passedRow[61]);
                        System.out.println(save);
                        save="";
                         
                    }
                    else{
                        save = smt;
                        getRow(130,t);
                        System.out.println("Return Token:" + passedRow[61]);
                        System.out.println(save);
                        save="";
                         
                    }
                }
                else if((Character.toString(bufferWord.charAt(bufferSize-1))).equals(eq)){
                    save = "";
                    if ((Character.toString(fchar.charAt(bufferSize-1))).equals(eq)){
                        save = eq + eq;
                        getRow(133,t);
                        System.out.println("Return Token:" + passedRow[61]);
                        System.out.println(save);
                        save="";
                         
                    }
                    else{
                        
                        if(identifier==1){
                            System.out.println(save);
                            save="";
                            identifier=0;
                        }
                        save = eq;
                        getRow(132,t);
                        System.out.println("Return Token:" + passedRow[61]);
                        System.out.println(save);
                        save="";
                    }
                }
                else if(isFirstState==true && Character.isDigit((bufferWord.charAt(bufferSize-1)))){
                save =save+bufferWord.charAt(bufferSize-1);
                char t;
                int U=0;
                int u=0;
                while((st3 = br3.read()) != -1){
                t=(char)st3;
                u++;
                if(Character.isDigit(t)){
                save =save+t;
                U=0;
                }
                else if(Character.isAlphabetic(t)){
                    identifier=1;
                    save =save+t;
                    U=1;
                    isFirstState=false;
                    break;
                }
                
                }
                for(int z=0;z<u-1;z++){
                    st2 = br2.read();
                    bufferSize++;
                    }
                
                if(U==0){
                System.out.println(save + "Identifier"+ "Not Matched");
                save="";}
                
                    
                
                }
                
                else{
                //check if there is only one character in bufferWord
                if (isFirstState==true) {
                    //find first state
                    //System.out.println("456789"+"           "+bufferWord.charAt(bufferSize-1));
                    char r=bufferWord.charAt(bufferSize-1);
                    if(st==10 || st==13)
                        continue;
                    getRow(0,table.Lexemes);
                    System.out.println();
                    findFirstState();
                    //isFirstState=false;
                    
                
                    
                }else {
                    //find the next state
                    getNextState(bufferWord,table.Lexemes);
                }
                }
                
               
             
            

            }} catch (IOException e) {
            System.out.println(e.getMessage());
        }

}}