package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Vector;

public class MatchDetail extends AppCompatActivity {

    DBHelper DB;

    public static Vector<User> users = new Vector();

    Button decrementBTN, incrementBtn, purchaseTicketBTN;
    TextView namaTimKiri, namaTimKanan,matchD, ticketQty;
    ImageView gambarTimKiri, gambarTimKanan, backArrow;

    String namaTeamKiri, namaTeamKanan, matchDate;
    int gambarTeamKiri, gambarTeamKanan, matchId;
    Integer count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        DB = new DBHelper(this);

        namaTimKiri = findViewById(R.id.namaTeamKiri);
        namaTimKanan = findViewById(R.id.namaTeamKanan);
        matchD = findViewById(R.id.matchDate);
        gambarTimKiri = findViewById(R.id.gambarTeamKiri);
        gambarTimKanan = findViewById(R.id.gambarTeamKanan);

        namaTeamKiri = getIntent().getStringExtra("namaTeamKiri");
        namaTeamKanan = getIntent().getStringExtra("namaTeamKanan");
        matchDate = getIntent().getStringExtra("matchDate");
        gambarTeamKanan = getIntent().getIntExtra("gambarTeamKanan",0);
        gambarTeamKiri = getIntent().getIntExtra("gambarTeamKiri", 0);
        matchId = getIntent().getIntExtra("matchId", 0);

        namaTimKiri.setText(namaTeamKiri);
        namaTimKanan.setText(namaTeamKanan);
        matchD.setText(matchDate);
        gambarTimKiri.setImageResource(gambarTeamKiri);
        gambarTimKanan.setImageResource(gambarTeamKanan);

        decrementBTN = findViewById(R.id.decrementBTN);
        incrementBtn = findViewById(R.id.incrementBTN);
        purchaseTicketBTN = findViewById(R.id.purchaseTicketBTN);
        ticketQty = findViewById(R.id.ticketQty);

        decrementBTN.setOnClickListener(v -> {
            if(count <=0){
                count = 0;
            }
            else{
                count--;
            }
            ticketQty.setText(""+count);
        });

        incrementBtn.setOnClickListener(v -> {
            count++;
            ticketQty.setText(""+count);
        });

        backArrow = findViewById(R.id.matchDetailBackArrow);
        backArrow.setOnClickListener(v -> {
            finish();
        });

        purchaseTicketBTN.setOnClickListener(v -> {
            Date currdate = new Date();

            Boolean check = DB.insertTransactionData(LoginActivity.userId, matchId, matchDate, namaTeamKiri, namaTeamKanan, currdate.toString(), count.toString());
            if(check == true){
                Toast.makeText(this, "Ticket purchased!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Ticket not purchased!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}