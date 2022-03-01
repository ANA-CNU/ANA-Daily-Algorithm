import gitrepourlparser.AbsolutePathBeforePackageNameParser;
import readmegenerator.BOJReadmeGenerator;

public class RMGenerator {
    public static void main(String[] args) {
        //== ANA 하루하나 알고리즘 리드미 만드는 코드 ==//
        AbsolutePathBeforePackageNameParser parser = new AbsolutePathBeforePackageNameParser();

        parser.setAbsolutePathBeforePackageName("https://github.com/AnA-algorithm/2022-algorithm-study/blob/main/신동훈");

        BOJReadmeGenerator rg = new BOJReadmeGenerator(parser);

        rg.setTitle("동훈이의 하루하나 알고리즘");//안해줄 경우 기본값인 "백준" 사용


        rg.generate();
    }
}
