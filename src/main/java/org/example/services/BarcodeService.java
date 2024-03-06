package org.example.services;



import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BarcodeService {
    private String code;
    private LocalDate createDate;
    private int id;
    public void SimpleObject(int id){
        this.code = String.valueOf(String.valueOf(id).hashCode());
        this.id = id;
        this.createDate = LocalDate.now();
    }
    // Getters
    public String getBarcode(int id ) {
        this.code = String.valueOf(String.valueOf(id).hashCode());
        if (id > 120){
            throw new ArithmeticException("Fake Error");
        }
        return this.code;
    }
    public LocalDate getCreateDate() {
        return createDate;
    }
    public int getId() {
        return id;
    }
}
