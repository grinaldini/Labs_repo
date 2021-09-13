import javax.swing.*;
import javax.xml.namespace.QName;
import javax.xml.xquery.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

import com.saxonica.xqj.SaxonXQDataSource;

public class CheckBox extends JFrame implements ActionListener{
    JLabel l;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
    JTextField tf1,tf2,tf3,
               tf4,tf42,
               tf51,tf52,tf53,
               tf61,tf62,
               tf7,tf8;
    JButton b;
    CheckBox(){
        l=new JLabel("Title");
        l.setBounds(50,50,300,20);

        cb1=new JCheckBox("1.3.1");
        cb1.setBounds(100,100,150,20);
        cb1.setToolTipText("Please enter author name, it will list all of his/her co-authors.");
        tf1=new JTextField("text field");
        tf1.setBounds(250,100,150,20);

        cb2=new JCheckBox("1.3.2");
        cb2.setBounds(100,150,150,20);
        cb2.setToolTipText("Please enter paper name, it will list all data of this paper.");
        tf2=new JTextField("text field");
        tf2.setBounds(250,150,150,20);

        cb5=new JCheckBox("1.3.3");
        cb5.setBounds(100,200,150,20);
        cb5.setToolTipText("Please enter a journal name, volume and number, it will display all the papers published in this book.");
        tf51=new JTextField("Journal name");
        tf51.setBounds(250,200,75,20);
        tf52=new JTextField("Volume");
        tf52.setBounds(325,200,75,20);
        tf53=new JTextField("Number");
        tf53.setBounds(400,200,75,20);

        cb6=new JCheckBox("1.3.4");
        cb6.setBounds(100,250,150,20);
        cb6.setToolTipText("Please enter a conference name and year, it will display all the papers published in this book.");
        tf61=new JTextField("Booktitle");
        tf61.setBounds(250,250,75,20);
        tf62=new JTextField("Year");
        tf62.setBounds(325,250,75,20);

        cb3=new JCheckBox("2.1");
        cb3.setBounds(100,300,150,20);
        cb3.setToolTipText("It will display all the article titles published in the area of SOSE.");
        tf3=new JTextField("SOSE Title's");
        tf3.setBounds(250,300,150,20);
        tf3.setEditable(false);

        cb4=new JCheckBox("2.2");
        cb4.setBounds(100,350,150,20);
        cb4.setToolTipText("Please enter author name and year, it will display the titles of the articles published by this author in the specific year.");
        tf4=new JTextField("text field");
        tf4.setBounds(250,350,75,20);
        tf42=new JTextField("text field");
        tf42.setBounds(325,350,75,20);


        cb7=new JCheckBox("2.3");
        cb7.setBounds(100,400,150,20);
        cb7.setToolTipText("It will display all the authors who have published 10 or more papers in the area of SOSE.");
        tf7=new JTextField("Authors papers over 10");
        tf7.setBounds(250,400,150,20);
        tf7.setEditable(false);

        cb8=new JCheckBox("2.4");
        cb8.setBounds(100,450,150,20);
        cb8.setToolTipText("Please enter a paper name, it will list all data of this paper.");
        tf8=new JTextField("Paper name");
        tf8.setBounds(250,450,150,20);

        b=new JButton("Submit");
        b.setBounds(100,500,80,30);
        b.addActionListener(this);
        add(l);add(cb1);add(cb2);add(cb3);add(cb4);
        add(cb5);add(cb6);add(cb7);add(cb8);add(b);
        add(tf1);add(tf2);add(tf3);add(tf4);add(tf42);
        add(tf51);add(tf52);add(tf53);
        add(tf61);add(tf62);add(tf7);add(tf8);
        setSize(500,600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    //****************using sql query********************
    //Given author name A, list all co-authors
    public String func131(String par) {
        String msg ="";
        //all co-authors

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lab1", "root", "201269")) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                String query = " select author from lab1tbl where author like  \"%" + par  + "%\"";

                PreparedStatement stmt = conn.prepareStatement(query);

                ResultSet rs = stmt.executeQuery(query);//no duplicate names, more than one of the same name, "John Ram, John Ram, Eddie Bower" , John Ram is duplicate
                while(rs.next())
                    msg = rs.getString("author");
                msg= msg.replace(par,"");

            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }
    //Given paper name, display all other information
    public String func132(String par) {
        String msg ="";
        //all co-authors

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lab1", "root", "201269")) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                String query = " select * from lab1.lab1tbl where title like  \"%" + par + "%\"";

                PreparedStatement stmt = conn.prepareStatement(query);

                ResultSet rs = stmt.executeQuery(query);//no duplicate names, more than one of the same name, "John Ram, John Ram, Eddie Bower" , John Ram is duplicate
                while (rs.next()){
                    msg += "+ Inproceedings:  ";
                    msg += rs.getString("inproceedings");
                    msg += ";\n";
                    msg += "   Author:  ";
                    msg += rs.getString("author");
                    msg += ";\n";
                    msg += "   Pages:  ";
                    msg += rs.getString("pages");
                    msg += ";\n";
                    msg += "   Year:  ";
                    msg += rs.getString("year");
                    msg += ";\n";
                    msg += "   Crossref:  ";
                    msg += rs.getString("crossref");
                    msg += ";\n";
                    msg += "   Booktitle:  ";
                    msg += rs.getString("booktitle");
                    msg += ";\n";
                    msg += "   URL:  ";
                    msg += rs.getString("url");
                    msg += ";";
                }
                //msg= msg.replace(par,"");

            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

    //Given journal name, volume, number, find out metadata of all papers in this book.
    public String func133(String jname, String volume, String number){
        String msg="";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lab1", "root", "201269")) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                String query = " select * from lab1.lab1tbl where journal like \"%" + jname + "%\""
                        +"and journalVolume like \"%"+ volume +"%\""
                        +"and journalNumber like \"%"+ number +"%\"";
                //select information using the given journal name, volume and number.

                PreparedStatement stmt = conn.prepareStatement(query);

                ResultSet rs = stmt.executeQuery(query);
                //put all the metadata in the msg string and make sure they will be shown on the window.
                while (rs.next()){
                    msg += "+ Inproceedings:  ";
                    msg += rs.getString("inproceedings");
                    msg += ";\n";
                    msg += "   Author:  ";
                    msg += rs.getString("author");
                    msg += ";\n";
                    msg += "   Title:  ";
                    msg += rs.getString("title");
                    msg += ";\n";
                    msg += "   Pages:  ";
                    msg += rs.getString("pages");
                    msg += ";\n";
                    msg += "   Year:  ";
                    msg += rs.getString("year");
                    msg += ";\n";
                    msg += "   Journal:  ";
                    msg += rs.getString("journal");
                    msg += ";\n";
                    msg += "   Journal volume:  ";
                    msg += rs.getString("journalVolume");
                    msg += ";\n";
                    msg += "   Journal number:  ";
                    msg += rs.getString("journalNumber");
                    msg += ";\n";
                    msg += "   URL:  ";
                    msg += rs.getString("url");
                    msg += ";\n"+"\n";
                }
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    //Given conference name and year, find out metadata of all papers in this book.
    public String func134(String btitle, String yr){
        String msg="";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lab1", "root", "201269")) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                String query = " select * from lab1.lab1tbl where booktitle like \"%" + btitle + "%\""
                        +"and year like \"%"+ yr +"%\"";

                PreparedStatement stmt = conn.prepareStatement(query);

                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    msg += "+ Inproceedings:  ";
                    msg += rs.getString("inproceedings");
                    msg += ";\n";
                    msg += "   Author:  ";
                    msg += rs.getString("author");
                    msg += ";\n";
                    msg += "   Title:  ";
                    msg += rs.getString("title");
                    msg += ";\n";
                    msg += "   Pages:  ";
                    msg += rs.getString("pages");
                    msg += ";\n";
                    msg += "   Year:  ";
                    msg += rs.getString("year");
                    msg += ";\n";
                    msg += "   Crossref:  ";
                    msg += rs.getString("crossref");
                    msg += ";\n";
                    msg += "   Booktitle:  ";
                    msg += rs.getString("journalVolume");
                    msg += ";\n";
                    msg += "   URL:  ";
                    msg += rs.getString("url");
                    msg += ";\n"+"\n";
                }
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }


    //***************************************using xquery***********************************************************
    //+Display all the articles title in the area of SOSE(Contain "Service Oriented" in title)
    public String func21() throws Exception{
        String msg = "";
        //String soeKey = "Service Oriented";
        try (InputStream in = new FileInputStream("dblp-soc-papers.xml")) {
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp = conn.prepareExpression("//inproceedings/title[contains(.,'Service Oriented')]/text()");

            exp.bindDocument(XQConstants.CONTEXT_ITEM, in, null, null);

            XQResultSequence result = exp.executeQuery();
            while (result.next()) {
                msg +="+\" ";
                msg += (result.getItemAsString(null));
                msg +="\"";
                msg +="\n";
            }
            in.close();
            conn.close();
            System.out.println("End");
        }
        return msg;
    }

    //use xquery in this func22 , last one... got it?
    //+Return message with titles of articles published by researcher ('Researcher Name') in a specific year ('Year')
    public static String func22(String author, String year) throws Exception {
        String msg = "";
        try (InputStream in = new FileInputStream("dblp-soc-papers.xml")) {
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp = conn.prepareExpression(
                    "declare variable $author as xs:string external;\n" +
                            "declare variable $year as xs:string external;\n" +
                            " for $n in //inproceedings\n" +
                            " where $n/author = $author and $n/year = $year\n" +
                            " return $n/title"
            );

            exp.bindDocument(XQConstants.CONTEXT_ITEM, in, null, null);
            exp.bindString(new QName("author"), author, null);
            exp.bindString(new QName("year"), year, null);

            XQResultSequence result = exp.executeQuery();
            while (result.next()) {
                msg += (result.getItemAsString(null));
            }
            in.close();
            conn.close();
            System.out.println("End");
        }
        return msg;
    }

    //Display all the authors who have published more than 10 papers in the area of SOSE
    public static String func23() throws Exception{
        String msg="";
        try (InputStream in = new FileInputStream("dblp-soc-papers.xml")) {
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp = conn.prepareExpression(
                    /* "for $n in //inproceedings\n" +
                        "where count($n/title[contains(.,'Service Oriented')]/text())>10 and $n/author = $author\n" +
                        "return $n/author\n"*/

                    //extract all value of author who published 10 or more SOSE papers from xml.
                            "for $element in distinct-values(//*/author )\n" +
                            "where (count(index-of(//*/author, $element))) >= 10\n"+
                            "return $element"

            );

            exp.bindDocument(XQConstants.CONTEXT_ITEM, in, null, null);

            XQResultSequence result = exp.executeQuery();
            //all the
            while (result.next()) {
                msg += "+"+(result.getItemAsString(null))+"\n";
            }

            in.close();
            conn.close();
            System.out.println("End");
        }
        return msg;
    }

    //Given paper name(title), display metadate.
    //When paper is conference.
   public String func24c(String title) throws Exception{
        String msg ="";

        try (InputStream in = new FileInputStream("dblp-soc-papers.xml")) {
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp1 = conn.prepareExpression(
                    "declare variable $title as xs:string external;\n" +
                            "let $inp := //inproceedings\n" +
                            "return(\n" +
                            " for $n in $inp\n" +
                                " where $n/title = $title\n" +
                                " return $n)"
                    //extract information of the required conference paper.
            );

            exp1.bindDocument(XQConstants.CONTEXT_ITEM, in, null, null);
            exp1.bindString(new QName("title"), title, null);

            XQResultSequence result = exp1.executeQuery();

            while (result.next()) {
                msg +="Publication channel: Conference\n";
                msg += (result.getItemAsString(null));
                //make sure the data will be displayed on window.
            }

            in.close();
            conn.close();
            System.out.println("End");
        }
        return msg;
    }

    //When paper is journal.
    public String func24j(String title) throws Exception{
        String msg ="";

        try (InputStream in = new FileInputStream("dblp-soc-papers.xml")) {
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp1 = conn.prepareExpression(
                    "declare variable $title as xs:string external;\n" +
                            "let $art := //article\n" +
                            "return(\n" +
                            " for $n in $art\n" +
                            " where $n/title = $title\n" +
                            " return $n)"
                    //extract information of the required journal paper.
            );

            exp1.bindDocument(XQConstants.CONTEXT_ITEM, in, null, null);
            exp1.bindString(new QName("title"), title, null);

            XQResultSequence result = exp1.executeQuery();

            while (result.next()) {
                msg += "Publication channel: Journal\n";
                msg += (result.getItemAsString(null));
                //make sure the data will be displayed on window.
            }

            in.close();
            conn.close();
            System.out.println("End");
        }
        return msg;
    }

    public void actionPerformed(ActionEvent e){
        String amount="";
        String par="";
        String par2="";
        String par3="";
        String msg="";
        if(cb1.isSelected()){
            par=tf1.getText();
            msg+="\n-------Query 1.3.1-------\n";
            msg += func131(par);

            //amount+=100;
            msg+="\n---------------------\n";
        }
        if(cb2.isSelected()){
            par=tf2.getText();
            msg+="\n-------Query 1.3.2-------\n";
            msg += func132(par);
            //amount+=30;
            msg+="\n---------------------\n";
        }
        if(cb5.isSelected()){
            par = tf51.getText();
            par2 = tf52.getText();
            par3 = tf53.getText();
            msg+="\n-------Query 1.3.3-------\n";

            msg += func133(par,par2,par3);

            msg += "\n---------------------\n";
        }
        if(cb6.isSelected()){
            par = tf61.getText();
            par2 = tf62.getText();

            msg+="\n-------Query 1.3.4-------\n";

            msg += func134(par,par2);

            msg += "\n---------------------\n";
        }


        if(cb3.isSelected()){
            //par=tf3.getText();
            msg+="\n-------Query 2.1-------\n";
            try{
                msg += func21();
            }
            catch(FileNotFoundException f){
                f.printStackTrace();
            }
            catch(Exception f ){
                f.printStackTrace();
            }
            //amount+=10;
            msg+="\n---------------------\n";
        }
        if(cb4.isSelected()){
            par=tf4.getText();
            par2 = tf42.getText();
            msg+="\n-------Query 2.2-------\n";
            try{
                msg += func22(par,par2);
            }
            catch(FileNotFoundException f){
                f.printStackTrace();
            }
            catch(Exception f ){
                f.printStackTrace();
            }
            //amount+=10;

            msg += "\n---------------------\n";
        }
        if(cb7.isSelected()){
            msg+="\n-------Query 2.3-------\n";
            try {
                msg += func23();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            msg+="\n---------------------\n";
        }
        if(cb8.isSelected()){
            par=tf8.getText();
            msg+="\n-------Query 2.4-------\n";
            try {
                msg += func24c(par);
                msg += func24j(par);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //amount+=30;
            msg+="\n---------------------\n";
        }

        //msg+="-----------------\n";
        //JOptionPane.showMessageDialog(this,msg);
        JTextArea textArea = new JTextArea(msg);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
        JOptionPane.showConfirmDialog(null, scrollPane, "Query Results",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showConfirmDialog(null, label, "ScreenPreview", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }
    public static void main(String[] args) {
        new CheckBox();
    }
}

