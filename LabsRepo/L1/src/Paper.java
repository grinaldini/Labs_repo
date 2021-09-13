import java.util.*;

public class Paper {
    String inproceedings;
    Vector author = new Vector(3,2);
    String title;
    String pages;
    String year;
    String crossref;
    String journal;
    String booktitle;
    String journalVolume;
    String journalNumber;
    String ee;
    String url;
    //For printing functions
    //String printAuthor;
    @Override
    public String toString() {
        //Enumeration vEnum = author.elements();
        //while(vEnum.hasMoreElements())
           // System.out.print(vEnum.nextElement()+" ");

        return author+title+"("+inproceedings+")"+pages+year+crossref+booktitle+url;
    }
}
