package pl.szkolenie.usluga;

import java.util.ArrayList;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "divisorService", name = "divisor", portName = "divisor"
	, targetNamespace = "http://math.training.com/")
public class DzielnikImplementacja implements Dzielnik {

	//@Oneway
	@WebResult(name = "dividents")
	@WebMethod(operationName = "find")
	@Override
	public ArrayList<Integer> znajdz(
			@WebParam(name = "begin") int poczatek,
			@WebParam(name ="end") int koniec,
			@WebParam(name = "divisor", header = true) int dzielnik) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = poczatek; i <= koniec; i++) {
			if (i % dzielnik == 0) {
				result.add(i);
			}
		}
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(result);
		return result;
	}

}
