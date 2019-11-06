
package avideostore;

import java.util.Objects;

public class customer extends VideoStore
{
    private String customerID;
    private String firstName;
    private String lastName;
    private double acctBalance;

    @Override
    public String toString() 
    {
        return "Customer ID#:" + customerID + " | First Name: " + firstName + " | Last Name: " + lastName + " | Account Balance: " + acctBalance + "\n";
    }
    
    public customer(String customerID, String firstName, String lastName, double acctBalance) 
    {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.acctBalance = acctBalance;
    }

    @Override
    public int hashCode() 
    {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.customerID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final customer other = (customer) obj;
        if (!Objects.equals(this.customerID, other.customerID)) 
        {
            return false;
        }
        return true;
    }

    public String getCustomerID() 
    {
        return customerID;
    }

    public void setCustomerID(String customerID) 
    {
        this.customerID = customerID;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public double getAcctBalance() 
    {
        return acctBalance;
    }

    public void setAcctBalance(double acctBalance) 
    {
        this.acctBalance = acctBalance;
    }
    
    
    
    
}
