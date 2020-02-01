package arsenal.metiz.catalog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CardViewHolder> {

    private ArrayList<Composition> comp;
    Context c;



    public Adapter(Context c, ArrayList<Composition> comp) {
        this.c =c;
        this.comp = comp;
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context layout = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(layout);
        View view = layoutInflater.inflate(R.layout.activty_list_card,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        Composition composition = comp.get(position);
        int imageRes = composition.getImage();
        final String title = composition.getTitle();
        String type = composition.getType();


        holder.imageView.setImageResource(imageRes);
        holder.title.setText(title);
        holder.type.setText(type);

        holder.setItemClickListener((v, position1) -> {
            Intent intent = new Intent(c, InfoActivity.class);
            intent.putExtra("Title", title);
            c.startActivity(intent);

        });




    }

    @Override
    public int getItemCount() {
        return comp.size();
    }

    public void replaceCompositions(ArrayList<Composition> comp) {
        this.comp.clear();
        this.comp.addAll(comp);
        notifyDataSetChanged();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView title, type;
        View cardView;
        ItemClickListener itemClickListener;

        public CardViewHolder(@NonNull View v) {
            super(v);
            cardView = v;
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            type = itemView.findViewById(R.id.type);

            cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClickListener(v, getLayoutPosition());

        }


        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;

        }
    }

}
