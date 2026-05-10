import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Absensi> dataAbsensi = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int noAbsen = 1;
    static Karyawan k1;

    public static void main(String[] args) {
        prosesLogin();

        k1 = new Karyawan("K001", "Mayday", 3);

        System.out.println();
        k1.tampilkanData();

        menuAbsensi();

        input.close();
    }

    public static void prosesLogin() {
        while (true) {
            System.out.println("<======== Login Sistem Absensi =======>\n");

            System.out.print("      Masukan Username : ");
            String username = input.nextLine();

            System.out.print("      Masukan Password : ");
            String password = input.nextLine();

            Login login = new Login(username, password);

            if (login.login()) {
                System.out.println("\n          Login Berhasil!!");
                System.out.println("<------------------------------------->");
                break;
            } else {
                System.out.println("\n      Login gagal! Coba lagi..");
                System.out.println("<------------------------------------->");
            }
        }
    }

    public static void menuAbsensi() {
        int pilihan;

        do {
            System.out.println("\n  <<======= Menu Absensi =======>>");
            System.out.println("         1. Input Absensi");
            System.out.println("         2. Lihat Semua Absensi");
            System.out.println("         0. Keluar");
            System.out.print("         Pilih : ");
            pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1:
                    inputAbsensi();
                    break;
                case 2:
                    tampilkanSemua();
                    break;
                case 0:
                    System.out.println("\nKeluar...");
                    break;
                default:
                    System.out.println("\n       Pilihan tidak valid!!");
            }

        } while (pilihan != 0);
    }

    public static void inputAbsensi() {
        System.out.println("\n>>>>>>>>>> LAKUKAN ABSENSI <<<<<<<<<<");
        System.out.println("     < --- Jenis Absensi --- >");
        System.out.println("            1. Hadir");
        System.out.println("            2. Izin");
        System.out.println("            3. Cuti");
        System.out.print("          Pilih jenis : ");
        int jenis = input.nextInt();
        input.nextLine();

        System.out.println();

        if (jenis < 1 || jenis > 3) {
            System.out.println(">> Jenis tidak valid!! Pilih antara 1-3..");
            return;
        }
        
        String idAbsen = "AK00" + noAbsen;
        noAbsen++;
        System.out.print("      ID Absensi : " + idAbsen);
                
        System.out.print("\n      Tanggal    : ");
        String tanggal = input.nextLine();

        if (jenis == 1) {
            int jamDatang, jamPulang;

            while ( true ) {
                System.out.print("      Jam Datang : ");
                jamDatang = input.nextInt();

                System.out.print("      Jam Pulang : ");
                jamPulang = input.nextInt();
                input.nextLine();

                int total = jamPulang - jamDatang;

                if ( jamDatang >= 0 && jamDatang <= 24 && jamPulang >= 0 && jamPulang <= 24 && total >= 0 && total <= 12 ) {
                    break;
                } else {
                    System.out.println("\n>> Jam kerja tidak valid! Tidak boleh '>' 12 jam!!");
                    System.out.println(">> Silakan input ulang!!\n");
                }

            }

            Hadir hadir = new Hadir(idAbsen, tanggal, "Hadir", jamDatang, jamPulang);
            dataAbsensi.add(hadir);

        } else if (jenis == 2) {
            System.out.print("      Alasan Izin : ");
            String alasan = input.nextLine();

            Izin izin = new Izin(idAbsen, tanggal, "Izin", alasan);
            dataAbsensi.add(izin);

        } else if (jenis == 3) {
            if (k1.getJatahCuti() > 0) {
                System.out.print("      Alasan Cuti : ");
                String alasan = input.nextLine();

                Cuti cuti = new Cuti(idAbsen, tanggal, "Cuti", alasan);
                dataAbsensi.add(cuti);

                k1.kurangiCuti(); 

                System.out.println("\n   Cuti berhasil! Sisa cuti: " + k1.getJatahCuti());
            } else {
                System.out.println("Cuti ditolak! Jatah cuti habis.");
            }

        }

        System.out.println("\n>>>>>>>>>> ABSENSI BERAKHIR <<<<<<<<<<");
        
    }

    public static void tampilkanSemua() {
        if (dataAbsensi.isEmpty()) {
            System.out.println("\n   <-- Belum ada data Absensi -->");
            return;
        }

        System.out.println("\n||========= Data Absensi =========||");

        for (Absensi i : dataAbsensi) {
            i.tampilkanAbsensi(); 
            System.out.println("      <---------------------->");
        }
    }
}