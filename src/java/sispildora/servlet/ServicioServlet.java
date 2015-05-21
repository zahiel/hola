/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sispildora.negocio.ServicioN;

/**
 *
 * @author Usuario
 */
public class ServicioServlet extends HttpServlet {
private String se;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
   
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FServicio.jsp";
        String pagina = "FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        String m = "";
        String d = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        
        String cod_servicio = request.getParameter("txtcod_servicio");
        String cod_producto = request.getParameter("txtcod_producto");
        String placa = request.getParameter("txttplaca");
        String fecha = request.getParameter("txtfecha");
        String valor = request.getParameter("txtvalor");
        String boton = request.getParameter("action");
        request.setAttribute("listado", null);
        request.setAttribute("datoservicio", null);
        
        ServicioN sn= new ServicioN();
 
        

        
        if ("guardar".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+boton;
                d = "cod_servicio:"+ cod_servicio;
            } catch (Exception e) {
            }
        }//fin boton guardar
        
        
        if ("actualizar".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+boton;
                d = "cod_servicio:"+ cod_servicio;
            } catch (Exception e) {
            }
        }//fin boton actualizar
            

        request.setAttribute("mensajes", m);
        request.setAttribute("datos", d);
        request.getRequestDispatcher(pagina).forward(request, response);
      
    }//fin metodo processRequest

                     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

//catch-controla y captura errores
        //IOException clase que permite controlar errores de entrada y salida
        //PrintWriter-imprime o escribe..Responce- entrega respuesta..
      //PrintWriter out=responce- da una respuesta  y la imprime en pantalla.
      