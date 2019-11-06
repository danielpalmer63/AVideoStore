
package avideostore;

import java.util.Objects;

public class movie extends VideoStore
{
    private String title;
    private int copiesRemaining;

    @Override
    public String toString() 
    {
        return "Movie Title: " + title + " | Copies Remaining: " + copiesRemaining + "\n";
    }

    public movie(String title, int copiesRemaining) 
    {
        this.title = title;
        this.copiesRemaining = copiesRemaining;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.title);
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
        final movie other = (movie) obj;
        if (!Objects.equals(this.title, other.title)) 
        {
            return false;
        }
        return true;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public int getCopiesRemaining() 
    {
        return copiesRemaining;
    }

    public void setCopiesRemaining(int copiesRemaining) 
    {
        this.copiesRemaining = copiesRemaining;
    }
    
    
}
