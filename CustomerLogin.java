package com.gqt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Customer;

public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer tempCustomer = new Customer();
		tempCustomer.setUsername(username);
		tempCustomer.setPassword(password);
		int status = tempCustomer.customerLogin();
		String name = tempCustomer.getName();
		System.out.println("Controller "+name);
		HttpSession session = request.getSession();
		session.setAttribute("sname", name);//String sname = name 
		session.setAttribute("susername", username);
		if(status == 1) {
			response.sendRedirect("/car-service-system/customerLoginSuccess.jsp");
		}
		else if(status == -1) {
			response.sendRedirect("/car-service-system/customerInvalidUsername.jsp");
		}
		else {
			response.sendRedirect("/car-service-system/customerInvalidPassword.jsp");
		}
	}
}
