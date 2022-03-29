package services.scores;

import java.util.List;
import java.util.Vector;

import dto.KeyValue;
import dto.scores.ScoresDTO;
import persistences.scores.ScoresDAO;
import services.Duty;
//��װ�����ж��û��Ĳ��� ����ScoresDAO�������ݿ�
public class Scores {
	private String Scores_name;
	private String password;
	

	public  Scores(String name, String psw){
		this.Scores_name = name;
		this.password = psw;
	}
	public Scores(){
		
	}
	
	
	public Vector<Vector<Object>> getAllScoress(){
		List<ScoresDTO> allScoress = null;
		
		allScoress = new ScoresDAO().getAllScores();
		
		return list2vector(allScoress);
	}

	//listת��Ϊvector
	private Vector<Vector<Object>> list2vector(List<ScoresDTO> allScores){
		
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		int sequence=1;
		for(ScoresDTO u:allScores){
			Vector<Object> v = new Vector<Object>();
			v.add(sequence++);
			v.add(new KeyValue<String, String>(u.getUser_name(),u.getId()));
			v.add(u.getUnit_name());
			v.add(u.getAttendance_score());
			v.add(u.getTest_score());
			v.add(u.getTotal_score());
			result.add(v);
		}	
		return result;
	}
	//�������
	public boolean saveScores(ScoresDTO Scores){
		boolean saveSuccessful = false;
		
		saveSuccessful = new ScoresDAO().saveScores(Scores);		
		return saveSuccessful;		
	}
	
	//ɾ������
	public boolean delScores(String ScoresId){
		boolean saveSuccessful = false;
		
		saveSuccessful = new ScoresDAO().delScores(ScoresId);		
		return saveSuccessful;	
	}
}

