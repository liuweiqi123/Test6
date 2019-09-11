package com.example.demo.Controller;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.TranslatorWebService;
import cn.com.webxml.TranslatorWebServiceSoap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Controller
public class TransLationController {


    //双向翻译
    @RequestMapping(value = "/TransLation",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin

    public List<String> TransLation(HttpServletRequest request) {
        List<String> list = null;
        try {
            request.setCharacterEncoding("utf-8");
            //获取页面返回的单词
            String word = request.getParameter("word");
            System.out.println(word);
            //创建TransLator翻译对象，对单词进行翻译
            TranslatorWebService translatorWebService = new TranslatorWebService();
            TranslatorWebServiceSoap soap = translatorWebService.getTranslatorWebServiceSoap();
            ArrayOfString arrayOfString = soap.getEnCnTwoWayTranslator(word);

            //创建列表，存储翻译结果
            list = arrayOfString.getString();
            request.setAttribute("info", list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void get(String mobileCode ,String userID ) throws Exception{
        URL url=new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode="+mobileCode+
                "&userID="+userID);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){ //结果码=200
            InputStream is=conn.getInputStream();
            //内存流 ，
            ByteArrayOutputStream boas=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len=-1;
            while((len=is.read(buffer))!=-1){
                boas.write(buffer, 0, len);
            }
            System.out.println("GET请求获取的数据:"+boas.toString());
            boas.close();
            is.close();
        }
    }
}
