// This class is used to keep track of the prepaid shipment subscription labels, 
// which have the following labels: type, iD, day, month. 
//
public class Label 
{
	//Attributes declaration
	private String type;
	private int iD;
	private int day;
	private int month;	

//Default constructor 
public Label()
{
	this.type = "";
	this.iD = 98000000; // default ID starting with 98
	this.day = 0;
	this.month = 0;
	
}

//Constructor with 4 parameters
public Label(String type, int iD, int day, int month)
{
	this.type = type;
	this.iD = iD;
	
	// Validate day and month
	this.day = ((day >=1 && day <= 31) ? day : 0);
	this.month = ((month >=1 && month <= 12) ? month : 0);
}

//Copy constructor with Label type parameter
public Label(Label other)
{
	this.type = other.type;
	this.iD = other.iD;
	this.day = other.day;
	this.month = other.month;
	
}

//Accessor methods for attributes
public String getType()
{
	return type;
}

public int getID()
{
	return iD;
}

public int getDay()
{
	return day;
}

public int getmonth()
{
	return month;
}


//Mutator method for attributes
public void setDay(int day)
{
	this.day = (day >= 1 && day <= 31 ? day: 0);
}

public void setMonth(int month)
{
	this.month = (month >= 1 && month <= 12 ? month: 0);
}


//toString() method
public String toString()
{
        return (type + " - " + iD + " - " +
               (day < 10 ? "0" : "") + day + "/" +
               (month < 10 ? "0" : "") + month);
}

//equals() method
public boolean equals(Object obj)
{
	if(this == obj)
	return true;
	
	if((obj == null) || getClass() != obj.getClass())
	return false;
	
	
	Label other = (Label) obj;
	
	return (iD == other.iD &&
            day == other.day &&
            month == other.month &&
            type.equals(other.type));

	
}



}

