public class Cuti extends Absensi {
    private String alasanCuti;

    public Cuti(String idAbsensi, String tanggalAbsen, String status, String alasanCuti) {
        super(idAbsensi, tanggalAbsen, status);
        setAlasanCuti(alasanCuti);
    }

    // Getter
    public String getAlasanCuti() { return alasanCuti; }

    // Setter
    public void setAlasanCuti(String alasanCuti) {
        if (alasanCuti != null && !alasanCuti.trim().isEmpty()) {
            this.alasanCuti = alasanCuti;
        } else {
            this.alasanCuti = "-";
        }
    }

    // Method
    @Override
    public void tampilkanAbsensi() {
        System.out.println("\n      { --- Absensi Cuti --- }");
        super.tampilkanAbsensi();
        System.out.println("        Alasan Cuti     : " + alasanCuti);
    }
}