package com.manchesterdigital.hackathon.domain;

import com.opencsv.bean.CsvBindByName;

public class ParkingData {

    @CsvBindByName
    private String GridRef;

    @CsvBindByName
    private String NumberOfTicketsIssued;

    @CsvBindByName
    private String AvgNumberOfTicketsPerDay;

    public String getGridRef() {
        return GridRef;
    }

    public void setGridRef(String gridRef) {
        this.GridRef = gridRef;
    }

    public String getNumberOfTicketsIssued() {
        return NumberOfTicketsIssued;
    }

    public void setNumberOfTicketsIssued(String numberOfTicketsIssued) {
        this.NumberOfTicketsIssued = numberOfTicketsIssued;
    }

    public String getAvgNumberOfTicketsPerDay() {
        return AvgNumberOfTicketsPerDay;
    }

    public void setAvgNumberOfTicketsPerDay(String avgNumberOfTicketsPerDay) {
        this.AvgNumberOfTicketsPerDay = avgNumberOfTicketsPerDay;
    }
}
