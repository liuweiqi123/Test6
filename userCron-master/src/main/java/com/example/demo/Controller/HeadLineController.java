package com.example.demo.Controller;

import com.example.demo.dao.HeadLineText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
public class HeadLineController {
    public final static String ENCODE = "UTF-8";
    public static Date date = new Date();
    /**
     * 调用对方接口方法
     *
     * @param path 对方或第三方提供的路径
     * @param data 向对方或第三方发送的数据，大多数情况下给对方发送JSON数据让对方解析
     * @return
     */
    public static String interfaceUtil(String path, String data) {
        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
//          conn.setRequestMethod("POST");
//           //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();

            System.out.println("查询结束");
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
    //json数据解析

    @RequestMapping(value = "/HeadLine",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin

    public static List<HeadLineText> JsonTest() throws JSONException {
        String Jsondata=interfaceUtil("http://zhouxunwang.cn/data/?id=75&key=XO6V+4FnGNX+iJmB8Yo1RGnJOwTgsJeZ/px16A&type=top", "");
        JSONObject jsonObject = new JSONObject(Jsondata);
        JSONObject jsonObject1 = new JSONObject(jsonObject.getString("result"));
        JSONArray jsonArray = jsonObject1.getJSONArray("data");
        List<HeadLineText> headLineList = new ArrayList<HeadLineText>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            HeadLineText headLineText = new HeadLineText();
            headLineText.setUniquekey(jsonObject2.getString("uniquekey"));
            headLineText.setAuthor_name(jsonObject2.getString("author_name"));
            headLineText.setCategory(jsonObject2.getString("category"));
            headLineText.setDate(jsonObject2.getString("date"));
            headLineText.setTitle(jsonObject2.getString("title"));
            headLineText.setUrl(jsonObject2.getString("url"));
            headLineText.setThumbnail_pic_s(jsonObject2.getString("thumbnail_pic_s"));
            headLineList.add(headLineText);
        }
        return headLineList;
    }

}