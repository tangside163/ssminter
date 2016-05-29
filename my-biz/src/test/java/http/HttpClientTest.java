package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void test1() {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://localhost:/user/getUser");
		BufferedReader reader = null;
		try {
			CloseableHttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			System.out.println("响应状态码为：" + statusCode);
			if (statusCode == 200) {
				HttpEntity httpEntity = response.getEntity();
				//EntityUtils.consume(httpEntity);
				InputStream inputStream = httpEntity.getContent();
				System.out.println("返回结果字符集:" + httpEntity.getContentEncoding());
			    reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
				String line = null;
				StringBuilder sb = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				reader.close();
				
				System.out.println(sb.toString());
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
