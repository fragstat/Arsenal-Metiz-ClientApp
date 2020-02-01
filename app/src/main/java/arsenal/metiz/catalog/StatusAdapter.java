package arsenal.metiz.catalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class  StatusAdapter extends RecyclerView.Adapter<StatusAdapter.CardViewHolder> {

    private final ArrayList<RequestsStatus> statuses = new ArrayList<>();


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context layout = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(layout);
        View view = layoutInflater.inflate(R.layout.activity_statuses_card,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        RequestsStatus status = statuses.get(position);
        String requestNumber = status.getRequestNumber();
        final String mark = status.getMark();
        String diameter = status.getDiameter();
        String layer = status.getLayer();
        String pack = status.getPack();
        String statusR = status.getStatus();


        holder.request.setText(requestNumber);
        holder.mark.setText(mark);
        holder.diameter.setText(diameter);
        holder.layer.setText(layer);
        holder.pack.setText(pack);
        holder.statusRe.setText(statusR);
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }

    void replaceStatuses(ArrayList<RequestsStatus> statuses) {
            this.statuses.clear();
            this.statuses.addAll(statuses);
            notifyDataSetChanged();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        TextView request, mark,diameter,layer,pack,statusRe;
        View cardView;

        public CardViewHolder(@NonNull View v) {
            super(v);
            cardView = v;
            request = itemView.findViewById(R.id.requestNumber);
            mark = itemView.findViewById(R.id.mType);
            diameter = itemView.findViewById(R.id.mDiameter);
            layer = itemView.findViewById(R.id.mLayer);
            pack = itemView.findViewById(R.id.mPackageS);
            statusRe = itemView.findViewById(R.id.mStatus);
        }

    }
}
