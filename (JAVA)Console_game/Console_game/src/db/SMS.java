package db;


import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
public class SMS {
	
  public static int sendCert(String HP) {
	 Random rand = new Random();
	 int cert = rand.nextInt(999998)+1;
    String api_key = "";
    String api_secret = "";
    Message coolsms = new Message(api_key, api_secret);
    
    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", HP);
    params.put("from", "");
    params.put("type", "SMS");
    params.put("text", "인증번호 "+cert+"를 입력해 주세요.");

    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
    return cert;
  }
}