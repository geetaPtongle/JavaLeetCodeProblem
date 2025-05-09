package stack;

import java.util.Stack;

// "static void main" must be defined in a public class.
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates main=new RemoveDuplicates();
        System.out.println(main.removeDuplicates("abbaca"));
    }
    
     public String removeDuplicates1(String s) {
          StringBuilder substr = new StringBuilder();
         for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
               if (!substr.isEmpty() && substr.charAt(substr.length() - 1) == ch) {
            substr.deleteCharAt(substr.length() - 1); 
        } else {
            substr.append(ch); 
        }
         }
         return substr.toString();
     }

     // Using stack approch
    // Time Complexity: O(n) - One pass over the string + stack processing.
// Space Complexity: O(n) - Space for the stack + StringBuilder to build a result.
    public String removeDuplicates2(String s) {
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek().equals(ch))
                st.pop();
            else
                st.push(ch);
        }
        StringBuilder result = new StringBuilder();
        for (char c : st) {
            result.append(c);
        }
        return result.toString();
    }

    public String removeDuplicates(String s) {
        StringBuilder subStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr=s.charAt(i);
            char prev=subStr.isEmpty() ? '$' : subStr.charAt(subStr.length()-1);
            if(curr !=prev)subStr.append(curr);
            else subStr.deleteCharAt(subStr.length()-1);
        }
        return subStr.toString();
    }
}