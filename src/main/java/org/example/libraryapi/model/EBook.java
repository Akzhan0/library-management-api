package org.example.libraryapi.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EBOOK")
public class EBook extends Book {

    private String downloadUrl;
    private Double fileSizeMb;

    public String getDownloadUrl() { return downloadUrl; }
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }

    public Double getFileSizeMb() { return fileSizeMb; }
    public void setFileSizeMb(Double fileSizeMb) { this.fileSizeMb = fileSizeMb; }
}
