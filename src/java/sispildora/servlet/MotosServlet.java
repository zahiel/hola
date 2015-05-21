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
import sispildora.entidades.Motos;
import sispildora.negocio.MotosN;

/**
 *
 * @author Usuario
 */
public class MotosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String modulo = "./FMotos.jsp";
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        String m1 = "";
       
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        
        String placa = request.getParameter("txtplaca");
        String cod_cliente = request.getParameter("txtcod_cliente");
        String marca = request.getParameter("txtmarca");
        String color = request.getParameter("txtcolor");
        String kilometraje = request.getParameter("txtkilometraje");
        String modelo = request.getParameter("txtmodelo");
        String boton = request.getParameter("action");
        request.setAttribute("listado1", null);
        request.setAttribute("datomoto", null);
        MotosN mn= new MotosN();
        
        
        if ("nuevo".equals(request.getParameter("action"))) {
            try {
                m1 = "Respuesta boton del servlet: "+boton;
        
            } catch (Exception e2) {
            }
        }//fin boton nuevo
         
        
        if ("guardar".equals(request.getParameter("action"))) {
            try {
           
                mn.getInsertarMotos(new Motos( placa,  cod_cliente,  marca,  color, kilometraje, modelo));
                  request.setAttribute("listado1", mn.ListadoMotos("cod_cliente",cod_cliente));
           
            } catch (Exception e2) {
                m1= e2.getMessage();
            }
        }//fin boton guardar
        
        
        if ("actualizar".equals(request.getParameter("action"))) {
            try {
                m1 = "Respuesta boton del servlet: "+boton;
        
            } catch (Exception e2) {
            }
        }//fin boton actualizar
        
        
        if ("modificar".equals(request.getParameter("action"))) {
            try {
                m1 = "Respuesta boton del servlet: "+boton;
     
            } catch (Exception e2) {
            }
        }//fin boton modificar
        
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
            request.setAttribute("datomoto", mn.getMotos("placa",placa));
                request.setAttribute("listado1", mn.ListadoMotos("placa",placa));
            } catch (Exception e) {
            m1=""+e.getMessage();
            }
        }//fin boton buscar---- regresamos a FMotos.jsp
        
        
        if ("mostrar".equals(request.getParameter("action"))) {
            try {
            request.setAttribute("listado1", mn.ListadoMotos("cod_cliente",cod_cliente));
            } catch (Exception e) {
            m1=""+e.getMessage();
            }
        }//fin boton mostrar

        
         if ("bloquear".equals(request.getParameter("action"))) {
            try {
                m1 = "Respuesta boton del servlet: "+ boton;
          
            } catch (Exception e2) {
            }
        }//fin boton bloquear
         
        request.setAttribute("mensajes", m1);
      
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
           
    

    
   
