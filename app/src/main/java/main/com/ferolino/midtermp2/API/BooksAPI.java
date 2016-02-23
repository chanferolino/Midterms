package main.com.ferolino.midtermp2.API;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import main.com.ferolino.midtermp2.model.Boks;
import main.com.ferolino.midtermp2.utils.HttpUtils;

/**
 * Created by Christian on 2/23/2016.
 */
public class BooksAPI {
    public static final String BASE_URL     = "http://joseniandroid.herokuapp.com";
    public static final String API_URL = "http://joseniandroid.herokuapp.com/api/books";

    private static final String BOOK_TITLE = "title";
    private static final boolean BOOK_isREAD = true;



    public static ArrayList<Boks> getBooks(String sring, @NonNull String requestMethod) {
        String json = HttpUtils.getResponse(API_URL, requestMethod);

        if (TextUtils.isEmpty(json)) {
            Log.d("Hohoho","wala");

            return null;
        }

        // Here we will now parse the json response and convert it into a Weather object.
        final String name;
         ArrayList<Boks> books = new ArrayList<Boks>();

        try {
            JSONArray jsons = new JSONArray(json);
            Log.d("Hohoho", jsons.toString());

            Boks boooki = new Boks ("gwapo","hehe");
            books.add(boooki);
            for (int i = 0; i < jsons.length(); i++) {
                JSONObject bookObject = jsons.getJSONObject(i);
               Boks booooks = new Boks(bookObject.getString("title"),
                       bookObject.getString("isRead")
                       );
               books.add(booooks);

            }
            return books;

        } catch (JSONException e) {
            Boks boooki = new Boks ("gwapa","hihi");
           Log.d("Hohoho", String.valueOf(e));
            books.add(boooki);
           return books;
        }

    }
}


