package id.ac.binus.session12.model;

public class Mahasiswa {
    private String nim;
    private String name;
    private String email;
    private String phone;
    private String alamat;

    public Mahasiswa(String nim, String name, String email, String phone, String alamat) {
        this.nim = nim;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.alamat = alamat;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
