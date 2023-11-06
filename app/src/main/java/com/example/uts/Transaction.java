package com.example.uts;

import java.util.Date;

public class Transaction {
    private Integer transactionId;
    private String transactionDate;
    private String namaTeamKiri, namaTeamKanan, matchDate, ticketQty;

    public Transaction(Integer transactionId, String ticketQty, String transactionDate, String namaTeamKiri, String namaTeamKanan, String matchDate) {
        this.transactionId = transactionId;
        this.ticketQty = ticketQty;
        this.transactionDate = transactionDate;
        this.namaTeamKiri = namaTeamKiri;
        this.namaTeamKanan = namaTeamKanan;
        this.matchDate = matchDate;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTicketQty() {
        return ticketQty;
    }

    public void setTicketQty(String ticketQty) {
        this.ticketQty = ticketQty;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getNamaTeamKiri() {
        return namaTeamKiri;
    }

    public void setNamaTeamKiri(String namaTeamKiri) {
        this.namaTeamKiri = namaTeamKiri;
    }

    public String getNamaTeamKanan() {
        return namaTeamKanan;
    }

    public void setNamaTeamKanan(String namaTeamKanan) {
        this.namaTeamKanan = namaTeamKanan;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }
}
