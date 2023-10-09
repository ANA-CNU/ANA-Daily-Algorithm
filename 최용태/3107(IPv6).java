import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    public static String appendZero(String part){
        return "0".repeat(4-part.length()) + part;
    }

    public static String findZero(int ipLength, int originalIpLen){
        return ("0000:".repeat(originalIpLen-ipLength));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ip=br.readLine();

        String[] partedByColonGroup = ip.split("::");

        int IPv6_BIT_LEN = 2*2*2*2*8; // 128
        int IPv6_LEN = IPv6_BIT_LEN / 16; // 8
        int currentIpLen = 0;

        for(int i=0; i < partedByColonGroup.length;i++){
            StringBuilder ipBuilder = new StringBuilder();
            String[] rePartedIp = partedByColonGroup[i].split(":");
            currentIpLen += rePartedIp.length;
            IntStream.range(0,rePartedIp.length).
                    forEach( ri -> ipBuilder.append(appendZero(rePartedIp[ri])).append(":"));

            partedByColonGroup[i] = ipBuilder.toString();
        }

        String recoveredIp = partedByColonGroup[0];

        if(partedByColonGroup.length == 2){
            recoveredIp += findZero(currentIpLen, IPv6_LEN) +
                            partedByColonGroup[1];
        }

        if(recoveredIp.length() < IPv6_LEN * 5){
            recoveredIp += findZero(currentIpLen, IPv6_LEN);
        }

        System.out.println(recoveredIp.substring(0,recoveredIp.length()-1));
    }
}
