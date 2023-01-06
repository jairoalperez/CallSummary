package com.snva.filesummary.filesummaryservice;

import com.snva.filesummary.bean.CallSummary;

import java.util.List;

public interface IFileSummaryService {

    List<CallSummary> getCallSummary(String filePath);

    String saveToFile(List<CallSummary> processFile);
}
