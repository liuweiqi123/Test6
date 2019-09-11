package com.example.demo;

import com.example.demo.dao.user_info;
import com.example.demo.mapper.user_departmentMapper;
import com.example.demo.mapper.user_infoMapper;
import com.example.demo.mapper.user_stationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quartz")
public class QuartzController{

    @Autowired
    public user_infoMapper user_infoMapper;

    @Autowired
    public user_departmentMapper user_departmentMapper;

    @Autowired
    public user_stationMapper user_stationMapper;


    //前台页面加载

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    //人员信息查询
    @RequestMapping(value = "/userselect",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public user_info userselect(String usercode){
        System.out.println(usercode);
        user_info user_infos = new user_info();
        if(user_infoMapper.selectByUsercode(usercode)!=null){
            user_info user_info = user_infoMapper.selectByUsercode(usercode);
            user_info.setDpartmentCode(user_departmentMapper.selectByDepartmentCode(user_info.getDpartmentCode()).getDepartmentName());
            user_info.setStationCode(user_stationMapper.selectByStationCode(user_info.getStationCode()).getStationName());
            return user_info;
        }
        else {
            return user_infos;
        }
    }

    //人员信息根据时间查询
    @RequestMapping(value = "/selectByTime",method = RequestMethod.POST)

    public List<user_info> selectByTime(String begintTime,String endTime){

        // 参数map
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("begintTime ", begintTime );
        params.put("endTime ", endTime );
        // 根据所有pararms查询期间内xxx表数据
        List<user_info> user_infoList = user_infoMapper.selectByParams(params);
        return  user_infoList;
    }



}
