package com.scu.bpo.controller.pages.front;

import com.scu.bpo.pojo.entity.Project;
import com.scu.bpo.pojo.entity.User;
import com.scu.bpo.pojo.entity.UserEmployer;
import com.scu.bpo.pojo.vo.ProjectInList;
import com.scu.bpo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pages/back")
public class UserEmployerController {
    @Resource
    ProjectService projectService;
    @Resource
    UserService userService;
    @Resource
    UserRoleService userRoleService;
    @Resource
    UserEmployerService userEmployerService;
    @Resource
    ClientSupportService clientSupportService;
    @Resource
    ProjectTypeService projectTypeService;

    @RequestMapping("/findEmployerInfo")
    @ResponseBody
    public UserEmployer findEmployerInfo(Integer projectId){
        //通过projectId查询employerId
        Integer employerId = projectService.selectProjectByKey(projectId).getUserEmployerId();
//        System.out.println(employerId);
        //通过employerId查询发包方信息
        UserEmployer userEmployer = userEmployerService.findEmployer(employerId);
        return userEmployer;
    }
    @RequestMapping("/findEmployerProjectInfo")
    @ResponseBody
    public List<ProjectInList> findEmployerProjectInfo(HttpSession session){
        List<ProjectInList> projectInLists = new ArrayList<ProjectInList>();
        //从session中获取用户id
        String userName = (String) session.getAttribute("userName");
        User user = userService.findUser(userName);
        Integer userId = user.getUserId();
        //通过userId查询查询userEmployerId得到项目信息
        Integer userEmployerId2 = userRoleService.findUserRoleEmployer(userId).getUserRoleId();
        List<Project> projectList = projectService.selectProjectByUserEmployerId(userEmployerId2);

        for(int i = 0; i<projectList.size(); i++){
            //新建projectInList对象
            ProjectInList projectInList = new ProjectInList();

            //将发包方ID转换为发包方名称
            //获取当前project中的UserEmployerId
            Integer userEmployerId = projectList.get(i).getUserEmployerId();
            String userEmployerName = userEmployerService.findEmployer(userEmployerId).getUserEmployerName();

            projectInList.setUserEmployerName(userEmployerName);
            //将设备id转化为设备名称
            String equipmentId = projectList.get(i).getEquipmentId();
            String[] equipmentIds = equipmentId.split("/");
            String equipmentName = "";
            for(int j = 0;j < equipmentIds.length -1 ;j++){
                Integer integer = new Integer(equipmentIds[j]);
                equipmentName += clientSupportService.getEquipmentName(integer)+"/";
            }
            Integer integer = new Integer(equipmentIds[equipmentIds.length-1]);
            equipmentName += clientSupportService.getEquipmentName(integer);

            projectInList.setEquipmentName(equipmentName);
            //获取项目类型
            Integer projectTypeId = projectList.get(i).getProjectTypeId();
            String projectTypeName = projectTypeService.findProjectTypeName(projectTypeId);
            projectInList.setProjectType(projectTypeName);

            //插入无需转换内容
            projectInList.setProjectId(projectList.get(i).getProjectId());
            projectInList.setProjectAdminId(projectList.get(i).getProjectAdminId());
            projectInList.setProjectName(projectList.get(i).getProjectName());
            projectInList.setSkillsRequirement(projectList.get(i).getSkillsRequirement());
            projectInList.setProjectRequirement(projectList.get(i).getProjectRequirement());
            projectInList.setProjectPeriod(projectList.get(i).getProjectPeriod());
            projectInList.setProjectBudget(projectList.get(i).getProjectBudget());
            projectInList.setProjectStatus(projectList.get(i).getProjectStatus());
            projectInList.setConnectName(projectList.get(i).getConnectName());
            projectInList.setConnectTel(projectList.get(i).getConnectTel());

            projectInLists.add(projectInList);
        }

        return projectInLists;
    }
    //转到项目竞标方案详情
    @RequestMapping("/EmployerProjectDetail")
    public String RedirectToEmployerProjectDetail(Integer projectId){
        return "pages/front/bpo_employer/BiddingScheme";
    }
    //通过用户id查找发包人信息
    @RequestMapping("/findUserEmployerById")
    @ResponseBody
    public UserEmployer findUserEmployerInfo(HttpSession session){
        String userName =(String) session.getAttribute("userName");
        Integer userId = userService.findUser(userName).getUserId();
        Integer userEmployerId = userRoleService.findUserRoleEmployer(userId).getUserRoleId();
        UserEmployer userEmployer = userEmployerService.findEmployer(userEmployerId);
        return userEmployer;
    }

}
