package com.scu.bpo.controller.pages.front;

import com.scu.bpo.pojo.entity.*;
import com.scu.bpo.pojo.vo.ProjectInList;
import com.scu.bpo.service.*;

//import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pages/front")
public class ProjectController {
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

    @RequestMapping("/addNewProject")
    public String addNewProject(Integer projectTypeId,
                                HttpServletRequest request,
                                String projectName,
                                String projectRequirement,
                                String skillsRequirement,
                                int projectPeriod,
                                String projectBudget,
                                String connectTel,
                                String connectName,
                                Model model) {
        //获取适配客户端id
        String[] values = request.getParameterValues("equipmentId");
        //获取用户id
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        User user = userService.findUser(userName);
        Integer userId = user.getUserId();
        //查找用户角色id，此处为找到发包方id
        UserRole userRole = userRoleService.findUserRoleEmployer(userId);
        Integer userEmployerId = (Integer) session.getAttribute("userEmployerId");
        //处理客户端id
        String tmpEquipmentId = "";
        for (int i = 0; i < values.length - 1; i++) {
            tmpEquipmentId += values[i] + "/";
        }
        tmpEquipmentId += values[values.length - 1];

        //处理工期
        String projectPeriodString = Integer.toString(projectPeriod);

        //添加到project
        Project project = new Project();
        project.setProjectTypeId(projectTypeId);
        project.setUserEmployerId(userEmployerId);
        project.setEquipmentId(tmpEquipmentId);
        project.setProjectName(projectName);
        project.setProjectRequirement(projectRequirement);
        project.setSkillsRequirement(skillsRequirement);
        project.setProjectPeriod(projectPeriodString);
        project.setProjectBudget(projectBudget);
        project.setConnectTel(connectTel);
        project.setConnectName(connectName);
        project.setProjectStatus("未审核");
        boolean flag = projectService.addNewProject(project);
        if (flag == true) {
            model.addAttribute("successMsg", "插入成功");
            return "redirect:/listPage";
        }
        return null;
    }

    @RequestMapping("/selectTopFiveProject")
    @ResponseBody
    public List<ProjectInList> selectTopProject() {
        List<Project> projectList = projectService.selectPassedProject();
        //要返回一个带有id转换为详细名称的类型，这里用entity里的ProjectInList类型存储
        List<ProjectInList> projectInLists = new ArrayList<ProjectInList>();
        for (int i = 0; i < projectList.size(); i++) {
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
            for (int j = 0; j < equipmentIds.length - 1; j++) {
                Integer integer = new Integer(equipmentIds[j]);
                equipmentName += clientSupportService.getEquipmentName(integer) + "/";
            }
            Integer integer = new Integer(equipmentIds[equipmentIds.length - 1]);
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

    //查询单个项目信息
    @RequestMapping("/selectSingleProject")
    @ResponseBody
    public ProjectInList selectSingleProject(Integer projectId) {
        Project project = projectService.selectProjectByKey(projectId);

        ProjectInList projectInList = new ProjectInList();

        //将发包方ID转换为发包方名称
        //获取当前project中的UserEmployerId
        Integer userEmployerId = project.getUserEmployerId();
        String userEmployerName = userEmployerService.findEmployer(userEmployerId).getUserEmployerName();

        projectInList.setUserEmployerName(userEmployerName);
        //将设备id转化为设备名称
        String equipmentId = project.getEquipmentId();
        String[] equipmentIds = equipmentId.split("/");
        String equipmentName = "";
        for (int j = 0; j < equipmentIds.length - 1; j++) {
            Integer integer = new Integer(equipmentIds[j]);
            equipmentName += clientSupportService.getEquipmentName(integer) + "/";
        }
        Integer integer = new Integer(equipmentIds[equipmentIds.length - 1]);
        equipmentName += clientSupportService.getEquipmentName(integer);

        projectInList.setEquipmentName(equipmentName);
        //获取项目类型
        Integer projectTypeId = project.getProjectTypeId();
        String projectTypeName = projectTypeService.findProjectTypeName(projectTypeId);
        projectInList.setProjectType(projectTypeName);

        //插入无需转换内容
        projectInList.setProjectId(project.getProjectId());
        projectInList.setProjectAdminId(project.getProjectAdminId());
        projectInList.setProjectName(project.getProjectName());
        projectInList.setSkillsRequirement(project.getSkillsRequirement());
        projectInList.setProjectRequirement(project.getProjectRequirement());
        projectInList.setProjectPeriod(project.getProjectPeriod());
        projectInList.setProjectBudget(project.getProjectBudget());
        projectInList.setProjectStatus(project.getProjectStatus());
        projectInList.setConnectName(project.getConnectName());
        projectInList.setConnectTel(project.getConnectTel());

        return projectInList;

    }

    //获取未审核项目
    @RequestMapping("/selectUnexaminedProject")
    @ResponseBody
    public List<ProjectInList> selectUnexaminedProject() {
        List<Project> projectList = projectService.selectUnexaminedProject();
        //要返回一个带有id转换为详细名称的类型，这里用entity里的ProjectInList类型存储
        List<ProjectInList> projectInLists = new ArrayList<ProjectInList>();
        for (int i = 0; i < projectList.size(); i++) {
            //新建projectInList对象
            ProjectInList projectInList = new ProjectInList();

            //将发包方ID转换为发包方名称
            //获取当前project中的UserEmployerId
            Integer userEmployerId = projectList.get(i).getUserEmployerId();
            System.out.println(userEmployerId);
            String userEmployerName = userEmployerService.findEmployer(userEmployerId).getUserEmployerName();

            projectInList.setUserEmployerName(userEmployerName);
            //将设备id转化为设备名称
            String equipmentId = projectList.get(i).getEquipmentId();
            String[] equipmentIds = equipmentId.split("/");
            String equipmentName = "";
            for (int j = 0; j < equipmentIds.length - 1; j++) {
                Integer integer = new Integer(equipmentIds[j]);
                equipmentName += clientSupportService.getEquipmentName(integer) + "/";
            }
            Integer integer = new Integer(equipmentIds[equipmentIds.length - 1]);
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

    //通过项目
    @RequestMapping("/examine")
    public String examine(HttpSession session, String projectId, Integer examine) {
        String userName = (String) session.getAttribute("userName");
        User user = userService.findUser(userName);
        Integer userId = user.getUserId();
        //通过userID获取user_role_Id
        UserRole userRole = userRoleService.findProjectAdmin(userId);
        //修改项目信息
        if (examine == 1 && projectId != "") {
            Integer success = projectService.examinePassed(Integer.valueOf(projectId), userRole.getUserRoleId());
        } else if (examine == 2 && projectId != "") {
            Integer success = projectService.examineRefused(Integer.valueOf(projectId), userRole.getUserRoleId());
        } else {
            return "redirect:/examineProject";
        }

        return "redirect:/examineProject";

    }

    @RequestMapping("redirectToCompetitiveOrListPage")
    public String redirectToCompetitiveOrListPage(HttpSession session, String projectId, Model model, Integer competitive) {
        String userName = (String) session.getAttribute("userName");
        User user = userService.findUser(userName);
        //获取用户接包方信息
        Integer userId = user.getUserId();
        UserRole Employee = userRoleService.findUserRoleEmployee(userId);
        if (competitive != 0 && projectId != "") {
            model.addAttribute("projectId", projectId);
            return "pages/front/bpo_employee/CompetitiveBidding";
        } else
            return "redirect:/listPage";
    }

    @RequestMapping("redirectToDetail")
    public String redirectToDetail(Integer projectId, Model model, HttpSession session) {
        model.addAttribute("ProjectId", projectId);
        Project project = projectService.selectProjectByKey(projectId);
        ProjectInList projectInList = new ProjectInList();
        //发包方姓名
        Integer userEmployerId = project.getUserEmployerId();
        String userEmployerName = userEmployerService.findEmployer(userEmployerId).getUserEmployerName();
        projectInList.setUserEmployerName(userEmployerName);
        //将设备id转化为设备名称
        String equipmentId = project.getEquipmentId();
        String[] equipmentIds = equipmentId.split("/");
        String equipmentName = "";
        for (int j = 0; j < equipmentIds.length - 1; j++) {
            Integer integer = new Integer(equipmentIds[j]);
            equipmentName += clientSupportService.getEquipmentName(integer) + "/";
        }
        Integer integer = new Integer(equipmentIds[equipmentIds.length - 1]);
        equipmentName += clientSupportService.getEquipmentName(integer);

        projectInList.setEquipmentName(equipmentName);
        //获取项目类型
        Integer projectTypeId = project.getProjectTypeId();
        String projectTypeName = projectTypeService.findProjectTypeName(projectTypeId);
        projectInList.setProjectType(projectTypeName);
        //无需查询
        projectInList.setProjectId(project.getProjectId());
        projectInList.setProjectAdminId(project.getProjectAdminId());
        projectInList.setProjectName(project.getProjectName());
        projectInList.setSkillsRequirement(project.getSkillsRequirement());
        projectInList.setProjectRequirement(project.getProjectRequirement());
        projectInList.setProjectPeriod(project.getProjectPeriod());
        projectInList.setProjectBudget(project.getProjectBudget());
        projectInList.setProjectStatus(project.getProjectStatus());
        projectInList.setConnectName(project.getConnectName());
        projectInList.setConnectTel(project.getConnectTel());

        session.setAttribute("projectInListSession", projectInList);
        model.addAttribute("projectInList", projectInList);
        return "pages/front/bpo_main/ViewProject";
    }
}
