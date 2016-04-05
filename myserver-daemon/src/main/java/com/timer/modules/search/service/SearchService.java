package com.timer.modules.search.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.timer.modules.BaseJobService;

@Service
public class SearchService extends BaseJobService {

    private final static Logger log = LoggerFactory.getLogger(SearchService.class);

    public static Integer count = 1;

    public void getSearhData() {
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\timer\\dto\\" + "searchDto.txt";
            File f = new File(filePath);

            if (f.exists() && f.length() > 10) {
                f.delete();
                f = new File(filePath);
                f.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f.getCanonicalPath(), true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

            List<String> content = getContent("http://www.icbc.com.cn/ICBCDynamicSite/Charts/GoldTendencyPicture.aspx");
            bufferWritter.newLine();
            bufferWritter.newLine();
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

                bufferWritter.write(new String(str.getBytes("gb2312"), "UTF-8"));
                bufferWritter.newLine();
            }

            bufferWritter.flush();
            bufferWritter.close();

            log.info(content.toArray().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("写入数据完成");
    }

    // public static void main(String[] args) throws InterruptedException {
    // String[] arr = new String[]{"银行买入价", "银行卖出价", "中间价", "最高中间价", "最低中间价"};
    // int i = 0;
    // while (true) {
    // List<String> content =
    // getContent("http://www.icbc.com.cn/ICBCDynamicSite/Charts/GoldTendencyPicture.aspx");
    // boolean b = false;
    // i=0;
    // for (String string : content) {
    // if (string.contains("人民币账户白银")) {
    // b = true;
    // }
    // if (string.contains("人民币账户铂金")) {
    // b = false;
    // }
    // if (b) {
    // // System.err.println(string);
    // try {
    // System.err.print(arr[i] + ":" + Double.parseDouble(string) + " ");
    // if(i == 1){
    // if(Double.parseDouble(string) <= 3.10) {
    // System.out.println(Double.parseDouble(string));
    // }
    // }
    // i++;
    // } catch (Exception e) {
    // // System.err.println(string);
    // }
    // }
    // }
    // System.err.println();
    //
    // Thread.sleep(60 * 1000 * 5);
    // }
    // }

    public static void main(String[] args) throws InterruptedException {
        String i = "abcdefghijklmnopqrstuvwxyz01234567890";

        for (int j = 0; j < 400; j++) {

            int len = i.length();
            int fs = (int) (Math.random() * len);
            int ed = (int) (Math.random() * len);

            int f = fs > ed ? ed : fs;
            int e = fs > ed ? fs : ed;

            String h = "http://blog.csdn.net/pistolove/article/details/50868105" + "?s=" + i.substring(f, e);
            getContent(h);
            getContent(h);
            System.err.println(h);
        }
    }

    private static List<String> getContent(String path) {
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
                System.err.println(line);
            }
            in.close();
        } catch (Exception e) {
            sb.append(e.toString());
            log.error(e.getMessage());
            log.error("Usage:   java   HttpClient   <URL>   [<filename>]");
        }
        return result;
    }
}
