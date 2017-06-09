package worm.face.data;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ACrawler {

	public static void main(String[] args) {
		String url = "http://www.80s.tw/movie/";
		List<String> listRegex = new ArrayList<String>();
		listRegex.add("<h1 class=\"font14w\">(.+?)</h1>");
		listRegex.add("<span class=\"score sc6\" ></span>(.+?)                            </span>");
		listRegex.add("上映日期：</span>(.+?)</span>");
		ACrawler.spiderRound(10000, 22100, url, listRegex);
	}

	private static void spiderRound(Integer startNum, Integer endNum, String url, List<String> listRegex) {
		int i = startNum;
		while (i <= endNum) {
			String source;
			Integer id = i;
			try {
				source = ACrawler.getByString(url + id);
				if(source != null) {
					for (String regex : listRegex) {
						List<String> name = RegexString1(source, regex);
						if(!name.isEmpty()) {
							System.out.print(name.get(0) + "----");
						}
					}
					System.out.println(id);
				} else {
					i++;
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			i++;
		}
	}

	public final static String getByString(String url) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {  
		     URL url2 = new URL(url);  
		     url2.openStream();  
		} catch (Exception e1) {  
		     System.out.println("连接打不开!");  
		     httpclient.close();
		     return null;
		}  

		try {
			HttpGet httpget = new HttpGet(url);
			httpget.addHeader("Accept", "text/html");
			httpget.addHeader("Accept-Charset", "utf-8");
			httpget.addHeader("Accept-Encoding", "gzip");
			httpget.addHeader("Accept-Language", "en-US,en");
			httpget.addHeader("User-Agent",
					"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						// System.out.println(status);
						return entity != null ? EntityUtils.toString(entity, "utf-8") : null;
					} else {
						System.out.println(status);
						Date date = new Date();
						System.out.println(date);
						System.exit(0);
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			return responseBody;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			httpclient.close();
		}
	}

	public static List<String> RegexString1(String targetStr, String patternStr) throws Exception {
		List<String> thunderPath = new ArrayList<String>();
		// 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		// 相当于埋好了陷阱匹配的地方就会掉下去
		Pattern pattern = Pattern.compile(patternStr);
		// 定义一个matcher用来做匹配
		Matcher matcher = pattern.matcher(targetStr);
		// 如果找到了
		while (matcher.find()) {
			// System.out.println("子路径" + matcher.group(1));
			thunderPath.add(matcher.group(1));
		}
		return thunderPath;
	}

}