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

const projectId = getQueryVariable("projectId");
const userEmployeeId = getQueryVariable("userEmployeeId");

$("main").ready(function (){
    $.ajax({
        url:"/pages/front/selectBiddingDetailByProjectIdAndEmployeeId",
        type:"GET",
        data:{
            projectId:projectId,
            userEmployeeId:userEmployeeId
        },
        contentType : "application/json",
        dataType:"json",
        success:function (json){
            var jsonStr = json;

            var mainContent = "";
            mainContent += " <p style=\"font-size: 25px; font-weight: 600;\" id=\"projectName\">竞标的项目的名称</p> " +
                "            <div class=\"AreaDiv\">\n" +
                "                <p class = \"AreaTitle\">*工期与预算</p>\n" +
                "                <div id = \"BudgetPeriod\">\n" +
                "                    <p id = \"Period\">工期：<span>" + jsonStr.projectPeriod + "天</span></p>\n" +
                "                    <p id = \"Budget\">预算金额：￥<span>"+ jsonStr.projectAmout +"</span></p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <dic class=\"AreaDiv\">\n" +
                "                <div class=\"AreaTitle\">*竞标优势</div>\n" +
                "                <p class = \"Text\">\n" +
                "                    " + jsonStr.projectSuperiority + "\n" +
                "                </p>\n" +
                "            </dic>\n" +
                "            <dic class=\"AreaDiv\">\n" +
                "                <div class=\"AreaTitle\">*竞标案例</div>\n" +
                "                <p class = \"Text\">\n" +
                "                    " + jsonStr.biddingExample +"\n" +
                "                </p>\n" +
                "            </dic>\n" +
                "            <div class=\"AreaDiv\">\n" +
                "                <p class = \"AreaTitle\">*联系方式</p>\n" +
                "                <div style=\"display: flex;\">\n" +
                "                    <p style=\"flex:1; margin-right: 20px;\">联系人: <span>"+ jsonStr.userEmployeeName +"</span></p>\n" +
                "                    <p style=\"flex:1; margin-left: 20px;\">电话: <span>" + jsonStr.userEmployeeTel + "</span></p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div id = \"SubmitButton\">\n" +
                "                <a href = \"/pages/front/CreateOrder?projectId="+projectId+"&userEmployeeId="+userEmployeeId+"&orderAmount="+jsonStr.projectAmout+"&schedule="+jsonStr.projectPeriod+"\">\n"+
                "                    <button class=\"btn btn-primary btn-block\">确定选择该竞标方案</button>\n" +
                "                </a>\n" +
                "                <a href=\"/pages/back/EmployerProjectDetail?projectId="+projectId+"\"><button class=\"btn btn-primary btn-block ReturnPage\">返回</button></a>\n" +
                "            </div>"
            $("#main").html(mainContent);
        },
        error:function (resp){
            console.log("666")
        }

    })
})
$("projectName").ready(function (){
    $.ajax({
        url: "/pages/front/selectSingleProject",
        type:"GET",
        data:{
            projectId:getQueryVariable("projectId"),
        },
        contentType : "application/json",
        dataType:"json",
        success:function (json){
            var jsonStr = json;
            $("#projectName").html(jsonStr.projectName);
        }
    })
})

