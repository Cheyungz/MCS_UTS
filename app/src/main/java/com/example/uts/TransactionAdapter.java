package com.example.uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private Context context;
    public static Vector<Transaction> transactions= new Vector();

    public TransactionAdapter(Context context, Vector<Transaction> list) {
        this.context = context;
        setTransactions(list);
    }

    public static void setTransactions(Vector<Transaction> transactions) {
        TransactionAdapter.transactions = transactions;
    }


    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trans_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {
        holder.transId.setText(String.valueOf(transactions.get(position).getTransactionId()));
        holder.transDate.setText(transactions.get(position).getTransactionDate());
        holder.timKiri.setText(transactions.get(position).getNamaTeamKiri());
        holder.timKanan.setText(transactions.get(position).getNamaTeamKanan());
        holder.matchDate.setText(transactions.get(position).getMatchDate());
        holder.ticket.setText(transactions.get(position).getTicketQty());

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView transId, transDate, timKiri, timKanan, matchDate, ticket;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transId = itemView.findViewById(R.id.transactionId);
            transDate = itemView.findViewById(R.id.transactionDate);
            timKiri = itemView.findViewById(R.id.timKiri);
            timKanan = itemView.findViewById(R.id.teamKanan);
            matchDate = itemView.findViewById(R.id.matchDate);
            ticket = itemView.findViewById(R.id.ticketQuantity);
        }
    }
}
