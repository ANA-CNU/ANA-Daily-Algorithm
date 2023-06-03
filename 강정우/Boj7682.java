import java.util.*;
public class Boj7682{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(true){
            String s= sc.next();
            if(s.equals("end"))
                break;
            int ocount=0;
            int xcount=0;
            boolean owin=false;
            boolean xwin=false;
            char [][]arr=new char[3][3];
            int k=0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    arr[i][j]=s.charAt(k++);
                    if(arr[i][j]=='O')
                        ocount++;
                    if(arr[i][j]=='X')
                        xcount++;
                }
            }
            if(xcount<ocount||xcount-ocount>=2){
                System.out.println("invalid");
                continue;
            }
            for(int i=0;i<3;i++){
                if((arr[i][0]=='X'&&arr[i][1]=='X'&&arr[i][2]=='X')||(arr[0][i]=='X'&&arr[1][i]=='X'&&arr[2][i]=='X')) {
                    xwin=true;
                }
                if((arr[i][0]=='O'&&arr[i][1]=='O'&&arr[i][2]=='O')||(arr[0][i]=='O'&&arr[1][i]=='O'&&arr[2][i]=='O')){
                    owin=true;
                }
            }
            if(arr[0][0]=='X'&&arr[1][1]=='X'&&arr[2][2]=='X') {
                xwin = true;
            }
            if(arr[0][2]=='X'&&arr[1][1]=='X'&&arr[2][0]=='X') {
                xwin = true;
            }
            if(arr[0][0]=='O'&&arr[1][1]=='O'&&arr[2][2]=='O') {
                owin = true;
            }
            if(arr[0][2]=='O'&&arr[1][1]=='O'&&arr[2][0]=='O') {
                owin = true;
            }
            if(xwin){
                if(xcount-1!=ocount){
                    System.out.println("invalid");
                    continue;
                }
            }
            if(owin){
                if(xcount!=ocount){
                    System.out.println("invalid");
                    continue;
                }
            }
            if(xwin&&owin){
                System.out.println("invalid");
                continue;
            }
            if(!xwin&&!owin&&xcount+ocount!=9){
                System.out.println("invalid");
                continue;
            }
            System.out.println("valid");
        }
    }
}
