/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import static assignment2.BookSortingApplication.listModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


/**
 *
 * holds all the methods that will be called by the BookSortingApplication class
 */
public class BookSortingApplicationMethods {
    
    /**
     * takes a file name and tries to open a text file within the executable file location
     */
    public Boolean loadFile(String fileName)//loads the data from the txt file
    {
        try
        {
            Scanner is = new Scanner(new File(fileName));
            while(is.hasNextLine())
            {
                String[] x = is.nextLine().split(",");
                switch(x[0])
                {
                    case "CRIME":
                        BookSortingApplication.crimeList.add(new Crime(x[1], Integer.parseInt(x[2]), Integer.parseInt(x[3]), x[4], Integer.parseInt(x[5]), x[6], x[7], Integer.parseInt(x[8]), Integer.parseInt(x[9])));
                        break;
                    case "DRAMA":
                        BookSortingApplication.dramaList.add(new Drama(x[1], Integer.parseInt(x[2]), Integer.parseInt(x[3]), x[4], Integer.parseInt(x[5]), x[6], x[7], Integer.parseInt(x[8]), Integer.parseInt(x[9])));
                        break;
                }
            }
            return true;
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showConfirmDialog(null, "The file '"+fileName+"' couldn't be found, the error is as follows: "+e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
    }
    
    /**
     * takes a file name and tries to save a comma separated value file within the executable file location
     */
    public void saveFile()
    {
        try
        {
            PrintStream fileStream = new PrintStream(new File(JOptionPane.showInputDialog(null, "Enter the name of the output file WITHOUT the extension")+".csv"));
            for(int x = 0; x < BookSortingApplication.crimeList.size(); x++)
            {
                fileStream.println("CRIME,"+BookSortingApplication.crimeList.get(x).getTitle()+","+BookSortingApplication.crimeList.get(x).getId()+","+BookSortingApplication.crimeList.get(x).getISBN()+","+BookSortingApplication.crimeList.get(x).getAuthor()+","+BookSortingApplication.crimeList.get(x).getPages()+","+BookSortingApplication.crimeList.get(x).getDateOfIssue()+","+BookSortingApplication.crimeList.get(x).getBorrowerName()+","+BookSortingApplication.crimeList.get(x).getDaysOverdue()+","+BookSortingApplication.crimeList.get(x).getPenalty());
            }
            for(int x = 0; x < BookSortingApplication.dramaList.size(); x++)
            {
                fileStream.println("DRAMA,"+BookSortingApplication.dramaList.get(x).getTitle()+","+BookSortingApplication.dramaList.get(x).getId()+","+BookSortingApplication.dramaList.get(x).getISBN()+","+BookSortingApplication.dramaList.get(x).getAuthor()+","+BookSortingApplication.dramaList.get(x).getPages()+","+BookSortingApplication.dramaList.get(x).getDateOfIssue()+","+BookSortingApplication.dramaList.get(x).getBorrowerName()+","+BookSortingApplication.dramaList.get(x).getDaysOverdue()+","+BookSortingApplication.dramaList.get(x).getPenalty());
            }
            fileStream.close();
        }
        catch(IOException b)
        {
            System.out.println(b.getMessage());
        }
    }
    
    /**
     * adds a book to the crime or drama arraylist, prompts the user for the books details
     */
    public void addBook()
    {
        JList list = new JList(new String[] {"Crime", "Drama"});
        JOptionPane.showMessageDialog(null, list, "Please select a book type", JOptionPane.PLAIN_MESSAGE);
        try
        {
            switch(Arrays.toString(list.getSelectedIndices()))
            {
                case"[0]"://Crime
                    BookSortingApplication.crimeList.add(new Crime(JOptionPane.showInputDialog(null, "Enter the title of the book"), Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of the book")), Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the ISBN of the book")), JOptionPane.showInputDialog(null, "Enter the author"), Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the no. of pages")), JOptionPane.showInputDialog(null, "Enter the date of issue eg. DD/MM/YY"), JOptionPane.showInputDialog(null, "Enter the borrowers name"), Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of days overdue")), 0));
                    break;
                case"[1]"://Drama
                    BookSortingApplication.dramaList.add(new Drama(JOptionPane.showInputDialog(null, "Enter the title of the book"), Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of the book")), Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the ISBN of the book")), JOptionPane.showInputDialog(null, "Enter the author"), Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the no. of pages")), JOptionPane.showInputDialog(null, "Enter the date of issue eg. DD/MM/YY"), JOptionPane.showInputDialog(null, "Enter the borrowers name"), Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of days overdue")), 0));
                    break;
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showConfirmDialog(null, "an error occured, here's the error: "+e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /**
     * takes all the books in the crime and drama array lists and adds them to the list model
     */
    public void updateListbox()
    {
        listModel.clear();
        //listModel.
        for(int x = 0; x < BookSortingApplication.crimeList.size(); x++)
        {
            listModel.addElement("CRIME, "+BookSortingApplication.crimeList.get(x).getTitle()+", "+BookSortingApplication.crimeList.get(x).getId()+", "+BookSortingApplication.crimeList.get(x).getISBN()+", "+BookSortingApplication.crimeList.get(x).getAuthor()+", "+BookSortingApplication.crimeList.get(x).getPages()+", "+BookSortingApplication.crimeList.get(x).getDateOfIssue()+", "+BookSortingApplication.crimeList.get(x).getBorrowerName()+", "+BookSortingApplication.crimeList.get(x).getDaysOverdue());
        }
        for(int x = 0; x < BookSortingApplication.dramaList.size(); x++)
        {
            listModel.addElement("DRAMA, "+BookSortingApplication.dramaList.get(x).getTitle()+", "+BookSortingApplication.dramaList.get(x).getId()+", "+BookSortingApplication.dramaList.get(x).getISBN()+", "+BookSortingApplication.dramaList.get(x).getAuthor()+", "+BookSortingApplication.dramaList.get(x).getPages()+", "+BookSortingApplication.dramaList.get(x).getDateOfIssue()+", "+BookSortingApplication.dramaList.get(x).getBorrowerName()+", "+BookSortingApplication.dramaList.get(x).getDaysOverdue());
        }
    }
    
    /**
     * takes the list model index and finds the total fine of the selected book, can throw a ArrayIndexOutOfBoundsException
     */
    public int viewPenalty(int x)
    {
        int i = 0;//total penalty
        try
        {
            String[] a = listModel.getElementAt(x).toString().split(",");//"a[8]" will be the no. of days taken out
            switch(a[0])
            {
                case "CRIME":
                    if(Integer.parseInt(String.valueOf(a[8]).trim()) > 3)
                    {
                        for(int e = 3;e <= Integer.parseInt(String.valueOf(a[8]).trim()) && e != 8; e++)
                        {
                            i = (i+5);
                        }
                    }
                    if(Integer.parseInt(String.valueOf(a[8]).trim()) > 8)
                    {
                        for(int f = 8;f <= Integer.parseInt(String.valueOf(a[8]).trim()) && f != 17; f++)
                        {
                            i = (i+10);
                        }
                    }
                    break;
                case "DRAMA":
                    if(Integer.parseInt(String.valueOf(a[8]).trim()) > 3)
                    {
                        for(int g = 3;g <= Integer.parseInt(String.valueOf(a[8]).trim()) && g != 8; g++)
                        {
                            i = (i+7);
                        }
                    }
                    if(Integer.parseInt(String.valueOf(a[8]).trim()) > 8)
                    {
                        for(int h = 8;h <= Integer.parseInt(String.valueOf(a[8]).trim()) && h != 17; h++)
                        {
                            i = (i+12);
                        }
                    }
                    break;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ERROR, ARRAY OUT OF BOUNDS"+e.getMessage());
            System.out.println(e.getCause());
            System.out.println();
        }
        
        return i;
    }
    
    /**
     * Sorts the list model by the amount of money the accompanying fines are worth
     */
    public void sortByMaxRev()//Sort books by days rented out, drama taking priority
    {
        DefaultListModel tmp = new DefaultListModel();  
        for(int x = 0; x < listModel.size(); x++)
        {
            String[] a = listModel.get(x).toString().split(",");
            
            for(int y = 0; y < listModel.size(); y++)
            {
                String[] b = listModel.get(y).toString().split(",");
                
                if(viewPenalty(x) > viewPenalty(y) && a[1].equals(b[1]) != true)
                {
                    tmp.add(0, listModel.get(x));
                    listModel.set(x, listModel.get(y));
                    listModel.set(y, tmp.get(0));
                }
            }
        }
    }
    
    /**
     * Sorts books from the list model by those who are and aren't overdue by 10 days 
     */
    public void sortBy10Days()
    {
        DefaultListModel tmp = new DefaultListModel();
        
        for(int x = 0; x < listModel.size(); x++)
        {
            String[] a = listModel.get(x).toString().split(",");
            
            for(int y = 0; y < listModel.size(); y++)
            {
                String[] b = listModel.get(y).toString().split(",");
                
                if(Integer.parseInt(a[8].trim()) > Integer.parseInt(b[8].trim()) && a[1].equals(b[1]) != true)
                {
                    tmp.add(0, listModel.get(x));
                    listModel.set(x, listModel.get(y));
                    listModel.set(y, tmp.get(0));
                }
            }
        }
    }
    
    /**
     * Sorts books from the list model by days taken out
     */
    public void sortByMostPopular()//Sort books by days taken out
    {
        DefaultListModel tmp = new DefaultListModel();
        
        for(int x = 0; x < listModel.size(); x++)
        {
            String[] a = listModel.get(x).toString().split(",");
            
            for(int y = 0; y < listModel.size(); y++)
            {
                String[] b = listModel.get(y).toString().split(",");
                
                if(Integer.parseInt(a[8].trim()) > Integer.parseInt(b[8].trim()))
                {
                    tmp.add(0, listModel.get(x));
                    listModel.set(x, listModel.get(y));
                    listModel.set(y, tmp.get(0));
                }
            }
        }
    }
    
    /**
     * Sorts books from the list model by numeric value of their id
     */
    public void sortByID()
    {
        DefaultListModel tmp = new DefaultListModel();
        for(int z = 0; z < 4; z++)
        {
            for(int x = 0; x < listModel.size(); x++)
            {
                String[] a = listModel.get(x).toString().split(",");

                for(int y = x+1; y < listModel.size(); y++)
                {
                    String[] b = listModel.get(y).toString().split(",");

                    if(a[2].compareTo(b[2]) > 0 && a[1].equals(b[1]) != true)
                    {
                        tmp.add(0, listModel.get(y));
                        listModel.set(y, listModel.get(x));
                        listModel.set(x, tmp.get(0));
                    }
                }
            }  
        }
    }
    
    /**
     * prompts the user to enter a person's name who has borrowed a book, a pop up box will show the total fine(s) said person has gathered
     */
    public void seeFinesFromBorrower(String x)//See all fines related to a borrower. This can span multiple books
    {
        int i = 0;
        for(int y = 0; y < listModel.size(); y++)
        {
            String[] a = listModel.get(y).toString().split(",");//a[8]
            
            if(a[7].trim().equals(x))
            {
                i = (i + viewPenalty(y));
            }
        }
        JOptionPane.showConfirmDialog(null, "Total amount in Penaltys: $"+i, "Total Owed", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Takes a string and searches the list model for an id that matches, if one is found the books details will be displayed
     */
    public void searchByID(String x)
    {
        for(int y = 0; y < listModel.size(); y++)
        {
            String[] a = listModel.get(y).toString().split(",");//a[2]
            
            if(a[2].trim().equals(x))
            {
                JOptionPane.showConfirmDialog(null, listModel.get(y).toString(), "Book Found", JOptionPane.PLAIN_MESSAGE);
                break;
            }
        }
    }
    
    /**
     * Takes a string and searches the list model for an author's name that matches, if one is found the books details will be displayed
     */
    public void searchByAuthor(String x)
    {
        for(int y = 0; y < listModel.size(); y++)
        {
            String[] a = listModel.get(y).toString().split(",");//a[4]
            
            if(a[4].trim().equals(x))
            {
                JOptionPane.showConfirmDialog(null, listModel.get(y).toString(), "Book Found", JOptionPane.PLAIN_MESSAGE);
                break;
            }
        }
    }
    
    /**
     * Computes the total fine for the selected book type, returns an int
     */
    public int overAllSpecificFine()
    {
        int i = 0;
        JList list = new JList(new String[] {"Crime", "Drama"});
        JOptionPane.showMessageDialog(null, list, "Please select a book type", JOptionPane.PLAIN_MESSAGE);
        try
        {
            switch(Arrays.toString(list.getSelectedIndices()))
            {
                case"[0]"://Crime
                    for(int x = 0; x < listModel.size(); x++)
                    {
                        String[] a = listModel.get(x).toString().split(",");
                        
                        if(a[0].trim().equals("CRIME"))
                        {
                            i = (i + viewPenalty(x));
                        }
                    }
                    break;
                case"[1]"://Drama
                    for(int x = 0; x < listModel.size(); x++)
                    {
                        String[] a = listModel.get(x).toString().split(",");
                        
                        if(a[0].trim().equals("DRAMA"))
                        {
                            i = (i + viewPenalty(x));
                        }
                    }
                    break;
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showConfirmDialog(null, "an error occured, here's the error: "+e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
        
        return i;
    }
    
    /**
     * Computes the total fine for all book types, returns an int
     */
    public int overAllFine()
    {
        int i = 0;
        try
        {
            for(int x = 0; x < listModel.size(); x++)
            {
                i = (i + viewPenalty(x));
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showConfirmDialog(null, "an error occured, here's the error: "+e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
        
        return i;
    }
    
    /**
     * Sorts the listModel array by max revenue and then prints a pop up with the top three books
     */
    public void topThreeEarners()
    {
        try
        {
            sortByMaxRev();
            
            JOptionPane.showConfirmDialog(null, "The top three earners are: "+listModel.get(0).toString()+", "+listModel.get(1).toString()+", "+listModel.get(2).toString(), "Top three", JOptionPane.PLAIN_MESSAGE);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            
        }
    }
    
    /**
     * Exits the program with code (0)
     */
    public void quit()
    {
        System.exit(0);
    }
}
