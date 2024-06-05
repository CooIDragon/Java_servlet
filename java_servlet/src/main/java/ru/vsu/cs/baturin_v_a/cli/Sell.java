package ru.vsu.cs.baturin_v_a.cli;

import ru.vsu.cs.baturin_v_a.model.Product;
import ru.vsu.cs.baturin_v_a.model.Sales;
import ru.vsu.cs.baturin_v_a.service.ProductServiceImpl;
import ru.vsu.cs.baturin_v_a.service.SalesServiceImpl;

import java.util.Scanner;

public class Sell implements Command{
    private Scanner scanner = new Scanner(System.in);
    private SalesServiceImpl salesService;
    private ProductServiceImpl productService;

    public Sell() {
        salesService = SalesServiceImpl.getInstance();
        productService = ProductServiceImpl.getInstance();
    }

    private Sales setParameters() {
        System.out.print("Enter product article for sale: ");
        int saleArticle = scanner.nextInt();
        System.out.print("Enter quantity for sale: ");
        int saleQuantity = scanner.nextInt();
        scanner.nextLine();
        Product saleProduct = productService.getProductByArticle(saleArticle);
        Sales sale = null;
        if (saleProduct != null && saleProduct.getQuantity() >= saleQuantity) {
            sale = new Sales(saleProduct, saleQuantity);
            salesService.addSale(sale);
            System.out.println("Sale completed successfully.");
        } else {
            System.out.println("Product not found or not enough in stock.");
        }
        return sale;
    }

    public void execute() {
        setParameters();
    }

    public String getCommandName() {
        return "Sell Product";
    }
}
