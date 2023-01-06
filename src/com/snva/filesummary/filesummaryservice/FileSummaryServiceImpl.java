package com.snva.filesummary.filesummaryservice;

import com.snva.filesummary.bean.CallSummary;
import com.snva.filesummary.utils.ReadUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileSummaryServiceImpl implements IFileSummaryService{

    ReadUtil readUtil;

    public FileSummaryServiceImpl() {
        readUtil = new ReadUtil();
    }

    @Override
    public List<CallSummary> getCallSummary(String filePath) {

        List<CallSummary> callSummaries = new ArrayList<>();

        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            allLines.forEach(x->{
                if (isValid(x)) {
                    String cols [] = x.split("\\s+");
                    CallSummary callSummary = new CallSummary();
                    if (cols.length==8) {
                        callSummary.setSrNo(cols[0]);
                        callSummary.setExt(cols[1]);
                        callSummary.setJun(cols[2]);
                        callSummary.setDirectoryNo(cols[3]);
                        callSummary.setDate(cols[4]);
                        callSummary.setTime(cols[5]);
                        callSummary.setDuration(cols[6]);
                        callSummary.setBillAmt(cols[7]);
                        callSummaries.add(callSummary);
                    }
                }
            });
        } catch (Exception e) {
            return null;
        }

        return callSummaries;
    }

    @Override
    public String saveToFile(List<CallSummary> processFile) {
        StringBuffer stringBuffer= new StringBuffer();
        String savePath = readUtil.readString("Please enter the path where you want to save ","error");
        File file = new File(savePath);
        if (file.isDirectory()){
            processFile.forEach(x->{
                stringBuffer.append(x.toString());
            });

            try{
                Files.write(Paths.get(file.getAbsolutePath()+"\\"+ LocalDate.now()),stringBuffer.toString().getBytes() );
            }catch (Exception e){
                return "The file was not saved due to "+e.getMessage();
            }
        }

        return "The output file is saved at "+file.getAbsolutePath();
    }

    private boolean isValid(String line) {
        try{
            Integer.parseInt(line.split("\\s+")[0]);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
