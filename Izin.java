public class Izin extends Absensi {
    private String alasanIzin;

    public Izin(String idAbsensi, String tanggalAbsen, String status, String alasanIzin) {
        super(idAbsensi, tanggalAbsen, status);
        setAlasanIzin(alasanIzin);
    }

    public String getAlasanIzin() { return alasanIzin; }

    public void setAlasanIzin(String alasanIzin) {
        if (alasanIzin != null && !alasanIzin.trim().isEmpty()) {
            this.alasanIzin = alasanIzin;
        } else {
            System.out.println("Alasan izin tidak boleh kosong.");
            this.alasanIzin = "-";
        }
    }

    @Override
    public void tampilkanAbsensi() {
        System.out.println("\n      { --- Absensi Izin --- }");
        super.tampilkanAbsensi();
        System.out.println("        Alasan Izin     : " + alasanIzin);
    }
}