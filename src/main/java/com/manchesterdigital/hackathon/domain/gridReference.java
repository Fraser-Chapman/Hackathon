package com.manchesterdigital.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class gridReference {

    @JsonProperty("gridRef")
    public String getGridRef() {
        return gridRef;
    }

    @JsonProperty("gridRef")
    public void setGridRef(String gridRef) {
        this.gridRef = gridRef;
    }

    private String gridRef;
}
