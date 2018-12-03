package com.example.allen.cours_selection;
import java.io.Serializable;
import java.util.Vector;

@SuppressWarnings("serial")
public class Student implements Serializable
{
    protected
    String name;
    String ID;
    String Grade;

    public
    Vector< Course > classesTaken;

    public Student ()
    {}

    /*public ~ Students ()
{
    classesTaken.pop ();
}*/

    public String getName ()
    {
        return this.name;
    }

    public void setName (String x)
    {
        this.name = x;
    }

    public String getID()
    {
        return this.ID;
    }

    public void setID (String x)
    {
        this.ID = x;
    }

    public void getClassesTaken (Course takenclass)
    {
        classesTaken.add(takenclass);
    }

    public void setGrade (String x)
    {
        this.Grade = x;
    }

    /*public string getGrade ()
    {
        return this.Grade;
    }

    public writingToFile ()
    {
        FileOutputStream fos = new FileOutputStream (filename);
        DataOutputStream outStream =
                new DataOutputStream (new BufferedOutputStream (fos));
        outStream.writeUTF (name);
        outStream.writeUTF (ID);
        int length = classesTaken.size ();
        for (int i = 0; i < length; i++)
        {
            outStream.writeUTF (classesTaken[i]);
        }
        outstream.close ();

    }*/
}
