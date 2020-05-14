package szz.cookie;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/1/21
 */
@javax.servlet.annotation.WebServlet("/CookieDemo5")
public class CookieDemo5 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 创建cookie对象
        Cookie c1 = new Cookie("msg", "哈哈");
        // 设置cookie的存活时间
//        c1.setMaxAge(30);// 将cookie持久化到硬盘，30s后会自动删除cookie文件
//        c1.setMaxAge(-1);// 默认值，当浏览器关闭后会自动删除
//        c1.setMaxAge(0);// 删除cookie

        // 设置path, 让当前服务器下部署的所有项目共享cookie信息
        c1.setPath("/");

        // 发送cookie
        response.addCookie(c1);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
