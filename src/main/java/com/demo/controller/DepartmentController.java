package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.department.DepartmentModel;
import com.demo.pojo.department.MyDepInfo;
import com.demo.service.DepMemberService;
import com.demo.service.DepartmentService;
import com.demo.util.ParamUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    DepartmentService departmentService;

    @Resource
    DepMemberService depMemberService;

    /*
    * 获取部门列表
    * 通过父级部门的部门名进行查询
    * 查询父级部门的子部门*/
/*    @GetMapping("/getDepList")
    @ApiOperation(value = "获取部门列表")
    @ApiImplicitParams(
            {@ApiImplicitParam(name="parentDepartmentName", value="父级部门名字", dataType="String", required=true),
             @ApiImplicitParam(name="pageNum", value = "当前页", dataType="Integer", required=true)})
    public ResultBody getDepList(@RequestParam("parentDepName")String parentDepName,
                                        @RequestParam("pageNum")Integer pageNum){
        PageResult departmentList = departmentService.getDepartmentList(parentDepName, pageNum);
        return ResultBody.ResHandle(departmentList, "部门列表为空");
    }*/

    /* *
     * @description: 获取部门列表
     * @params: [departmentGrade 部门等级, parentDepName 部门id]
     * @return: com.demo.exception.ResultBody
     * @author: lazy
     * @dateTime: 2021/4/1 16:32
     */
    @GetMapping("/getDepList")
    public ResultBody getDepList(String departmentGrade, String parentId) {
        List<DepartmentModel> depList = departmentService.getDepList(departmentGrade, parentId);
        return ResultBody.ResHandle(depList, "未查询到部门");
    }

    /*
    * 添加子部门
    *参数：
    *    需要添加部门的名字
    *    需要添加部门的父级部门  */
    @PostMapping("/addDepartment")
    @ApiOperation(value = "添加部门")
    @ApiImplicitParams({@ApiImplicitParam(name="departmentName", value="部门名字", dataType="String", required=true),
            @ApiImplicitParam(name="parentDepartmentName", value="父级部门名字", dataType="String", required=true)})
    public ResultBody addDepartment(@RequestParam("departmentName")String depName,
                                    @RequestParam("parentName")String parentName,
                                    @RequestParam("parentId")String parentId,
                                    @RequestParam("departmentGrade")String departmentGrade){
        boolean flag = departmentService.addDepartment(depName, parentId, parentName, departmentGrade);
        return ResultBody.ResHandle(flag, "添加部门失败");
    }

/*    @ApiOperation(value = "添加父部门")
    @ApiImplicitParams({@ApiImplicitParam(name="departmentName", value="部门名字", dataType="String", required=true)})
    @PostMapping("/addParentDepartment")
    public ResultBody addParentDepartment(@RequestParam("departmentName")String departmentName){
        boolean flag = departmentService.addParentDepartment(departmentName);
        return ResultBody.ResHandle(flag, "添加父级部门失败");
    }*/

    /*
    * 部门信息更新
    * 参数：
    *   部门id
    *   需要更新的部门名字
    *   需要更新的父类id
    * */
    @PutMapping("/updateDepartment")
    @ApiOperation(value = "更新部门信息")
    @ApiImplicitParams({@ApiImplicitParam(name="departmentName", value="需要修改的部门名字", dataType="String", required=true),
            @ApiImplicitParam(name="newDepartmentName", value="新部门名字", dataType="String"),
            @ApiImplicitParam(name="parentDepartmentName", value="父级部门名字", dataType="String")})
    public ResultBody updateDepartment(@RequestParam("departmentId")String departmentId,
                                       String departmentName,
                                       String parentId,
                                       String parentName,
                                       String departmentGrade){
        boolean flag = departmentService.updateDepartment(departmentId, departmentName, parentId, parentName, departmentGrade);
        return ResultBody.ResHandle(flag, "修改部门信息失败");
    }

    @DeleteMapping("/deleteDepartment")
    @ApiOperation(value = "删除部门信息")
    @ApiImplicitParams({@ApiImplicitParam(name="departmentName", value = "部门名字", dataType = "String", required=true)})
    public ResultBody deleteDepartment(@RequestParam("departmentId")String departmentId){
        boolean flag = departmentService.deleteDepartment(departmentId);
        return ResultBody.ResHandle(flag, "删除部门信息失败");

    }


    @PutMapping("/joinDepartment")
    public ResultBody joinDepartment(@RequestParam("departmentId")String departmentId,
                                     @RequestParam("departmentName")String departmentName,
                                     @RequestParam("position")String position,
                                     HttpServletRequest request) {
        String userId = ParamUtil.getUserId(request);
        boolean flag = depMemberService.joinDepartment(departmentId, departmentName, userId, position);
        return ResultBody.ResHandle(flag, "加入失败");
    }

    @PutMapping("/updateMemInfo")
    public ResultBody updateMemInfo(@RequestParam("departmentId")String departmentId,
                                    @RequestParam("userId")String userId,
                                    boolean deleted,
                                    boolean isOld) {
        boolean flag = depMemberService.updateMemInfo(departmentId, userId, deleted, isOld);
        return ResultBody.ResHandle(flag, "信息错误");
    }

    @GetMapping("/getMyDep")
    public ResultBody getMyDep(@RequestParam("userId")String userId) {
        MyDepInfo myDep = departmentService.getMyDep(userId);
        return ResultBody.ResHandle(myDep, "未加入部门");
    }


}
