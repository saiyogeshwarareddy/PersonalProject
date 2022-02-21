package com.sai.handler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sai.dao.UserDao;
import com.sai.bean.UserBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserHandler
 */
public class UserHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/user.jsp";
	private static String Edit = "/edit.jsp";
	private static String UserRecord = "/listUser.jsp";
	private UserDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserHandler() {
		super();
		dao = new UserDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirect = "";
		String uId = request.getParameter("userid");
		String action = request.getParameter("action");
		if (!((uId) == null) && action.equalsIgnoreCase("insert")) 
		{
			int id = Integer.parseInt(uId);
			UserBean user = new UserBean();
			user.setId(id);
			user.setfName(request.getParameter("firstName"));
			user.setlName(request.getParameter("lastName"));
			user.setdob(request.getParameter("dob"));
			user.setgender(request.getParameter("gender"));
			user.setaddress(request.getParameter("address"));
			dao.addUser(user);
			redirect = UserRecord;
			request.setAttribute("users", dao.getAllUsers());
			System.out.println("Record Added Successfully");
		} 
		else if (action.equalsIgnoreCase("delete")) 
		{
			String userId = request.getParameter("userId");
			int uid = Integer.parseInt(userId);
			dao.removeUser(uid);
			redirect = UserRecord;
			request.setAttribute("users", dao.getAllUsers());
			System.out.println("Record Deleted Successfully");
		} 
		else if (action.equalsIgnoreCase("editform")) 
		{
			redirect = Edit;
		} 
		else if (action.equalsIgnoreCase("edit")) 
		{
			String userId = request.getParameter("userId");
			int uid = Integer.parseInt(userId);
			UserBean user = new UserBean();
			user.setId(uid);
			user.setfName(request.getParameter("firstName"));
			user.setlName(request.getParameter("lastName"));
			user.setdob(request.getParameter("dob"));
			user.setgender(request.getParameter("gender"));
			user.setaddress(request.getParameter("address"));
			dao.editUser(user);
			request.setAttribute("user", user);
			redirect = UserRecord;
			System.out.println("Record updated Successfully");
		} 
		else if (action.equalsIgnoreCase("listUser")) {
			redirect = UserRecord;
			request.setAttribute("users", dao.getAllUsers());
		} 
		else 
		{
			redirect = INSERT;
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
