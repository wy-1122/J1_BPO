function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}


$("top_panel_container").ready(function (){
   $.ajax({
       url:"/pages/front/selectSingleProject",
       type:"GET",
       data:{
           projectId:getQueryVariable("projectId")
       },
       contentType : "application/json",
       dataType:"json",
       success:function (json){
           var jsonStr = json;
           // console.log(jsonStr);
           var projectInfo = "";
           projectInfo += "     <div class = \"top-up-panel\">\n" +
               "                    <div class = \"top-left-panel\">\n" +
               "                        <ul class=\"breadcrumb\">\n" +
               "                            <li><a href=\"#\">工作台</a></li>\n" +
               "                            <li class=\"active\">项目</li>\n" +
               "                        </ul>\n" +
               "                        <p class = \"ProjectTitle\">" + jsonStr.projectName + "</p>\n" +
               "                        <div class=\"project-tips\">\n" +
               "                            <span class = \"project-tip\">" + jsonStr.projectType + "</span>\n" +
               "                            <span class=\"split\">|</span>\n" +
               "                            <span class = \"project-tip\">发布于 2020-11-10</span>\n" +
               "                            <span class=\"split\">|</span>\n" +
               "                            <span class = \"project-tip\">竞标要求：不限地域&nbsp;</span>\n" +
               "                            <span class=\"split\">|</span>\n" +
               "                            <span class = \"project-tip\">公开项目</span>\n" +
               "                        </div>\n" +
               "                    </div>\n" +
               "                    <div class = \"top-right-panel\">\n" +
               "                        <p class = \"ProjectState\">" + jsonStr.projectStatus + "</p>\n" +
               "                        <p class = \"ProjectMoney\">￥" + jsonStr.projectBudget + "</p>\n" +
               "                        <p class = \"PorojectDDL\">希望在 <span>" + jsonStr.projectPeriod + "</span> 天内完成</p>\n" +
               "                    </div>\n" +
               "                </div>\n" +
               "                <div class=\"top-down-panel\">\n" +
               "                    <ul class = \"operate-list\">\n" +
               "                        <li><a href=\"#\"><span>竞标</span></a></li>\n" +
               "                        <li><a href=\"#\"><span>详情</span></a></li>\n" +
               "                        <li><a href=\"#\"><span>修改</span></a></li>\n" +
               "                    </ul>\n" +
               "                </div>";
           $("#top_panel_container").html(projectInfo);
       },
       error:function (resp){
           console.log("666")
       }


   })
})

$("content").ready(function (){
    $.ajax({
        url:"/pages/front/selectBiddingSchemeByProject",
        type:"GET",
        data:{
            projectId:getQueryVariable("projectId")
        },
        contentType : "application/json",
        dataType:"json",
        success:function (json){
            var jsonStr = json;
            console.log(jsonStr);
            var biddingscheme = "";
            for(let index in jsonStr){
                if(jsonStr[index].biddingStatus == "竞标中"){
                    biddingscheme += "<div class = \"SchemeItem\">\n" +
                        "                <div class = \"SchemeItemState\">\n" +
                        "                    " + jsonStr[index].biddingStatus + "\n" +
                        "                </div>\n" +
                        "                <div class=\"SchemeItemIcon\">\n" +
                        "                    <div class=\"SchemeItemIconAvatar\">\n" +
                        "                        <a href=\"#\">\n" +
                        "                            <img src=\"/static/images/avatar_default.gif\">\n" +
                        "                        </a>\n" +
                        "                    </div>\n" +
                        "                    <p class=\"ShcemeItemGrade\">服务评价: <span>4.6</span></p>\n" +
                        "                </div>\n" +
                        "                <div class=\"SchemeItemPerson\">\n" +
                        "                    <p class = \"PersonName\">" + jsonStr[index].userEmployeeName + "</p>\n" +
                        "                    <p class = \"PseronInfo\">\n" +
                        "                        <span>手机" + jsonStr[index].userEmployeeTel + "</span> |\n" +
                        "                        <span>已完成 <span class = \"ProjectNum\">0</span> 个项目</span>\n" +
                        "                    </p>\n" +
                        "                    <p class = \"PersonSkills\">\n" +
                        "                        <a>查看更多</a>\n" +
                        "                    </p>\n" +
                        "                    <p class = \"SchemeTime\">\n" +
                        "                        竞标时间: <span>2020-11-13 11:18</span>\n" +
                        "                    </p>\n" +
                        "                </div>\n" +
                        "                <div class = \"SchemeItemProject\">\n" +
                        "                    <div class=\"SchemeItemBudgetTime\">\n" +
                        "                        <div class = \"ProjectInfo\">\n" +
                        "                            <p>￥" + jsonStr[index].projectAmout + "</p>\n" +
                        "                            <span>报价 ( 元 ) </span>\n" +
                        "                        </div>\n" +
                        "                        <div class = \"ProjectInfo\">\n" +
                        "                            <p>" + jsonStr[index].projectPeriod + "</p>\n" +
                        "                            <span>工期 ( 天 ) </span>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                    <a href = \"/pages/front/RedirectToBiddingDetail?userEmployeeId="+ jsonStr[index].userEmployeeId +"&projectId="+ jsonStr[index].projectId +"\"><button class=\"btn MoreInfo\">查看详情</button></a>\n" +
                        "                </div>\n" +
                        "            </div>"
                }
                else if(jsonStr[index].biddingStatus=="已拒绝"){
                    biddingscheme += "<div class = \"SchemeItem RejectedItem\">\n" +
                        "                <div class = \"SchemeItemState\">\n" +
                        "                    " + jsonStr[index].biddingStatus + "\n" +
                        "                </div>\n" +
                        "                <div class=\"SchemeItemIcon\">\n" +
                        "                    <div class=\"SchemeItemIconAvatar\">\n" +
                        "                        <a href=\"#\">\n" +
                        "                            <img src=\"/static/images/avatar_default.gif\">\n" +
                        "                        </a>\n" +
                        "                    </div>\n" +
                        "                    <p class=\"ShcemeItemGrade\">服务评价: <span>4.6</span></p>\n" +
                        "                </div>\n" +
                        "                <div class=\"SchemeItemPerson\">\n" +
                        "                    <p class = \"PersonName\">" + jsonStr[index].userEmployeeName + "</p>\n" +
                        "                    <p class = \"PseronInfo\">\n" +
                        "                        <span>手机" + jsonStr[index].userEmployeeTel + "</span> |\n" +
                        "                        <span>已完成 <span class = \"ProjectNum\">0</span> 个项目</span>\n" +
                        "                    </p>\n" +
                        "                    <p class = \"PersonSkills\">\n" +
                        "                        <a>查看更多</a>\n" +
                        "                    </p>\n" +
                        "                    <p class = \"SchemeTime\">\n" +
                        "                        竞标时间: <span>2020-11-13 11:18</span>\n" +
                        "                    </p>\n" +
                        "                </div>\n" +
                        "                <div class = \"SchemeItemProject\">\n" +
                        "                    <div class=\"SchemeItemBudgetTime\">\n" +
                        "                        <div class = \"ProjectInfo\">\n" +
                        "                            <p>￥" + jsonStr[index].projectAmout + "</p>\n" +
                        "                            <span>报价 ( 元 ) </span>\n" +
                        "                        </div>\n" +
                        "                        <div class = \"ProjectInfo\">\n" +
                        "                            <p>" + jsonStr[index].projectPeriod + "</p>\n" +
                        "                            <span>工期 ( 天 ) </span>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                    <a href = \"/pages/front/RedirectToBiddingDetail?userEmployeeId="+ jsonStr[index].userEmployeeId +"&projectId="+ jsonStr[index].projectId +"\"><button class=\"btn MoreInfo\">查看详情</button></a>\n" +
                        "                </div>\n" +
                        "            </div>"
                }



            }
            $("#content").html(biddingscheme);
        },
        error:function(resp){
            console.log("666");
        }

    })
})
