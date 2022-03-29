package services.training;



import java.util.List;
import java.util.Vector;

import dto.KeyValue;
import dto.training.TrainingDTO;
import persistences.training.TrainingDAO;

import services.Duty;
//封装了所有对用户的操作 调用TrainingDAO操作数据库
public class Training {
	private String Training_name;
	private String password;
	

	public  Training(String name, String psw){
		this.Training_name = name;
		this.password = psw;
	}
	public Training(){
		
	}
	
	public Vector<Vector<Object>> getSomeTrainings(TrainingDTO training){
		List<TrainingDTO> someTrainings = null;
		
		someTrainings = new TrainingDAO().getSomeTraining(training);
		
		return list2vector(someTrainings);
	}
	public Vector<Vector<Object>> getAllTrainings(){
		List<TrainingDTO> someTrainings = null;
		
		someTrainings = new TrainingDAO().getAllTraining();
		
		return list2vector(someTrainings);
	}

	//将list转化为vector
	private Vector<Vector<Object>> list2vector(List<TrainingDTO> allTraining){
		
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		int sequence=1;
		for(TrainingDTO u:allTraining){
			
			Vector<Object> v = new Vector<Object>();
			v.add(sequence++);
			v.add(new KeyValue<String, String>(u.getTrain_plan_name(),u.getTrain_plan_id()));
			v.add(u.getTrain_plan_type());
			v.add(u.getTrain_plan_year());
			v.add(u.getIs_finish());
			result.add(v);
		}	
		return result;
	}
	
	public boolean saveTraining(TrainingDTO Training){
		boolean saveSuccessful = false;
		
		saveSuccessful = new TrainingDAO().saveTraining(Training);		
		return saveSuccessful;		
	}
	
	public boolean delTraining(String TrainingId){
		boolean saveSuccessful = false;
		
		saveSuccessful = new TrainingDAO().delTraining(TrainingId);		
		return saveSuccessful;	
	}
}

