package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashish.cameraoverlay.ImagePreview;
import com.ashish.cameraoverlay.MainActivity;
import com.ashish.cameraoverlay.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Model> spacecrafts;

    public MyAdapter(Context c, ArrayList<Model> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.items, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
final Activity act=(Activity)c;
        final Model s = spacecrafts.get(position);
        Picasso.with(c).load(s.getUri()).placeholder(R.drawable.loading).noFade().into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(act, ImagePreview.class);
                intent.putExtra("path",s.getUri().toString());
                act.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}