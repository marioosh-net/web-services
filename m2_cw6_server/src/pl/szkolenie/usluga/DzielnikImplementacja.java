package pl.szkolenie.usluga;

import java.util.ArrayList;

import javax.jws.WebService;

@WebService
public class DzielnikImplementacja implements Dzielnik {

	@Override
	public ArrayList<Integer> znajdz(int poczatek, int koniec, int dzielnik) {
		ArrayList<Integer> r = new ArrayList<>();
		for(int i = poczatek; i<= koniec; i++) {
			if(i%dzielnik == 0) {
				r.add(i);
			}
		}
		return r;
	}

}
