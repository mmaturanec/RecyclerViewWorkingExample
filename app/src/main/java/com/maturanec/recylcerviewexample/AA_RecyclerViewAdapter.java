package com.maturanec.recylcerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AA_RecyclerViewAdapter extends RecyclerView.Adapter<AA_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<AminoAcidModel> aminoAcidModels;
    public AA_RecyclerViewAdapter(Context context, ArrayList<AminoAcidModel> aminoAcidModels, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.aminoAcidModels = aminoAcidModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public AA_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recylcer_view_row, parent, false);
        return new AA_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AA_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //assigning values to the view we created in the recycle_view_row layout file
        //based on the position of the recycler view
            //https://www.youtube.com/watch?v=Mc0XT58A1Z4&t=1176s
                //https://www.youtube.com/watch?v=7GPUpvcU1FE
        holder.tvName.setText(aminoAcidModels.get(position).getAminoAcidName());
        holder.tv3Letter.setText(aminoAcidModels.get(position).getAminoAcidAbbreviation());
        holder.tv1Letter.setText(aminoAcidModels.get(position).getAminoAcidAbbreviationSmall());
        holder.imageView.setImageResource(aminoAcidModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return aminoAcidModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the views from our recycler_view_row layout file
        //kinda like in the onCreate method

        ImageView imageView;
        TextView tvName, tv3Letter, tv1Letter;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView3);
            tv3Letter = itemView.findViewById(R.id.textView2);
            tv1Letter = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null)
                    {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION)
                        {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
