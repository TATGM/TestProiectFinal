package MainPackage;

public class Incaltaminte extends Haina{ //Clasa care Mosteneste clasa Haina
	private int marime;
	
	public Incaltaminte(int marime, String nume)
	{
		super(nume);              //Constructor ce contine metoda super pentru a satisface nevoile de constructor al superclasei
		this.marime = marime;
	}
	
	public Incaltaminte(int marime, String nume, String culoare, int pret)
	{
		super(nume, culoare, pret);
		this.marime = marime;
	}
	
	public int getMarime() //metode get/set pentru campul nou adaugat 
    {
        return marime;
    }

    public void setMarime(int marime)
    {
        this.marime = marime;
    }
    
    @Override
    public String toString() //metoda toString suprascrisa pentru a include noul camp
    {
        String s = "Nume: " + nume + "|  Culoare: " + culoare + "|  Pret: " + pret + "| Marime: " + marime +"|  Numar total de haine = " +NR_OF_CLOTHING_ITEMS;
        return s;
    }
}

