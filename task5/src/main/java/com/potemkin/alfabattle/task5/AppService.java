package com.potemkin.alfabattle.task5;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.potemkin.alfabattle.task5.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Service
@Slf4j
public class AppService {

    private Map<String, Item> items = new ConcurrentHashMap<>();
    private Map<Integer, Discount> discountsMap = new ConcurrentHashMap<>();

    public void updateDiscounts(List<Discount> discounts) {
        discountsMap.clear();
        discounts.forEach(discount -> discountsMap.put(discount.getShopId(), discount));
    }


    public ResponseReceipt calculateReceipt(RequestReceipt requestReceipt) {
        int shopId = requestReceipt.getShopId();
        boolean hasGlobal = requestReceipt.isLoyaltyCard() && discountsMap.containsKey(-1);
        boolean hasDiscount = requestReceipt.isLoyaltyCard() && discountsMap.containsKey(shopId);
        log.info("calculateReceipt");
        List<ResponsePosition> positions = new ArrayList<>();
        Stream.of(requestReceipt.getPositions()).forEach(position -> {
            Item item = items.get(position.getItemId());
            positions.addAll(LongStream.range(0, position.getQuantity()).mapToObj(i -> {
                BigDecimal globalDiscount = hasGlobal ? new BigDecimal(discountsMap.get(-1).getDiscount()) : BigDecimal.ZERO;
                BigDecimal discount = hasDiscount ? new BigDecimal(discountsMap.get(shopId).getDiscount()) : BigDecimal.ZERO;
                BigDecimal resultDiscount = discount.compareTo(globalDiscount) > 0 ? discount : globalDiscount;
                BigDecimal price = item.getPrice().subtract(item.getPrice().multiply(resultDiscount));
                return new ResponsePosition(item.getId(), item.getName(), price, item.getPrice());
            })
                    .collect(Collectors.toList()));
        });
        BigDecimal total = positions.stream().map(ResponsePosition::getPrice).reduce(new BigDecimal(0), BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal regularPrice = positions.stream().map(ResponsePosition::getRegularPrice).reduce(new BigDecimal(0), BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal discount = regularPrice.subtract(total).setScale(2, RoundingMode.HALF_EVEN);
        return new ResponseReceipt(total, discount, positions);
    }

    @PostConstruct
    void loadSCV() {
        log.info("start read");
        try {
            try (CSVReader csvReader = new CSVReader(new FileReader("items.csv"))) {
                log.info("scv has been found");
                String[] values = csvReader.readNext();
                while ((values = csvReader.readNext()) != null) {
                    try {
                        String id = values[0];
                        String name = values[1];
                        String groupId = values[2];
                        BigDecimal price = new BigDecimal(values[3]);
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
