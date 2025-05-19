package daynamic_programin;

public class LengthAfterTransformations {
//    Brute force approach
    public int lengthAfterTransformations1(String s, int t) {
        for(int i=0; i<t; i++){
            int n=s.length();
            String res="";
            for(int j=0; j<n; j++){
                if(s.charAt(j) =='z') res += "ab";
                else{
                    char a=s.charAt(j);
                    a++;
                    res += a;
                }
            }
            s= res;
        }
        System.out.println(s.toString());
        return s.length();
    }
    private final int mod = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {

        int freq[] =new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0; i<t; i++){
            int newFre[] =new int[26];
            for(int j=0; j<26; j++){
                if(j==25){
                    newFre[j]=(newFre[0] + freq[25])%mod;
                    newFre[1]=(newFre[1] + freq[25])%mod;
                }else{
                    newFre[j]=(newFre[j+1] + freq[j])%mod;
                }
            }
            freq=newFre;
        }
    long leng=0;
        for(int i=0; i<26; i++){
            leng = (leng + freq[i])%mod;
        }
        return Math.toIntExact(leng);
    }
    public static void main(String args[]){
        LengthAfterTransformations le= new LengthAfterTransformations();
        System.out.println(le.lengthAfterTransformations("abcyy", 2));
    }
}