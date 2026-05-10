public class Karyawan {
    private String idKaryawan;
    private String namaKaryawan;
    private int jatahCuti;

    // Construktor
    public Karyawan(String idKaryawan, String namaKaryawan, int jatahCuti) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.jatahCuti = jatahCuti;
    }

    // Getter
    public String getIdKaryawan() { return idKaryawan; }
    public String getNamaKaryawan() { return namaKaryawan; }
    public int getJatahCuti() { return jatahCuti; }

    // Setter
    public void setNamaKaryawan(String namaKaryawan)  { 
         if (namaKaryawan != null && !namaKaryawan.trim().isEmpty()) {
            this.namaKaryawan = namaKaryawan;
        } else {
            System.out.println("Nama karyawan tidak boleh kosong.");
        }
     }

    // Method

    public void kurangiCuti() {
        if (jatahCuti > 0) {
            jatahCuti--;
        } else {
            System.out.println("Jatah cuti habis!");
        }
    }

    public void tampilkanData() {
        System.out.println("==========>> Data Karyawan <<==========");
        System.out.println("        ID Karyawan     : " + idKaryawan);
        System.out.println("        Nama Karyawan   : " + namaKaryawan);
        System.out.println("        Sisa Jatah Cuti : " + jatahCuti);
    }
}
