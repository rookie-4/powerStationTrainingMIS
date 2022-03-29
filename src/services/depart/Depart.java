package services.depart;

import java.util.List;
import java.util.Vector;

import persistences.depart.DepartDAO;
import services.Duty;
import dto.KeyValue;
import dto.UserDTO;
import dto.department.DepartDTO;

public class Depart {
	
	//������в���
	public List<DepartDTO> getAllDeparts(){
		List<DepartDTO> allDeparts = null;
		
		allDeparts = new DepartDAO().getAllDeparts();
		
		return allDeparts;
	}
//	private Vector<Vector<Object>> list2vector(List<DepartDTO> allDepart){
//		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
//		
//		for(DepartDTO u:allDepart){
//			Vector<Object> v = new Vector<Object>();
////			v.add(u.getUnit_id());
//			v.add(u.getUp_unit_id());
//			v.add(u.getUnit_class());
//			v.add(new KeyValue<String, String>(u.getUnit_name(),u.getUnit_id()));
//			v.add(u.getAddress());
//			v.add(u.getTelephone());
//			v.add(u.getContact_person());
//			v.add(u.getEmail());
//			v.add(u.getHeader());
//			v.add(Duty.getName(u.getDuty()));
//			v.add(u.getAddress());
//			result.add(v);
//		}
//		
//		return result;
//	}
	
	//�޸Ĳ���
	public boolean modifyDepart(DepartDTO depart,String name){
		DepartDAO dao = new DepartDAO();
		//ɾ��֮ǰ��ѯ�ϼ����ŵ�id
		depart.setUp_unit_id(dao.selUpId(depart).toString());
//		depart.setUp_unit_id(dao.selUpId(depart.getUnit_name();
		System.err.println(dao.selUnitId(depart));
		String s = dao.selUnitId(depart).toString();
		
		//��ɾ��
		dao.delDepart(depart);
		
		depart.setUnit_id(s);
		depart.setUnit_name(name);
		//�ٱ���
		boolean result=dao.saveDepart(depart);
		
		return result;	
	}
	
	//ɾ������
	public boolean delDepart(DepartDTO depart){
		DepartDAO dao = new DepartDAO();

		boolean result=dao.delDepart(depart);
		
		return result;
	}
	
	//�����Ӳ���
	public boolean saveSubDepart(DepartDTO depart){
//		java.util.Random r=new java.util.Random(); 
//		String subNum = depart.getUnit_id()+(r.nextInt()%1000+100);
		String subNum = String.valueOf((int)(Math.random()*1000+100));
		
		System.out.println(subNum);
		depart.setUnit_id(subNum);
		DepartDAO dao = new DepartDAO();
		boolean result=dao.saveDepart(depart);
		
		return result;
	}
	
	//�õ��ϼ����ź�
	public String getUpNum(String name){
		DepartDAO dao = new DepartDAO();
		DepartDTO departDTO = new DepartDTO();
		departDTO.setUnit_name(name);
		return dao.selUnitId(departDTO).toString();
	}
	
	//ͨ��id�õ�����
	public DepartDTO getDepartById(String id){
		DepartDTO depart = null;
		depart = new DepartDAO().getDepartById(id);
		return depart;
	}
	
	//�õ����ŵ�����
	public int getDepartcount(){
		return new DepartDAO().getDepartCount();
	}

	public static void main(String[] args) {
		Depart d = new Depart();
		DepartDTO dto = new DepartDTO();
		
		d.saveSubDepart(dto);
//		String s = d.selUnitId(dto).toString();
//		System.out.println(s);
	}
}
