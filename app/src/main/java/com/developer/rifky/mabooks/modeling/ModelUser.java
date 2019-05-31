package com.developer.rifky.mabooks.modeling;

/**
 * Created by Rifky on 28-Dec-17.
 */

public class ModelUser {
    private String judul;
    private String peminjam;
    private String nohp;
    private String dipinjam;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getDipinjam() {
        return dipinjam;
    }

    public void setDipinjam(String dipinjam) {
        this.dipinjam = dipinjam;
    }
}
