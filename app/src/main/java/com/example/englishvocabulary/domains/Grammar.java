package com.example.englishvocabulary.domains;

public class Grammar {
    private String id;
    private String structure;
    private String example;

    public Grammar(String id, String structure, String example) {
        this.id = id;
        this.structure = structure;
        this.example = example;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
