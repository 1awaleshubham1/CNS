/*
Name: Furkhan Mujibodden Shaikh
Class: BECSEII
Aim: WRITE A JAVA PROGRAM TO IMPLEMENT TRANSPOSITION CIPHER
ROLL: 63
*/

import java.util.*;

class TranspositionCipher {
    
    Scanner sc = new Scanner(System.in);
    char alphabets[] = new char[26];
    String input = new String();
    int no_of_digits_in_key;
    int key[] = new int[20];
    String ciphertext = new String();
    String plaintext = new String();
    int cols,rows;
    char table[][];
    char table2[][];
    
    TranspositionCipher(){ 
        int i;
        char j;   
        for(i=0,j='A';i<26;i++,j++){
            alphabets[i] = j;
        }
    }

    int max(int a[],int len){
        int m = a[0];
        for(int i=1;i<len;i++){
            if(m<a[i]){
                m = a[i];
            }
            else{
                continue;
            }
        }
        return m;
    }

    void getInputs(){
        int cnt=0;
        System.out.println("\nEnter the Input String To Be Encrypted");
        input = sc.nextLine();
        input = input.toUpperCase();
        input.trim();

        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == 32){
                break;
            }
            cnt+=1;
        }
    }

    
    void getKey(){
        System.out.println("\nEnter the Space Separated Key");
        String st;
        String tmp[];
        st = sc.nextLine();
        tmp = st.split(" ");
        no_of_digits_in_key = tmp.length;
        for(int i=0;i<no_of_digits_in_key;i++){
            key[i] = Integer.parseInt(tmp[i]);
        }
        cols = max(key,no_of_digits_in_key);
        int temp;
        temp = input.length()%cols;
        if(temp == 0){
            rows = input.length() / cols;
        }
        else{
            rows = input.length()/cols +1;
        }

        table = new char[rows][cols];
        table2 = new char[rows][cols];
        
        System.out.println();
    }

    void cipher(){
        int k=0;
        System.out.println("\nCipher Matrix: ");
        for(int i=1;i<=no_of_digits_in_key;i++){
            System.out.print(i +" ");
        }
        System.out.println("");

        for(int i=0;i<rows;i++){
            
            for(int j=0;j<cols;j++){
                if(k < input.length()){
                    table[i][j] = input.charAt(k);
                    k+=1;
                }
                
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(table[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();

        int i=key[0];
        int ctr=0;
        // i refer to columns
        // j refer to rows
        for(;ctr<no_of_digits_in_key;){
            for(int j=0;j<rows;j++){
                ciphertext+=table[j][i-1];
            }
            i = key[++ctr];
        }
        ciphertext = ciphertext.replaceAll("\0", ""); 
        System.out.println(input +" is Encrypted To " +ciphertext);
    }

    void decrypt(){
        int k=0;
        System.out.println("\nPlain Matrix: ");
        for(int i=1;i<=no_of_digits_in_key;i++){
            System.out.print(i +" ");
        }
        System.out.println("");

        int i = key[0];
        int ctr=0;
        for(;ctr<no_of_digits_in_key;){
            for(int j=0;j<rows;j++){
                if(k<input.length()){
                    table2[j][i-1]= ciphertext.charAt(k);
                    k+=1;
                }
            }
            i = key[++ctr];
        }

        for(i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(table2[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();

        for(i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                plaintext+=table2[i][j];
            }
        }

        System.out.println(ciphertext +" is Decyrted To " +plaintext);
    }
    
}

class TranspositionCipherFurkhan {
    public static void main(String args[]){
        TranspositionCipher tc = new TranspositionCipher(); 
        tc.getInputs();
        tc.getKey();
        tc.cipher();
        tc.decrypt();
    } 

}

// OUTPUT
/* 
Enter the Input String To Be Encrypted
FURKHAN SHAIKH

Enter the Space Separated Key
4 3 2 1 5


Cipher Matrix:
1 2 3 4 5
F U R K H
A N   S H
A I K H

FURKHAN SHAIKH is Encrypted To KSHR KUNIFAAHH

Plain Matrix:
1 2 3 4 5
F U R K H
A N   S H
A I K H

KSHR KUNIFAAHH is Decyrted To FURKHAN SHAIKH
*/