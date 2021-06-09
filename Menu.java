import java.util.Scanner;

public class Menu
{
    // =============
    //  CONSTRUCTOR
    // =============
	
    private Scanner sc;
    public Menu()
    {
        sc = new Scanner(System.in);
    }

    public void mainMenu(Family family)		//Method Menu Program
    {
        System.out.println("PROGRAM HADIAH KELUARGA");
        System.out.println("1. Tambah anggota keluarga");
        System.out.println("2. Tampilkan anggota keluarga");
        System.out.println("3. Tambah Hadiah");
        System.out.println("4. Tampilkan Hadiah");
        System.out.println("5. Siapa yang Ulang Tahun?");
        System.out.println("0. Exit");
        
        try
        {
            int option = Integer.parseInt(sc.nextLine());
    
            switch (option)
            {
            case 0:
                System.exit(0);
                break;

            case 1:
                addMember(family);			//Menambah anggota keluarga (Paman atau Sepupu)
                break;

            case 2:
                this.showMember(family);	//Menampilkan anggota keluarga
                break;

            case 3:
                this.insertPresent(family);	//Menambahkan hadiah dari paman untuk sepupunya
                break;
            
            case 4:
                this.showPresents(family);	//Menampilkan hadiah dari paman untuk sepupunya
                break;

            case 5:
                this.birthday(family);		//Menampilkan anggota keluarga bedasarkan tanggal ulang tahunnya
    
            default:
                System.out.println();
                mainMenu(family);			//Menampilkan main menu
                break;
            }
        }
        catch (NumberFormatException e)		//Jika input bukan nilai integer
        {
            System.out.println("Input is not an integer\n");
            this.mainMenu(family);			//Kembali ke main menu
        }
    }

    public void addMember(Family family)		//Method untuk menambah anggota keluarga
    {
        System.out.println("\nTambah anggota keluarga");
        System.out.println("1. Tambah Paman");
        System.out.println("2. Tambah Saudara");
        System.out.println("0. Back");
        
        try 
        {
            int option = Integer.parseInt(sc.nextLine());	//Input pilihan menu
            switch (option)
            {
            case 0:
                this.mainMenu(family);						//Kembali ke menu
                break;

            case 1:											//Menambah Paman
                System.out.print("Nama : ");
                String uncleName = sc.nextLine();
                
                if (family.addUncle(uncleName))
                    System.out.println("Paman dapat ditambahkan\n");
                else
                    System.out.println("Paman tidak dapat ditambahkan\n");
                break;
    
            case 2:
                System.out.print("Nama : ");					//Menambah Sepupu
                String nieceName = sc.nextLine();

                System.out.print("Hari : ");					//Tanggal ulang tahun
                int day = Integer.parseInt(sc.nextLine());

                System.out.print("Bulan : ");				//Bulan ulang tahun
                int month = Integer.parseInt(sc.nextLine());
    
                if (family.addNiece(nieceName, day, month))	//Hari ulang tahun dan nama sepupu ditambah
                    System.out.println("Sepupu ditambahkan\n");
                else
                    System.out.println("Sepupu tidak ditambahkan\n");	//Gagal ditambahkan
                break;

            default:
                addMember(family);
            }
        } 
        catch (NumberFormatException e)
        {
            System.out.println("Input is not an integer");
            this.addMember(family);	//Input tidak valid
        }
        mainMenu(family);
    }

    public void showMember(Family family)		//Menampilkan anggota keluarga
    {
        System.out.println("\nTampil anggota keluarga");
        System.out.println("1. Tampilkan Paman");
        System.out.println("2. Tampilkan sepupu");
        System.out.println("0. Back");

        try
        {
            int option = Integer.parseInt(sc.nextLine());	//Input pilihan menu

            switch (option)
            {
            case 0:
                this.mainMenu(family);
                break;

            case 1:
                family.listUncles();	//Daftar paman dalam keluarga
                System.out.println();
                break;
    
            case 2:
                family.listNieces();	//Daftar sepupu dalam keluarga
                System.out.println();
                break;

            default:
                showMember(family);	
                break;
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Input is not an integer\n");	//Input tidak valid
            this.showMember(family);
        }

        this.mainMenu(family);
    }

    public void insertPresent(Family family)	//Method untuk menambahkan hadiah ulang tahun
    {
        
        System.out.print("Nama Paman : ");	
        String uncleName = sc.nextLine();

        System.out.print("Nama Sepupu : ");
        String nieceName = sc.nextLine();

        System.out.print("Deskripsi Hadiah : ");
        String present = sc.nextLine();
        try
        {
            if (family.findUncle(uncleName).addPresent(family.findNiece(nieceName), present))
                System.out.println("Hadiah ditambah \n");
            else
                System.out.println("Tidak dapat ditambah\n");
        }
        catch (NullPointerException e)
        {
            System.out.println("Paman tidak ada!\n");
        }

        this.mainMenu(family);
    }

    public void showPresents(Family family)		//Method untuk menampilkan Hadiah
    {
        System.out.println("\nTampilkan Hadiah");
        System.out.println("1. Dari paman");
        System.out.println("2. Untuk sepupu");
        System.out.println("0. Back");

        try
        {
            int option = Integer.parseInt(sc.nextLine());

            switch (option)
            {
            case 0:
                this.mainMenu(family);
                break;

            case 1:
                try
                {
                    System.out.print("Nama: ");
                    String uncleName = sc.nextLine();

                    family.findUncle(uncleName).listPresents(family.getNieces());
                    System.out.println();
                }
                catch (NullPointerException e)
                {
                    System.out.println("Paman tidak ada\n");
                }
                break;
    
            case 2:
                try
                {
                    System.out.print("Nama: ");
                    String nieceName = sc.nextLine();

                    family.findNiece(nieceName).listPresents(family.getUncles());
                    System.out.println();
                }
                catch (NullPointerException e)
                {
                    System.out.println("Sepupu tidak ada\n");
                }
                break;

            default:
                showPresents(family);
                break;
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Input is not an integer\n");
            this.showPresents(family);	//Input tidak valid
        }

        this.mainMenu(family);
    }

    public void birthday(Family family)	//Method untuk mencari hadiah ulang tahun
    {
        System.out.print("Nama : ");
        String name = sc.nextLine();

        family.birthday(family.findNiece(name), family.getUncles());
    }
}