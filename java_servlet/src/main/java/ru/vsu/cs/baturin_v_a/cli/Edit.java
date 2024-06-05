package ru.vsu.cs.baturin_v_a.cli;

import ru.vsu.cs.baturin_v_a.model.Product;
import ru.vsu.cs.baturin_v_a.service.ProductServiceImpl;

import java.util.Scanner;

public class Edit implements Command{
    private Scanner scanner = new Scanner(System.in);
    private ProductServiceImpl productService;

    public Edit() {
        productService = ProductServiceImpl.getInstance();
    }

    public void setParameters() {
        System.out.print("Enter product article for editing: ");
        int editArticle = scanner.nextInt();
        scanner.nextLine();
        Product editProduct = productService.getProductByArticle(editArticle);
        if (editProduct != null) {
            System.out.print("Enter new product name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new product page count: ");
            int pageCount = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new product price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter new product quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine();
            editProduct.setName(newName);
            editProduct.setPageCount(pageCount);
            editProduct.setPrice(newPrice);
            editProduct.setQuantity(newQuantity);
            productService.updateProduct(editProduct);
            System.out.println("Product successfully edited.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void execute() {
        setParameters();
    }

    public String getCommandName() {
        return "Edit Product";
    }
}
