package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BranchesAPI
 */
@WebServlet("/BranchesAPI")
public class BranchesAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Branch brObj = new Branch();
    public BranchesAPI() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = brObj.insertBranch(request.getParameter("branchID"), 
				 request.getParameter("branchName"), 
				request.getParameter("branchAddress"), 
				request.getParameter("branchContact"),
		        request.getParameter("branchEmail"));
				response.getWriter().write(output); 
	}
	
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
	 for (String param : params)
	 { 
	 String[] p = param.split("=");
	 map.put(p[0], p[1]);
	 }
	 }
	catch (Exception e)
	 {
	 }
	return map;
	}

	
//		private static Map getParasMap(HttpServletRequest request)
//		{
//			Map<String, String> map = new HashMap<String, String>();
//			try
//			{
//				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
//				String queryString = scanner.hasNext() ?
//						scanner.useDelimiter("\\A").next() : "";
//				scanner.close();
//				
//				String[] params = queryString.split("&");
//				for (String param : params)
//				{ 
//					String[] p = param.split("=");
//					map.put(p[0], p[1]);
//				}
//			}
//			
//			catch (Exception e)
//			{
//			}
//			
//			return map;
//		}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = brObj.updateBranch(paras.get("branchID").toString(),
										   paras.get("branchName").toString(),
										   paras.get("branchAddress").toString(),
										   paras.get("branchContact").toString(),
										   paras.get("branchEmail").toString());
			                               response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = brObj.deleteBranch(paras.get("branchID").toString());
		response.getWriter().write(output);
	}

}
