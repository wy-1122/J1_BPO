$(document).ready(function(){

    const images = document.getElementsByClassName("BackgroundImage");
    var ImgIndex = 0,ImgNum = 1;

    document.getElementById("MainDiv").addEventListener('mousemove',(e) => {
        let width = $("#BackgroundImage" + ImgIndex).width() - window.innerWidth;
        let percentageX = (e.clientX - window.innerWidth / 2) / window.innerWidth;
        let offsetX = width * percentageX;

        let height = $("#BackgroundImage" + ImgIndex).height() - window.innerHeight;
        let percentageY = (e.clientY - window.innerHeight / 2) / window.innerHeight;
        let offsetY = height * percentageY;

        document.getElementById("Background").style.setProperty('--offsetX',`${offsetX}px`);
        document.getElementById("Background").style.setProperty('--offsetY',`${offsetY}px`);
    });

    $("#ProjectType a").click(function(){
        $("#ProjectType a").each(function (){
            // $(this).css("background", "transparent");
            $(this).removeClass("ItemSelected");
        });
        $(this).addClass("ItemSelected");
        // $(this).css("background","rgba(220,139,20,0.5)");
    });

    $("#MoneySelect a").click(function(){
        $("#MoneySelect a").each(function (){
            // $(this).css("background", "transparent");
            $(this).removeClass("ItemSelected");
        });
        // $(this).css("background","rgba(220,139,20,0.5)");
        $(this).addClass("ItemSelected");
    });
    $("#project_list").ready(function(){
        $.ajax({
            url:"/pages/front/selectTopFiveProject",
            type:"GET",
            data:"",
            contentType : "application/json",
            dataType:"json",
            success: function (json){
                let jsonStr = json;
                var prj = "";
                console.log(jsonStr);
                console.log("888");


                for(let index in jsonStr){

                    //打印网页
                    prj += "                <div class=\"project-list\" id=\"project_list\">\n" +
                        "                    <!--项目块-->\n" +
                        "                    <div class=\"contain-for-project\">\n" +
                        "                        <div class=\"project\">\n" +
                        "                            <!--名称+金额-->\n" +
                        "                            <div class=\"projectNameAndMoney\">\n" +
                        "                                <!--名称-->\n" +
                        "                                <div class=\"project-name\"><a id=\"project_name\" href=\"/pages/front/redirectToDetail?projectId=" + jsonStr[index].projectId + "\">" + jsonStr[index].projectName + "</a></div>\n" +
                        "                                <!--金额-->\n" +
                        "                                <div class=\"project-money\"><a href=\"#\">" + jsonStr[index].projectBudget + "</a></div>\n" +
                        "                            </div>\n" +
                        "                            <!--各种类型-->\n" +
                        "                            <div class=\"project-detail\">\n" +
                        "                                <ul>\n" +
                        "                                    <li><a href=\"#\">项目</a></li>\n" +
                        "                                    <li><a href=\"#\">" + jsonStr[index].projectType + "</a></li>\n" +
                        "                                    <li><a href=\"#\">" + jsonStr[index].projectPeriod + "天</a></li>\n" +
                        "                                </ul>\n" +
                        "                            </div>\n" +
                        "                            <!--技能要求、发布时间-->\n" +
                        "                            <div class=\"skill-requirement\">\n" +
                        "                                <div class=\"skill\"><a href=\"#\">技能要求:" + jsonStr[index].skillsRequirement + "</a></div>\n" +
                        "\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </div>";

                }
                $("#project_list").html(prj);
                prj="";
            },
            error:function(resp){
                // $.message.alert('出错了','系统出错，请联系管理员','error');
                console.log("666");
            }
        })
    })

});



