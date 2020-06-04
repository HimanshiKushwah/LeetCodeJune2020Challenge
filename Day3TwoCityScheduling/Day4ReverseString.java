package Day3TwoCityScheduling;

import java.util.Arrays;

class Day4ReverseString{
    private void swap(char[] s, int i, int j) {
        s[i] = (char)(s[i] ^ s[j]);
        s[j] = (char)(s[i] ^ s[j]);
        s[i] = (char)(s[i] ^ s[j]);
    }    
    public void reverseString(char[] s){
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            swap(s, i, j);
        }
    }
    
    public static void main(String[] args){
    	char[] ch={'h','e','n','n','a','k'};
        new Day4ReverseString().reverseString(ch);
        System.out.println(ch);
        
    }
}