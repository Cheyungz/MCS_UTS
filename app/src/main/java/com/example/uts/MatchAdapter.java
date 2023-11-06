package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private Context context;
    public static Vector<Match> match = new Vector<>();

    public MatchAdapter(Context context) {
        this.context = context;
    }

    public static void setMatch(Vector<Match> match) {
        MatchAdapter.match = match;
    }

    @NonNull
    @Override
    public MatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.match_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchAdapter.ViewHolder holder, int position) {
        holder.namaTeamKiri.setText(match.get(position).getNamaTeamKiri());
        holder.namaTeamKanan.setText(match.get(position).getNamaTeamKanan());
        holder.gambarTeamKanan.setImageResource(match.get(position).getGambarTeamkanan());
        holder.gambarTeamKiri.setImageResource(match.get(position).getGambarTeamKiri());
        holder.matchDate.setText(match.get(position).getMatchDate());
    }

    @Override
    public int getItemCount() {
        return match.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView namaTeamKiri, namaTeamKanan, matchDate;
        ImageView gambarTeamKiri, gambarTeamKanan;

        CardView click;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaTeamKiri = itemView.findViewById(R.id.namaTeamKiri);
            namaTeamKanan = itemView.findViewById(R.id.namaTeamKanan);
            gambarTeamKiri = itemView.findViewById(R.id.gambarTeamKiri);
            gambarTeamKanan = itemView.findViewById(R.id.gambarTeamKanan);
            matchDate = itemView.findViewById(R.id.matchDate);
            click = (CardView) itemView.findViewById(R.id.matchCV);
            click.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent detail = new Intent(v.getContext(), MatchDetail.class);

            detail.putExtra("gambarTeamKiri", match.get(getAdapterPosition()).getGambarTeamKiri());
            detail.putExtra("gambarTeamKanan", match.get(getAdapterPosition()).getGambarTeamkanan());
            detail.putExtra("namaTeamKiri", match.get(getAdapterPosition()).getNamaTeamKiri());
            detail.putExtra("namaTeamKanan", match.get(getAdapterPosition()).getNamaTeamKanan());
            detail.putExtra("matchDate", match.get(getAdapterPosition()).getMatchDate());
            detail.putExtra("matchId", match.get(getAdapterPosition()).getMatchId());
            context.startActivity(detail);
        }
    }
}
