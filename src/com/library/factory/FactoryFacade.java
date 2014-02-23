package com.library.factory;

import com.library.database.MySqlDatabaseAccess;
import com.library.interfaces.ILibrayDataAccess;

public class FactoryFacade {
	
	public static ILibrayDataAccess getDataAccessObject() {
		return new MySqlDatabaseAccess();
	}
}
