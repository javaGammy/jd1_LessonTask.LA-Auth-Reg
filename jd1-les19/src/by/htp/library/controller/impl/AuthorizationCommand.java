package by.htp.library.controller.impl;

import by.htp.library.bean.User;
import by.htp.library.controller.Command;
import by.htp.library.dao.UserDao;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;
import by.htp.library.service.UserService;

public class AuthorizationCommand implements Command{

	@String response = "";

	UserService service = ServiceProvider.getInstance().getUserService();
	// params[1]
	User user = new User();
	try {
		service.authorization(user.getLogin(), user.getPassword());
		response = "Registration successfully completed";
	} catch (ServiceException e) {
		// log
		response = "error";
	}
	

	return response;

}
