package MainPackage;

public class MagazinHaine implements Magazin{

	private static MagazinHaine single_instance = null;
	private static final String adress = "511 Dina Forge, Suite 990, 87699-7291, Borerborough, North Carolina, United States";
	private static final String name = "H&M";
	
	public String getName()
	{
		return name;
	}
	
	public String getAdress()
	{
		return adress;
	}
	
	public static MagazinHaine getInstance()
    {
        if (single_instance == null)
            single_instance = new MagazinHaine();
  
        return single_instance;
    }
}
