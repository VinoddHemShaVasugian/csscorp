/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Framework.BSROException;
import model.DBMock;
import model.EntryPoint;

/**
 *
 * @author Amala
 */
public class ProcessDataServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws Exception 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        String result = null;
        String flag = request.getParameter("flag");
        DBMock dbmock = new DBMock();        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(flag.equalsIgnoreCase("1"))
        {
            result = dbmock.getProjectNames();
            out.print(result);
        }
        else if(flag.equalsIgnoreCase("2"))
        {
            String projectName = request.getParameter("selectedProject");
            result = dbmock.getProjectDetails(projectName);
            out.print(result);
        }
        else if(flag.equalsIgnoreCase("3"))
        {
            String selectedProjectDetails = request.getParameter("selectedProjectDetails");
            dbmock.runProjects(selectedProjectDetails);
            Object[] args={null,null};
            EntryPoint qwer =new EntryPoint();   
            qwer.testMain(args);
        }
        
    }

  

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
