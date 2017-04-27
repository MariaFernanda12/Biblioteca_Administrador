package Controlador;

import DAO.DaoElementos;
import Modelo.Elemento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Modificar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String etiqueta = request.getParameter("etiqueta");
        String cantidad = request.getParameter("cantidad");
        String ubicacion = request.getParameter("ubicacion");
        String estado = request.getParameter("estado");
        DaoElementos daoElm = new DaoElementos();
        boolean resultado
                = daoElm.modificarElemento(Integer.parseInt(cantidad), estado, ubicacion, Integer.parseInt(etiqueta));
        if (resultado == false) {
            request.setAttribute("Modificar", "OK");
        } else {
            request.setAttribute("Modificar", "NOK");
        }
        //3. RequestDispacher
        RequestDispatcher rd = request.getRequestDispatcher("Modificar.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
