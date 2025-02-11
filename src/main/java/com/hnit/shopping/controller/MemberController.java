package com.hnit.shopping.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hnit.shopping.entity.Member;
import com.hnit.shopping.service.IMemberService;
import com.hnit.shopping.vo.ResultVO;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
    private IMemberService memberService;
	
	@Autowired
	private IMemberService service;
	
	@PostMapping("/login")
	public ResultVO login(HttpSession session, Member m) {
		Member member = service.login(m);
		if(null == member) {
			return new ResultVO(500, "登录失败,请您注册账号信息");
		}else {
			session.setAttribute("member", member);
			return new ResultVO(200,"登录成功");
		}
	}
	
	 @PostMapping("/register")
	    public ResultVO register(@RequestBody Member member) {
	        boolean success = service.register(member);
	        if (success) {
	            return new ResultVO(200, "注册成功");
	        } else {
	            return new ResultVO(500, "注册失败");
	        }
	    }
	
	@GetMapping("/loginOut")
	public ResultVO loginOut(HttpSession session) {
		session.removeAttribute("member");
		session.invalidate();
		return new ResultVO(200, "安全退出");
	}
	
	/**
	 * 检查会员是否登录
	 * @param session
	 * @return
	 */
	
	@GetMapping("/doCheck")
	public ResultVO doCheck(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(null == member) {
			return new ResultVO(600, "暂未登录");
		}else {
			member.setPassword(null);
			return new ResultVO(200, "登录成功", member);
		}
	}
	
	 @GetMapping("/info")
	    public ResultVO getMemberInfo(@RequestParam String nickName) {
	        try {
	            Member member = memberService.getMemberByNickName(nickName);
	            if (member == null) {
	                return new ResultVO(404, "用户不存在", null);
	            }
	            
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            Map<String, Object> memberInfo = new HashMap<>();
	            memberInfo.put("nickName", member.getNickName());
	            memberInfo.put("tel", member.getTel());
	            memberInfo.put("sex", member.getSex());
	            
	            if (member.getRegisterTime() != null) {
	                memberInfo.put("registerTime", sdf.format(member.getRegisterTime()));
	            } else {
	                memberInfo.put("registerTime", "未设置");
	            }
	            
	            return new ResultVO(200, "获取成功", memberInfo);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResultVO(500, "获取用户信息失败", null);
	        }
	    }
	 

}
