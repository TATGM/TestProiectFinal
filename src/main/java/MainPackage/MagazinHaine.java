package MainPackage;

public class MagazinHaine implements Magazin{ //Implementeaza interfata Magazin si declara metodele acesteia

	private static MagazinHaine single_instance = null;//Clasa este de tip Singleton deci se creaza o instanta null-a la inceput
	private static final String adress = "511 Dina Forge, Suite 990, 87699-7291, Borerborough, North Carolina, United States";
	private static final String name = "H&M";
	
	public String getName() //Metode get set pentru numele si adresa magazinului
	{
		return name;
	}
	
	public String getAdress()
	{
		return adress;
	}
	
	public static MagazinHaine getInstance() // Metoda specifica clasei singleton, verifica existenta unei instante
    {										 //, in caz ca nu exista, creeaza una si o returneaza
        if (single_instance == null)
            single_instance = new MagazinHaine();
  
        return single_instance;
    }
}
