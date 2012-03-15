package pl.szkolenie.service;

import java.awt.Image;

import javax.jws.WebService;

@WebService
public interface ImageRepo {
	Image getImage(String name);
	void put(String name, Image image);
}
