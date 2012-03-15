package pl.szkolenie.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import pl.szkolenie.model.Phone;

public class PhoneAdapter extends XmlAdapter<AdaptedPhone, Phone> {

	@Override
	public Phone unmarshal(AdaptedPhone v) throws Exception {
		return new Phone(v.getNumber());
	}

	@Override
	public AdaptedPhone marshal(Phone v) throws Exception {
		AdaptedPhone adaptedPhone = new AdaptedPhone();
		adaptedPhone.setNumber(v.getNumber());
		return adaptedPhone;
	}

}
