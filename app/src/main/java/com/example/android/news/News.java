package com.example.android.news;

/**
 * An {@link News} object contains information related to a single news.
 */
public class News {

    // PillarName of the news
    private String mPillar;
    // Title of the news
    private String mTitle;
    // Time of the news
    private String mTime;
    // Website URL of the news
    private String mUrl;
    //Author of the article
    private String mAuthor;

    /**
     * Constructs a new {@link News} object.
     *
     * @param pillarName         is the pillar name of the news
     * @param title              is the title of the news
     * @param time               is the time when the news appeared
     * @param url                is the website URL to find more details about the news
     * @param author             is the author of the article
     */

        public News(String pillarName, String title, String time, String url, String author) {
        mPillar = pillarName;
        mTitle = title;
        mTime = time;
        mUrl = url;
        mAuthor = author;
    }

    // Returns the pillar of the news.
    public String getPillar() {
        return mPillar;
    }

    // Returns the title of the news.
    public String getTitle() {
        return mTitle;
    }

    // Returns the time when the news appeared.
    public String getTime() {
        return mTime;
    }

    // Returns the website URL to find more information about the new.
    public String getUrl() {
        return mUrl;
    }

    // Returns the author of the article
    public String getAuthor() {
        return mAuthor;
    }

}
