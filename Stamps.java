// This class is used to keep track of the number of stamps used.
// The parcel stamp type are from one of these categories:
//  category_A($2), category_B($5), category_C($10), category_D ($15), category_E ($20).
//

public class Stamps 
{
	
		//Stamps constant price
		public final int CATEGORY_A = 2;
		public final int CATEGORY_B = 5;
		public final int CATEGORY_C = 10;
		public final int CATEGORY_D = 15;
		public final int CATEGORY_E = 20;
		
		
		//Stamps count by category
		private int categoryA;
		private int categoryB;
		private int categoryC;
		private int categoryD;
		private int categoryE;

//Default constructor
public Stamps()
{
	    
		this.categoryA = 0;
		this.categoryB = 0;
		this.categoryC = 0;
		this.categoryD = 0;
		this.categoryE = 0;
}

//Constructor with 5 integer parameters
public Stamps(int categoryA, int categoryB, int categoryC, int categoryD, int categoryE)
{
		this.categoryA = categoryA;
		this.categoryB = categoryB;
		this.categoryC = categoryC;
		this.categoryD = categoryD;
		this.categoryE = categoryE;
			
}

//Copy constructor with one parameter of type Stamps
public Stamps(Stamps other)
{
		this.categoryA = other.categoryA;
		this.categoryB = other.categoryB;
		this.categoryC = other.categoryC;
		this.categoryD = other.categoryD;
		this.categoryE = other.categoryE;
}

//Accessor methods fof all attributes
public int getCategoryA()
{
	return categoryA;
}

public int getCategoryB()
{
	return categoryB;
}

public int getCategoryC()
{
	return categoryC;
}
public int getCategoryD()
{
	return categoryD;
}
public int getCategoryE()
{
	return categoryE;
}

//Mutator methods for all attributes
public void setCategoryA(int categoryA) 
{
	this.categoryA = categoryA;
}

public void setCategoryB(int categoryB) 
{
	this.categoryB = categoryB;
}

public void setCategoryC(int categoryC) 
{
	this.categoryC = categoryC;
}

public void setCategoryD(int categoryD) 
{
	this.categoryD = categoryD;
}

public void setCategoryE(int categoryE) 
{
	this.categoryE = categoryE;
}

//Add Stamps() method
public void addStamps(int categoryA, int categoryB, int categoryC, int categoryD, int categoryE)
{
	this.categoryA += categoryA;
	this.categoryB += categoryB;
	this.categoryC += categoryC;
	this.categoryD += categoryD;
	this.categoryE += categoryE;
	
}

//StampsTotal() method
public int stampsTotal()
{
	return((categoryA*CATEGORY_A + categoryB*CATEGORY_B + categoryC*CATEGORY_C +
			categoryD*CATEGORY_D + categoryE*CATEGORY_E));
}

//ToString() method
public String toString()
{
        return categoryA + " x $2 + " + categoryB + " x $5 + " +
               categoryC + " x $10 + " + categoryD + " x $15 + " +
               categoryE + " x $20";

}

//equals method to compare two Stamps objects
public boolean equals(Object obj) 
{
    if (this == obj) 
    return true;
    if (obj == null || getClass() != obj.getClass()) 
    return false;
    Stamps other = (Stamps) obj;
    return categoryA == other.categoryA &&
           categoryB == other.categoryB &&
           categoryC == other.categoryC &&
           categoryD == other.categoryD &&
           categoryE == other.categoryE;



}
	
}
