import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public class Uncle implements Comparable<Uncle> 
{
    private String name;
    private LinkedHashMap<Niece, String> presents;  // container for presents that don't have duplicate value

    //  CONSTRUCTOR

    protected Uncle(String name)
    {
        this.name = name;
        this.presents = new LinkedHashMap<Niece, String>();
    }

    //  ACCESSORS

    public String getName()
    {
        return this.name;
    }

    public LinkedHashMap<Niece, String> getPresents()
    {
        return this.presents;
    }

    public void listPresents(TreeSet<Niece> nieces)
    {
        Iterator<Niece> it = nieces.iterator();

        while (it.hasNext())
        {
            Niece temp = (Niece) it.next();

            if (presents.containsKey(temp))	//Jika ada hadiah paman bagi sepupunya
                System.out.println(this.presents.get(temp) + " for " + temp.getName());
            else
                System.out.println("Uncle " + this.name + " doesn't have any presents for " + temp.getName() + " yet");
        }
    }

    public int compareTo(Uncle u)
    {
        return this.name.compareTo(u.name);
    }

    public String toString()
    {
        return this.name;
    }

    //  MUTATOR 

    public boolean addPresent(Niece recipient, String description)
    {
        try
        {
            if (recipient.hasPresent(description))
                return false;
            else
            {
                if (this.presents.containsValue(description))
                    return false;
                else
                {
                    recipient.receivePresent(this, description);
                    this.presents.put(recipient, description);
                    return true;
                }
            }
        }
        catch (NullPointerException e)
        {
            return false;
        }
    }
}