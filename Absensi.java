public class Absensi {
    private String idAbsensi;
    private String tanggalAbsen;
    private String status;

    public Absensi(String idAbsensi, String tanggalAbsen, String status) {
        this.idAbsensi = idAbsensi; 
        setTanggalAbsen(tanggalAbsen);
        setStatus(status);
    }

    // Getter
    public String getIdAbsensi() { return idAbsensi; }
    public String getTanggalAbsen() { return tanggalAbsen; }
    public String getStatus() { return status; }

    // Setter
    public void setTanggalAbsen(String tanggalAbsen) {
        if (tanggalAbsen != null && !tanggalAbsen.trim().isEmpty()) {
            this.tanggalAbsen = tanggalAbsen;
        } else {
            System.out.println("Tanggal absen tidak boleh kosong.");
            this.tanggalAbsen = "-";
        }
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status;
        } else {
            System.out.println("Status tidak boleh kosong.");
            this.status = "-";
        }
    }

    public void tampilkanAbsensi() {
        System.out.println("        ID Absensi      : " + idAbsensi);
        System.out.println("        Tanggal Absen   : " + tanggalAbsen);
        System.out.println("        Status Absen    : " + status);
    }
}