// This class is used as a Registry that contains Stamps and Labels, which are 
// represented by an object of type Stamps and an array of objects of type Labels.

public class Registry 
{
	
	//Attributes declaration
	private Stamps stamps;
	private Label[] labels;
	
	//Default constructor
	public Registry()
	{
		this.stamps = new Stamps();
		this.labels = null;
	
	}
	
	//Constructor with two parameters 
	public Registry(Stamps stamps, Label[] labels)
	{
		this.stamps = new Stamps(stamps);
			if (labels != null)
			{
				this.labels = new Label[labels.length];
					for (int count = 0; count < labels.length; count++)
					{
						this.labels[count] = new Label(labels[count]);
					}
			}
			else
			{
				labels = null;
			
			}
			
	}		
			
	//Method for comparison of value (in $) of stamps of two objections of Registry class
	public boolean equalStampsValue(Registry other)
	{
		return (this.stamps.stampsTotal() == other.stamps.stampsTotal());	
	}
	
	/*Method to compare the number of each stamps category of two registry object 
	(ie. check if the numbers are equal)*/
	public boolean equalStampsCategories(Registry other)
	{
		
		return(this.stamps.equals(other.stamps));
	}
	
	//Method to determine value of shipment stamps of Registry
	public int StampValueTotal()
	{
		
		return(this.stamps.stampsTotal());
	}
	
	//Method that returns Registry's number of labels
	public int numberOfLabels()
	{
		return ((labels==null) ? 0: labels.length);
	}
	
	//Method that adds new label to Registry
	public int addLabel(Label newLabel)
	{
		if(labels == null)
		{
			labels = new Label[1];
			labels[0] = new Label(newLabel);
			
      	}
		else 
		{
			Label[] newLabels = new Label[labels.length + 1];
				for(int count = 0; count < labels.length; count++)
				{
					newLabels[count] = labels[count];
				}
				
			newLabels[labels.length] = new Label(newLabel);
			labels = newLabels;
			
		}
		return(labels.length);
		
	}
	
	//Method for label removal from Registry
	public boolean removeLabel(Label labelRemove)
	{
		if(labels == null || labels.length == 0)
		{
		return(false);
		}
		int indexRemove = -1;
		for(int count = 0; count < labels.length; count++)
		{	
			if(labels[count].equals(labelRemove))
	        {
				indexRemove = count; 
				break;
	        }
		}
		
		if(indexRemove == -1)
		{
		return(false);
		}
		
	Label[] newLabels = new Label[labels.length -1];
	int newIndex = 0;
	for (int count = 0; count < labels.length; count++)
	{
		if(count != indexRemove)
		{
			newLabels[newIndex++] = labels[count];
			
		}
	}
	
	labels = newLabels;

	return(true);
	}
	
	
	//Method for update of expiry day and expiry month of label
	public boolean updateExpiryLabel(Label labelUpdate, int newDay, int newMonth)
	{
		if(labels == null || labels.length == 0)
		{
			return (false);
		}
		
		for (int count = 0; count < labels.length; count++)
		{
			if(labels[count].equals(labelUpdate))
			{
				labels[count].setDay(newDay);
				labels[count].setMonth(newMonth);
				return(true);
			}
			
		}
		return(false);	
		}
	
	//Method for addition of stamps shipment to Registry
	public int addStamps(int cat1, int cat2, int cat3, int cat4, int cat5)
	{
		stamps.addStamps(cat1, cat2, cat3, cat4, cat5);
		return(stamps.stampsTotal());
		
	}
	
	//Equals() Method for Registry
	public boolean equals(Object obj)
	{
	   if(this == obj)
	   return(true);
	   
	   if(obj == null || getClass() != obj.getClass())
	   return(false);
	   
	   Registry other = (Registry) obj;
	   return(this.stamps.stampsTotal() == other.stamps.stampsTotal() 
			   && this.numberOfLabels() == other.numberOfLabels());
			   		  
	}
	
	//toString() Method for Registry
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append(stamps.toString()).append("\n");
		if(labels == null || labels.length == 0)
		{
			result.append("No labels");
		}
		else
		{
			for(int count = 0; count < labels.length; count++)
			{
				result.append(labels[count].toString()).append("\n");
			}
			
		}
		return result.toString();
	}
	
	// getLabels method to return the labels array
    public Label[] getLabels() 
    {
        return labels;
    }
    
    // Get object Stamps
    public Stamps getStamps() 
    {
        return this.stamps;
    }
	
}
