package com.bigdecimal.dockerizedspringboot;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class WhatsAppMessageService {
    public final String ACCOUNT_SID = "AC209db14a24086167da78530ba9a02e7f";
    public final String AUTH_TOKEN = "04fa1e17802fc47ec39368ab173037b6";
   
    public Boolean sendTwilioMessage(WhatsAppMessage message) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message twilioMessage = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:+2349081386758"),
                    new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                    message.getText())
                    .create();
            if (twilioMessage != null) {
                System.out.println(twilioMessage.getSid());
                return true;
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }
}
