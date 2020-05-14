<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: songzhizhuo
  Date: 2020/1/27
  Time: 10:38 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homepage</title>
</head>
<body>
<%
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
                out.write("<h1> 欢迎回来，您上次访问的时间是 " + value + "</h1>");
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
        out.write("<h1>欢迎您首次访问</h1> ");

    }

%>
</body>
</html>
