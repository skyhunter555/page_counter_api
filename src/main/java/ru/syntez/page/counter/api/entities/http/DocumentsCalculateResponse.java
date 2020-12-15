package ru.syntez.page.counter.api.entities.http;

public class DocumentsCalculateResponse {
    private Integer documents;
    private Integer pages;

    public DocumentsCalculateResponse(Integer documents, Integer pages) {
        this.documents = documents;
        this.pages = pages;
    }

    public Integer getDocuments() {
        return documents;
    }

    public void setDocuments(Integer documents) {
        this.documents = documents;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
