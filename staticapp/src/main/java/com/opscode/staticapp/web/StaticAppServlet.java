package com.opscode.staticapp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticAppServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static Logger logger = Logger.getLogger(StaticAppServlet.class.getName());

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    // parse the limit param off of the request
    int n = 10;
    String count = request.getParameter("n");
    if (count != null) {
      try {
        n = Integer.parseInt(count);
      } catch (NumberFormatException ignore) {
      }
    }

    // redirect to the JSP for display
    getServletConfig().getServletContext()
        .getRequestDispatcher("/WEB-INF/jsp/results.jsp").forward(request, response);

  }

}
