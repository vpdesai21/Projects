package com.ecommerce.service.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.ecommerce.bean.User;
import com.ecommerce.bean.UserCredentials;
import com.ecommerce.constants.Constants;
import com.ecommerce.dao.users.UserDao;
import com.ecommerce.util.EncryptionUtil;

@Path("/users")
public class UserService {

	@GET
	@Path("/verifyLoggedIn")
	@Produces(MediaType.TEXT_HTML)
	public String verifyLoggedIn(@Context HttpServletRequest req  ) {
		
		HttpSession sess = req.getSession();
		String isLoggedIn = (String)sess.getAttribute(Constants.IS_LOGGED_IN);
		
		if(isLoggedIn!=null && isLoggedIn.equalsIgnoreCase(Constants.YES))
			return Constants.YES;
		
		return Constants.NO;
	}
	
	
	@POST
	@Path("/authenticate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User isAuthentic(UserCredentials credentials, 
							@Context HttpServletRequest req) {
		UserDao userDao = new UserDao();
		String encryptedPassword = EncryptionUtil.sha256Hex(credentials.getPassword());
		User user = userDao.isAuthentic(credentials.getUsername(), encryptedPassword);
		
		if(user != null) {
			req.getSession().setAttribute(Constants.IS_LOGGED_IN, Constants.YES);
			return user;
		} else {
			req.getSession().setAttribute(Constants.IS_LOGGED_IN, Constants.NO);
		}
			
		return user;
	}
	
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String signup(User user, 
							@Context HttpServletRequest req) {
		UserDao userDao = new UserDao();
		String encryptedPassword = EncryptionUtil.sha256Hex(user.getPassword());
		boolean successSignUp = userDao.signup(user.getUsername(), encryptedPassword, user.getFirstname(), user.getLastname(), user.getDob());
		if(successSignUp)
			return Constants.SUCCESS;
		else
			return Constants.FAILURE;
	}

}
