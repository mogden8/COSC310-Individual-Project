package assignment2;



import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GetDistance {



    private static final String API_KEY="AIzaSyDCa-lgqAYrBGHeMoiewFWF51KEH3zHEgU";
    static OkHttpClient client = new OkHttpClient();


public static String calculate(String source ,String destination) throws IOException {
String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+source+"&destinations="+destination+"&key="+ API_KEY;
            Request request = new Request.Builder()
                .url(url)
                .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
          }


}