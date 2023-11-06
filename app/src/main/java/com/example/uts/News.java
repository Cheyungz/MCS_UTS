package com.example.uts;

public class News {
    private String newsTitle;
    private String newsContent;
    private String newsDescription;
    private int image;

    public News(String newsTitle, String newsContent, String newsDescription, int image) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsDescription = newsDescription;
        this.image = image;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
