package com.metaship.dto.photo;

public class Photo {
    private String s;
    private String m;
    private String original;

    public String getOriginal() {
        return original;
    }
    public void setOriginal(String original) {
        this.original = original;
    }

    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }

    public String getM() {
        return m;
    }
    public void setM(String m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "s='" + s + '\'' +
                ", m='" + m + '\'' +
                ", original='" + original + '\'' +
                '}';
    }
}
