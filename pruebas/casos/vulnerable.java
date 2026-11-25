public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        Runtime.getRuntime().exec("sh -c echo " + nombre);
        Statement st = conn.createStatement();
        st.executeQuery("SELECT * FROM users WHERE name = '" + nombre + "'");
        response.getWriter().println(request.getParameter("bio"));
        new FileInputStream("/datos/" + nombre);
        response.sendRedirect(request.getParameter("next"));
        ObjectInputStream ois = new ObjectInputStream(request.getInputStream());
        MessageDigest md = MessageDigest.getInstance("MD5");
        String q = String.format("SELECT * FROM t WHERE id = %s", nombre);
    }
}
