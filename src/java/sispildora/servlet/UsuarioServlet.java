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
import sispildora.entidades.Usuario;
import sispildora.negocio.UsuarioN;

/**
 *
 * @author Usuario
 */
public class UsuarioServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
   
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FUsuario.jsp";
        String pagina = "FPrincipal.jsp";
        
        String m = "";
        String d = "";
        
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        
        String user = request.getParameter("txtusuario");
        String nombre = request.getParameter("txtnombre");
        String clave = request.getParameter("txtclave");
        String perfil = request.getParameter("cboperfil");
        String estado = request.getParameter("cboestado");
        String mail =request.getParameter("txtmail");
        String boton = request.getParameter("action");
        request.setAttribute("listado", null);
        request.setAttribute("datousuario", null);
        request.setAttribute("targetModulo", modulo);
        request.setAttribute("edicion", "");
        UsuarioN un= new UsuarioN();
        
        
        if ("nuevo".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+boton;
                d = "Nombre:"+ nombre;
                request.setAttribute("edicion", "");
            } catch (Exception e) {
            }
        }//fin boton nuevo
        
        
        if ("guardar".equals(request.getParameter("action"))) {
            try {
                un.getInsertarUsuario(new Usuario(user,nombre,clave,perfil,estado,mail));
                request.setAttribute("listado", un.ListadoUsuario());
                request.setAttribute("edicion", "");
            } catch (Exception e) {
                m=""+e.getMessage();
            }
        }//fin boton guardar --regresamos a FUsuario.jsp
        
        
        if ("actualizar".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+boton;
                d = "Nombre:"+ nombre;
            } catch (Exception e) {
                
            }
        }//fin boton actualizar ---
        
        
        if ("modificar".equals(request.getParameter("action"))) {
            
            try {
                un.getActualizarUsuario(new Usuario(user,nombre,clave,perfil,estado,mail));
                request.setAttribute("listado", un.ListadoUsuario());
                request.setAttribute("edicion", "readonly");
            } catch (Exception e) {
                m=""+e.getMessage();
            }
        }//fin boton modificar
        
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
            request.setAttribute("datousuario", un.getUsuario(user));
            request.setAttribute("edicion", "readonly");
            //regresamos a Fusuario.jsp
            } catch (Exception e) {
            m=""+e.getMessage();
            }
        }//fin boton buscar---- regresamos a FUsuario.jsp
        
        
        if ("mostrar".equals(request.getParameter("action"))) {
            try {
            request.setAttribute("listado", un.ListadoUsuario());
            request.setAttribute("edicion", "");
            } catch (Exception e) {
            m=""+e.getMessage();
            }
        }//fin boton mostrar

        
         if ("bloquear".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta boton del servlet: "+ boton;
                d = "Nombre:"+ nombre;
                request.setAttribute("edicion", "");
            } catch (Exception e) {
            }
        }//fin boton bloquear
         
          if("salir".equals(request.getParameter("action"))){
            request.getSession().invalidate();
          //  request.setAttribute("target", null);
           request.setAttribute("targetModulo", "./FLoginBox.jsp");  
           request.getRequestDispatcher("./index.jsp").forward(request, response);
        }
    
      if("blanco".equals(request.getParameter("action"))){
            request.getSession().invalidate();
          //  request.setAttribute("target", null);
           request.setAttribute("targetModulo", "./FBlanco.jsp");  
           request.getRequestDispatcher("./index.jsp").forward(request, response);
        }
      
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
      