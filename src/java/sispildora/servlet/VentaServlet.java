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
import sispildora.entidades.Producto;
import sispildora.entidades.Venta;
import sispildora.entidades.Venta_detalle;
import sispildora.negocio.ClientesN;
import sispildora.negocio.ProductoN;
import sispildora.negocio.VentaN;
import sispildora.utilidades.Utilidades;

/**
 *
 * @author Usuario
 */
public class VentaServlet extends HttpServlet {

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
        String modulo = "./FVentas.jsp";
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        String men = "";
        String usuario = request.getParameter("txtusuario");
        String cod_cliente = request.getParameter("txtcod_cliente");
        
        ClientesN cn=new ClientesN();
        Venta entVen = new Venta();
        VentaN vn=new VentaN();
        ProductoN pn= new ProductoN();
        Producto entPro = new Producto();
        
         
        request.setAttribute("mensajes", null);
        request.setAttribute("datoventa", null);
        request.setAttribute("listadoproducto", null);
        request.setAttribute("listadodetalle", null);
        
        
        String nrofactura = request.getParameter("txtnrofactura");
        String idecliente = request.getParameter("txtidecliente");
        String subtotal = request.getParameter("txtsubtotal");
        String iva = request.getParameter("txtiva");
        String tipo = request.getParameter("txttipo");
        String cantidad = request.getParameter("txtcantidad");
        String valor = "";
        String codpro = request.getParameter("cboproducto");


        
        
           
        if ("init".equals(request.getParameter("action"))) {
            try {
            entVen.setNrofactura(vn.getConsecutivo());//generar consecutivo
            entVen.setFecha(Utilidades.getFecha());
            entVen.setIdecliente("");
             entVen.setUsuario(usuario);
             entVen.setSubtotal("0");
             entVen.setIva("0");
             entVen.setTipo("Pendiente");
             request.setAttribute("datoventa", entVen);
             
              
            } catch (Exception e2) {
            }
            try {
             request.setAttribute("listadoproducto", pn.ListadoProducto());
            
              
            } catch (Exception e2) {
            }
            try {
              request.setAttribute("listadodetalle",vn.ListadoVenta_detalle());
              
            } catch (Exception e2) {
            }
            
            
            
            
        }//fin boton nuevo
        
          if ("guardardetalle".equals(request.getParameter("action"))) {
             
               try {
        // public Venta_detalle(String nrofactura, String codprod, String cantidad, String valor, String iva){
             entPro= pn.getProducto(codpro);
           
              } catch (Exception e2) {
                    men += e2.getMessage();
             }
             
              
              try {
        // public Venta_detalle(String nrofactura, String codprod, String cantidad, String valor, String iva){
             valor = entPro.getValor();
             iva =  ""+ 16/100;
              vn.InsertarVentaDetalle(new Venta_detalle(nrofactura,codpro,cantidad,valor,iva  ));
              } catch (Exception e2) {
                  men += e2.getMessage();
             }
                    
              
              
              try {
                entVen.setNrofactura(vn.getConsecutivo());//generar consecutivo
                entVen.setFecha(Utilidades.getFecha());
                entVen.setIdecliente("");
                entVen.setUsuario(usuario);
                entVen.setSubtotal("0");
                entVen.setIva("0");
                entVen.setTipo("Pendiente");
                request.setAttribute("datoventa", entVen);


            } catch (Exception e2) {
            }
            try {
             request.setAttribute("listadoproducto", pn.ListadoProducto());
            
              
            } catch (Exception e2) {
            }
                     
              try {
                request.setAttribute("listadodetalle",vn.ListadoVenta_detalle());
            
              
            } catch (Exception e2) {
            }
            
            
        }//fin boton nuevo
        
        
        
        
       request.setAttribute("mensajes", men);
      request.getRequestDispatcher(pagina).forward(request, response);
    }

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
