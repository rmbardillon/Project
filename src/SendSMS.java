import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SendSMS {
    public static final String ACCOUNT_SID = "AC7601bbe4957a22e096017815a91f7ee4";
    public static final String AUTH_TOKEN = "8fa26a682fb27eadf80ab06899fb3739";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+639760657071"),
                        new com.twilio.type.PhoneNumber("+12565675473"),
                        "Your message")
                .create();

        System.out.println(message.getSid());
    }
}