package MainPackage;

public class Incaltaminte extends Haina{
	private int marime;
	
	public Incaltaminte(int marime, String nume)
	{
		super(nume);
		this.marime = marime;
	}
	
	public Incaltaminte(int marime, String nume, String culoare, int pret)
	{
		super(nume, culoare, pret);
		this.marime = marime;
	}
	
	public int getMarime()
    {
        return marime;
    }

    public void setMarime(int marime)
    {
        this.marime = marime;
    }
    
    @Override
    public String toString()
    {
        String s = "Nume: " + nume + "|  Culoare: " + culoare + "|  Pret: " + pret + "| Marime: " + marime +"|  Numar total de haine = " +NR_OF_CLOTHING_ITEMS;
        return s;
    }
}
