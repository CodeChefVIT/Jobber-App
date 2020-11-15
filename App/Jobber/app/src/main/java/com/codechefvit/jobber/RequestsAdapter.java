package com.codechefvit.jobber;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RequestsAdapter extends RecyclerView.Adapter<RequestsAdapter.RequestViewHolder> {

    private int[] images;
    private String[] head;
    private String[] location;
    private Context context;

    public RequestsAdapter(int[] images, String[] head, String[] location, Context context)
    {
        this.images=images;
        this.head=head;
        this.location=location;
        this.context=context;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.request_layoutitem,parent,false);
        RequestViewHolder requestViewHolder=new RequestViewHolder(view,images,head,location,context);
        return requestViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {
        int imageid=images[position];
        String headid=head[position];
        String locationid=location[position];

        holder.dp.setImageResource(imageid);
        holder.top.setText(headid);
        holder.loc.setText(locationid);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class RequestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView dp;
        TextView top;
        TextView loc;
        Context context;
        int[] images;
        String[] head;
        String[] location;
        public RequestViewHolder(@NonNull View itemView, int[] images,String[] head,String[] location,Context context) {
            super(itemView);

            dp=itemView.findViewById(R.id.dps);
            top=itemView.findViewById(R.id.headings);
            loc=itemView.findViewById(R.id.locations);

            this.context=context;
            this.images=images;
            this.head=head;
            this.location=location;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"Task accepted",Toast.LENGTH_LONG).show();
        }
    }
}
