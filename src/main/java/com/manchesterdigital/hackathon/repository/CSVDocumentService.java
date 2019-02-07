package com.manchesterdigital.hackathon.repository;

import com.manchesterdigital.hackathon.domain.ParkingData;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVDocumentService {

    public List<ParkingData> getdata() throws FileNotFoundException {

            return new CsvToBeanBuilder(new FileReader("src/main/resources/ParkingData.csv"))
                    .withType(ParkingData.class)
                    .build()
                    .parse();

    }

}
