package com.timer.modules.ag.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.timer.modules.BaseJobService;

@Service
public class AgService extends BaseJobService{

    public static void main(String[] args) throws InterruptedException {
        AgService agService = new AgService();
       while(true) {
           agService.getAG();
           Thread.sleep(10000);
       }
    }
    
    /**
     * 获取当前白银的价格
     */
    public void getAG() {
        List<String> content = getContent("http://www.icbc.com.cn/ICBCDynamicSite/Charts/GoldTendencyPicture.aspx");
        StringBuffer buffer = new StringBuffer();
        boolean catc = false;
        for (String str : content) {
            if (str.contains("人民币账户白银")) {
                buffer.append(str.trim());
                catc = true;
                continue;
            }

            if (catc) {
                buffer.append(str.trim());
            }
        }
        String filter = filter(buffer.toString());
        System.err.println(filter);
    }

    private static String filter(String str) {
        int fs = 0;
        int ed = 0;
        int len  = str.length();
        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == '<') {
                fs = i;
                continue;
            }
            if(str.charAt(i) == '>') {
                ed = i;
            }
            if(fs !=0 && ed !=0 ) {
                String re = str.substring(fs, ed+1);
                if(re.equals("</a>")){
                    String rt = str.substring(0, ed + 1);
                    return rt;
                    
                }
                return filter(str.replace(re, "  "));
            }
        }
        return str;
    }

    private List<String> getContent(String path) {
        List<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        try {
            java.net.URL url = new java.net.URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = in.readLine()) != null) {
                result.add(line);
            }
            in.close();
        } catch (Exception e) {
            sb.append(e.toString());
        }
        return result;
    }

}
