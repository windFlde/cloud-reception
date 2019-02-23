package com.jk.utils;

import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500592485";

	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC2yRuyFCOg1bOS5PocRvaNiIyMmy0W+wDxLFu5MVmwrR7YQKMNtJoB+ZbiOx7L5i4rdBgADbNLQinaMk4iysjIhq8X4iMrOFO2CLMKmx9XVO1oyudrvC18zLM0IuwsQEohYhnURlrWbBZRL7EvtyxaJX8UtXfqTxtolo901u2uYYarhB84er+qyJnDtYnYnmhDUNrT+8aicgahKIIJnNFXPTHpbXIoazVHfmP2bPVHm2bCaZMe7gP3u5oc0HMXD/yBO6UwGU3xUds05e252TzYl0/IT+GSY6lm3dq7sRnLpOHpNfQlW/ENAtKICotUYkXp2euKBgHC0zhNk6lu5FbvAgMBAAECggEAV07oc7865XAuPlQxQ6CB1EkNGXxlpTxvzsMpbOQtuz52JUV6nOlPRvI5KAalRy/Dje3+KMhig+gupZKxz9yc22u55uaVdeeJ1MGDA+XkqopefFevAr7320zLrHOh6+Eph5icTdDtQs6OOmlVcT1FainO8c1cYgc3SFXiYCTpkwkiyVj0MBaewr3xY9BxJ1S7NLq+YiutZFIzyXxVztI3BGF/sa5zF9d0NpF9r/fxLr3IYZMS5d3iqLJ2UhgbShY1EUZysWJSPy7OaYKvgYL8neJmZVgtvnLPrldktRGoX+rcYaqCf720ZF9TPz+N5wAiz86dVBMq0B1wBtnVGCW3QQKBgQDwL81XIwbDprqu6EdY5kCXz9L33bMftTSAfHaa3mPRTSWBuYJAjwC8dDlMYlzwyjEQa8KnGfedMl3lU8G5mNPbh1rT44MFvpjJ3Sy3RpVLO6T3npTqc4HSq+Vld6omuNSsSzm1xVE2QTaCIHUCjoXDpxwQ40VDo2+1QMXPz0+DEwKBgQDC0dht22ZiyL4iD0u89CZyGWvN68ydHQCdRd0Fws60nkVzctyQvPwzfj0kIK0F8KI3M9GbR59A99SnNKAuYs933Ku6JAyaOeksXBkMi5UVZG3ksY9eTckwi/Bi2Gt1xpGyA7oh5dSGklOL4sCr2fZWCQbjuSH4Yzry0qC9zWt8NQKBgCZFx7ep2isVB0xVsQDGd+Z49EoQ5rkXu8z5iEC3TTqNy3s3Xz0ATIK7FmJIjjzESzstoK/V4HIJE5M2XHlBlAi4Mc3vw/IHY/tOphByS9nYIDpg56PQUhCK2ZvojJFtBF6MAh8n2QAHNjNYDq0gnsoFd+BtBp13jpZYQu0RQL9HAoGBAIDmm07Elc/Shoq+mBwjZrSjwUJ0O+PQZrGoof7H0ECNX+JtIybZA/2GDyoyPIjrmEjyDkOxddtknt0q4rkOQ7tI1I7Kf1Qj8PWa0jAMws1ur49bNELvMKjgTmL4UtGQWqHv+V2oVZ/cfU7W7yhFhMmUG2zc928DKOO1HQm4Ot/pAoGBAK/HdgmjMwmiDfUgFfTRh57q5PyJjZiUWPe/DvbzSvVd7z+xNUh0R0t8ESHBIKEppwmhv9F19C06F7mDSmUwoYDT1xwM2xR+1/xmGktjdDJbeDd64e+7TN9gHLsBY+So7Ki8tC2tkYhtLeFyTyYuSOs09JFwQ697TjRUHXDA/yqu";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6M4ZpAIMEnWAY9t4Tfe8EV2H9Bbgb9d+VIJFPXH26v7DWlZtR+MUJiHtQtz4kTyIjg1wGKb/0JomcobNXXKIi3sfEIkNEQTy9qW5dR+LQpFCB8mcJk7jWMRl3hMQrVAy3CIaZ3NKb/oFpCoiaU3hYn9CyKQLrh7iqytpbGtc8+upjXTORnFMnrcJEYpYveqm/cDIlDz8KmWKUbb09UXWvMY8JRXUCvVFx4akPxHpT0DYIBeAxgM+XV1OReyI2tttI5I7ZCvLChz8TtreHJrqWt8qkA7BqRdRYyRe40Wo1iueoCUBW41VkMS7DlqKkGf1vbZuo4FjAJyzVRf0X3sVZwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8089/shop/error.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:4001/toView?viewName=shopping";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

