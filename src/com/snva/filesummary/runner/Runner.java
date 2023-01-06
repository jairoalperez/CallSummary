package com.snva.filesummary.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.snva.filesummary.filesummaryui.FileSummaryUiServicelmpl;
import com.snva.filesummary.filesummaryui.IFileSummaryUiService;
import com.snva.filesummary.utils.ReadUtil;

public class Runner {

    private ReadUtil m_readUtil;
    private IFileSummaryUiService m_FileSummaryUiService;

    public Runner() throws IOException {
        m_readUtil = new ReadUtil();
        m_FileSummaryUiService = new FileSummaryUiServicelmpl();
        checkUserOptions();
    }

    private void checkUserOptions() throws IOException {
        int choice = 0;
        do {
            displayMainMenu();
            choice=m_readUtil.readInt("Input Your choice","Input valid Choice");
            switch(choice) {
                case 1 : System.out.println("caso 1");
                    break;

                case 2 : System.out.println("caso 2");
                    break;

                case 3 : System.out.println("caso 3");
                    break;

                case 4 : System.out.println("caso 4");
                    break;

                case 5 : System.out.println("caso 5");
                    break;

                case 6 : m_FileSummaryUiService.processFile();
                    break;

                default: System.out.println("Wrong Choice");
                    break;
            }
        } while (choice!=6);
    }

    private void displayMainMenu()
    {
        System.out.println("     Main Menu     ");
        System.out.println("-------------------");
        System.out.println("1. Add New Employee ");
        System.out.println("2. Remove An Employee ");
        System.out.println("3. Show All Employees Information ");
        System.out.println("4. Search An Employee ");
        System.out.println("5. Sort By First Name ");
        System.out.println("6. Read a Files & Clean it");
        System.out.println("7. Exit ");
    }

    public static void main(String[] args) throws IOException {
        new Runner();
    }
}
