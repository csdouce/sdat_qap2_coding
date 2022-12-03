package com.keyin.sdat.qap2;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "tournament_sequence")

    // Instance Variables
    @Column(name = "id")
    private long tournamentId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "location")
    private String location;

    @Column(name = "entry_fee")
    private long entryFee;

    @Column(name = "cash_prize_amount")
    private long cashPrizeAmount;

    // Getters and Setters
    public long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(long entryFee) {
        this.entryFee = entryFee;
    }

    public long getCashPrizeAmount() {
        return cashPrizeAmount;
    }

    public void setCashPrizeAmount(long cashPrizeAmount) {
        this.cashPrizeAmount = cashPrizeAmount;
    }
}
