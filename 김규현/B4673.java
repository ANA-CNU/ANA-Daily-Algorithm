public class B4673 {

    public static int make(int n){
        int sum = n;

        while(n!=0){
            sum = sum + n % 10;
            n /= 10;
        }

        return sum;
    }
    public static void main(String[] args) {

         boolean [] b = new boolean[10001];

         for(int i = 0; i < b.length; i++){
             if(make(i) < 10001){
                 b[make(i)] = true;
             }
         }

         for(int i = 0; i < b.length; i++){
             if(!b[i]){
                 System.out.println(i);
             }
         }
    }
}

