package marfix.com.demogql;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;

public class MyApolloClient {

    private static final String BASE_URL = "https://api.graph.cool/simple/v1/cjpaxmgyz7zlr0162u09d1nvr";

    public static ApolloClient getMyApolloClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        return ApolloClient.builder()
                .serverUrl(BASE_URL).okHttpClient(okHttpClient).build();
    }

}
