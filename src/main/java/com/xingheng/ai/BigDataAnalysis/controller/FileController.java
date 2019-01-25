package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.JsonData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 数据上传
 *
 * @author: lym
 * @Date:2019/1/10 11 55
 * @Description:
 */

@Controller
@PropertySource({"classpath:application.properties"})  //加载配置文件
public class FileController {


//	@RequestMapping(value = "/api/v1/gopage",method = RequestMethod.POST)
//	public Object index() {
//		return "index";
//	}

//	private static final String filePath = "/Users/lym/Desktop/";

	@Value("${web.images-path}")
	private String filePath;

	@ApiOperation("数据上传")
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

		//file.isEmpty(); 判断图片是否为空
		//file.getSize(); 图片大小进行判断
		System.out.println("配置路径："+filePath);
		String name = request.getParameter("name");
		System.out.println("用户名：" + name);

		// 获取文件名
		String fileName = file.getOriginalFilename();
		System.out.println("上传的文件名为：" + fileName);

		// 获取文件的后缀名,比如图片的jpeg,png
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println("上传的后缀名为：" + suffixName);

		// 文件上传后的路径
		fileName = UUID.randomUUID() + suffixName;
		System.out.println("转换后的名称:" + fileName);

		File dest = new File(filePath + fileName);

		try {
			file.transferTo(dest);  // transferTo 方法用于文件保存(效率和操作比原来的FileOutputStream 方便高效)

			return new JsonData(0, fileName,"");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JsonData(-1, "fail to save ","");
	}
}
