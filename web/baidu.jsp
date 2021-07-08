<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>百度一下</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>

    <script type="text/javascript">
        $(function () {

            $("#search").keyup(function () {
                var searchContent = $("#search").val();
                $("#search-content").html("");
                if(searchContent != null && searchContent != "") {


                    $.post("SearchServlet",{"searchContent":searchContent} , function (msg) {
                        console.log(msg);
                        $.each(msg, function (index, ele) {
                            $("#search-content").append("<div>" + ele.sName + "</div>");

                        })
                    }, "json")
                }
            });
        });
    </script>
</head>
<body>

<div id="content">
    <input type="text" name="search" id="search"><button id="btn">百度一下</button>
    <br>
    <div id="search-content">

    </div>
</div>

</body>
</html>
