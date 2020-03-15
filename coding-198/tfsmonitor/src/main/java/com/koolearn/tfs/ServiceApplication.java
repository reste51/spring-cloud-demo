package com.koolearn.tfs;

import com.koolearn.tfs.client.Tfstool;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michael on 2017/10/28.
 */
@SpringBootApplication
public class ServiceApplication {

    private static Tfstool tfstool = Tfstool.getInstance();

    private static boolean isOk = true;

    public static void main(String args[]) {
//        SpringApplication.run(ServiceApplication.class, args);


        while(true) {
            try {
                test();
            } catch (Exception e) {
                e.printStackTrace();
                isOk = false;
                alert(e);
            }
            try{
                Thread.sleep(60*1000);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void alert(Exception e) {
        Map<String,String> params = new HashMap<>();
        params.put("subject", "tfs功能异常");
        //mail content
        params.put("content", "tfs不正常啦 异常信息如下："+getErrorInfoFromException(e));

        //to
        params.put("tos", "liuyi@koolearn.com,miaoyoumeng@koolearn.com,wangying@koolearn.com");

        post("http://falcon-mobi.cluster.koolearn.com/common/sendEmail", params);
    }

    public static String getErrorInfoFromException(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            String ret = sw.toString();
            sw.close();
            pw.close();
            return ret;
        } catch (Exception e2) {
            return "ErrorInfoFromException";
        }
    }

    public static String post(String url, Map<String,String> params){
        InputStream is = null;
        try {
            HttpClient c = new DefaultHttpClient();
            HttpPost p = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if(params!=null){
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            //设置参数到请求对象中
            p.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            HttpResponse r = c.execute(p);

            is = r.getEntity().getContent();
            StringBuffer sb = new StringBuffer(1024);
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = is.read(b, 0, b.length))>0) {
                sb.append(new String(b, 0, len));
            }

            int statusCode = r.getStatusLine().getStatusCode();
            if(statusCode>=400){
            }
            return sb.toString();
        }
        catch(IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try{
                    is.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void test() throws Exception {

        String filename = "/aaaa.txt";
        System.out.println("========="+tfstool.isFileExist(filename));
        if(tfstool.isFileExist(filename)) {
            try {
                tfstool.rmFile(filename);
            }catch(Exception e) {

            }
        }
        tfstool.createFile(filename);
        //long offset, byte[] data, long dataOffset, long length
        byte[] data = "test content".getBytes();
        tfstool.writeFile(filename, 0, data, 0, data.length);
        System.out.println("okok");

        if(!isOk) {
            isOk = true;
            ok();
        }
    }

    private static void ok() {
        Map<String,String> params = new HashMap<>();
        params.put("subject", "tfs ok");
        //mail content
        params.put("content", "tfs恢复正常");

        //to
        params.put("tos", "liuyi@koolearn.com,miaoyoumeng@koolearn.com,wangying@koolearn.com");

        post("http://falcon-mobi.cluster.koolearn.com/common/sendEmail", params);
    }
}
