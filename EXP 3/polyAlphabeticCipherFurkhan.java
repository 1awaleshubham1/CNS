import java.util.*;

import sun.net.www.content.text.plain;
class polyCipher {
    
    Scanner sc = new Scanner(System.in);
    char alphabets[] = new char[26];
    String input = new String();
    String key;
    String ciphertext = new String();
    String plaintext = new String();
    
    polyCipher(){ 
        int i;
        char j;   
        for(i=0,j='A';i<26;i++,j++){
            alphabets[i] = j;
        }
    }

       
    void getInputs(){
        System.out.println("\nEnter the Input String To Be Encrypted");
        input = sc.nextLine();
        input = input.toUpperCase();
    }

    void getKey(){
        System.out.println("\nEnter the Key");
        char keyArr[] = new char[200];
        key = sc.nextLine();
        key = key.toUpperCase();
        key = key.trim();
        for(int i=0;i<key.length();i++){
            keyArr[i] = key.charAt(i);
        }
        key = "";
        int j=0;
        for(int k = 0;k<key.length();k++){
            System.out.println(keyArr[k]);
        }
        
        for(int i=0;i<input.length();i++){
            if(Character.isLetter(input.charAt(i))){
                if(i >= key.length()){
                    if(j>5){
                        j=0;
                    }
                    key+=keyArr[j];
                    j+=1;
                }
                else{
                    key+= keyArr[i];
                }
                
            }
            else{
                key+=input.charAt(i);
            }
        }
        System.out.println("\nExtended Key is " + key);
    }

    int getIndex(char ch){
        int temp = (int)ch;
        int tmp=0;
        int temp_integer = 64;
        if(temp<=90 & temp>=65)
        {
            tmp = temp - temp_integer - 1;
            return tmp;
        }
        return 0;   
    }

    
    void cipher(){
        int plainindex = 0;
        int keyindex = 0;
        int cipherindex = 0;

        for(int i=0;i<input.length();i++){
            if(Character.isLetter(input.charAt(i))){
               plainindex = getIndex(input.charAt(i));
               keyindex = getIndex(key.charAt(i));
               cipherindex = (plainindex + keyindex) % 26;
               ciphertext+=alphabets[cipherindex];
            }
            else{
                ciphertext+=input.charAt(i);
            }
                
        }
        System.out.println("\n " +input +" is Encerypted To " +ciphertext);
    }

    void decrypt(){
        int plainindex = 0;
        int keyindex = 0;
        int cipherindex = 0;

        for(int i=0;i<ciphertext.length();i++){
            if(Character.isLetter(ciphertext.charAt(i))){
               cipherindex = getIndex(ciphertext.charAt(i));
               keyindex = getIndex(key.charAt(i));
               plainindex = (cipherindex - keyindex + 26 ) % 26;
               plaintext+=alphabets[plainindex];
            }
            else{
                plaintext+=ciphertext.charAt(i);
            }
                
        }
        System.out.println("\n " +ciphertext +" is DECRYPTED To " +plaintext);
    } 
       
}

class polyAlphabeticCipherFurkhan {
    public static void main(String args[]){
        polyCipher mc = new polyCipher(); 
        mc.getInputs();
        mc.getKey();
        mc.cipher();
        mc.decrypt();
    } 

}