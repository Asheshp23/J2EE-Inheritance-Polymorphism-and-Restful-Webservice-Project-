<%-- 
    Document   : insert
    Created on : 7-Mar-2019, 11:03:40 PM
    Author     : asheshpatel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="Insert" method="post">



            Name:<input type="text" name="name"> 
            </br>

          
            Address: <input type="text" name="address"> 
            </br>

            
            email : <input type="text" name="email"> 
            </br>
            
            phone: <input type="text" name="phone"> 
            </br>
            
            <input type="submit" name="insert" value="insert"> 
            </br>

        </form>


    </body>
</html>
