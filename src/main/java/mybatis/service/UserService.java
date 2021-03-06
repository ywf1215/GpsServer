package mybatis.service;

import java.util.List;

import mybatis.domain.TrackBean;
import mybatis.domain.User;
import mybatis.mapper.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	private static Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserMapper userMapper;

	@Transactional
	public void addUser(User user) {
		try{
			userMapper.addUser(user);
		}catch(Throwable e){
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
	}

	@Transactional
	public void batchAddUser(List<User> users) {
		userMapper.batchAddUser(users);
	}
	
	@Transactional
	public void createTable(String tableName) {
		try{
			userMapper.createTable(tableName);
		}catch(Throwable e){
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
	}
	
	public String getDeptById(int id){
		String ret = null;
		try{
			ret = userMapper.getDeptById(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ret;
	}
	
	public List<String> getAllTrackTables(){
		return userMapper.getAllTrackTables();
	}

	@Transactional
	public void addTrack(TrackBean track) {
		try{
			userMapper.addTrack(track);
		}catch(Throwable e){
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
	}
}
