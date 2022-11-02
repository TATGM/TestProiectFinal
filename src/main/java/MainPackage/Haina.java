package MainPackage;

public class Haina //Clasa Haina care stocheaza date despre un obiect haina
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

    public Haina(String nume, String culoare, int pret) //Clasa are doi constructori, demonstrand polimorfism prin argumente diferite
    {
        this.nume = nume;
        this.culoare = culoare;
        this.pret = pret;
        NR_OF_CLOTHING_ITEMS++;
    }

    public String getNume() //metode get/set pentru diferitele campuri ale clasei
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

    public static int getTotalNumber() //Metoda ia nr total de haine create si il returneaza
    {
        return NR_OF_CLOTHING_ITEMS;
    }

    public String toString() //Metoda returneaza un String cu toate campurile clasei
    {
        String s = "Nume: " + nume + "|  Culoare: " + culoare + "|  Pret: " + pret + "|  Numar total de haine = " +NR_OF_CLOTHING_ITEMS;
        return s;
    }

}
