import java.io.*;
import java.util.*;

public class Main {
    static final long mod=1000003;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long a=Long.parseLong(bf.readLine());
        long ka=pow(2,a),k=(ka-1)*(ka-2)%mod;
        long kaa=pow(6,mod-2);
        System.out.println(k*kaa%mod);
    }
    static long pow(long x,long y){
        if(y==1) return x;
        long u=pow(x,y/2);
        u=u*u%mod;
        if(y%2==1) u=u*x%mod;
        return u;
    }
}
