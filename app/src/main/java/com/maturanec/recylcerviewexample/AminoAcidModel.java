package com.maturanec.recylcerviewexample;

public class AminoAcidModel {

    String aminoAcidName;
    String aminoAcidAbbreviation;
    String aminoAcidAbbreviationSmall;
    int image;

    public AminoAcidModel(String aminoAcidName, String aminoAcidAbbreviation, String aminoAcidAbbreivationSmall, int image) {
        this.aminoAcidName = aminoAcidName;
        this.aminoAcidAbbreviation = aminoAcidAbbreviation;
        this.aminoAcidAbbreviationSmall = aminoAcidAbbreivationSmall;
        this.image = image;
    }

    public String getAminoAcidName() {
        return aminoAcidName;
    }

    public String getAminoAcidAbbreviation() {
        return aminoAcidAbbreviation;
    }


    public int getImage() {
        return image;
    }

    public String getAminoAcidAbbreviationSmall() {
        return aminoAcidAbbreviationSmall;
    }
}
