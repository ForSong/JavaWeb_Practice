package szz.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/1/27
 */
@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用session共享数据

        // 1. 获取session
        HttpSession session = request.getSession();
        // 2. 期望在客户端关闭后，session也能相同,
        // 根据session的原理，可以知道，只需要设置一个Cookie，让cookie中保留session的信息即可
        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60 * 60);
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
