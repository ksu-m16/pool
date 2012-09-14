
public class Application {

	public static void main(String[] args) {
		
		PoolModel m = new PoolModel();
		PoolView v = new PoolView();
		PoolController c = new PoolController();
		c.setModel(m);
		v.setController(c);

		m.generateSets();
		v.run();				

		
	}

	

}
