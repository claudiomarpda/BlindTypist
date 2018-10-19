package com.blind.typist.dictionary;

public class Word {

    private String name;
    private String classification;
    private String singularPlural;
    private String gender;

    public Word(String name, String classification, String singularPlural, String gender) {
        this.name = name;
        this.classification = classification;
        this.singularPlural = singularPlural;
        this.gender = gender;
    }

    public Word(String name, String classification, String singularPlural) {
        this.name = name;
        this.classification = classification;
        this.singularPlural = singularPlural;
        this.gender = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSingularPlural() {
        return singularPlural;
    }

    public void setSingularPlural(String singularPlural) {
        this.singularPlural = singularPlural;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Word{" +
                "name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                ", singularPlural='" + singularPlural + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
