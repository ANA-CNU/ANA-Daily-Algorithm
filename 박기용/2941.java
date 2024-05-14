import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("");
        String[] arr2 = new String[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            arr2[i] = arr[i] + arr[i + 1];
        }

        int croatiacount = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            switch (arr2[i]) {
                case "c=":
                    croatiacount++;
                    break;
                case "c-":
                    croatiacount++;
                    break;
                case "dz":
                    if (i <= arr.length - 3 && arr[i + 2].equals("="))
                        croatiacount += 2;
                    break;
                case "d-":
                    croatiacount++;
                    break;
                case "lj":
                    croatiacount++;
                    break;
                case "nj":
                    croatiacount++;
                    break;
                case "s=":
                    croatiacount++;
                    break;
                case "z=":
                    if (i != 0 && !arr[i - 1].equals("d")) {
                        croatiacount++;
                    } else if (i == 0) {
                        croatiacount++;
                    }
            }
        }

        bw.write((arr.length - croatiacount) + "");
        bw.close();
    }
}
