package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: lym
 * @Date:2019/1/21 19 49
 * @Description:
 */


@Controller  //返回不是数据，不用RestController
@RequestMapping("/freemaker")
public class FreemakerController {


	@Autowired
	private ServerSettings setting;


	@GetMapping("hello")
	public String index(ModelMap modelMap){

		modelMap.addAttribute("setting", setting);

		return "fm/index";  //不用加后缀，在配置文件里面已经指定了后缀
	}




}
