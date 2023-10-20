package controller;

import Repository.AnalysisStringRepository;

public class AnalysisStringProgram {

    AnalysisStringRepository program;

    public AnalysisStringProgram() {
        program = new AnalysisStringRepository();
    }

    public void run() {
        System.out.println("===== Analysis String Program ====");
        program.analysisString();
    }
}
