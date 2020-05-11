import java.util.*;
class CaesarCipher {
    
    Scanner sc = new Scanner(System.in);
    char alphabets[] = new char[26];
    int i;
    char j;
    String input = new String();
    int key;
    char cipherText[] = new char[200];
    char plainText[] = new char[200];
    
    String strcipherText="";

    CaesarCipher(){
        
        for(i=0,j='A';i<26;i++,j++){
            alphabets[i] = j;
        }

    }
    
    void getInputs(){
        System.out.println("\nEnter the Input String To Be Encrypted");
        input = sc.nextLine();
        input = input.toUpperCase();
        // System.out.println(input);
    }

    void getKey(){
        System.out.println("\nEnter the Key");
        key = sc.nextInt();
        // System.out.print(key);
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
        int max = 25;
        int i;
        int index;
        int replacement_index;
        for(i=0;i<input.length();i++){
            if(Character.isLetter(input.charAt(i))){
                index = getIndex(input.charAt(i));
                if( (index+key) > max){
                    replacement_index = (index+key) - max - 1;
                    cipherText[i] = alphabets[replacement_index]; 
                }
                else{
                    cipherText[i] = alphabets[index + key]; 
                }
            }
            else{
                cipherText[i] = input.charAt(i);
            }
        }

        System.out.print(input + " is Encrypted to ");
        for(i=0;i<cipherText.length;i++){
            System.out.print(cipherText[i]);
        }
        System.out.println();

    }

    void decrypt(){

        int min = 0;
        int i;
        int replacement_index;
        int index;

        for(i=0;i<cipherText.length;i++){
            strcipherText += cipherText[i];
        }

        for(i=0;i<strcipherText.length();i++){
            if(Character.isLetter(strcipherText.charAt(i))){
                index = getIndex(strcipherText.charAt(i));
                if( (index-key) < min){
                    replacement_index = (index+key)  - 1;
                    plainText[i] = alphabets[replacement_index]; 
                }
                else{
                    plainText[i] = alphabets[index - key]; 
                }
            }
            else{

                plainText[i] = strcipherText.charAt(i);
            }
        }

        System.out.print(strcipherText.trim() + " is Decrypted to ");
        for(i=0;i<plainText.length;i++){
            System.out.print(plainText[i]);
        }
        System.out.println();


    }
}

class caesarFurkhan {
    public static void main(String args[]){
        CaesarCipher cs = new CaesarCipher(); 
        cs.getInputs();
        cs.getKey();
        cs.cipher();
        cs.decrypt();
    }   
}

