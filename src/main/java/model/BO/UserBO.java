package model.BO;

import model.DAO.*;

import java.util.ArrayList;

import model.Bean.*;

public class UserBO {
	
	public static boolean addUser(Admin admin) {
		
		// TODO Auto-generated method stub
		return UserDAO.addUser(admin);
	}
	
	public static Admin getAdminByLogin(String username, String password) {
		return UserDAO.getAdminByLogin(username, password);
	}
}
