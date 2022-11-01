package MainPackage;

public class Haina
{
    public static int NR_OF_CLOTHING_ITEMS;
    protected String nume;
    protected String culoare;
    protected int pret;

    public Haina(String nume)
    {
        this.nume = nume;
        NR_OF_CLOTHING_ITEMS++;
    }

    public Haina(String nume, String culoare, int pret)
    {
        this.nume = nume;
        this.culoare = culoare;
        this.pret = pret;
        NR_OF_CLOTHING_ITEMS++;
    }

    public String getNume()
    {
        return nume;
    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public String getCuloare()
    {
        return culoare;
    }

    public void setCuloare(String culoare)
    {
        this.culoare = culoare;
    }

    public int getPret()
    {
        return pret;
    }

    public void setPret(int pret)
    {
        this.pret = pret;
    }

    public static int getTotalNumber()
    {
        return NR_OF_CLOTHING_ITEMS;
    }

    public String toString()
    {
        String s = "Nume: " + nume + "|  Culoare: " + culoare + "|  Pret: " + pret + "|  Numar total de haine = " +NR_OF_CLOTHING_ITEMS;
        return s;
    }

}
