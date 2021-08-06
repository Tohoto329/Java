public class Atoi {
    public int myAtoi(String s){
        int sign = 1;
        int i = 0;
        long result = 0;
        if(s.length() == 0){
            return 0;
        }
        // ignoring trailing white spaces or trailing 0's
        
        while(i < s.length() && (s.charAt(i) == ' ' || s.charAt(i) == 0)){
            i++;
        }
        if(i == s.length()){
            return 0;
        }
        
        
        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        } else if(s.charAt(i) == '+'){
            i++;
        }
        
        
        while(i < s.length()){
            if(!Character.isDigit(s.charAt(i))){
                // checking for any non digit values
                break;
            }            
            int parsedInt = Character.getNumericValue(s.charAt(i));
            result *= 10;
            result += parsedInt;
            if(result > Integer.MAX_VALUE ){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }            
            i++;
        }
        result *= sign;
        return (int)result;
    }
}