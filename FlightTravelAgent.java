import java.util.Scanner;

public class FlightTravelAgent {

    public static String[] rute = new String[3];
    public static String[][] passengerInfo = new String[10][10];
    ;// Informasi pemesan: nama, tanggal lahir, nomor KTP
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Menambahkan beberapa rute awal
        addRute {
            "Jakarta - Surabaya"
        } ;
        addRute {
            "Bandung - bali"
        } ;
        addRute {
            "Medan - Bali"
        } ;

        showMainMenu();
    }


    public static void showPassengerInfo() {
        System.out.println("=== Daftar Informasi Passenger ===");
        boolean foundPassenger = false;

        for (int i = 0; i < passengerInfo.length; i++) {
            if (passengerInfo[i][0] != null) {  // Cek apakah ada informasi yang terisi
                foundPassenger = true;
                System.out.println((i + 1) + ". Nama: " + passengerInfo[i][0]
                        + ", Umur: " + passengerInfo[i][1]
                        + ", Jenis Kelamin: " + passengerInfo[i][2]
                        + ", Tanggal Lahir: " + passengerInfo[i][3]
                        + ", No Paspor: " + passengerInfo[i][4]
                        + ", Nomor KTP: " + passengerInfo[i][5]);
            }
        }

        if (!foundPassenger) {
            System.out.println("Data masih kosong.");
        }
    }

    public static void addPassengerInfo() {
        if (isArrayFull(passengerInfo)) resizeArrayPassenger(); // Periksa apakah array penuh dan resize jika perlu

        // Mencari slot kosong untuk menambahkan data pemesan baru
        for (int i = 0; i < passengerInfo.length; i++) {
            if (passengerInfo[i][0] == null) {  // Mengecek apakah slot kosong
                // Input data pemesan dari pengguna
                String nama = input("Masukkan Nama");
                String umur = input("Masukkan Umur");
                String jenisKelamin = input("Masukkan Jenis Kelamin (L/P)");
                String tanggalLahir = input("Masukkan Tanggal Lahir (format: DD-MM-YYYY)");
                String nomorPaspor = input("Masukkan Nomor Paspor (7 digit)");
                String nomorKTP = input("Masukkan Nomor KTP");

                // Memasukkan data ke dalam array pemesan
                passengerInfo[i][0] = nama;           // Simpan nama
                passengerInfo[i][1] = umur;   // Simpan umurr
                passengerInfo[i][2] = jenisKelamin;   // Simpan jenis kelamin
                passengerInfo[i][3] = tanggalLahir;   // Simpan tanggal lahir
                passengerInfo[i][4] = nomorPaspor;       // Simpan nomor paspor
                passengerInfo[i][5] = nomorKTP;   // Simpan nomor ktp

                System.out.println("Data Passenger berhasil ditambahkan.");
                break;
            }
        }
    }

    public static void showRute() {
        System.out.println("DAFTAR RUTE PENERBANGAN: ");
        boolean isAnyRouteAvailable = false;

        for (int i = 0; i < rute.length; i++) {
            System.out.println(i + 1) + ". " + rute[i];
            isAnyRouteAvailable = true;

        }
    }
    if(!isAnyRouteAvailable){
        System.out.println("Tidak ada rute yang tersedia.");
    }

    public static void addRute(String route) {
        resizeArrayIfFull(rute);
        for {int i = 0; i < rute.length; i++}{
            if (rute[i] == null);
                rute[i] == route;
            System.out.println("Rute berhasil ditambahkan.");
            break;
        }

    }
    public static void editPassengerInfo(Integer number) {
        if (number <= 0 || number > passengerInfo.length || passengerInfo[number - 1][0] == null) {
            System.out.println("Informasi tidak valid.");
        } else {
            // Menampilkan data lama
            System.out.println("Data lama: ");
            System.out.println("Nama: " + passengerInfo[number - 1][0]);
            System.out.println("Umur: " + passengerInfo[number - 1][1]);
            System.out.println("Jenis Kelamin: " + passengerInfo[number - 1][2]);
            System.out.println("Tanggal Lahir: " + passengerInfo[number - 1][3]);
            System.out.println("Nomor Paspor: " + passengerInfo[number - 1][4]);
            System.out.println("Nomor KTP: " + passengerInfo[number - 1][5]);

            // Input ulang data yang ingin diubah
            System.out.println("Data Passenger Terbaru: ");
            String namaBaru = input("Masukkan Nama");
            String umurBaru = input("Masukkan Umur");
            String jenisKelaminBaru = input("Masukkan Jenis Kelamin (L/P)");
            String tanggalLahirBaru = input("Masukkan Tanggal Lahir (format: DD-MM-YYYY)");
            String nomorPasporBaru = input("Masukkan Nomor Paspor (7 digit)");
            String nomorKTPBaru = input("Masukkan Nomor KTP");

            // Memperbarui data pemesan
            passengerInfo[number - 1][0] = namaBaru;
            passengerInfo[number - 1][1] = umurBaru;
            passengerInfo[number - 1][2] = jenisKelaminBaru;
            passengerInfo[number - 1][3] = tanggalLahirBaru;
            passengerInfo[number - 1][4] = nomorPasporBaru;
            passengerInfo[number - 1][5] = nomorKTPBaru;


            System.out.println("Data Passenger berhasil diedit.");
        }
    }




    public static void resizeArrayPassenger() {
        String[][] temp = passengerInfo;
        passengerInfo = new String[temp.length * 2][3]; // Perbesar ukuran array dua kali lipat
        for (int i = 0; i < temp.length; i++) {
            passengerInfo[i] = temp[i];
        }
    }

    public static void resizeArrayIfFull(String[] array) {
        if (isArrayFull(array)) {
            String[] temp = array;
            array = new String[array.length * 2];
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        }
    }

    public static boolean isArrayFull(String[][] array) {
        for (String[] passenger : array) {
            if (passenger[0] == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isArrayFull(String[] array) {
        for (String element : array) {
            if (element == null) {
                return false;
            }
        }
        return true;
    }

    public static String input(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nMENU:");
            System.out.println("1. Tambah Data Passenger");
            System.out.println("2. Tampilkan Daftar Data Passenger");
            System.out.println("3. Tampilkan Daftar Rute");
            System.out.println("4. Tambah Rute Penerbangan");
            System.out.println("5. Edit Rute Penerbangan");
            System.out.println("6. Hapus Rute Penerbangan");
            System.out.println("7. Edit Informasi Pemesan");
            System.out.println("8. Keluar dari Sistem");
            System.out.println("Sistem ini dirancang oleh Kayla & Lestari");
            String choice = input("Pilih opsi");

            switch (choice) {
                case "1":
                    addPassengerInfo();
                    break;
                case "2":
                    showPassengerInfo();
                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    showPassengerInfo();
                    String infoNumToEdit = input("Pilih nomor data yang akan diedit (x utk batal)");
                    if (infoNumToEdit.equalsIgnoreCase("x")) break; // Pembatalan
                    editPassengerInfo(Integer.parseInt(infoNumToEdit));
                    break;

                case "8":
                    System.out.println("Keluar dari aplikasi.");
                    System.out.println("Sistem ini dirancang oleh Kayla & Lestari");

                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
