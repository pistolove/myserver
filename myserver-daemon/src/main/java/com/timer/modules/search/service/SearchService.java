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

import com.timer.modules.BaseJobService;

public class SearchService extends BaseJobService{

	private final static Logger log = LoggerFactory.getLogger(SearchService.class);

	public static Integer count = 1;

	public void getSearhData() {
		try {
			String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\timer\\dto\\" + "searchDto.txt";
			File f = new File(filePath);
			
			if(f.exists() && f.length() > 10){
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
				if(str.contains("人民币账户白银")){
					buffer.append(str.trim());
					catc = true;
					continue;
				}
				
				if(catc){
					buffer.append(str.trim());
				}
				
				bufferWritter.write(new String(str.getBytes("gb2312"),"UTF-8"));
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

	public static void main(String[] args) {
		List<String> content = getContent("http://www.icbc.com.cn/ICBCDynamicSite/Charts/GoldTendencyPicture.aspx");
		for (String string : content) {
			System.err.println(string);
		}
	}

	private static List<String> getContent(String path) {
		List<String> result = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		try {
			java.net.URL url = new java.net.URL(path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
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
			log.error(e.getMessage());
			log.error("Usage:   java   HttpClient   <URL>   [<filename>]");
		}
		return result;
	}
}
