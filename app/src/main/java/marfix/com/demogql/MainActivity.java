package marfix.com.demogql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPosts();
    }

    private void getPosts() {
        MyApolloClient.getMyApolloClient().query(
                AllLegsQuery.builder().build()
        ).enqueue(new ApolloCall.Callback<AllLegsQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<AllLegsQuery.Data> response) {
                Log.i("INF", (response.data() != null ? response.data().allLegs.size() : 0) + "");
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
                Log.e("ERR", e.getMessage());
            }
        });
    }

}
