package szz.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/1/22
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置相应的消息体数据格式以及编码
        response.setContentType("text/html;charset=utf-8");
        // 获取所有的cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false; //没有cookie叫lastTime
        // 遍历所有的cookie
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 获取cookie的名称
                String name = cookie.getName();
                // 判断cookie 的名称是否为 lastTime
                if ("lastTime".equals(name)) {
                    flag = true;

                    // 并刷新这个cookie的值为当前的时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    System.out.println(str_date); // url编码前
                    // URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println(str_date);//编码后

                    // 设置cookie存活时间为一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    cookie.setValue(str_date);
                    response.addCookie(cookie);

                    // 如果存在lastTime的cookie就输出现在这个cookie的值
                    // 响应数据
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1> 欢迎回来，您上次访问的时间是 " + value + "</h1>");
                    break;


                }
            }
        }
        if (cookies == null || cookies.length == 0 || !flag) {
            // 第一次访问
            // 并刷新这个cookie的值为当前的时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);

            System.out.println(str_date); // url编码前
            // URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println(str_date);//编码后

            Cookie cookie = new Cookie("lastTime", str_date);
            // 设置cookie存活时间为一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);
            cookie.setValue(str_date);
            response.addCookie(cookie);

            // 响应数据
            response.getWriter().write("<h1>欢迎您首次访问</h1> ");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
