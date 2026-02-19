class Solution {
    public double myPow(double x, int n) {
        long num = n;
        if(num <0){
            return (1.0/pow(x,-num));
        }
        return pow(x,n);
    }

    private static double pow(double x, long n){
        if(n==0) return 1.0;
        if(n==1) return x;

        if(n%2==1){
            return x*pow(x,n-1);
        }
        return pow(x*x,n/2);
    }
}