package ru.vsu.cs.baturin_v_a.cli;

import ru.vsu.cs.baturin_v_a.service.ProductServiceImpl;

public class PrintInv implements Command{
    private ProductServiceImpl productService;

    public PrintInv() {
        productService = ProductServiceImpl.getInstance();
    }

    public void execute() {
        System.out.println(productService.printAllProducts());
    }

    public String getCommandName() {
        return "Print inventory";
    }
}
