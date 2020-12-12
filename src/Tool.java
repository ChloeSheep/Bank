public class Tool {
    Tool(){}
    public static boolean is_alpha(String str) {
        if(str==null) return false;
        return str.matches("^[A-Za-z]+$");
    }
    public static boolean in_range(String str,int num1,int num2){
        return str.length() <= num2 && str.length() >= num1;
    }
    public static boolean is_number(String str){
        if (str==null) return false;
        return str.matches("^[0-9]+");
    }
}
