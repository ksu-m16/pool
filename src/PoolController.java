import java.util.Arrays;


public class PoolController {
	private PoolModel model = new PoolModel();
	private int nSet;
	public int getSetNum() {
		return nSet;
	}

	public void generateSets(){
		model.generateSets();
		nSet = 0;
	}
	
	public PoolModel getModel() {
		return model;
	}

	public void setModel(PoolModel model) {
		this.model = model;
	}
	
	public int getCount(){
		model.generateSets();
		return model.getCount();
	}
	
	public int[] getNextSet(){
		if (model.getCount() == 0){
			return null;
		}
		
		if (nSet >= model.getCount()){
			nSet = model.getCount() % nSet;
		}
		return setCodeToSet((int)(model.getSets()).get(nSet++));
	}
	
	public int getNext(){
		if (nSet >= model.getCount()){
			nSet = model.getCount() % nSet;
		}
		return (model.getSets()).get(nSet++);
	}
	
	
	
	private int[] setCodeToSet(int setCode) {
		int[] set = new int[15];
		
	
		set[0] = ((setCode & (1<<0))== 0) ? 0 : 1;
		set[1] = ((setCode & (1<<1))== 0) ? 0 : 1;
		set[2] = ((setCode & (1<<2))== 0) ? 0 : 1;
		set[3] = ((setCode & (1<<3))== 0) ? 0 : 1;
		set[4] = ((setCode & (1<<4))== 0) ? 0 : 1;
		set[5] = ((setCode & (1<<5))== 0) ? 0 : 1;
		set[6] = ((setCode & (1<<6))== 0) ? 0 : 1;
		set[7] = ((setCode & (1<<7))== 0) ? 0 : 1;
		set[8] = ((setCode & (1<<8))== 0) ? 0 : 1;
		set[9] = ((setCode & (1<<9))== 0) ? 0 : 1;
		set[10] = 2;
		set[11] = ((setCode & (1<<10))== 0) ? 0 : 1;
		set[12] = ((setCode & (1<<11))== 0) ? 0 : 1;
		set[13] = ((setCode & (1<<12))== 0) ? 0 : 1;
		set[14] = ((setCode & (1<<13))== 0) ? 0 : 1;
		
		return set;
	}
	

	
	
}
