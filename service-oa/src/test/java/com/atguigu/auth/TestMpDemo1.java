package com.atguigu.auth;

import com.atguigu.auth.mapper.SysRoleMapper;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMpDemo1 {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void getAll(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println("sysRoles = " + sysRoles);
    }

    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleCode("root");
        sysRole.setRoleName("主管理员");
        sysRole.setDescription("管理员");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println("rows = " + rows);
        System.out.println("sysRole = " + sysRole);

    }

    @Test
    public void update(){
        SysRole sysRole = sysRoleMapper.selectById(9);

        sysRole.setDescription("修改后的管理员");

        int rows = sysRoleMapper.updateById(sysRole);
        System.out.println("rows = " + rows);
        System.out.println("sysRole = " + sysRole);
    }

    @Test
    public void delete(){

        int rows = sysRoleMapper.deleteById(9);
        System.out.println("rows = " + rows);


    }

    @Test
    public void testQuery1(){

        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();

        String roleName = "主管理员";

        wrapper.eq("role_name",roleName);

        List<SysRole> sysRoles = sysRoleMapper.selectList(wrapper);

        System.out.println("sysRoles = " + sysRoles);


    }

    @Test
    public void testQuery2(){

        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();

        String roleName = "主管理员";

        wrapper.eq(SysRole::getRoleName,roleName);

        List<SysRole> sysRoles = sysRoleMapper.selectList(wrapper);

        System.out.println("sysRoles = " + sysRoles);


    }
}
