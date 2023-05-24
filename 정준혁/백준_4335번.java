package 하루하나;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_4335번 {
    public static void main(String[] args)throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        ArrayList<Integer> high = new ArrayList<Integer>();
        ArrayList<Integer> low = new ArrayList<Integer>();
        int right = 0;
        
            while(true) {
                int num = Integer.parseInt(br.readLine());
                if(num == 0) {    
                    return;
                }
                String isright = br.readLine();
                
                if(isright.charAt(4) == 'h') {    
                    high.add(num);
                }else if(isright.charAt(4) == 'l') {    
                    low.add(num);
                }else {                        
                    right = num;
                    break;
                }
            }
            boolean istrue = true;
            for(int i = 0; i < high.size(); i++) {    
                if(right >= high.get(i)) {
                    istrue = false;
                    break;
                }
            }
            if(istrue) {
                for(int i = 0; i < low.size(); i++) {   
                    if(right <= low.get(i)) {
                        istrue = false;
                        break;
                    }
                }
            }
            if(istrue) {
                System.out.println("Stan may be honest");
            }else {
                System.out.println("Stan is dishonest");
            }
 
        }
    }
 
}
