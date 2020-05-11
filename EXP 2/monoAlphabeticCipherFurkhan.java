import java.util.*;
class monoCipher {
    
    Scanner sc = new Scanner(System.in);
    char alphabets[] = new char[26];
    char cipherbets[] = new char[26];
    String input = new String();
    String key;
    String ciphertext = new String();
    String plaintext = new String();
    
    monoCipher(){ 
        int i;
        char j;   
        for(i=0,j='A';i<26;i++,j++){
            alphabets[i] = j;
        }
    }

    boolean check(char ch){
        for(int i=0;i<cipherbets.length;i++){
            if(ch == cipherbets[i]){
                return true;
            }
        }
        return false;
    }

    void setCipherAlphabets(){
        int cnt=0;
        for(int i=0;i<key.length();i++){
            cipherbets[i] = key.charAt(i);
        }
        for(int j=0;j<26;j++){
            if(check(alphabets[j])){
                continue;
            }
           else{
                    if((key.length()+cnt) < 26)
                    {
                        cipherbets[key.length()+cnt] = alphabets[j];
                        cnt+=1;
                    }
            }
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
        key = sc.nextLine();
        key = key.toUpperCase();
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

    int getIndexInCipherBets(char ch){
        for(int i=0;i<cipherbets.length;i++){
            if(ch == cipherbets[i]){
                return i;
            }
        }
        return -1;
    }

    void cipher(){
        System.out.print("\nOpen Alphabet   : ");
        for(int j=0;j<26;j++){
            System.out.print(alphabets[j] +" ");
        }
        System.out.println();

        System.out.print("Cipher Alphabet : ");
        for(int j=0;j<26;j++){
            System.out.print(cipherbets[j] +" ");
        }
        System.out.println();

        int index;
        ciphertext = "";
        
        for(int i=0;i<input.length();i++){
            if(Character.isLetter(input.charAt(i))){
                index = getIndex(input.charAt(i));
                ciphertext+=Character.toString(cipherbets[index]);
            }
            else{
                ciphertext += input.charAt(i);

            }
            
        }
        System.out.println("\n" + input +" is Encrypted to " +ciphertext);
    }

    void decrypt(){
        
        System.out.print("\nCipher Alphabet : ");
        for(int j=0;j<26;j++){
            System.out.print(cipherbets[j] +" ");
        }
        System.out.println();

        System.out.print("Open Alphabet   : ");
        for(int j=0;j<26;j++){
            System.out.print(alphabets[j] +" ");
        }
        System.out.println();

        int index;
        for(int i=0;i<ciphertext.length();i++){
            if(Character.isLetter(ciphertext.charAt(i))){
                index = getIndexInCipherBets(ciphertext.charAt(i));
                plaintext+=Character.toString(alphabets[index]);
            }
            else{
                plaintext += input.charAt(i);

            }
            
        }
        System.out.println("\n" + ciphertext +" is Decrypted to " +plaintext);
    }

}

class monoAlphabeticCipher {
    public static void main(String args[]){
        monoCipher mc = new monoCipher(); 
        mc.getInputs();
        mc.getKey();
        mc.setCipherAlphabets();
        mc.cipher();
        mc.decrypt();
    } 

}