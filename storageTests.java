import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class storageTests extends Storage{

	@Test
	void testRemove() {
		Storage.loadData();
		for(App a : appList) {
			System.out.println(a.getName());
		}
		Storage.removeApp("Facebook");
		System.out.println("");
		for(App a : appList) {
			System.out.println(a.getName());
		}
	}

}
