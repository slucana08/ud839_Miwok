package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{

    private int mbackgroundColor;

    public WordAdapter(Context context, ArrayList<Word> words,int backgroundColor) {
        super(context, 0,words);
        this.mbackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word currentWord = getItem(position);
        LinearLayout rootLinearLayout = listItemView.findViewById(R.id.rootLinearLayout);
        rootLinearLayout.setBackgroundColor(ContextCompat.getColor(getContext(),mbackgroundColor));
        TextView miwokTextView = listItemView.findViewById(R.id.miwokNumberText);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTextView = listItemView.findViewById(R.id.defaultNumberText);
        defaultTextView.setText(currentWord.getDefautTranslation());
        ImageView imageView = listItemView.findViewById(R.id.miwokImage);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
