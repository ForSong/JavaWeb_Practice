package szz.cookie;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/1/21
 */
@javax.servlet.annotation.WebServlet("/CookieDemo1")
public class CookieDemo1 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 创建cookie对象
        Cookie c = new Cookie("msg", "hello");
        // 发送cookie
        response.addCookie(c);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
