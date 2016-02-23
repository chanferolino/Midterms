package main.com.ferolino.midtermp2;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import main.com.ferolino.midtermp2.API.BooksAPI;
import main.com.ferolino.midtermp2.Adapter.BooksAdapter;
import main.com.ferolino.midtermp2.model.Boks;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Boks> boki;
    private BooksAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        boki = new ArrayList<Boks>();
        listView = (ListView) findViewById(R.id.listView);


       mAdapter = new BooksAdapter(MainActivity.this,R.layout.content_main, boki);

        FetchBooksTask fetchbookTask = new FetchBooksTask();
        fetchbookTask.execute();
        listView.setAdapter(mAdapter);
    }

    public class FetchBooksTask extends AsyncTask<String, Void, ArrayList<Boks>> {

        @Override
        protected ArrayList<Boks> doInBackground(String[] params) {
            if (params.length == 0) {
                return null;
            }

            String album = params[0];


        return BooksAPI.getBooks(BooksAPI.API_URL,"GET");
        }

        @Override
        protected void onPostExecute(ArrayList<Boks> bokses) {
            super.onPreExecute();


            mAdapter.addAll(bokses);
        }
    }
}
