package Controlador;

import DAO.DaoElementos;
import DAO.DaoPrestamo;
import Modelo.Elemento;
import Modelo.ModeloPazSalvo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PazSalvo extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<ModeloPazSalvo> lista = null;
        //1. Crear instancia del DAO
        DaoPrestamo daoPr = new DaoPrestamo();
        //Lista todos los elementos.
        lista = daoPr.listarUsuariosNoPazSalvo();
        //2. Envio de los datos por el request.
        request.setAttribute("Paz", lista);
        //3. RequestDispacher
        RequestDispatcher rd = request.getRequestDispatcher("PazSalvo.jsp");
        rd.forward(request, response);
    }




}
