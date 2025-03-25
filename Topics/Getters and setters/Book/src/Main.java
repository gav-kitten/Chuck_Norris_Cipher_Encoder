class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String[] getAuthors() {
        String[] authors = new String[this.authors.length];

        System.arraycopy(this.authors, 0, authors, 0, this.authors.length);

        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = new String[authors.length];

        System.arraycopy(authors, 0, this.authors, 0, authors.length);
    }
}