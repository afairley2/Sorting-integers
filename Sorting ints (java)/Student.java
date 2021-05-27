


 /****************
 * really simple Student class
 * will need to update later!
 *
 ****************/
    public class Student implements Comparable<Student>
    {
        private Integer id ;
        private String fname ;
        private String lname ;
        
        public int getId() 
        {
			return id;
		}

		public void setId(int id) 
		{
			this.id = id;
		}

		public String getFname() 
		{
			return fname;
		}

		public void setFname(String fname) 
		{
			this.fname = fname;
		}

		public String getLname() 
		{
			return lname;
		}

		public void setLname(String lname) 
		{
			this.lname = lname;
		}

		public int compareTo(Student other)
        {

            int compare = this.lname.compareTo(other.lname);
            if (compare == 0)
            {
                compare = this.fname.compareTo(other.fname);
                if (compare ==0)
                    compare = this.id.compareTo(other.id);
            }
                
            return compare;
        }
		
		public boolean equals(Object other)
		{
			if (other == null)
			   {
			      return false;
			   }

			   if (this.getClass() != other.getClass())
			   {
			      return false;
			   }

			   if (this.getId() != ((Student)other).getId())
			   {
			      return false;
			   }

			   if (!this.getFname().equals(((Student)other).getFname()))
			   {
			      return false;
			   }
			   if (!this.getLname().equals(((Student)other).getLname()))
			   {
			      return false;
			   }

			   return true;
		}
		public int hashCode() 
		{  
			
		    return this.toString().hashCode();  
		} 

        public Student(int n,String f,String l)
        {
            id = n;
            fname = f;
            lname = l;
        }

        public  String toString()
        {
            String strout = "ID: " + id + " " + fname + " " + lname;
            return strout;
        }

        
    }
