package ru.vsu.cs.baturin_v_a.cli;

import ru.vsu.cs.baturin_v_a.service.SalesServiceImpl;

public class PrintSales implements Command{
    private SalesServiceImpl salesService;

    public PrintSales() {
        salesService = SalesServiceImpl.getInstance();
    }

    public void execute() {
        System.out.println(salesService.printSales());
    }

    public String getCommandName() {
        return "Print sales";
    }
}
