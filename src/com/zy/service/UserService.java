package com.zy.service;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.zy.hibernate.pojo.Input;
import com.zy.hibernate.pojo.InputDAO;
import com.zy.hibernate.pojo.Output;
import com.zy.hibernate.pojo.OutputDAO;
import com.zy.hibernate.pojo.User;
import com.zy.hibernate.pojo.UserDAO;

@Service
@Path("UserService")
public class UserService {
	@Resource
	private UserDAO userDao;
	@Resource
	private OutputDAO opDao;
	@Resource
	private InputDAO ipDao;

	@GET
	@Path("UserLogin/{uid},{upwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public String userLogin(@PathParam("uid")Integer uid,@PathParam("upwd")String upwd){
		User user = new User();
		user = userDao.findById(uid);
		if(user.getUpwd().equals(upwd)){
			return "{'userLogin':['state':'1']}";
		}
		return "{'userLogin':['state':'0']}";
	}
	
	@GET
	@Path("UserPay/{uid},{upaypwd},{money},{targetUid}")
	public String userPay(@PathParam("uid")Integer uid,@PathParam("upaypwd")String upaypwd,@PathParam("money")float money,@PathParam("targetUid")Integer targetUid){
		User user = userDao.findById(uid);
		if(user.getUpaypwd().equals(upaypwd)){
			if(user.getBalance()>=money){
				if(userDao.findById(targetUid)!=null){
					user.setBalance(user.getBalance()-money);
					userDao.merge(user);
					Output op = new Output();
					op.setUserByUid(user);
					op.setOpMoney(money);
					Input ip = new Input();
					ip.setUserBySourceUid(user);
					ip.setIpMoney(money);					
					user = userDao.findById(targetUid);
					op.setUserByTargetUid(user);
					ip.setUserByUid(user);
					user.setBalance(user.getBalance()+money);
					userDao.merge(user);
					op.setOpState("付成功");
					ip.setIpState("收成功");
					opDao.save(op);
					ipDao.save(ip);
					return "{'userPay':['state':'1']}";
				}
			}
		}
		return "{'userPay':['state':'0']}";
	}
	//getter&setters
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
