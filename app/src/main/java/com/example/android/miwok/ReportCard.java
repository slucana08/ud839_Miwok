package com.example.android.miwok;

public class ReportCard {
    private String fullName;
    private int chemistryGrade;
    private int englishGrade;
    private int biologyGrade;
    private int mathGrade;
    private int historyGrade;
    private int geographyGrade;

    public ReportCard (String fullName){
        fullName = fullName;
        chemistryGrade = 0;
        englishGrade = 0;
        biologyGrade = 0;
        mathGrade = 0;
        historyGrade = 0;
        geographyGrade = 0;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName;}
    public int getChemistryGrade(){ return chemistryGrade; }
    public void setChemistryGrade(int chemistryGrade) { this.chemistryGrade = chemistryGrade; }
    public int getEnglishGrade(){ return englishGrade; }
    public void setEnglishGrade(int englishGrade) { this.englishGrade = englishGrade; }
    public int getBiologyGrade(){ return biologyGrade; }
    public void setBiologyGrade(int biologyGrade){ this.biologyGrade = biologyGrade; }
    public int getMathGrade(){ return mathGrade; }
    public void setMathGrade(int mathGrade){ this.mathGrade = mathGrade; }
    public int getHistoryGrade(){ return historyGrade; }
    public void setHistoryGrade(int historyGrade) { this.historyGrade = historyGrade; }
    public int getGeographyGrade(){ return geographyGrade; }
    public void setGeographyGrade(int geographyGrade){ this.geographyGrade = geographyGrade; }

    @Override
    public String toString() {
        String report = "Name: " + fullName;
        report += "\nYour grades are: ";
        report += "\nChemistry: " + chemistryGrade;
        report += "\nEnglish: " + englishGrade;
        report += "\nBiology: " + biologyGrade;
        report += "\nMath: " + mathGrade;
        report += "\nHistory: " + historyGrade;
        report += "\nGeography: " + geographyGrade;
        return report;
    }
}
