package com.mehmeteraysurmeli.poster;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class postClass extends ArrayAdapter<String> {

    private final ArrayList<String> userEmail;
    private final ArrayList<String> userComment;
    private final ArrayList<String> userImage;
    private final Activity contect;

    public postClass(ArrayList<String> userEmail, ArrayList<String> userComment, ArrayList<String> userImage, Activity contect) {
        super(contect,R.layout.custom_view,userEmail);
        this.userEmail = userEmail;
        this.userComment = userComment;
        this.userImage = userImage;
        this.contect = contect;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = contect.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);

        TextView userEmailText = customView.findViewById(R.id.userEmailCustomView);
        TextView commentText = customView.findViewById(R.id.userCommentTextView);
        ImageView imageView = customView.findViewById(R.id.imageCustomView);

        userEmailText.setText(userEmail.get(position));
        commentText.setText(userComment.get(position));

        Picasso.get().load(userImage.get(position)).into(imageView);

        return customView;
    }
}
