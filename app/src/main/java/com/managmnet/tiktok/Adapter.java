package com.managmnet.tiktok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    Context context;
    ArrayList<Model> arrayList;
    boolean isPlaying;
    public Adapter(Context context, ArrayList<Model> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.reel_rv,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.v.setVideoPath(arrayList.get(position).getVideoUri());
        holder.name.setText(arrayList.get(position).getName());
        holder.iv.setImageResource(arrayList.get(position).getProfile());
        MediaController mc = new MediaController(context.getApplicationContext());

        holder.v.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                isPlaying=true;
            }
        });
        holder.v.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                isPlaying=true;

            }
        });
        holder.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(isPlaying)
             {

                 holder.v.pause();
                 isPlaying=false;
             }
             else{


                 holder.v.resume();
                 isPlaying=true;
             }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        VideoView v;
        ImageView iv;
        TextView name;
        FrameLayout l;
        public ViewHolder(@NonNull View view)
        {
            super(view);

            l = view.findViewById(R.id.videolayout);
            v = view.findViewById(R.id.videoView);
            iv = view.findViewById(R.id.profile_image);
            name = view.findViewById(R.id.textView);
        }
    }

}
