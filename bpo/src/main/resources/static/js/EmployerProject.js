$("content").ready(function (){
    $.ajax({
        url:"/pages/back/findEmployerProjectInfo",
        type:"GET",
        data:"",
        contentType : "application/json",
        dataType:"json",
        success:function (json){
            var jsonStr = json;
            console.log(jsonStr);
            console.log(jsonStr[0].projectStatus);
            var prj = "";
            for(let index in jsonStr){
                prj += "<div class = \"SchemeItem\">\n" +
                    "                    <div class = \"SchemeItemState\" id=\"projectStatus\">\n" +
                    "                        "+ jsonStr[index].projectStatus +" \n" +
                    "                    </div>\n" +
                    "                    <div class=\"SchemeItemIcon\">\n" +
                    "                        <div class=\"SchemeItemIconAvatar\">\n" +
                    "                            <a href=\"#\">\n" +
                    "                                <img src=\"/static/images/avatar_default.gif\">\n" +
                    "                            </a>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"SchemeItemPerson\">\n" +
                    "                        <p class = \"PersonName\"><a href=\"/pages/back/EmployerProjectDetail?projectId="+ jsonStr[index].projectId +"\" style=\"text-decoration: none;color: black\">" + jsonStr[index].projectName + "</a></p>\n" +
                    "                        <p class = \"SchemeTime\">\n" +
                    "                            发布时间: <span>2020-11-13 11:18</span>\n" +
                    "                        </p>\n" +
                    "                    </div>\n" +
                    "                    <div class = \"SchemeItemProject\">\n" +
                    "                        <div class=\"SchemeItemBudgetTime\">\n" +
                    "                            <div class = \"ProjectInfo\">\n" +
                    "                                <p>" + jsonStr[index].projectBudget + "</p>\n" +
                    "                                <span>报价 ( 元 ) </span>\n" +
                    "                            </div>\n" +
                    "                            <div class = \"ProjectInfo\">\n" +
                    "                                <p>" + jsonStr[index].projectPeriod +  "</p>\n" +
                    "                                <span>工期 ( 天 ) </span>\n" +
                    "                            </div>\n" +
                    "                        </div>\n";

                if (jsonStr[index].projectStatus == "已通过")
                    prj += "                        <a href=\"/pages/back/EmployerProjectDetail?projectId=" +jsonStr[index].projectId +"\"><button class=\"btn MoreInfo\">查看详情</button></a>\n";

                prj += "                    </div>\n" +
                        "                </div>";
            }
            $("#content").html(prj);
            prj="";
        },
        error:function (resp){
            console.log("666")
        }

    })
})
