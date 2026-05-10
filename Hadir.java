public class Hadir extends Absensi {
    private int jamDatang;
    private int jamPulang;

    public Hadir(String idAbsensi, String tanggalAbsen, String status, int jamDatang, int jamPulang) {
        super(idAbsensi, tanggalAbsen, status);
        setJamDatang(jamDatang);
        setJamPulang(jamPulang);
    }

    public int getJamDatang() { return jamDatang; }
    public int getJamPulang() { return jamPulang; }

    public void setJamDatang(int jamDatang) {
        if (jamDatang >= 0 && jamDatang <= 24) {
            this.jamDatang = jamDatang;
        } else {
            System.out.println("Jam datang tidak valid.");
            this.jamDatang = 0;
        }
    }

    public void setJamPulang(int jamPulang) {
        if (jamPulang >= jamDatang && (jamPulang - jamDatang) <= 12) {
            this.jamPulang = jamPulang;
        } else {
            System.out.println("Jam pulang tidak valid.");
            this.jamPulang = jamDatang; 
        }
    }

    private boolean validasiJamKerja() {
        int total = jamPulang - jamDatang;
        return total <= 12 && total >= 0;
    }

    public int hitungJamKerja() {
        return validasiJamKerja() ? (jamPulang - jamDatang) : 0;
    }

    @Override
    public void tampilkanAbsensi() {
        System.out.println("\n      { --- Absensi Hadir --- }");
        super.tampilkanAbsensi();
        System.out.println("        Jam Datang      : " + jamDatang);
        System.out.println("        Jam Pulang      : " + jamPulang);
        System.out.println("        Total Jam Kerja : " + hitungJamKerja() + " jam");
    }
}