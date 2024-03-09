import java.time.LocalDate;
import java.time.ZoneId;

public class Baek_10699
{
    public static void main(String[] args)
    {
        LocalDate data = LocalDate.now(ZoneId.of("UTC+0"));
        System.out.println(data);
    }
}