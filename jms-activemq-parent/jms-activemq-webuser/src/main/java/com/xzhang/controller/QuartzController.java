package com.xzhang.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xzhang.model.InstmtQuartz;
import com.xzhang.response.RequestStatus;
import com.xzhang.response.ResponseVo;
import com.xzhang.service.IQuartzService;
import com.xzhang.string.StringUtil;
import com.xzhang.web.RenderUtil;

/**
 * @author zx
 * desc : 定时任务控制器
 *
 */
@Controller
@RequestMapping("/quartzController")
public class QuartzController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(QuartzController.class);
	
	@Autowired
	private IQuartzService quartzService;
	
	
	/**
	 * 获取到指定的定时任务信息
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/getQuartzById.do")
	public String getQuartzById(HttpServletRequest request,HttpServletResponse response,
			String id){
		Assert.isTrue(!StringUtil.isEmptyOrNull(id), "转入的id为空...");
		InstmtQuartz quartz = this.quartzService.findQuartzById(id);
		request.setAttribute("quartz", quartz);
		return "/quartz/quartz";
	}
	
	
	@RequestMapping("/addQuartz.do")
	public void addQuartz(HttpServletRequest request,HttpServletResponse response,
			InstmtQuartz quartz){
		ResponseVo responseVo;
		try {
			Assert.isTrue(null != quartz, "转入的quartz为空...");
			//假设这边是新增一个对象信息
			//add...
			responseVo = new ResponseVo(RequestStatus.REQUEST_OK.getCode(), RequestStatus.REQUEST_OK.getDesc());
		}catch (IllegalArgumentException e) {
			String errorCode = e.getMessage();
			String errorDesc = RequestStatus.getDescByCode(errorCode);
			responseVo = new ResponseVo(errorCode, errorDesc);
			
			log.info(errorCode + ":" + errorDesc, e);
		} catch (Exception e) {
			log.error(RequestStatus.UNKNOWN_ERROR.getDesc(), e);
			responseVo = new ResponseVo(RequestStatus.UNKNOWN_ERROR.getCode(), RequestStatus.UNKNOWN_ERROR.getDesc());
		}
		//把处理的结果返回给ajax
		RenderUtil.renderJson(responseVo, response);
	}
	
	

}
