$("detail").ready(function (){
    $.ajax({
        url:"/pages/back/findUserEmployerById",
        type:"GET",
        data:"",
        contentType : "application/json",
        dataType:"json",
        success:function (json){
            var jsonStr = json;
            console.log(jsonStr);
            var content = "";
            content += "<table class = \"table DetailTable\">\n" +
                "                    <tr><td class = \"col-sm-4 TableItemName\">昵称：</td><td>"+ jsonStr.userEmployerName +"</td></tr>\n" +
                "                    <tr><td class = \"col-sm-4 TableItemName\">所在地：</td><td>"+ jsonStr.userEmployerRegion +"</td></tr>\n" +
                "                    <tr><td class = \"col-sm-4 TableItemName\">个人介绍：</td><td>" + jsonStr.userEmployerInctroduction + "</td></tr>\n" +
                "                    <tr><td class = \"col-sm-4 TableItemName\">电话：</td><td>"+ jsonStr.userEmployerTel +"</td></tr>\n" +
                "                </table>";
            $("#content").html(content);
        }
    })
})
