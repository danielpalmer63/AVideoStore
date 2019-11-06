
package avideostore;

public class AVideoStore 
{

    public static void main(String[] args) 
    {
        VideoStore store = new VideoStore();
       
        store.addMovie("Avatar", 100);
        store.addMovie("The Collapse of the IST 242 Empire Vol: 2", 5);
        store.addMovie("4 Mile", 10);
        
        store.addCustomer("502889", "Jack", "Black", 10.56);
        store.addCustomer("123456", "Adam", "West", 89.45);
        
        store.addRental("The Collapse of the IST 242 Empire Vol: 2", "123456");
        store.addRental("4 Mile", "123456"); 
        
        store.showAll();
    }    
}
