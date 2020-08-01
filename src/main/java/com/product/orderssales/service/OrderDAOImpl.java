package com.product.orderssales.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.product.orderssales.domain.ProductSalesInfo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    public List<ProductSalesInfo> getAllOrders() {
        List<ProductSalesInfo> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("SalesRecords.csv"));) {
            String[] values = null;
            csvReader.readNext();
            while ((values = csvReader.readNext()) != null) {
                records.add(buildOrder(values));
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return records;
    }

    private ProductSalesInfo buildOrder(String[] values) throws ParseException {
        ProductSalesInfo productSalesInfo =
            new ProductSalesInfo
            .ProductSalesInfoBuilder(Long.parseLong(values[6]), values[2], dateFormat.parse(values[5]), dateFormat.parse(values[7]))
            .region(values[0])
            .country(values[1])
            .profit(Double.parseDouble(values[13]))
            .unitsSold(Long.parseLong(values[8]))
            .build();
        return productSalesInfo;
    }
}
