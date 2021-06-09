import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public class Niece implements Comparable<Niece> 
{
    private String name;
    private int day, month;                         // niece's birthday
    private LinkedHashMap<Uncle, String> presents;  // container for presents that don't have duplicate value

    //  CONSTRUCTOR

    protected Niece(String name, int day, int month)
    {
        this.name = name;
        this.day = day;
        this.month = month;
        this.presents = new LinkedHashMap<Uncle, String>();
    }

    //  ACCESSORS

    public String getName()
    {
        return this.name;
    }

    public void listPresents(TreeSet<Uncle> uncles)
    {
        Iterator<Uncle> it = uncles.iterator();

        while (it.hasNext())
        {
            Uncle temp = (Uncle) it.next();
            if (presents.containsKey(temp))
                System.out.println(this.presents.get(temp) + " dari paman " + temp.getName());
            else
                System.out.println("Paman " + temp.getName() + " tidak memberi hadiah kepada " + this.name + "" );
        }
    }

    public int compareTo(Niece niece)
    {
        if (this.month == niece.month)
            return this.day - niece.day;

        return this.month - niece.month;
    }

    public String toString()
    {
        return this.name + ": " + this.day + " " + this.getMonth();
    }

    // function to get a name of a month from niece's birthday month
    private String getMonth()
    {
        switch (this.month) {
            case 1:
                return "January";

            case 2:
                return "February";

            case 3:
                return "March";

            case 4:
                return "April";

            case 5:
                return "May";

            case 6:
                return "June";

            case 7:
                return "July";

            case 8:
                return "August";

            case 9:
                return "September";

            case 10:
                return "October";

            case 11:
                return "November";

            case 12:
                return "December";

            default:
                return null;
        }
    }

    //  MUTATOR
    
    public void receivePresent(Uncle sender, String description)
    {
        this.presents.put(sender, description);
    }

    public void clearPresents()
    {
        this.presents.clear();
    }

    //  VALIDATOR

    public boolean hasPresent(String present)
    {
        return this.presents.containsValue(present);
    }
}