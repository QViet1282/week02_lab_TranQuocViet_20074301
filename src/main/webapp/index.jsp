<%@ page import="vn.edu.iuh.fit.backend.models.Product" %>
<%@ page import="java.awt.*" %>
<%@ page import="vn.edu.iuh.fit.backend.services.ProductServices" %>
<%@ page import="com.sun.jna.platform.win32.Advapi32Util" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Danh sach san pham" %></h1>
<br/>


<%
//    List<Product> data = (List<Product>) request.getAttribute("dataProduct");
    ProductServices productServices = new ProductServices();
    List<Product> data = productServices.getAll();
    for (Product pro : data) { %>

<h3><%= pro.getName() %></h3>
<h3><%= pro.getDescription() %></h3>
<%--    <td><%= pro. %></td>--%>
    <%--                <td>--%>
    <%--                    <form action="/control" method="post">--%>
    <%--                        <input type="hidden" name="id" value="<%= account.getAccount_id() %>">--%>
    <%--                        <input type="hidden" name="action" value="update">--%>
    <%--                        <button type="submit">Update</button>--%>
    <%--                    </form>--%>
    <%--                </td>--%>

<% } %>
</body>
</html>