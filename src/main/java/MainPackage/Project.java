package MainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.ArrayList;

public class Project implements ActionListener
{
    static JTextField text, text2;
    static JLabel output;
    static JTable table;
    public static ArrayList<Haina> haine = new ArrayList<Haina>();
    public static final ArrayList<Incaltaminte> incaltaminte = new ArrayList<Incaltaminte>();
    //static Haina[] haine = new Haina[20];
    static DefaultTableModel model;

    public static void main(String[] args) {

        StringBuffer sb=new StringBuffer("Meniu "); 
        //NameHolder nh = NameHolder.getInstance();
        sb.append("Principal"); 
        JFrame frame = new JFrame(sb.toString()); 

        Haina h1 = new Haina("Tricou", "Rosu", 20);
        Haina h2 = new Haina("Tricou", "Negru", 25);
        Haina h3 = new Haina("Bluza", "Albastru", 55);
        Haina h4 = new Haina("Pantaloni", "Galben", 35);
        haine.add(h1);
        haine.add(h2);
        haine.add(h3);
        haine.add(h4);
        Incaltaminte p1 = new Incaltaminte(19, "Pantofi", "Bleu", 200);
        incaltaminte.add(p1);

        String[][] data = new String[20][4]; 

        /*for(int i = 0; i < Haina.NR_OF_CLOTHING_ITEMS ;i++)
        {
            data[i][0] = haine.get(i).getNume();
            data[i][1] = haine.get(i).getCuloare();
            data[i][2] = Integer.toString(haine.get(i).getPret());

        }*/
        for(int i = 0; i < haine.size() ;i++)
        {
            data[i][0] = haine.get(i).getNume();
            data[i][1] = haine.get(i).getCuloare();
            data[i][2] = Integer.toString(haine.get(i).getPret());
        }
        
        for(int i = 0; i < incaltaminte.size() ;i++)
        {
            data[i][0] = incaltaminte.get(i).getNume();
            data[i][1] = incaltaminte.get(i).getCuloare();
            data[i][2] = Integer.toString(incaltaminte.get(i).getPret());
            data[i][3] = Integer.toString(incaltaminte.get(i).getMarime());
        }
        
        String[] columnNames = { "Articol", "Culoare", "Pret", "Marime" };
 

        model = new DefaultTableModel(columnNames, 0);

        table = new JTable(model);

        frame.add(new JScrollPane(table));

        /*
        for(int i = 0; i < Haina.NR_OF_CLOTHING_ITEMS ;i++)
        {
        model.addRow(
                   new Object[]{
                         haine.get(i).getNume(), 
                         haine.get(i).getCuloare(),
                         haine.get(i).getPret()
                   });
        }*/
        
        for(int i = 0; i < haine.size() ;i++)
        {
        model.addRow(
                   new Object[]{
                         haine.get(i).getNume(), 
                         haine.get(i).getCuloare(),
                         haine.get(i).getPret()
                   });
        }
        
        for(int i = 0; i < incaltaminte.size() ;i++)
        {
        model.addRow(
                   new Object[]{
                		   incaltaminte.get(i).getNume(), 
                		   incaltaminte.get(i).getCuloare(),
                		   incaltaminte.get(i).getPret(),
                		   incaltaminte.get(i).getMarime()
                   });
        }

        JButton addButton = new JButton("Add Article");
        JButton searchButton = new JButton("Cautare");
        JButton addButton2 = new JButton("Add Shoes");
        JButton storeInfoButton = new JButton("Store Info");

        frame.add(addButton);frame.add(searchButton);frame.add(addButton2);frame.add(storeInfoButton);
        
        storeInfoButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new ShowInfo();
            }
        });
        
        searchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Search(haine, incaltaminte);
            }
        });
        
        addButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new AddShoes(incaltaminte);
                new TooManyItems();
            }
        });

        Project instance = new Project();

        addButton.addActionListener(instance);

        frame.setLayout(new FlowLayout());
        frame.setSize(480, 750);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        new CreateFrame(); 
        new TooManyItems();
    }
    
static public class ShowInfo extends JFrame
{
	public ShowInfo()
	{
		MagazinHaine mh = MagazinHaine.getInstance();
        final JLabel label1  = new JLabel("Nume Magazin: " + mh.getName());
        final JLabel label2  = new JLabel("Adresa Magazin: " + mh.getAdress());

        JButton button = new JButton("Done");
        button.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
        		dispose();
            }
        });
        add(label1);  add(label2); add(button);

        setLayout(new FlowLayout());
        setSize(700, 100);
        setVisible(true);
	}
}
    
static abstract class Error{  
	  abstract void StopProgram();  
}  

static class TooManyItems extends Error
{
	public TooManyItems()
	{
		StopProgram();
	}
	void StopProgram()
	{
		if((incaltaminte.size() + haine.size()) >= 30)
			System.exit(0);
	}
}

static class AddShoes extends JFrame
{
	public AddShoes(final ArrayList<Incaltaminte> incaltaminte)
	{
		final JTextField text1 = new JTextField(10);
        final JTextField text2 = new JTextField(10);
        final JTextField text3 = new JTextField(10);
        final JTextField text4 = new JTextField(10);
        final JLabel label1  = new JLabel("Articol: ");
        final JLabel label2  = new JLabel("Culoare: ");
        final JLabel label3  = new JLabel("Pret   : ");
        final JLabel label4  = new JLabel("Marime : ");

        JButton button = new JButton("Done");

        add(label1); add(text1); add(label2); add(text2); add(label3); add(text3); add(label4); add(text4);

        add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Utility.isNumeric(text1.getText()) || (Utility.isNumeric(text2.getText())) || !(Utility.isNumeric(text3.getText())))
                {
                    new ShowError(); 
                    dispose();
                }
                else
                {
                Incaltaminte h = new Incaltaminte(Integer.parseInt(text4.getText()), text1.getText(), text2.getText(), Integer.parseInt(text3.getText()));
                //haine[Haina.NR_OF_CLOTHING_ITEMS] = h;
                incaltaminte.add(h);

                model.addRow(
                   new Object[]{
                        text1.getText(), 
                        text2.getText(),
                        text3.getText(),
                        text4.getText()
                   });
                dispose();
                }
            }
        });

        setLayout(new FlowLayout());
        setSize(800, 100);
        setVisible(true);
	}
}
    
class CreateFrame extends JFrame
{
    public CreateFrame()
    {

        final JTextField text1 = new JTextField(10);
        final JTextField text2 = new JTextField(10);
        final JTextField text3 = new JTextField(10);
        final JLabel label1  = new JLabel("Articol: ");
        final JLabel label2  = new JLabel("Culoare: ");
        final JLabel label3  = new JLabel("Pret   : ");

        JButton button = new JButton("Done");

        add(label1); add(text1); add(label2); add(text2); add(label3); add(text3);

        add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Utility.isNumeric(text1.getText()) || (Utility.isNumeric(text2.getText())) || !(Utility.isNumeric(text3.getText())))
                {
                    new ShowError(); 
                    dispose();
                }
                else
                {
                Haina h = new Haina(text1.getText(), text2.getText(), Integer.parseInt(text3.getText()));
                //haine[Haina.NR_OF_CLOTHING_ITEMS] = h;
                haine.add(h);

                model.addRow(
                   new Object[]{
                        text1.getText(), 
                        text2.getText(),
                        text3.getText()
                   });
                dispose();
                }
            }
        });

        setLayout(new FlowLayout());
        setSize(500, 100);
        setVisible(true);
    }
}
}

class ShowError extends JFrame 
{
    public ShowError()
    {
    JLabel erLabel  = new JLabel("EROARE: datele de intrare nu sunt corecte");
    JButton errorButton = new JButton("Confirm");
    errorButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        }
    });

    add(erLabel); add(errorButton);
    setLayout(new FlowLayout());
    setSize(400, 100);
    setVisible(true);
    }
}

class Search extends JFrame
{
    public Search(final ArrayList<Haina> haine, final ArrayList<Incaltaminte> incaltaminte)
    {
    final JLabel searchLabel  = new JLabel("Introdu Articolul Cautat");
    final JLabel articolLabel  = new JLabel("Aici vor aparea informatiile despre articol");
    final JTextField searchText = new JTextField(10);
    final JButton searchButton = new JButton("Confirm");
    searchButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            int n = 0;
            int m = 0;
            /*for(int i = 0; i < Haina.NR_OF_CLOTHING_ITEMS ;i++)
            {
                if(searchText.getText().equals(haine.get(i).getNume()))
                {
                m = i;
                n++;
                }
            }*/
            for(int i = 0; i < haine.size() ;i++)
            {
                if(searchText.getText().equals(haine.get(i).getNume()))
                {
                m = i;
                n++;
                }
            }
            if(n == 0)
            searchLabel.setText("Nu sa gasit");
            else if (n == 1)
            {
            searchLabel.setText("Gasit!");
            articolLabel.setText(haine.get(m).toString());
            }
            else 
            {
            searchLabel.setText("Gasit " + n + " articole numite: ");
            articolLabel.setText(haine.get(m).toString());
            }
            
            for(int i = 0; i < incaltaminte.size() ;i++)
            {
                if(searchText.getText().equals(incaltaminte.get(i).getNume()))
                {
                m = i;
                n++;
                }
            }
            if(n == 0)
            searchLabel.setText("Nu sa gasit");
            else if (n == 1)
            {
            searchLabel.setText("Gasit!");
            articolLabel.setText(incaltaminte.get(m).toString());
            }
            else 
            {
            searchLabel.setText("Gasit " + n + " articole numite: ");
            articolLabel.setText(incaltaminte.get(m).toString());
            }
        }
    });

    add(searchLabel); add(searchText); add(searchButton); add(articolLabel);
    setLayout(new FlowLayout());
    setSize(500, 200);
    setVisible(true);
    }
}
