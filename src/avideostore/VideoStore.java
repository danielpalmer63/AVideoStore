
package avideostore;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
public class VideoStore 
{
    HashSet<movie> movies = new HashSet();
    HashSet<customer> customers = new HashSet();
    HashMap<customer, movie> custWithRent = new HashMap();
    
    public void addMovie(String title, int copiesRemaining)
    {
        movies.add(new movie(title, copiesRemaining));
    }
    
    public void updateMovie(String title, int copiesRemaining)
    {
        Iterator findMovie = movies.iterator();
        movie tempMovieForSearch = new movie(title, copiesRemaining);
        while (findMovie.hasNext())
        {
            movie foundMov = (movie)findMovie.next();
            if (foundMov.equals(tempMovieForSearch))
            {
                movies.remove(foundMov);
                movies.add(tempMovieForSearch);
                break;
            }
        }       
    }
    
    public void addCustomer(String customerID, String firstName, String lastName, double acctBalance)
    {
        customers.add(new customer(customerID, firstName, lastName, acctBalance));
    }
    
    public void updateCustomer(String customerID, String firstName, String lastName, double acctBalance)
    {
        Iterator findCust = customers.iterator();
        customer tempCustForSearch = new customer(customerID, firstName, lastName, acctBalance);
        while (findCust.hasNext())
        {
            customer foundCust = (customer)findCust.next();
            if (foundCust.equals(tempCustForSearch))
            {
                customers.remove(foundCust);
                customers.add(tempCustForSearch);
                break;
            }
        }
    }
    
    public boolean addRental(String title, String customerID)
    {
        movie tempMovieForSearch = new movie(title, 0);
        customer tempCustomerForSearch = new customer(customerID, "", "", 0);
        
        Iterator movIt = movies.iterator();
        Iterator custIt = customers.iterator();
        
        boolean movVer = false;
        boolean custVer = false;
        
        movie foundMov = null;
        customer foundCust = null;
        
        while(movIt.hasNext())
        {
            foundMov = (movie)movIt.next();
            if(foundMov.equals(tempMovieForSearch) && foundMov.getCopiesRemaining() > 0)
            {
                movVer = true;
                updateMovie(foundMov.getTitle(), (foundMov.getCopiesRemaining() - 1));
                break;
            }
            else
            {
                movVer = false;
            }           
        }
        
        while(custIt.hasNext())
        {
            foundCust = (customer)custIt.next();
            if(foundCust.equals(tempCustomerForSearch))
            {
                custVer = true;
                break;
            }
            else
            {
                custVer = false;
            }
        }
            
        if (movVer == true && custVer == true)
        {
            custWithRent.put(foundCust, foundMov);
            return true;
        }        
        else
        {
            System.out.println("ERROR: This movie or customer ID does not exist");
            return false;
        }
    }
    
    public void showAll()
    {
        Iterator printIterMov = movies.iterator();
        Iterator printIterCust = customers.iterator();
        
        System.out.println("------MOVIES------");
        
        while(printIterMov.hasNext())
        {
            System.out.println(movies.toString().replaceAll(", |\\[|\\]", ""));
            break;
        }
        
        System.out.println("------CUSTOMERS------");
        
        while(printIterCust.hasNext())
        {       
            System.out.println(customers.toString().replaceAll(", |\\[|\\]", ""));
            break;
        }
        
        System.out.println("------RENTALS------");
        
        for (HashMap.Entry<customer, movie> entry: custWithRent.entrySet())
        {
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }       
    }    
}
