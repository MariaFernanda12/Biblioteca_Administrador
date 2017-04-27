package Controlador;

import DAO.DaoPrestamo;
import Modelo.HistorialPrestamos;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarPrestamos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<HistorialPrestamos> lista = null;
            //1. Crear instancia del DAO
            DaoPrestamo daoPr = new DaoPrestamo();
            //Lista todos los elementos.
            lista = daoPr.listarHistorial();
            //2. Envio de los datos por el request.
            request.setAttribute("Prestamo", lista);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("HistorialPrestamos.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ListarPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
