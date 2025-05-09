package linkList;

import java.util.Stack;

public class SimplifyPath {
        public String simplifyPath(String path) {
            String[] arr= path.split("/");
            Stack<String> str= new Stack<>();

            for (String s : arr) {
                if (!str.isEmpty() && s.equals("..")) {
                    str.pop();
                }
                if (!s.equals("") && !s.equals(".") && !s.equals(".."))
                    str.push(s);
            }
            if(str.isEmpty()){
                return "/";
            }

            StringBuilder sb= new StringBuilder();
            for(String curr: str){
                System.out.println(curr);
                sb.append("/");
                sb.append(curr);
            }

            return sb.toString();
        }
        public static void main(String[] args) {
            SimplifyPath sp = new SimplifyPath();
            System.out.println(sp.simplifyPath("/.../a/../b/c/../d/./"));
        }
}
