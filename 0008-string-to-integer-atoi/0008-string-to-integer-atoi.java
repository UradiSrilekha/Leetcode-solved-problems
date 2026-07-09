class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        long result =0;
        StringBuilder ans = new StringBuilder();
        if(s.length()==0){
            return 0;
        }
        int i =0;
        int sign = 1;
        if(s.charAt(i)=='+' || s.charAt(i)=='-'){
            if(s.charAt(i)=='-'){
                sign = -1;
            }
            i++;
        }
        while(i<s.length()){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
            result = result*10 + (s.charAt(i)-'0');
            
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;

            }
            else{
                return (int)(sign*result);
            }
        }
        return (int)(sign*result);
       
    }
}