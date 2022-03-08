/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author asus
 */
public class SmsApi {
    public static final String ACCOUNT_SID = "ID_TWILIO";
    public static final String AUTH_TOKEN = "TOKEN_TWILIO";

    public static void sendSMS(String num, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(/*num ili bch yjih il msg */new PhoneNumber(num),new PhoneNumber("+14704444081"), msg).create();

        System.out.println(message.getSid());

    }
}
