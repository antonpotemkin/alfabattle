package com.potemkin.alfabattle.task5;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.potemkin.alfabattle.task5.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class AppService {

    private Map<Integer, Item> items = new ConcurrentHashMap<>();

    @PostConstruct
    void loadSCV() {
        log.info("start read");
        try {
            try (CSVReader csvReader = new CSVReader(new FileReader("items.csv"))) {
                log.info("scv has been found");
                String[] values = csvReader.readNext();
                while ((values = csvReader.readNext()) != null) {
                    try {
                        int id = Integer.parseInt(values[0]);
                        String name = values[1];
                        String groupId = values[2];
                        double price = Double.parseDouble(values[3]);
                        items.put(id, new Item(id, name, groupId, price));
                    } catch (NumberFormatException e) {
                        log.warn("error while parse {}", e.getMessage());
                    }

                }
            }
            log.info("items count {}", items.size());

        } catch (IOException | CsvValidationException e) {
            log.error("error ", e);
        }
    }
}
