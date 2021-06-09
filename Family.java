import java.util.Iterator;
import java.util.TreeSet;

public class Family 
{
    private TreeSet<Uncle> uncles;
    private TreeSet<Niece> nieces;

    //  CONSTRUCTOR

    public Family() 
    {
        this.uncles = new TreeSet<Uncle>();
        this.nieces = new TreeSet<Niece>();
    }

    //  ACCESSORS

    public TreeSet<Niece> getNieces()
    {
        return this.nieces;
    }

    public TreeSet<Uncle> getUncles()
    {
        return this.uncles;
    }

    public Uncle findUncle(String name) 	//Lookup a niece by name; return null if not found.
    {
        Iterator<Uncle> it = this.uncles.iterator();

        while (it.hasNext()) {
            Uncle temp = (Uncle) it.next();

            if (temp.getName().equals(name))
                return temp;
        }

        return null;
    }

    public Niece findNiece(String name) 	//Lookup an uncle by name; return null if not found.
    {
        Iterator<Niece> it = this.nieces.iterator();

        while (it.hasNext()) 
        {
            Niece temp = (Niece) it.next();
            
            if (temp.getName().equals(name))
                return temp;
        }

        return null;
    }

    public void listUncles() 				//List (to the console) the uncles recorded.
    {
        Iterator<Uncle> it = this.uncles.iterator();

        while (it.hasNext())
            System.out.println("Uncle " + it.next());
    }

    public void listNieces() 				//List (to the console) the nieces recorded
    {
        Iterator<Niece> it = this.nieces.iterator();

        while (it.hasNext())
            System.out.println(it.next());
    }

    //  MUTATORS

    public boolean addUncle(String name) //Add a new uncle. If there is already an uncle of the name, false is returned and nothing is added.
    {
        Uncle temp = new Uncle(name);

        if (uncles.contains(temp))
            return false;
        else 
        {
            this.uncles.add(temp);
            return true;
        }
    }

    public boolean addNiece(String name, int day, int month) //Add a new niece. If there is already a niece of this name, false is returned and nothing is added.
    {
        if (this.findNiece(name) == null)
        {
            this.nieces.add(new Niece(name, day, month));
            return true;
        }
        else 
        {
            System.out.println(this.findNiece(name).getName());
            return false;
        }
    }

    public void birthday(Niece niece, TreeSet<Uncle> uncles)
    {
        try
        {
            System.out.println("Hari ini ulang tahun " + niece.getName() + "\n");
            System.out.println("Dia mendapat :");
    
            niece.listPresents(uncles);
    
            niece.clearPresents();
    
            Iterator<Uncle> it = uncles.iterator();
    
            while (it.hasNext())
            {
                Uncle temp = (Uncle) it.next();
    
                if (temp.getPresents().containsKey(niece))
                    temp.getPresents().remove(niece);
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Saudara Tidak Ada\n");
        }
    }
}