package org.example.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrinterFactory {
    @Bean("epson")
    public Printer getEpson() {
        return new EpsonPrinter();
    }

    @Bean("hp")
    public Printer getHP() {
        return new HPPrinter();
    }
}
