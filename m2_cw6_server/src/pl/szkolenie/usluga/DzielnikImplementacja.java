package pl.szkolenie.usluga;

import java.util.ArrayList;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName="divisorService", name="divisor", portName="divisor", targetNamespace="http://net.mario.com/")
public class DzielnikImplementacja implements Dzielnik {

	@Oneway	// no response - serwer tylko potwierdza odbior
	@WebResult(name="dividents")
	@WebMethod(operationName="find")
	@Override
	public ArrayList<Integer> znajdz(@WebParam(name="begin") int poczatek, @WebParam(name="end") int koniec, @WebParam(name="divisor")  int dzielnik) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		for(int i = poczatek; i<= koniec; i++) {
			if(i%dzielnik == 0) {
				r.add(i);
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(r);
		return r;
	}

}
