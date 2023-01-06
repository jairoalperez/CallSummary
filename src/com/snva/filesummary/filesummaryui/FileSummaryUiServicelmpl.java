package com.snva.filesummary.filesummaryui;

import com.snva.filesummary.bean.CallSummary;
import com.snva.filesummary.filesummaryservice.FileSummaryServiceImpl;
import com.snva.filesummary.filesummaryservice.IFileSummaryService;
import com.snva.filesummary.utils.ReadUtil;

import java.io.File;
import java.util.List;

public class FileSummaryUiServicelmpl implements IFileSummaryUiService{

    private ReadUtil readUtil;
    private IFileSummaryService iFileSummaryService;

    public FileSummaryUiServicelmpl() {
        readUtil = new ReadUtil();
        iFileSummaryService = new FileSummaryServiceImpl();
    }

    @Override
    public void processFile() {
        String filePath = readUtil.readString("Enter a file path", "Error");

        File file = new File(filePath);

        if( file.exists()) {
           List<CallSummary> callSummaries = iFileSummaryService.getCallSummary(filePath);
           callSummaries.forEach(x->{
               System.out.println(x);
           });
            String savePath=iFileSummaryService.saveToFile(callSummaries);
            System.out.println("The file was created at  "+savePath);
        }else{
            System.out.println("The path "+filePath+" doeas not exist");
        }

    }
}
