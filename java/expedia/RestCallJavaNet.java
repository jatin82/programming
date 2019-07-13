import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2{
	public static void main(String[] args)  {
		try {
			URL url = new URL("http://localhost:8081/custom");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder ans = new StringBuilder();
			String out = "";
			while((out=br.readLine())!=null) {
				ans.append(out);
			}
			Pattern pattern = Pattern.compile("LEARNINGVIEW");
			Matcher m = pattern.matcher(ans);
			int count = 0;
			while(m.find()) {
				count++;
			}
			System.out.println(count);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
