package com.pixelcircle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PixelCircle")
public class PixelCircleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Pixel Circle</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<canvas id='canvas' width='500' height='500'></canvas>");
        response.getWriter().println("<script>");
        response.getWriter().println("var canvas = document.getElementById('canvas');");
        response.getWriter().println("var ctx = canvas.getContext('2d');");
        response.getWriter().println("var angle = 0;");
        response.getWriter().println("function drawCircle() {");
        response.getWriter().println("  ctx.clearRect(0, 0, canvas.width, canvas.height);");
        response.getWriter().println("  var x = 250 + 100 * Math.cos(angle);");
        response.getWriter().println("  var y = 250 + 100 * Math.sin(angle);");
        response.getWriter().println("  ctx.beginPath();");
        response.getWriter().println("  ctx.arc(x, y, 5, 0, Math.PI * 2, true);");
        response.getWriter().println("  ctx.fill();");
        response.getWriter().println("  angle += 0.05;");
        response.getWriter().println("  requestAnimationFrame(drawCircle);");
        response.getWriter().println("}");
        response.getWriter().println("drawCircle();");
        response.getWriter().println("</script>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
