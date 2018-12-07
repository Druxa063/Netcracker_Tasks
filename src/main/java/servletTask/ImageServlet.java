package servletTask;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        try (OutputStream out = response.getOutputStream()) {
            Random random = new Random();
            BufferedImage im = new BufferedImage(640, 120, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = im.getGraphics();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            graphics.setColor(new Color(r, g, b));
            graphics.setFont(new Font("Arial", Font.BOLD, 72));
            graphics.drawString("Hello World!", 100, 100);
            ImageIO.write(im, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
