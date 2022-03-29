package services.user;

import java.util.List;
import java.util.Vector;

import dto.KeyValue;
import dto.UserDTO;
import persistences.UserDAO;
import services.Duty;
//��װ�����ж��û��Ĳ��� ����UserDAO�������ݿ�
public class User {
	private String user_name;
	private String password;
	

	public  User(String name, String psw){
		this.user_name = name;
		this.password = psw;
	}
	public User(){
		
	}
	public boolean findUser(){
		boolean result = false;
		
		result = new UserDAO().findUser(user_name, password);
				
		return result;
	}
	public boolean saveUser(UserDTO user){
		boolean saveSuccessful = false;
		
		saveSuccessful = new UserDAO().saveUser(user);		
		return saveSuccessful;		
	}
	public boolean updateUser(UserDTO user){
		boolean updateSuccessful = false;
		
		updateSuccessful = new UserDAO().updateUser(user);		
		return updateSuccessful;
				
	}
	public boolean nameExisted(String userName){
				
		return (new UserDAO().nameExisted(userName));
		
	}
	
	
	//------------------------------------------------------------------------
	
	public Vector<Vector<Object>> getAllEmployees(){
		List<UserDTO> allEmployees = null;
		
		allEmployees = new UserDAO().getAllEmployees();
		
		return list2vector(allEmployees);
	}
	public Vector<Vector<Object>> getSomeEmployee(String name,String sex){
		List<UserDTO> allEmployee = null;
		
		allEmployee = new UserDAO().getSomeEmployee(name,sex);
		
		return list2vector(allEmployee);
	}
	
	private Vector<Vector<Object>> list2vector(List<UserDTO> allUser){
		
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		int sequence=1;
		for(UserDTO u:allUser){
			Vector<Object> v = new Vector<Object>();
			v.add(sequence++);
			v.add(new KeyValue<String, String>(u.getName(),u.getUser_id()));
			v.add(u.getUnit_name());
			v.add(u.getBirthday());
			v.add(u.getCard_id());
			v.add(Duty.getName(u.getDuty()));
			v.add(u.getTelephone());
			result.add(v);
		}
		
		return result;
//		colums.add("���");
//		colums.add("����");
//		colums.add("����");
//		colums.add("��������");
//		colums.add("���֤");
//		colums.add("ְ��");
//		colums.add("��ϵ�绰");
	}

	public boolean delEmployee(String userId){
		boolean saveSuccessful = false;
		
		saveSuccessful = new UserDAO().delEmployee(userId);		
		return saveSuccessful;	
	}
	public boolean saveEmployee(UserDTO user){
		boolean saveSuccessful = false;
		
		saveSuccessful = new UserDAO().saveEmployee(user);		
		return saveSuccessful;
				
	}
	
}

