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
		if (nSet >= model.getCount()){
			nSet = model.getCount() % nSet;
		}
		return setCodeToSet((int)(model.getSets()).get(nSet++));
	}
	
	
	
	
	private int[] setCodeToSet(int setCode) {
		int[] set = new int[15];
		String binSet = Integer.toBinaryString(setCode);
		char[] b = binSet.toCharArray();
		if(b.length < 14){
			char[] tempb = new char[14];
			Arrays.fill(tempb, '0');
			for (int i = 14 - b.length; i < 14; i++) {
			tempb[i] = b[i - (14 - b.length)];
			}
			b = tempb;
		}
		set[0] = Integer.parseInt("" + b[0]);
		set[1] = Integer.parseInt("" + b[1]);
		set[2] = Integer.parseInt("" + b[2]);
		set[3] = Integer.parseInt("" + b[3]);
		set[4] = Integer.parseInt("" + b[4]);
		set[5] = Integer.parseInt("" + b[5]);
		set[6] = Integer.parseInt("" + b[6]);
		set[7] = Integer.parseInt("" + b[7]);
		set[8] = Integer.parseInt("" + b[8]);
		set[9] = Integer.parseInt("" + b[9]);
		set[10] = 2;
		set[11] = Integer.parseInt("" + b[10]);
		set[12] = Integer.parseInt("" + b[11]);
		set[13] = Integer.parseInt("" + b[12]);
		set[14] = Integer.parseInt("" + b[13]);
		
		return set;
	}
	

	
	
}
