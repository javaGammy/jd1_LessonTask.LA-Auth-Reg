package by.htp.library.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.UserDao;

public class FileUserDao implements UserDao{
	
	@Override
	public boolean authorization(String login, String password) {		
		File file = new File("C:\\Users\\chernyak\\Desktop\\jd1-les19\\src\\resources\\users.txt");

		List<String> list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
		
		String firstUser = list.get(0);
		String secondUser = list.get(2);
		
		String[] firstUserSplit;
		String[] secondUserSplit;
		
		firstUserSplit = firstUser.split(" ", 4);
		secondUserSplit = secondUser.split(" ", 4);		
		
		String[] firstUserLoginSplit;
		String[] firstUserPasswordSplit;
		
		String[] secondUserLoginSplit;
		String[] secondUserPasswordSplit;
		
		firstUserLoginSplit = firstUserSplit[1].split("=", 2);	
		firstUserPasswordSplit = firstUserSplit[2].split("=", 2);
		
		secondUserLoginSplit = secondUserSplit[1].split("=", 2);
		secondUserPasswordSplit = secondUserSplit[2].split("=", 2);
		
		if (login.equals(firstUserLoginSplit[1]) && password.equals(firstUserPasswordSplit[1])) {
			return true;
		}
		
		if (login.equals(secondUserLoginSplit[1]) || password.equals(secondUserPasswordSplit[1])) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean registration(User newUser) throws DaoException{
		try {
			FileWriter writer = new FileWriter("");
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return false;
	}

	@Override
	public boolean changeUserStatus(int idUser, String newStatus) {
		// TODO Auto-generated method stub
		return false;
	}

}
