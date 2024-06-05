package ru.vsu.cs.baturin_v_a.cli;

import ru.vsu.cs.baturin_v_a.model.Product;
import ru.vsu.cs.baturin_v_a.service.ProductServiceImpl;

import java.util.Scanner;

public class Add implements Command {
    private Scanner scn = new Scanner(System.in);
    private ProductServiceImpl productService;

    public Add() {
        productService = ProductServiceImpl.getInstance();
    }

    private Product setParameters() {
        System.out.print("Enter product article: ");
        int article = Integer.parseInt(scn.nextLine());
        System.out.print("Enter product name: ");
        String name = scn.nextLine();
        System.out.print("Enter product page count: ");
        int pageCount = scn.nextInt();
        System.out.print("Enter product price: ");
        double price = scn.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scn.nextInt();
        scn.nextLine();

        return new Product(article, name, pageCount, price, quantity);
    }

    public void execute() {
        productService.addProduct(setParameters());
    }

    public String getCommandName() {
        return "Add Product";
    }
}
