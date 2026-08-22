class Solution {
    public boolean checkDivisibility(int n) {
        int original=n;
        int sum=0;
        int product=1;
        while(original>0){
            int digit=original%10;
            sum+=digit;
            product*=digit;
            original/=10;
        }
            return n%(sum+product)==0;
        }
    }
