
public final class Student implements Comparable<Student>
{
	private int schoolID;
	private String name;

	public Student(String namePassed,int schoolIDPassed)
	{
		schoolID= schoolIDPassed;
		name= namePassed;
	}

	public int getSchoolID()
	{
		return schoolID;
	}

	public void setSchoolID(int schoolIDPassed)
	{
		schoolID=schoolIDPassed;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String namePassed)
	{
		name=namePassed;
	}

	public boolean equals(Object toCompare)
	{
	  if(toCompare instanceof Student)
	  {
	    Student temp= (Student) toCompare;
	    return(temp.getSchoolID()==schoolID);
	  }
	  return false;
	}
	
	public int compareTo(Student toCompare)
	{
	  //TODO 1B: Implement compareTo such that we return 1 if the current object student ID is greater than toCompare's, -1 if the current object student ID is less toCompare's school ID and finally, 0  if they are equal
  if( schoolID> toCompare.getSchoolID()){
            return 1;
        }
        else if(schoolID< toCompare.getSchoolID()){
            return -1;
        }
        return 0;
	}
	
	public String toString()
	{
	  String toReturn="name: "+name+" id: "+schoolID;
	  return (toReturn);
	}
	
	 @Override
    public int hashCode() 
    { 
      
      //TODO 1A: Override  Hash Code and Implement Such That it Returns the Student ID
      return this.schoolID;

    } 

}