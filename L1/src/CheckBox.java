import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.xml.namespace.QName;
import javax.xml.xquery.*;

import java.io.*;
import com.saxonica.xqj.SaxonXQDataSource;

public class CheckBox extends JFrame implements ActionListener{
    JLabel l;
    JCheckBox cb1,cb2,cb3,cb4;
    JTextField tf1,tf2,tf3,tf4,tf42;
    JButton b;
    CheckBox(){
        l=new JLabel("Title");
        l.setBounds(50,50,300,20);
        cb1=new JCheckBox("1.3.1");
        cb1.setBounds(100,100,150,20);
        tf1=new JTextField("text field");
        tf1.setBounds(200,100,150,20);
        cb2=new JCheckBox("1.3.2");
        cb2.setBounds(100,150,150,20);
        tf2=new JTextField("text field");
        tf2.setBounds(200,150,150,20);
        cb3=new JCheckBox("2.1");
        cb3.setBounds(100,200,150,20);
        tf3=new JTextField("SOSE Title's");
        tf3.setBounds(200,200,150,20);
        tf3.setEditable(false);
        cb4=new JCheckBox("2.2");
        cb4.setBounds(100,250,150,20);
        tf4=new JTextField("text field");
        tf4.setBounds(200,250,75,20);
        tf42=new JTextField("text field");
        tf42.setBounds(275,250,75,20);
        b=new JButton("Submit");
        b.setBounds(100,300,80,30);
        b.addActionListener(this);
        add(l);add(cb1);add(cb2);add(cb3);add(cb4);add(b);add(tf1);add(tf2);add(tf3);add(tf4);add(tf42);
        setSize(420,420);
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
                "jdbc:mysql://localhost:3306/sys", "root", "password")) {

            if (conn != null) {
                System.out.println("Connected to the database!");

                String query = " select author from sys.lab1tbl where author like  \"%" + par  + "%\"";

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
                "jdbc:mysql://localhost:3306/sys", "root", "password")) {

            if (conn != null) {
                System.out.println("Connected to the database!");

                String query = " select * from sys.lab1tbl where title like  \"%" + par + "%\"";

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
    public void actionPerformed(ActionEvent e){
        String amount="";
        String par="";
        String par2="";
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


