import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SendOTP {
    public static void sendSMS (String otpStr) {
        try {

            String apiKey = "apiKey=" + "NmEzNzMxNzI0NTM4Nzg3NTMyNGY2ZTY2NjE0ZDQ0NmI=";

            String message = "&message=" + URLEncoder.encode("Your OTP is " + otpStr,
                    "UTF-8");

            String numbers = "&numbers=" + "09062267692";

            String apiURL = "https://api.txtlocal.com/send/?" + apiKey + message + numbers;

            URL url = new URL(apiURL);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));

            String line = "";
            StringBuilder sb = new StringBuilder();

            while ( (line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendSMS("12345");
    }
}
