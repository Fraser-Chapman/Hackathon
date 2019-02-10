package com.manchesterdigital.hackathon.repository;

import com.manchesterdigital.hackathon.domain.ParkingData;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

@Service
public class CSVDocumentService {

    public List<ParkingData> getCarParkData() {

        try {
            return new CsvToBeanBuilder(new FileReader("src/main/resources/ParkingData.csv"))
                    .withType(ParkingData.class)
                    .build()
                    .parse();

        }catch (FileNotFoundException fileNotFound) {
            System.out.println(fileNotFound);
            return Collections.emptyList();
        }
    }
}
