package szz.cookie;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/1/21
 */
@javax.servlet.annotation.WebServlet("/CookieDemo3")
public class CookieDemo3 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 创建cookie对象
        Cookie c1 = new Cookie("msg", "hello");
        Cookie c2 = new Cookie("name", "zhangsan");
        // 发送cookie,可以同时创建和发送多个cookie
        response.addCookie(c1);
        response.addCookie(c2);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
