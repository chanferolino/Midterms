package main.com.ferolino.midtermp2;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import main.com.ferolino.midtermp2.API.BooksAPI;
import main.com.ferolino.midtermp2.model.Boks;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Boks> boki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listView);

        FetchBooksTask fetchbookTask = new FetchBooksTask();
        fetchbookTask.execute();
    }

    public class FetchBooksTask extends AsyncTask<String, Void, Boks> {

        @Override
        protected Boks doInBackground(String[] params) {
            if (params.length == 0) {
                return null;
            }

            String album = params[0];
            Uri builtUri = Uri.parse(BooksAPI.API_URL).buildUpon()

                    .build();

        return BooksAPI.getBooks(builtUri,"GET");
        }

        @Override
        protected void onPostExecute(ArrayList<Boks> bokses) {
           boki = new ArrayList<Boks>();

            try {

                JSONArray items = new JSONArray("bokb");

                for (int i = 0; i < items.length(); i++) {
                    JSONObject videoObject = items.getJSONObject(i);
                    Albums al = new Video(videoObject.getString("title"),
                            videoObject.getString("description"),
                            videoObject.getJSONObject("player")
                                    .getString("default"),
                            videoObject.getJSONObject("thumbnail")
                                    .getString("sqDefault"));

                    videos.add(video);
                }

            } catch (JSONException e) {
                // manage exceptions
            }
            super.onPostExecute(bokses);
        }
    }
}
