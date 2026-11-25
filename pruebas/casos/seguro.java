public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setInt(1, id);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        response.sendRedirect("/inicio");
    }
}
