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
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvNames);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the movie data
        Boks booki = mBooks.get(position);

        if (booki!= null) {

            if (viewHolder.tvName != null) {
                viewHolder.tvName.setText(booki.getTitle());
            }

        }

        return convertView;
    }

    private static class ViewHolder {

        public TextView tvName;

    }
}
