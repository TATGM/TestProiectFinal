package MainPackage;

class NameHolder {
    private static NameHolder single_instance = null; //Clasa specifica singleton
  
    public String s;
  
    private NameHolder()
    {
        s = "Meniu Principal";
    }
  
    public static NameHolder getInstance()
    {
        if (single_instance == null)
            single_instance = new NameHolder();
  
        return single_instance;
    }
}
