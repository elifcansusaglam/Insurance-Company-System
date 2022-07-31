package com.elifcansusaglam.finalproject.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "insurance_report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;
    @Column(name="profit")
    private int profit;
    @Column(name="loss")
    private int loss;
    @ManyToOne
    @JoinColumn(name="insurance_id",referencedColumnName = "id")
    private Agency agency;

    public Report(int id, Date startDate, Date endDate, int profit, int loss, Agency agency) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.profit = profit;
        this.loss = loss;
        this.agency=agency;
    }

    public Report() {
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }


    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", profit=" + profit +
                ", loss=" + loss +
                '}';
    }
}
