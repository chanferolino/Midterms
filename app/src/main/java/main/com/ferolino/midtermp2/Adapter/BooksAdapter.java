package main.com.ferolino.midtermp2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import main.com.ferolino.midtermp2.R;
import main.com.ferolino.midtermp2.model.Boks;

/**
 * Created by Christian on 2/23/2016.
 */
public class BooksAdapter extends ArrayAdapter<Boks> {
    private Context mContext;
    private int         mLayoutId;
    private List<Boks> mBooks;
    public BooksAdapter(Context context, int resource, List<Boks> books) {
        super(context, resource, books);

        mContext = context;
        mLayoutId = resource;
        mBooks = books;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

            // create the view holder
            viewHolder = new ViewHolder();

            viewHolder.listtt = (ListView) convertView.findViewById(R.id.listView);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the movie data
       Boks books = mBooks.get(position);

        if (books != null) {

            if (viewHolder.tvTitle != null) {
                viewHolder.listtt.setText(album.getmName());
            }

        }

        return convertView;
    }

    private static class ViewHolder {

        public ListView listtt;

    }
}
