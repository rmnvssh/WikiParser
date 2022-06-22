import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;


public class Parser extends Thread{
    private final String BASE_URL="https://en.wikipedia.org/api/rest_v1/page/summary/";
    private String subject;
    private String extractText;

    public Parser(String subject) {
        this.subject=subject;
    }

    public void run() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL+subject)
                .get()
                .build();
        try {
            Response response=client.newCall(request).execute();
            String data = response.body().string();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(data);
            extractText = (String)jsonObject.get("extract");
            System.out.println(extractText);
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
