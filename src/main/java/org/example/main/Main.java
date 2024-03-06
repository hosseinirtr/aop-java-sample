package org.example.main;

import org.example.config.ProjectConfig;
import org.example.services.BarcodeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            BarcodeService  service = c.getBean(BarcodeService.class);
            String result = service.getBarcode(10);

            System.out.print("\nresult"+ result);
        }
    }
}