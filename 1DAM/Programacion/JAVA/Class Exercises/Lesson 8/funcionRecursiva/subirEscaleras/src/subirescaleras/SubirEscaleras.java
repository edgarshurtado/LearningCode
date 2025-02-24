/*
    Exercise description
*/

package subirescaleras;

/**
 *
 * @author Edgar S. Hurtado
 * 
 */



public class SubirEscaleras {

    static void subirEscalera(int escalones){
       if (escalones -1  > 0) {
            subirEscalera(escalones - 1);
        }
        System.out.println("Estoy en el escalón " + escalones);
    }
    
    static void bajarEscalera(int escalones){
        System.out.println("Estoy en el escalón " + (escalones -1));
        if (escalones -1  > 0) {
            
            bajarEscalera(escalones - 1);
        }
    }
    
    static void bajarSubirEscalera(int escalones){
        System.out.println("Estoy en el escalón " + (escalones - 1));
        if (escalones - 1 > 0) {
            bajarSubirEscalera(escalones - 1);
        }
        System.out.println("Estoy en el escalón " + escalones);
    }
    
    static void writeSequence(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            System.out.println("1\n1");
        } else {
            System.out.println(n -1);
            writeSequence(n - 1);
            System.out.println(n-1);
        }
    }
    
    static void upDown(int n, int m) {        
        if (n < 0) throw new IllegalArgumentException();
        
        if (n < m) {
            System.out.println(n);
            upDown(n+1, m);
        }

        if (n == m) {
            System.out.println(n);
        }
        
        if (n > 0 && n != m) {
            System.out.println(n);
        }
    }
   
    static void trambolika(int n, int m) {
        /*
         Función que sabe subí y bajá    
         */
        System.out.println(n);
        if (n < m) {
            upDown(n + 1, m);
            System.out.println(n);
        }
    }
    
    static int fibonacci(int position){
        if (position > 2) {
            return fibonacci(position - 1) + fibonacci(position - 2);
        } else {
            return 1;
        }
    }
    static void printFibonacci(int positions){
        for (int i = 1; i <= positions; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    
    static int pow(int base, int exponent){
        if (exponent > 0) {
            return base * pow(base, exponent - 1);
        } else {
            return 1;
        }
    }
    static int multiplication(int a, int b){
        if (b > 0) {
            return a + multiplication(a, b-1);  
        } else {
            return 0;
        }
    }
    
    static boolean palindrome(String sentence, int initIndex){
        char a = sentence.charAt(initIndex);
        char b = sentence.charAt((sentence.length()-initIndex)-1);
        if (initIndex < (sentence.length()/2)) {
            if (palindrome(sentence, initIndex+1)) {
                return a == b;
            } else {
                return false;
            }
        } else {
            return a == b;
        }
    }
    
    static boolean palindrome1arg(String sentence){
        if (sentence.length() > 2) {
            if (palindrome1arg(sentence.substring(1, sentence.length()-1))) {
                return sentence.charAt(0) == sentence.charAt(sentence.length()-1);
            } else {
                return false;
            }
        } else {
            //if sentence has a odd number of chars
            return true;
        }
    }
   
    public static void main(String[] args) {
        String sentence;
        System.out.println(palindrome1arg("abccba"));
    }
}
