package pe.edu.utp;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;


/**
 * Created by GrupoUTP on 21/05/2016.
 */
@WebServlet(name = "ListaServlet",urlPatterns = "/Lista")
public class ListaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/plain");
        PrintWriter out = null;
        out = response.getWriter();
        response.setContentType("text/html");
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
            Connection con = ds.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            if (rs != null){
                out.println("<link href=../bootstrap/css/bootstrap.min.css rel=stylesheet>");
                out.println("<link rel=stylesheet href=https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css integrity=sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7 crossorigin=anonymous>");
                out.println("<link rel=stylesheet href=https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css integrity=sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r crossorigin=anonymous>");
                out.println("<script src=https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js integrity=sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS crossorigin=anonymous></script>");
                out.println("<table class=table >");
                out.println("<th>Apellido Paterno<th>Apellido Materno<th>Nombre(s)<th>Sexo<th>Edad<th>Categoria");
                while (rs.next()){
                    out.println("<tr><td>");
                    out.println(rs.getString("ApPaterno"));
                    out.println("</td><td>");
                    out.println(rs.getString("ApMaterno"));
                    out.println("</td><td>");
                    out.println(rs.getString("Nombre"));
                    out.println("</td><td>");
                    out.println(rs.getString("Sexo"));
                    out.println("</td><td>");
                    out.println(rs.getInt("Edad"));
                    out.println("</td><td>");
                    out.println(rs.getString("Categoria"));
                    out.println("</td></tr>");
                }
                out.println(rs.getString("<a href=index.jsp>Regresar</a>"));
                out.println("</table>");
            }

        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (NamingException e2) {
            e2.printStackTrace();
        }
    }
}