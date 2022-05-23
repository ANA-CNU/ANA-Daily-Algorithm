import java.util.*;

class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] Args) {
        int tst = s.nextInt();
        for (int i = 0; i < tst; i++) {
            Dot start = new Dot(s.nextInt(), s.nextInt());
            //이 코드에서는 nextInt가 무엇이 올 지 개발자가 알고 있음을 내포한다.
            //변수를 사용해 x, y를 표현했으면 좋았을듯
            Dot end = new Dot(s.nextInt(), s.nextInt());
            //end나 start가 무엇을 의미하는지 알 수 없다. 모호한 이름
            int N = s.nextInt();
            //N도 마찬가지.
            int startCnt = 0;
            int endCnt = 0;
            for (int j = 0; j < N; j++) {
                Dot circle = new Dot(s.nextInt(),s.nextInt(),s.nextInt());
                boolean inS = start.isInCircle(circle);
                boolean inE = end.isInCircle(circle);
                // inS, inE라는 이름이 아니라 다른 이름이었으면 더 좋았을듯
                if(inS && inE) { } //이 조건문덩어리는 정말 보기 안 좋다.
                //그리고 왜 if, else if가 무엇을 의미하는지 알 수 없다.
                else if(inS) {
                    startCnt++;
                } else if(inE) {
                    endCnt++;
                }
            }

            System.out.println(startCnt + endCnt);
        }
    }
}

class Dot {
    //Dot이라는 이름만으로 무엇을 하는 클래스인지 유추할 수 없다.
    int x, y, r;

    public Dot(int x, int y) { //this()를 사용해도 되었을 것이다.
        this.x = x;
        this.y = y;
    }

    public Dot(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }


    double getDistance(Dot tar) { //이게 함수형 프로그래밍이 맞나?
        return Math.sqrt(Math.pow(x-tar.x,2) + Math.pow(y-tar.y,2));
        //몰아서 쓰다 보니 가독성이 떨어진다.
    }

    boolean isInCircle(Dot tar) { //SRP에 따라 클래스를 분리해야 한다.
        double d = getDistance(tar);
        return d < tar.r;
    }
}