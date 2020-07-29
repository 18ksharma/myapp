package com.example.cycleshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.cycleshare.models.Comment;
import com.example.cycleshare.models.Post;
import com.parse.ParseFile;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder>  {
    private Context context;
    private List<Comment> comments;

    public CommentsAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.bind(comment);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void clear() {
        comments.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Comment> listofcomments) {
        comments.addAll(listofcomments);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivprofilePic;
        private TextView tvUsername;
        private TextView tvContents;
        private TextView tvTimestamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivprofilePic=itemView.findViewById(R.id.ivProfilePicture);
            tvUsername=itemView.findViewById(R.id.tvUsername);
            tvContents=itemView.findViewById(R.id.tvContent);
            tvTimestamp=itemView.findViewById(R.id.tvTimestamp);
        }

        public void bind(Comment comment) {
            tvUsername.setText(comment.getUser().getUsername());
            tvContents.setText(comment.getContents());
            tvTimestamp.setText(Utils.getRelativeTimeAgo(comment.getCreatedAt().toString()));
            ParseFile profilePic = comment.getUser().getParseFile("profilePic");
            if(profilePic!=null) {
                //Circle crops profile pic
                Glide.with(context).load(profilePic.getUrl()).placeholder(R.drawable.ic_baseline_person_24)
                        .transform(new CircleCrop()).into(ivprofilePic);
            }
            else{
                Glide.with(context).load("http://img.freepik.com/free-vector/abstract-geometric-lines-seamless-pattern_144290-8.jpg?size=626&ext=jpg")
                        .placeholder(R.drawable.ic_baseline_person_24).transform(new CircleCrop()).into(ivprofilePic);

            }


        }
    }
}
