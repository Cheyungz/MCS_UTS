package com.example.uts;

public class Match {
    private String namaTeamKiri;
    private String namaTeamKanan;
    private int gambarTeamKiri;
    private int gambarTeamkanan;
    private int matchId;
    private String matchDate;

    public Match(String namaTeamKiri, String namaTeamKanan, int gambarTeamKiri, int gambarTeamkanan, int matchId, String matchDate) {
        this.namaTeamKiri = namaTeamKiri;
        this.namaTeamKanan = namaTeamKanan;
        this.gambarTeamKiri = gambarTeamKiri;
        this.gambarTeamkanan = gambarTeamkanan;
        this.matchId = matchId;
        this.matchDate = matchDate;
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

    public int getGambarTeamKiri() {
        return gambarTeamKiri;
    }

    public void setGambarTeamKiri(int gambarTeamKiri) {
        this.gambarTeamKiri = gambarTeamKiri;
    }

    public int getGambarTeamkanan() {
        return gambarTeamkanan;
    }

    public void setGambarTeamkanan(int gambarTeamkanan) {
        this.gambarTeamkanan = gambarTeamkanan;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }
}
