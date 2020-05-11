import java.util.*;

class HillCipher {
    
    Scanner sc = new Scanner(System.in);
    char alphabets[] = new char[26];
    String input = new String();
    int [][]key;
    String ciphertext = new String();
    String plaintext = new String();
    int vector[][];
    int len=0;
    int rows,cols;
    String cipherstring="";
    
    HillCipher(){ 
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

    String multiply(int a[][],int b[][]){
        int c[][] = new int[rows][1];
        
        for(int i=0;i<rows;i++){    
            for(int j=0;j<1;j++){    
                c[i][j]=0;      
                for(int k=0;k<rows;k++)      
                {      
                    c[i][j]+=a[i][k]*b[k][j];   
                }
            }
        }   
        
        int x;
        String res="";
        for(int i=0;i<rows;i++){
            for(int j=0;j<1;j++){
                x = c[i][j];
                x = x % 26;
                res+= String.valueOf(x);
            }
            res+=" ";
        }
        return res.trim();
    }

    void setVectors(){
        len= input.length();
        int j=0;
        
        if(len%2 == 1){
            input+="X";
        }
        for(int i=0;i<(input.length())/2;i++){
            for(int k=0;k<rows;k++){
                vector[k][0] = getIndex(input.charAt(j));
                j+=1;
            }
            cipherstring += multiply(key,vector);
            cipherstring+=" ";
        }
        String cipherarr[] = cipherstring.split("\\s+");
        // for(int i=0;i<cipherarr.length;i++){
        //     System.out.print(cipherarr[i] +" ");
        // }
        for(int i=0;i<cipherarr.length;i++){
            ciphertext+=getChar(Integer.parseInt(cipherarr[i]));
        }
        System.out.println("\n" + input+ " is Encrypted to " +ciphertext);
        System.out.println("\n" + ciphertext +" is Decrypted to " +input);
        
    }

    void getKey(){
        System.out.println("\nEnter Rows in Key Matrix");
        rows = sc.nextInt();
        System.out.println("Enter Columns in Key Matrix");
        cols = sc.nextInt();

        key = new int[rows][cols];
        vector = new int[rows][1];
        
        System.out.println("Enter the Matrix Contents Row-Wise");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                key[i][j] = sc.nextInt();
            }
        }

        System.out.print("\nKey is : \n");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(key[i][j] + " ");
            }
            System.out.println();
        }

        setVectors();

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

    char getChar(int ch){
        return alphabets[ch];
    }
    
}

class HillCipherFurkhan {
    public static void main(String args[]){
        HillCipher hc = new HillCipher(); 
        hc.getInputs();
        hc.getKey();
    } 

}