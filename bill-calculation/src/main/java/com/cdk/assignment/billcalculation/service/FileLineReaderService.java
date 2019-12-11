package com.cdk.assignment.billcalculation.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cdk.assignment.billcalculation.BillCalculationApplication;


public class FileLineReaderService {
    private final String fileDir;


    public FileLineReaderService(String fileDir) {
        this.fileDir = fileDir;
        
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(getFileInputStream());
        scanner.useDelimiter("\r?\n");
        while (scanner.hasNext()) {
            lines.add(scanner.next());
        }
       
        return lines;
    }

    private InputStream getFileInputStream() {
        
           ClassLoader classLoader = BillCalculationApplication.class.getClassLoader();
           return classLoader.getResourceAsStream(fileDir);
      
    }
}
