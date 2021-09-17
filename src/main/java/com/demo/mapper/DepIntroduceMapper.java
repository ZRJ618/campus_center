package com.demo.mapper;

import com.demo.pojo.introduce.DepIntroduceModel;
import com.demo.pojo.introduce.DepIntroducePojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DepIntroduceMapper {
    /* *
     * @description: 添加部门宣传信息
     * @params: [depIntroducePojo]
     * @return: void
     * @author: lazy
     * @dateTime: 2021/3/20 16:03
     */
    Integer addDepIntroduce(DepIntroducePojo depIntroducePojo);

    /* *
     * @description: 修改第一负责人
     * @params: [chargeOne 第一负责人学号, departmentId 被修改的部门id]
     * @return: void
     * @author: lazy
     * @dateTime: 2021/3/22 15:59
     */
    Integer updateChargeOne(String chargeOne, String departmentId, String modifyTime);


    /* *
     * @description: 修改第二负责人
     * @params: [chargeOne 第一负责人学号, departmentId 被修改的部门id]
     * @return: void
     * @author: lazy
     * @dateTime: 2021/3/22 15:59
     */

    Integer updateChargeTow(String chargeTow, String departmentId, String modifyTime);

    /* *
     * @description: 修改第一负责人
     * @params: [chargeOne 第一负责人学号, departmentId 被修改的部门id]
     * @return: void
     * @author: lazy
     * @dateTime: 2021/3/22 15:59
     */
    Integer updateChargeThree(String chargeThree, String departmentId, String modifyTime);

    DepIntroducePojo getDepById(String departmentId);

    Integer updateDepIntroduce(DepIntroducePojo depIntroducePojo);

    Integer deleteDepInfo(String departmentId);
}
