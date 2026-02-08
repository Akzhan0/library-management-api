package org.example.libraryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class BookRequest {

    @NotBlank(message = "title is required")
    @Size(max = 150, message = "title must be <= 150 chars")
    private String title;

    @NotBlank(message = "author is required")
    @Size(max = 120, message = "author must be <= 120 chars")
    private String author;

    @Size(max = 30, message = "isbn must be <= 30 chars")
    private String isbn;

    public BookRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    private String type; 


    private String downloadUrl;
    private Double fileSizeMb;

 
    private Integer pages;
    private String coverType;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDownloadUrl() { return downloadUrl; }
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }

    public Double getFileSizeMb() { return fileSizeMb; }
    public void setFileSizeMb(Double fileSizeMb) { this.fileSizeMb = fileSizeMb; }

    public Integer getPages() { return pages; }
    public void setPages(Integer pages) { this.pages = pages; }

    public String getCoverType() { return coverType; }
    public void setCoverType(String coverType) { this.coverType = coverType; }


}

