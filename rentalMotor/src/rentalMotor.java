import java.util.Scanner;

public class rentalMotor {

        public static void watermark() {

            System.out.println("Kelompok 12");
            System.out.println("Shift 2");
            System.out.println("Program Rental Motor");
            System.out.println("Anggota :");
            System.out.println("Putri Mazro'aturrosyada (21120125120045)");
            System.out.println("Isytia Khoironnida Tahara (21120125120046)");
            System.out.println("Arbi Anugerah Dinata (21120125120047)");
            System.out.println("Panji Bagas Respati (21120125120048)\n");

        }

        public static String sambutan() {
            return "Selamat Datang di 12SHOWROOM\nSilahkan masukkan data diri, dan motor yang akan Anda sewa";
        }

        public static int hitungTotal(String motor, int hari, boolean member) {
            int hargaPerHari;

            if (motor.equalsIgnoreCase("Vario")) {
                hargaPerHari = 80000;
            } else if (motor.equalsIgnoreCase("NMAX")) {
                hargaPerHari = 120000;
            } else if (motor.equalsIgnoreCase("Beat")) {
                hargaPerHari = 70000;
            } else if (motor.equalsIgnoreCase("PCX")) {
                hargaPerHari = 130000;
            } else {
                hargaPerHari = 0;
            }

            int total = hargaPerHari * hari;

            // Diskon untuk member
            if (member) {
                total -= total * 0.1;
            }

            return total;
        }

        public void tampilkanNota(String nama, String motor, int hari, boolean member, int total) {
            System.out.println("\n===== NOTA SEWA =====");
            System.out.println("Nama : " + nama);
            System.out.println("Motor : " + motor);
            System.out.println("Durasi : " + hari + " hari");

            int hargaPerHari = 0;
            if (motor.equalsIgnoreCase("Vario")) hargaPerHari = 80000;
            else if (motor.equalsIgnoreCase("NMAX")) hargaPerHari = 120000;
            else if (motor.equalsIgnoreCase("Beat")) hargaPerHari = 70000;
            else if (motor.equalsIgnoreCase("PCX")) hargaPerHari = 130000;

            System.out.println("Harga per hari : Rp" + hargaPerHari);
            System.out.println("Status member : " + (member ? "Ya (Diskon 10%)" : "Tidak"));
            System.out.println("Total bayar : Rp. " + total);
        }

        public void ucapanTerimaKasih() {
            System.out.println("\nTerima kasih telah menyewa di 12SHOWROOM!");
            System.out.println("Semoga perjalananmu menyenangkan! 🏍️");
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            rentalMotor showroom = new rentalMotor();

            watermark();
            System.out.println(sambutan());

            String lagi;
            do {
                System.out.print("\nMasukkan nama Anda : ");
                String nama = input.nextLine();

                System.out.print("Pilih motor (Vario/NMAX/Beat/PCX) : ");
                String motor = input.nextLine();

                System.out.print("Lama sewa (hari) : ");
                int hari = input.nextInt();
                input.nextLine();

                System.out.print("Apakah Anda member? (ya/tidak) : ");
                String status = input.nextLine();
                boolean member = status.equalsIgnoreCase("ya");

                int total = hitungTotal(motor, hari, member);

                if (total > 0) {
                    showroom.tampilkanNota(nama, motor, hari, member, total);
                } else {
                    System.out.println("\nMaaf, jenis motor yang Anda pilih tidak tersedia di 12SHOWROOM.");
                }

                System.out.print("\nIngin menyewa motor lain? (ya/tidak) : ");
                lagi = input.nextLine();

            } while (lagi.equalsIgnoreCase("ya"));

            showroom.ucapanTerimaKasih();
            input.close();
        }
    }

