package com.example.android.news;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<News> {

    private String firstLine;
    private String secondLine;

    /**
     * Create a new {@link NewsAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param urlNews is the list of {@link News}s to be displayed.
     */
    public NewsAdapter(Activity context, ArrayList<News> urlNews) {
        super(context, 0, urlNews);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        /**
         * the pillar name of the news
         */
        // Find the TextView in the .xml layout with the ID pillarTextView
        TextView pillarTextView = (TextView) listItemView.findViewById(R.id.pillar_text_view);
        // Display the pillar of the current news in that TextView
        pillarTextView.setText("Category: " + currentNews.getPillar());

        LinearLayout main = (LinearLayout) listItemView.findViewById(R.id.description_linear_layout);

        // Get the appropriate background color based on the pillar value
        int pillarColor = getPillarColor(currentNews.getPillar());

        // Set the color
        main.setBackgroundColor(pillarColor);


        /**
         * the title of the news
         */
        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView firstLineTitleTextView = (TextView) listItemView.findViewById(R.id.first_line_text_view);
        //Show first and second line text
        firstLineTitleTextView.setText(currentNews.getTitle());

        /**
         * Date and time of news
         */

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_text_view);
        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time_text_view);

        String originalTime = currentNews.getTime();
        firstLine = originalTime.substring(0, 10);
        secondLine = originalTime.substring(11, 16);

        // Display the date of the current news in that TextView
        dateView.setText("Date: " + firstLine);
        // Display the time of the current news in that TextView
        timeView.setText("Time: " + secondLine);


        /**
         * AUTHOR
         */
        // Find the TextView in the .xml layout with the ID authorTextView
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_text_view);

        if (currentNews.getAuthor() != "") {
            // Display the author of the current news in that TextView
            authorTextView.setText("Author: " + currentNews.getAuthor());
        } else {
            authorTextView.setVisibility(View.GONE);
        }


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }

    private int getPillarColor(String pillar) {
        int pillarColorResourceId;
        String a = pillar;
        if (pillar.equalsIgnoreCase("news")) {
            pillarColorResourceId = R.color.pillar1;
        } else {
            if (pillar.equalsIgnoreCase("lifestyle")) {
                pillarColorResourceId = R.color.pillar2;
            } else {
                pillarColorResourceId = R.color.pillar3;
            }
        }
        return ContextCompat.getColor(getContext(), pillarColorResourceId);
    }
}