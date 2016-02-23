package main.com.ferolino.midtermp2.API;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

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
    public static final String BASE_URL     = "joseniandroid.herokuapp.com";
    public static final String API_URL = "joseniandroid.herokuapp.com/api/books";

    private static final String BOOK_TITLE = "title";
    private static final boolean BOOK_isREAD = true;



    public static Boks getBooks(Uri uri, @NonNull String requestMethod) {
        String json = HttpUtils.getResponse(API_URL, requestMethod);

        final String name;
        final String isRead;
        if (TextUtils.isEmpty(json)) {
            return null;
        }

        // Here we will now parse the json response and convert it into a Weather object.



        try {

            JSONArray items = new JSONArray("json");

            for (int i = 0; i < items.length(); i++) {
                JSONObject bookObject = items.getJSONObject(i);
               Boks booooks = new Boks(bookObject.getString("title"),
                       bookObject.getString("isRead")
                       );

                Boks a = new Boks();
                a.setmName(name);
                a.setmArtist(artist);
                a.setmImageId(image);

            }

        } catch (JSONException e) {
            // manage exceptions
        }
        return books;
    }
}
