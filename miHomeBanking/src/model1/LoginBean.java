package model1;

	public class LoginBean 
	{
	  public boolean login(String userName, String password) 
	  {
	    if (userName==null || password==null || !(userName.equals("aibo") && password.equals("kitada")))
	      return false;
	    else
	      return true;
	  }
	} 
