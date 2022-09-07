package com.fanfanfan.cmsservice.service.impl;
import com.fanfanfan.cmsservice.service.MsmService;
import com.fanfanfan.cmsservice.utils.HttpUtils;
import com.fanfanfan.cmsservice.utils.RandomUtil;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 发送短信
 */
@Service
public class MsmServiceImpl  implements MsmService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public boolean send(String PhoneNumbers) {
        String redisCode=(String)redisTemplate.opsForValue().get(PhoneNumbers);
        if (!StringUtils.isEmpty(redisCode)){return true;}
        String host = "http://dingxin.market.alicloudapi.com";
        String path = "/dx/sendSms";
        String method = "POST";
        String appcode = "ad6e3c87f59a431aad7b9ee5c942fbed";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", PhoneNumbers);
        String fourBitRandom = RandomUtil.getFourBitRandom();
        System.out.println(fourBitRandom);
        querys.put("param", "code:"+fourBitRandom);
        querys.put("tpl_id", "TP1711063");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            redisTemplate.opsForValue().set(PhoneNumbers,fourBitRandom,10, TimeUnit.DAYS);
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
       return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
/*

        if (StringUtils.isEmpty(PhoneNumbers)) return false;}

        DefaultProfile profile =
                DefaultProfile.getProfile("default", "LTAIq6nIPY09VROj", "FQ7UcixT9wEqMv9F35nORPqKr8XkTF");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        request.putQueryParameter("SignName", "我的谷粒在线教育网站");
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
*/

}
