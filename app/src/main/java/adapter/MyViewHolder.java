package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashish.cameraoverlay.R;

public class MyViewHolder extends RecyclerView.ViewHolder {


    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);


        img= (ImageView) itemView.findViewById(R.id.spacecraftImg);

    }
}
