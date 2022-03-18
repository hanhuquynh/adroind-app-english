package com.example.englishvocabulary.domains;

public class Vocabulary {
    private String id;
    private String word;
    private String type;
    private String pronounce;
    private String meaning;

    public Vocabulary(String id, String word, String type, String pronounce, String meaning) {
        this.id = id;
        this.word = word;
        this.type = type;
        this.pronounce = pronounce;
        this.meaning = meaning;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
