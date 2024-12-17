package com.pixelcircle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PixelCircle")
public class PixelCircleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("""
            <!DOCTYPE html>
            <html lang='en'>
            <head>
                <meta charset='UTF-8'>
                <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                <title>Pixel Circle Animation</title>
                <style>
                    body {
                        margin: 0;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        background-color: #f0f0f0;
                        overflow: hidden;
                    }
                    #canvas {
                        border: 1px solid black;
                    }
                </style>
            </head>
            <body>
                <canvas id='canvas' width='400' height='400'></canvas>
                <script>
                    const canvas = document.getElementById('canvas');
                    const ctx = canvas.getContext('2d');

                    let angle = 0;
                    const radius = 100;
                    const centerX = canvas.width / 2;
                    const centerY = canvas.height / 2;

                    function drawPixel(x, y) {
                        ctx.fillStyle = 'red';
                        ctx.fillRect(x, y, 5, 5);
                    }

                    function animate() {
                        ctx.clearRect(0, 0, canvas.width, canvas.height);

                        const x = centerX + radius * Math.cos(angle);
                        const y = centerY + radius * Math.sin(angle);

                        drawPixel(x, y);

                        angle += 0.05; // Increment angle for animation
                        requestAnimationFrame(animate);
                    }

                    animate();
                </script>
            </body>
            </html>
        """);
    }
}