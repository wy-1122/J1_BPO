$(document).ready(function(){
    $(".TypeDiv").click(function () {
        $(".TypeDiv").each(function () {
            $(this).removeClass("SelectedType");
        });
        $(this).addClass("SelectedType");
    })

    $(".SelectGroup li").click(function () {
        $(this).toggleClass("SelectedSkill");
        let str = $("[name='skillsRequirement']").val();
        if (str == ""){
            $("[name='skillsRequirement']").val($(this).text());
        } else{
            let strs = str.split(","),flag = 0,value = "";
            for (let t in strs){
                if (strs[t] == $(this).text()){
                    flag = 1;
                }
                else {
                    if (value == "") value = strs[t];
                    else value += "," + strs[t];
                }
            }
            if (!flag) value += "," + $(this).text()
            $("[name='skillsRequirement']").val(value);
        }
    });

    $("#dropdownMenu1").click(function () {
        $("#SkillMenu").toggle();
    })
})